package com.unique.examine.service;

import com.unique.examine.common.context.ExamineContext;
import com.unique.examine.entity.po.Examine;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 审批表 服务类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-15
 */
public interface IExamineService extends IService<Examine> {

    void addOrUpdate(ExamineContext context);

    void process(ExamineContext context);
}
