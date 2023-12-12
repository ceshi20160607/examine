package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

import com.kakarote.common.log.entity.OperationLog;
import com.kakarote.crm.common.CrmModel;
import com.kakarote.crm.entity.BO.*;
import com.kakarote.core.entity.BasePage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {


    /**
    * 查询所有数据
    *
    * @param search 搜索数据
    * @return data
    */
    BasePage<Map<String, Object>> queryPageList(CrmSearchBO search);

    /**
    * 保存或新增信息
    *
    * @param ${entity} model
    */
    Map<String, Object> addOrUpdate(${entity} crmModel, boolean isExcel);

    /**
    * 查询字段配置
    *
    * @param id     主键ID
    * @return data
    */
    ${entity} queryById(Long id);


    /**
    * 删除客户数据
    *
    * @param ids ids
    */
    List<OperationLog> deleteByIds(List<Long> ids);

}
</#if>
