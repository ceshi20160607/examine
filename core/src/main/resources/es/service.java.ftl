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
    * 查询字段配置
    *
    * @param id 主键ID
    */
    List<CrmModelFieldVO> queryField(Long id);
    /**
    * 查询字段配置
    *
    * @param id 主键ID
    */
    List<List<CrmModelFieldVO>> queryFormPositionField(Long id);

    /**
    * 保存或新增信息
    *
    * @param crmModel model
    */
    Map<String, Object> addOrUpdate(CrmBusinessSaveBO crmModel, boolean isExcel);

    /**
    * 查询字段配置
    *
    * @param id     主键ID
    * @return data
    */
    CrmModel queryById(Long id);

    /**
    * 查询详情
    *
    * @param id     主键ID
    */
    public List<CrmModelFieldVO> information(Long id);

    /**
    * 删除客户数据
    *
    * @param ids ids
    */
    List<OperationLog> deleteByIds(List<Long> ids);

    /**
    * 根据客户id，获取客户摘要
    *
    * @param id 主键ID
    * @return data
    */
    CrmModel queryDigestById(Long id);
}
</#if>
