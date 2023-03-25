package com.unique.examine.controller;


import com.unique.core.common.Result;
import com.unique.examine.entity.bo.ExamineContext;
import com.unique.examine.service.IExamineService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/test")
    @ApiOperation("test")
    public Result test(){
        return Result.ok();
    }

    /**
     * 添加审核，，审核业务初始化
     * @author UNIQUE
     * @date 2023/3/15
     */
    @PostMapping("/add")
    @ApiOperation("添加审批")
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
    @ApiOperation("进行审批")
    public Result process(@RequestBody ExamineContext context){
        iExamineService.process(context);
        return Result.ok();
    }



}
