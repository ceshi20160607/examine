package com.unique.admin.controller;


import com.unique.admin.entity.po.AdminDept;
import com.unique.admin.service.IAdminDeptService;
import com.unique.core.common.BasePage;
import com.unique.core.common.Result;
import com.unique.core.bo.SearchBO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-25
 */
@RestController
@RequestMapping("/adminDept")
public class AdminDeptController {
    @Autowired
    private IAdminDeptService iAdminDeptService;

    @PostMapping("/add")
    @ApiOperation("保存数据")
    public Result add(@RequestBody AdminDept adminDept) {
        iAdminDeptService.save(adminDept);
        return Result.ok();
    }

    @PostMapping("/update")
    @ApiOperation("修改数据")
    public Result update(@RequestBody AdminDept adminDept) {
        iAdminDeptService.updateById(adminDept);
        return Result.ok();
    }

    @PostMapping("/queryPageList")
    @ApiOperation("查询列表页数据")
    public Result<BasePage<List<AdminDept>>> queryPageList(@RequestBody SearchBO search) {
        search.setPageType(1);
        BasePage<List<AdminDept>> mapBasePage = iAdminDeptService.queryPageList(search);
        return Result.ok(mapBasePage);
    }

    @PostMapping("/queryById")
    @ApiOperation("根据ID查询")
    public Result<AdminDept> queryById(@RequestParam("id") @ApiParam(name = "id", value = "id") Long id) {
        AdminDept adminDept = iAdminDeptService.getById(id);
        return Result.ok(adminDept);
    }

    @PostMapping("/deleteById")
    @ApiOperation("根据ID删除数据")
    public Result deleteById(@ApiParam(name = "ids", value = "id列表") @RequestBody List<Long> ids) {
        iAdminDeptService.removeByIds(ids);
        return Result.ok();
    }
}
