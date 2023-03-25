package com.unique.admin.controller;


import com.unique.admin.entity.po.AdminUser;
import com.unique.admin.service.IAdminUserService;
import com.unique.core.common.BasePage;
import com.unique.core.common.Result;
import com.unique.core.common.bo.SearchBO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-25
 */
@RestController
@RequestMapping("/adminUser")
public class AdminUserController {

    @Autowired
    private IAdminUserService iAdminUserService;

    @PostMapping("/add")
    @ApiOperation("保存数据")
    public Result add(@RequestBody AdminUser adminUser) {
        iAdminUserService.save(adminUser);
        return Result.ok();
    }

    @PostMapping("/update")
    @ApiOperation("修改数据")
    public Result update(@RequestBody AdminUser adminUser) {
       /* if (AuthUtil.isRwAuth((Integer) crmModel.getEntity().get("businessId"), CrmEnum.BUSINESS, CrmAuthEnum.EDIT)) {
            throw new CrmException(SystemCodeEnum.SYSTEM_NO_AUTH);
        }*/
        iAdminUserService.updateById(adminUser);
        return Result.ok();
    }

    @PostMapping("/queryPageList")
    @ApiOperation("查询列表页数据")
    public Result<BasePage<Map<String, Object>>> queryPageList(@RequestBody SearchBO search) {
        search.setPageType(1);
        BasePage<Map<String, Object>> mapBasePage = new BasePage<>();
        return Result.ok(mapBasePage);
    }

    @PostMapping("/queryById")
    @ApiOperation("根据ID查询")
    public Result<AdminUser> queryById(@RequestParam("id") @ApiParam(name = "id", value = "id") Long id) {
        AdminUser adminUser = iAdminUserService.getById(id);
        adminUser.setPassword(null);
        adminUser.setSalt(null);
        return Result.ok(adminUser);
    }

    @PostMapping("/deleteById")
    @ApiOperation("根据ID删除数据")
    public Result deleteById(@ApiParam(name = "ids", value = "id列表") @RequestBody List<Long> ids) {
        iAdminUserService.removeByIds(ids);
        return Result.ok();
    }
}
