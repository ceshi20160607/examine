package com.unique.approve.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.unique.approve.entity.bo.ExamineSaveBO;
import com.unique.approve.entity.bo.ExamineSearchBO;
import com.unique.approve.entity.po.*;
import com.unique.approve.entity.vo.ExamineVO;
import com.unique.approve.enums.ExamineStatusEnum;
import com.unique.approve.mapper.ExamineMapper;
import com.unique.approve.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unique.approve.utils.ApproveUtil;
import com.unique.core.common.BasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 审批表 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2024-01-30
 */
@Service
public class ExamineServiceImpl extends ServiceImpl<ExamineMapper, Examine> implements IExamineService {

    @Autowired
    private IExamineSettingService examineSettingService;
    @Autowired
    private IExamineSettingUserService examineSettingUserService;
    @Autowired
    private IExamineNodeService examineNodeService;
    @Autowired
    private IExamineNodeUserService examineNodeUserService;

    @Autowired
    private IExamineRecordService examineRecordService;


    @Override
    @Transactional
    public void addOrUpdate(ExamineSaveBO saveBO) {
        //保存
        Examine examine = saveBO.getExamine();
        if (ObjectUtil.isNotEmpty(examine.getId())) {
            lambdaUpdate().set(Examine::getStatus, ExamineStatusEnum.OFF.getType())
                    .eq(Examine::getId,examine.getId()).update();
        }
        //添加
        examine.setId(null);
        if (save(examine)) {
            Long examineId = examine.getId();
            saveBO.getExamineSetting().setExamineId(examineId);
            //用户
            saveBO.getExamineSettingUser().forEach(r->r.setExamineId(examineId));
            //添加子节点
            List<ExamineNode> examineNodes = ApproveUtil.recursionBuildHadSubList(saveBO.getExamineNodeList(), 0L);
            List<ExamineNodeUser> nodeUserList = new ArrayList<>();
            examineNodes.forEach(r->{
                r.setExamineId(examineId);
                if (CollectionUtil.isNotEmpty(r.getNodeUserList())) {
                    r.getNodeUserList().forEach(u->{
                        u.setExamineId(examineId);
                    });
                    nodeUserList.addAll(r.getNodeUserList());
                }
            });
            //保存examinesetting
            examineSettingService.save(saveBO.getExamineSetting());
            //保存examinesettingUser
            examineSettingUserService.saveBatch(saveBO.getExamineSettingUser());
            //添加节点
            if (CollectionUtil.isNotEmpty(examineNodes)) {
                examineNodeService.saveBatch(examineNodes);
            }
            //添加节点user
            if (CollectionUtil.isNotEmpty(nodeUserList)) {
                examineNodeUserService.saveBatch(nodeUserList);
            }
        }

    }

    @Override
    public BasePage<ExamineVO> queryPageList(ExamineSearchBO searchBO) {
        return getBaseMapper().queryPageList(searchBO.parse(), searchBO);
    }

    @Override
    @Transactional
    public void deteleByIds(List<Long> ids) {
        List<ExamineRecord> hadRecordList = examineRecordService.lambdaQuery().in(ExamineRecord::getExamineId, ids).list();
        if (CollectionUtil.isEmpty(hadRecordList)) {
            removeByIds(ids);
            examineSettingService.remove(new LambdaQueryWrapper<ExamineSetting>().in(ExamineSetting::getExamineId,ids));
            examineSettingUserService.remove(new LambdaQueryWrapper<ExamineSettingUser>().in(ExamineSettingUser::getExamineId,ids));
            examineNodeService.remove(new LambdaQueryWrapper<ExamineNode>().in(ExamineNode::getExamineId,ids));
            examineNodeUserService.remove(new LambdaQueryWrapper<ExamineNodeUser>().in(ExamineNodeUser::getExamineId,ids));
        }
    }
}
