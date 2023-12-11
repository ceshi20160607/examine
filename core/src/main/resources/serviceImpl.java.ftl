package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

import com.kakarote.common.log.entity.OperationLog;
import com.kakarote.core.entity.BasePage;
import com.kakarote.crm.common.CrmModel;
import com.kakarote.crm.entity.BO.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Autowired
    private ICrmActionRecordService crmActionRecordService;
    @Autowired
    private ActionRecordUtil actionRecordUtil;

    /**
    * 导出时查询所有数据
    *
    * @param search 业务查询对象
    * @return data
    */
    @Override
    public BasePage<Map<String, Object>> queryPageList(CrmSearchBO search) {
        BasePage<Map<String, Object>> basePage = getBaseMapper().queryPageList(search.parse(),search);
        return basePage;
    }
    /**
    * 保存或新增信息
    *
    * @param crmModel model
    */
    @Override
    public Map<String, Object> addOrUpdate(CrmBusinessSaveBO crmModel, boolean isExcel) {
        Map<String, Object> map = new HashMap<>();
        CrmParams newModel = BeanUtil.copyProperties(crmModel.getEntity(), CrmParams.class);
        if (ObjectUtil.isEmpty(newModel.getId())){
        save(newModel);
        actionRecordUtil.addRecord(newModel.getId(), CrmEnum.CUSTOMER, newModel.getName());
        }else {
        CrmParams old = getById(newModel.getId());
        newModel.setUpdateTime(LocalDateTime.now());
        updateById(newModel);
        actionRecordUtil.updateRecord(BeanUtil.beanToMap(old), BeanUtil.beanToMap(newModel), CrmEnum.CUSTOMER, newModel.getName(), newModel.getId());
        }
        map.put("id", newModel.getId());
        return map;
    }


    /**
    * 查询字段配置
    *
    * @param id 主键ID
    * @return data
    */
    @Override
    public ${entity} queryById(Long id) {
        ${entity} byId = getById(id);
        if (ObjectUtil.isNotEmpty(byId)) {
        return byId;
        }
        return new ${entity}();
    }

    /**
    * 删除客户数据
    *
    * @param ids ids
    */
    @Override
    public List<OperationLog> deleteByIds(List<Long> ids) {
        removeByIds(ids);
        //删除字段操作记录
        crmActionRecordService.deleteActionRecord(CrmEnum.CUSTOMER, ids);
        List<OperationLog> operationLogList = new ArrayList<>();
        return operationLogList;
    }

}
</#if>
