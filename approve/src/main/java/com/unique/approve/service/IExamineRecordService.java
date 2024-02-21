package com.unique.approve.service;

import com.unique.approve.entity.dto.ExamineContext;
import com.unique.approve.entity.po.ExamineRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 审核记录表 服务类
 * </p>
 *
 * @author UNIQUE
 * @since 2024-01-30
 */
public interface IExamineRecordService extends IService<ExamineRecord> {

    void create(ExamineContext context);

    void process(ExamineContext context);
}
