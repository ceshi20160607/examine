package com.unique.examine.controller;


import com.unique.core.common.Result;
import com.unique.examine.entity.po.ExamineRecordLog;
import com.unique.examine.service.IExamineRecordLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 审批任务日志表 前端控制器
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-15
 */
@RestController
@RequestMapping("/examineRecordLog")
public class ExamineRecordLogController {

    @Autowired
    private IExamineRecordLogService iExamineRecordLogService;

    @GetMapping("/recordLogList/{examineRecordId}")
    public Result list(@PathVariable("examineRecordId") Long examineRecordId){
        List<ExamineRecordLog> ret = iExamineRecordLogService.pageList(examineRecordId);
        return Result.ok(ret);
    }
}
