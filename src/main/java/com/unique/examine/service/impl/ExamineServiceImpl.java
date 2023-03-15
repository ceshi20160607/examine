package com.unique.examine.service.impl;

import com.unique.examine.common.context.ExamineContext;
import com.unique.examine.common.utils.ExamineUtil;
import com.unique.examine.entity.po.Examine;
import com.unique.examine.mapper.ExamineMapper;
import com.unique.examine.service.IExamineRecordLogService;
import com.unique.examine.service.IExamineRecordService;
import com.unique.examine.service.IExamineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 审批表 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-15
 */
@Service
public class ExamineServiceImpl extends ServiceImpl<ExamineMapper, Examine> implements IExamineService {

    @Autowired
    private IExamineRecordService iExamineRecordService;

    @Autowired
    private IExamineRecordLogService iExamineRecordLogService;

    @Override
    @Transactional
    public void addOrUpdate(ExamineContext context) {
        ExamineUtil.createProcess(context);
        //保存=》db
        iExamineRecordService.save(context.getExamineRecord());
        iExamineRecordLogService.saveOrUpdateBatch(context.getExamineRecordLogList());
    }

    @Override
    public void process(ExamineContext context) {
        ExamineUtil.examineProcess(context);
    }
}
