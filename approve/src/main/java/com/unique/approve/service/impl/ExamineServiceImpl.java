package com.unique.approve.service.impl;

import com.unique.approve.entity.dto.ExamineContext;
import com.unique.approve.entity.po.Examine;
import com.unique.approve.mapper.ExamineMapper;
import com.unique.approve.service.IExamineRecordNodeService;
import com.unique.approve.service.IExamineRecordService;
import com.unique.approve.service.IExamineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unique.approve.utils.ExamineUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private IExamineRecordService iExamineRecordService;

    @Autowired
    private IExamineRecordNodeService iExamineRecordNodeService;

    @Override
    @Transactional
    public void addOrUpdate(ExamineContext context) {
        ExamineUtil.createProcess(context);
        //保存=》db
        iExamineRecordService.save(context.getExamineRecord());
        iExamineRecordNodeService.saveOrUpdateBatch(context.getExamineRecordNodeList());
    }

    @Override
    public void process(ExamineContext context) {
        ExamineUtil.examineProcess(context);
    }
}
