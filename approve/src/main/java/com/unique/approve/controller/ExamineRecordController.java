package com.unique.approve.controller;


import com.unique.approve.entity.dto.ExamineContext;
import com.unique.approve.service.IExamineRecordService;
import com.unique.core.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 审核记录表 前端控制器
 * </p>
 *
 * @author UNIQUE
 * @since 2024-01-30
 */
@RestController
@RequestMapping("/examineRecord")
public class ExamineRecordController {

    @Autowired
    private IExamineRecordService examineRecordService;
    /**
     * 添加审核，，审核业务初始化
     * @author UNIQUE
     * @date 2023/3/15
     */
    @PostMapping("/create")
    @ApiOperation("添加审批")
    public Result create(@RequestBody ExamineContext context){
        examineRecordService.create(context);
        return Result.ok();
    }

    /**
     * 进行审核
     * @author UNIQUE
     * @date 2023/3/15
     */
    @PostMapping("/process")
    @ApiOperation("进行审批")
    public Result process(@RequestBody ExamineContext context){
        examineRecordService.process(context);
        return Result.ok();
    }

}
