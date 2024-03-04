package com.unique.approve.controller;


import com.unique.approve.entity.bo.ExamineSaveBO;
import com.unique.approve.entity.bo.ExamineSearchBO;
import com.unique.approve.entity.dto.ExamineContext;
import com.unique.approve.entity.dto.ExamineNodeFill;
import com.unique.approve.entity.vo.ExamineVO;
import com.unique.approve.service.IExamineService;
import com.unique.core.common.BasePage;
import com.unique.core.common.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private IExamineService examineService;

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
        examineService.addOrUpdate(saveBO);
        return Result.ok();
    }
    @PostMapping("/update")
    @ApiOperation("修改审批")
    public Result update(@RequestBody ExamineSaveBO saveBO){
        examineService.addOrUpdate(saveBO);
        return Result.ok();
    }
    @PostMapping("/queryPageList")
    @ApiOperation("查询")
    public Result<BasePage<ExamineVO>> queryPageList(@RequestBody ExamineSearchBO searchBO){
        BasePage<ExamineVO> ret = examineService.queryPageList(searchBO);
        return Result.ok(ret);
    }
    @PostMapping("/deteleByIds")
    @ApiOperation("删除审批")
    public Result deteleByIds(@ApiParam(name = "ids", value = "id列表") @RequestBody List<Long> ids){
        examineService.deteleByIds(ids);
        return Result.ok();
    }

}
