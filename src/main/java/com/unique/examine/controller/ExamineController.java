package com.unique.examine.controller;


import com.unique.core.common.Result;
import com.unique.examine.common.context.ExamineContext;
import com.unique.examine.service.IExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 审批表 前端控制器
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-15
 */
@RestController
@RequestMapping("/examine")
public class ExamineController {

    @Autowired
    private IExamineService iExamineService;

    /**
     * 添加审核，，审核业务初始化
     * @author UNIQUE
     * @date 2023/3/15
     */
    @PostMapping("/add")
    public Result add(@RequestBody ExamineContext context){
        iExamineService.addOrUpdate(context);
        return Result.ok();
    }




    /**
     * 进行审核
     * @author UNIQUE
     * @date 2023/3/15
     */
    @PostMapping("/process")
    public Result process(@RequestBody ExamineContext context){
        iExamineService.process(context);
        return Result.ok();
    }



}
