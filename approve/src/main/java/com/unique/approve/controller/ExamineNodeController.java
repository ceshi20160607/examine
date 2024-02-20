package com.unique.approve.controller;


import com.unique.approve.entity.dto.ExamineContext;
import com.unique.approve.service.IExamineNodeService;
import com.unique.core.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 审批节点表 前端控制器
 * </p>
 *
 * @author UNIQUE
 * @since 2024-01-30
 */
@RestController
@RequestMapping("/examineNode")
public class ExamineNodeController {

    @Autowired
    private IExamineNodeService examineNodeService;
    /**
     * 添加审核，，审核业务初始化
     * @author UNIQUE
     * @date 2023/3/15
     */
    @PostMapping("/add")
    @ApiOperation("添加审批节点")
    public Result add(@RequestBody ExamineContext context){
//        examineNodeService.addOrUpdate(context);
        return Result.ok();
    }
}
