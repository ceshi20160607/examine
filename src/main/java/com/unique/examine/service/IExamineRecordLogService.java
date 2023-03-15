package com.unique.examine.service;

import com.unique.examine.entity.po.ExamineRecordLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 审批任务日志表 服务类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-15
 */
public interface IExamineRecordLogService extends IService<ExamineRecordLog> {

    List<ExamineRecordLog> pageList(Long examineRecordId);
}
