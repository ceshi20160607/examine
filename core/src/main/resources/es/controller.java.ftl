package ${package.Controller};


import com.kakarote.common.log.annotation.OperateLog;
import com.kakarote.common.log.entity.OperationResult;
import com.kakarote.common.log.enums.ApplyEnum;
import com.kakarote.common.log.enums.BehaviorEnum;
import com.kakarote.common.log.enums.OperateObjectEnum;
import com.kakarote.core.exception.CrmException;
import com.kakarote.crm.common.CrmModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.kakarote.core.common.Result;
import com.kakarote.core.entity.BasePage;
import com.kakarote.crm.entity.BO.*;
import com.kakarote.common.log.entity.OperationLog;

import ${package.Service}.${table.serviceName};

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    private ${table.serviceName} ${table.serviceName?uncap_first};


    /**
    * 查询所有数据
    *
    * @param search 业务查询对象
    * @return data
    */
    @PostMapping("/queryPageList")
    @ApiOperation("查询列表页数据")
    public Result<BasePage<Map<String, Object>>> queryPageList(@RequestBody CrmSearchBO search) {
        search.setPageType(1);
        BasePage<Map<String, Object>> mapBasePage = ${table.serviceName?uncap_first}.queryPageList(search);
        return Result.ok(mapBasePage);
    }
    /**
    * 新建页面字段
    *
    */
    @PostMapping("/field")
    @ApiOperation("查询新增所需字段")
    public Result<List> queryField(@RequestParam(value = "type", required = false) String type) {
        if (StrUtil.isNotEmpty(type)) {
            return Result.ok(${table.serviceName?uncap_first}.queryField(null));
        }
        return Result.ok(${table.serviceName?uncap_first}.queryFormPositionField(null));
    }

    /**
    * 编辑页面字段
    *
    * @param id
    */
    @PostMapping("/field/{id}")
    @ApiOperation("查询修改数据所需信息")
    public Result<List> queryFieldPath(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id,
    @RequestParam(value = "type", required = false) String type) {
        if (StrUtil.isNotEmpty(type)) {
            List<CrmModelFieldVO> collect = ${table.serviceName?uncap_first}.queryField(id).stream().filter(field -> !field.getFieldName().equals("ownerUserId")).collect(Collectors.toList());
            return Result.ok(collect);
        }
        return Result.ok(${table.serviceName?uncap_first}.queryFormPositionField(id));
    }

    /**
    * 保存数据
    *
    * @param crmModel 业务对象
    * @return data
    */
    @PostMapping("/add")
    @ApiOperation("保存数据")
    @OperateLog(behavior = BehaviorEnum.SAVE, apply = ApplyEnum.CRM, object = OperateObjectEnum.CUSTOMER)
    public Result<Map<String, Object>> add(@RequestBody CrmBusinessSaveBO crmModel) {
        Map<String, Object> map = ${table.serviceName?uncap_first}.addOrUpdate(crmModel, false, null);
        Object operation = map.get("operation");
        map.remove("operation");
        return OperationResult.ok(map, (List<OperationLog>) operation);
    }
    /**
    * 更新数据
    *
    * @param crmModel 业务对象
    * @return data
    */
    @PostMapping("/update")
    @ApiOperation("修改数据")
    @OperateLog(behavior = BehaviorEnum.UPDATE, apply = ApplyEnum.CRM, object = OperateObjectEnum.CUSTOMER)
    public Result<Map<String, Object>> update(@RequestBody CrmBusinessSaveBO crmModel) {
        Map<String, Object> map = ${table.serviceName?uncap_first}.addOrUpdate(crmModel, false, null);
        Object operation = map.get("operation");
        map.remove("operation");
        return OperationResult.ok(map, (List<OperationLog>) operation);
    }
    /**
    * 查询数据
    * @param id 业务对象id
    * @return data
    */
    @PostMapping("/queryById/{id}")
    @ApiOperation("根据ID查询")
    public Result<CrmModel> queryById(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {
        boolean exists = ${table.serviceName?uncap_first}.lambdaQuery().eq( ${entity}::getId, id).ne(CrmCustomer::getStatus, 3).exists();
        if (!exists) {
            throw new CrmException(CrmCodeEnum.CRM_DATA_DELETED, CrmEnum.CUSTOMER.getType());
        }
        CrmModel model = ${table.serviceName?uncap_first}.queryById(id);
        return Result.ok(model);
    }
    /**
    * 查询详情页基本信息
    *
    * @param  id
    * @return data
    */
    @PostMapping("/information/{id}")
    @ApiOperation("查询详情页信息")
    public Result<List<CrmModelFieldVO>> information(@PathVariable("id") @ApiParam(name = "id", value = "id") Long id) {

    List<CrmModelFieldVO> information = ${table.serviceName?uncap_first}.information(id);

    return Result.ok(information);
    }
    /**
    * 删除数据
    * @param ids 业务对象ids
    * @return data
    */
    @PostMapping("/deleteByIds")
    @ApiOperation("根据ID删除数据")
    public Result deleteByIds(@ApiParam(name = "ids", value = "id列表") @RequestBody List<Long> ids) {
        List<OperationLog> operationLogList = ${table.serviceName?uncap_first}.deleteByIds(ids);
        return OperationResult.ok(operationLogList);
    }


}
</#if>

