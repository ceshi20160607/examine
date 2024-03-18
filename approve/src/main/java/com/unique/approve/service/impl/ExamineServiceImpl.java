package com.unique.approve.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.unique.approve.entity.bo.ExamineSaveBO;
import com.unique.approve.entity.bo.ExamineSearchBO;
import com.unique.approve.entity.po.*;
import com.unique.approve.entity.vo.ExamineVO;
import com.unique.approve.mapper.ExamineMapper;
import com.unique.approve.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unique.core.common.BasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    @Override
    @Transactional
    public void addOrUpdate(ExamineSaveBO saveBO) {
        //保存
        Examine examine = saveBO.getExamine();
        Boolean isAdd = ObjectUtil.isEmpty(examine.getId()) ? Boolean.TRUE : Boolean.FALSE;
        if (isAdd) {
            if (save(examine)) {
                saveBO.getExamineSetting().setExamineId(examine.getId());
                examineSettingService.save(saveBO.getExamineSetting());
                //用户
                saveBO.getExamineSettingUser().forEach(r->r.setExamineId(examine.getId()));
                examineSettingUserService.saveBatch(saveBO.getExamineSettingUser());
            }
        }else{
            updateById(examine);
            examineSettingService.updateById(saveBO.getExamineSetting());
            examineSettingUserService.saveOrUpdateBatch(saveBO.getExamineSettingUser());
        }
    }

    @Override
    public BasePage<ExamineVO> queryPageList(ExamineSearchBO searchBO) {
        return getBaseMapper().queryPageList(searchBO.parse(), searchBO);
    }

    @Override
    @Transactional
    public void deteleByIds(List<Long> ids) {
        removeByIds(ids);
        examineSettingService.remove(new LambdaQueryWrapper<ExamineSetting>().in(ExamineSetting::getExamineId,ids));
        examineSettingUserService.remove(new LambdaQueryWrapper<ExamineSettingUser>().in(ExamineSettingUser::getExamineId,ids));
    }
}
