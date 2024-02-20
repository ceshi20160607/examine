package com.unique.approve.service;

import com.unique.approve.entity.dto.ExamineContext;
import com.unique.approve.entity.po.Examine;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 审批表 服务类
 * </p>
 *
 * @author UNIQUE
 * @since 2024-01-30
 */
public interface IExamineService extends IService<Examine> {

    void addOrUpdate(ExamineContext context);

    void process(ExamineContext context);
}
