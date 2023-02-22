package com.unique.examine.service.impl;

import com.unique.examine.entity.po.ExamineTask;
import com.unique.examine.mapper.ExamineTaskMapper;
import com.unique.examine.service.IExamineTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审批任务表 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-02-15
 */
@Service
public class ExamineTaskServiceImpl extends ServiceImpl<ExamineTaskMapper, ExamineTask> implements IExamineTaskService {

}
