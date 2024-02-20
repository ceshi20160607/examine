package com.unique.approve.controller;


import com.unique.approve.entity.po.ExamineRecordNode;
import com.unique.approve.service.IExamineRecordNodeService;
import com.unique.core.common.BasePage;
import com.unique.core.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/queryList/{examineRecordId}")
    public Result list(@PathVariable("examineRecordId") Long examineRecordId){
//        BasePage<ExamineRecordNode> ret = examineRecordNodeService.pageList(examineRecordId);
        return Result.ok(null);
    }
}
