package com.unique.approve.controller;


import com.unique.approve.entity.dto.ExamineNodeFill;
import com.unique.approve.entity.po.ExamineRecordNode;
import com.unique.approve.service.IExamineRecordNodeService;
import com.unique.core.common.BasePage;
import com.unique.core.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 审批节点表 前端控制器
 * </p>
 *
 * @author UNIQUE
 * @since 2024-01-30
 */
@RestController
@RequestMapping("/examineRecordNode")
public class ExamineRecordNodeController {

    @Autowired
    private IExamineRecordNodeService examineRecordNodeService;
    @PostMapping("/fillNodeUser")
    @ApiOperation("设置自选审批人")
    public Result fillNodeUser(@RequestBody ExamineNodeFill examineNodeFill){
        examineRecordNodeService.fillNodeUser(examineNodeFill);
        return Result.ok();
    }
    @PostMapping("/addNewNode")
    @ApiOperation("动态添加审批节点")
    public Result addNewNode(@RequestBody ExamineNodeFill examineNodeFill){
        //todo:动态添加审批节点
        return Result.ok();
    }


    @GetMapping("/queryList/{examineRecordId}")
    public Result list(@PathVariable("examineRecordId") Long examineRecordId){
//        BasePage<ExamineRecordNode> ret = examineRecordNodeService.pageList(examineRecordId);
        return Result.ok(null);
    }
}
