package com.unique.approve.controller;


import com.unique.approve.entity.bo.ExamineSaveBO;
import com.unique.approve.entity.dto.ExamineContext;
import com.unique.approve.entity.dto.ExamineNodeFill;
import com.unique.approve.service.IExamineService;
import com.unique.core.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 审批表 前端控制器
 * </p>
 *
 * @author UNIQUE
 * @since 2024-01-30
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
    public Result add(@RequestBody ExamineSaveBO saveBO){
        iExamineService.addOrUpdate(saveBO);
        return Result.ok();
    }

}
