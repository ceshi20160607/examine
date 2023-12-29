package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.kakarote.common.field.service.FieldDataService;
import com.kakarote.common.field.utils.FieldUtil;
import com.kakarote.core.servlet.ApplicationContextHolder;
import com.kakarote.core.utils.UserCacheUtil;
import com.kakarote.crm.common.ActionRecordUtil;
import com.kakarote.crm.constant.CrmEnum;
import com.kakarote.crm.entity.PO.CrmActionRecord;
import com.kakarote.crm.entity.PO.CrmField;
import com.kakarote.crm.entity.PO.CrmQuote;
import com.kakarote.crm.mapper.CrmQuoteMapper;
import com.kakarote.crm.service.*;
import com.kakarote.core.servlet.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakarote.common.log.entity.OperationLog;
import com.kakarote.core.entity.BasePage;
import com.kakarote.crm.common.CrmModel;
import com.kakarote.crm.entity.BO.*;

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
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} , CrmPageService{

    @Autowired
    private ICrmActionRecordService crmActionRecordService;
    @Autowired
    private ActionRecordUtil actionRecordUtil;
    @Autowired
    private ICrmFieldService crmFieldService;

    @Autowired
    private FieldDataService fieldDataService;
    /**
    * 导出时查询所有数据
    *
    * @param search 业务查询对象
    * @return data
    */
    @Override
    public BasePage<Map<String, Object>> queryPageList(CrmSearchBO search) {
        BasePage<Map<String, Object>> basePage = queryList(search);
        return basePage;
    }

    /**
    * 查询字段配置
    *
    * @param id 主键ID
    * @return data
    */
    @Override
    public List<CrmModelFieldVO> queryField(Long id) {
        CrmModel crmModel = queryById(id, null);
        List<CrmModelFieldVO> vos = crmFieldService.queryField(crmModel, true);

        return vos;
    }
    /**
    * 查询字段配置
    *
    * @param id 主键ID
    * @return data
    */
    @Override
    public List<List<CrmModelFieldVO>> queryFormPositionField(Long id) {
        CrmModel crmModel = queryById(id);

        List<List<CrmModelFieldVO>> vos = crmFieldService.queryFormPositionFieldVO(crmModel, true);

        for (List<CrmModelFieldVO> filedVOList : vos) {
            filedVOList.forEach(field -> {
                if ("ownerUserId".equals(field.getFieldName())) {
                    SimpleUser user = new SimpleUser();
                    user.setUserId(UserUtil.getUserId());
                    user.setRealname(UserUtil.getUser().getRealname());
                    field.setDefaultValue(Collections.singleton(user));
                }
            });
        }

        return vos;
    }
    /**
    * 保存或新增信息
    *
    * @param crmModel model
    */
    @Override
    public Map<String, Object> addOrUpdate(CrmBusinessSaveBO crmModel, boolean isExcel) {
        Map<String, Object> map = new HashMap<>();
        List<OperationLog> operationLogList = new ArrayList<>();
        OperationLog operationLog = new OperationLog();

        setData(crmModel.getEntity());
        ${entity} newModel = BeanUtil.copyProperties(crmModel.getEntity(), ${entity}.class);
        if (ObjectUtil.isEmpty(newModel.getId())){
            save(newModel);
<#--            crmActivityService.addActivity(2, CrmActivityEnum.CUSTOMER, crmCustomer.getCustomerId());-->
<#--            CrmActionRecord crmActionRecord = actionRecordUtil.addRecord(crmCustomer.getCustomerId(), CrmEnum.CUSTOMER, crmCustomer.getCustomerName());-->

            operationLog.setOperationObject(newModel.getCustomerId(), newModel.getCustomerName());
            operationLog.setOperationInfo(crmActionRecord.getDetail());
        }else {
            ${entity} old = getById(newModel.getId());
            newModel.setUpdateTime(LocalDateTime.now());

            Map<String, Object> oldMap = BeanUtil.beanToMap(old);
            Map<String, Object> newMap = BeanUtil.beanToMap(newModel);
            updateById(newModel);

            actionRecordUtil.updateRecord(BeanUtil.beanToMap(old), BeanUtil.beanToMap(newModel), CrmEnum.CUSTOMER, newModel.getName(), newModel.getId());
            List<String> updateRecord = actionRecordUtil.updateRecord(oldMap, newMap, CrmEnum.CUSTOMER, newModel.getName(), newModel.getId(), crmModel.getSaveType());

            operationLog.setOperationObject(newModel.getCustomerId(), newModel.getCustomerName());
            operationLog.setOperationInfo(JSONUtil.toJsonStr(updateRecord));
            operationLogList.add(operationLog);
        }

        ${entity} retModel = getById(newModel.getId());
        crmModel.setEntity(BeanUtil.beanToMap(retModel));
        savePage(crmModel, retModel.getId(), isExcel);

        Map<String, Object> map = new HashMap<>();
        map.put("customerId", retModel.getCustomerId());
        map.put("customerName", retModel.getCustomerName());
        map.put("operation", operationLogList);
        return map;
    }


    /**
    * 查询字段配置
    *
    * @param id 主键ID
    * @return data
    */
    @Override
    public CrmModel queryById(Long id) {
        CrmModel crmModel;
        if (id != null) {
            crmModel = getBaseMapper().queryById(id);
            Long ownerUserId = crmModel.getOwnerUserId();

            crmModel.setLabel(getLabel().getType());
            crmModel.setOwnerUserName(UserCacheUtil.getUserName(ownerUserId));
            fieldDataService.setDataByBatchId(crmModel, getLabel());
            List<String> stringList = ApplicationContextHolder.getBean(ICrmRoleFieldService.class).queryNoAuthField(crmModel.getLabel(), crmModel.getOwnerUserId());
            stringList.forEach(crmModel::remove);
            // 客户详情摘要
            CrmModel digest = queryDigestById(id);
            crmModel.put("digest", digest);
        } else {
            crmModel = new CrmModel(CrmEnum.CUSTOMER.getType());
        }
        return crmModel;
    }
    /**
    * 查询详情
    *
    * @param id     主键ID
    */
    @Override
    public List<CrmModelFieldVO> information(Long id) {
        List<CrmModelFieldVO> collect = queryField(id, true);
        //collect.removeIf(r -> Arrays.asList("ownerUserId", "owner_user_name").contains(r.getFieldName()));
        return collect;
    }
    /**
    * 删除客户数据
    *
    * @param ids ids
    */
    @Override
    public List<OperationLog> deleteByIds(List<Long> ids) {
        removeByIds(ids);
        //删除文件
        //adminFileService.delete(batchList);
        //删除跟进记录
        //crmActivityService.deleteActivityRecord(ids);
        //删除字段操作记录
        //crmActionRecordService.deleteActionRecord(CrmEnum.CUSTOMER, ids);
        //删除自定义字段
        //fieldDataService.deleteByDataId(ids, getLabel());
        //crmBackLogDealService.deleteByTypeIds(ids, CrmBackLogEnum.TO_ENTER_CUSTOMER_POOL);
        deletePage(ids);
        List<OperationLog> operationLogList = new ArrayList<>();
        return operationLogList;
    }

    @Override
    public CrmModel queryDigestById(Long id) {
        return getBaseMapper().queryDigestById(id);
    }

    /**
    * 判断类型
    */
    private void setData(Map<String, Object> entity) {
        List<CrmField> fieldList = crmFieldService.lambdaQuery().eq(CrmField::getLabel, getLabel().getType()).eq(CrmField::getFieldType, 1).list();
        for (CrmField crmField : fieldList) {
            if (entity.get(crmField.getFieldName()) != null) {
                String value = FieldUtil.format2DbString(entity.get(crmField.getFieldName()), crmField.getType(), entity.get(crmField.getFieldName()).toString());
                entity.put(crmField.getFieldName(), value);
            }
        }
    }
}
</#if>
