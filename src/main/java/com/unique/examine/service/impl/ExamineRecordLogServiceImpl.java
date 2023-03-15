package com.unique.examine.service.impl;

import com.unique.examine.entity.po.ExamineRecordLog;
import com.unique.examine.mapper.ExamineRecordLogMapper;
import com.unique.examine.service.IExamineRecordLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 审批任务日志表 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-15
 */
@Service
public class ExamineRecordLogServiceImpl extends ServiceImpl<ExamineRecordLogMapper, ExamineRecordLog> implements IExamineRecordLogService {

    @Override
    public List<ExamineRecordLog> pageList(Long examineRecordId) {
        return lambdaQuery().eq(ExamineRecordLog::getRecordId,examineRecordId).list();
    }
}
