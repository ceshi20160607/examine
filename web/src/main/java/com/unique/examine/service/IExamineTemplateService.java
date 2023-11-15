package com.unique.examine.service;

import com.unique.examine.entity.bo.ExamineContext;
import com.unique.examine.entity.po.ExamineTemplate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 审批任务日志表 服务类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-15
 */
public interface IExamineTemplateService extends IService<ExamineTemplate> {

    void addOrUpdate(ExamineContext context);
}
