package com.unique.examine.controller;


import com.unique.core.common.Result;
import com.unique.examine.entity.bo.ExamineContext;
import com.unique.examine.service.IExamineTemplateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 审批任务日志表 前端控制器
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-15
 */
@RestController
@RequestMapping("/examineTemplate")
public class ExamineTemplateController {
    @Autowired
    private IExamineTemplateService iExamineTemplateService;

    /**
     * 添加审核，，审核业务初始化
     * @author UNIQUE
     * @date 2023/3/15
     */
    @PostMapping("/add")
    @ApiOperation("添加审批模板")
    public Result add(@RequestBody ExamineContext context){
        iExamineTemplateService.addOrUpdate(context);
        return Result.ok();
    }
}
