package com.unique.javassist.swaggerbody;

import cn.hutool.core.util.ObjectUtil;
import io.swagger.models.Model;
import io.swagger.models.ModelImpl;
import io.swagger.models.Swagger;
import io.swagger.models.properties.*;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class SwaggerAop {

//    //新生产的model前缀
//    public static final String SWAGGER_BASE_CLASS_NAME ="swaggerCustom";
//    //客户的保存类名
//    public static final String CUSTOMER_ENTITY_CLASS_NAME ="CrmCustomerSaveNewBO";
//    //商机的保存类名
//    public static final String BUSINESS_ENTITY_CLASS_NAME ="CrmBusinessSaveNewBO";
//    //发票的保存类名
//    public static final String INVOICE_ENTITY_CLASS_NAME ="CrmInvoiceSaveNewBO";
//
//    @Pointcut(value = "execution(public * springfox.documentation.swagger2.mappers.ServiceModelToSwagger2MapperImpl.mapDocumentation(..))")
//    public void point(){
//    }
//
//    @Around("point()")
//    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        Swagger swagger = (Swagger) proceedingJoinPoint.proceed();
//        Map<String, Model> returnValue = swagger.getDefinitions() ;
//        //客户
//        createNewModel(CUSTOMER_ENTITY_CLASS_NAME,CrmEnum.CUSTOMER,returnValue,"entity");
//        //商机
//        createNewModel(BUSINESS_ENTITY_CLASS_NAME,CrmEnum.BUSINESS,returnValue,"entity");
//        //发票
//        createNewModel(INVOICE_ENTITY_CLASS_NAME,CrmEnum.INVOICE,returnValue,"entity");
//        return swagger;
//    }
//
//    /**
//     * 将 CRM 字段转换为模型属性
//     *
//     * @param type 类型
//     * @return {@link Property}
//     */
//    private Property turnCrmFieldToModelProperty(Integer type){
//        Property property = new StringProperty();
//        switch (FieldEnum.parse(type)){
//            case NUMBER:
//                property = new IntegerProperty();
//                break;
//            case NUMBER_FLOAT:
//                property = new DoubleProperty();
//                break;
//        }
//        return property;
//    }
//
//    /**
//     * 创建新模型
//     *
//     * @param entityName  处理对应的原始类
//     * @param crmEnum     CRM 枚举
//     * @param returnValue 数据源
//     */
//    private void createNewModel(String entityName,CrmEnum crmEnum,Map<String, Model> returnValue,String turnFieldName){
//        if(ObjectUtil.isNotEmpty(entityName)){
//            List<CrmFieldSort> allBusinessFieldSortList = ApplicationContextHolder.getBean(CrmFieldSortServiceImpl.class).queryAllFieldSortList(crmEnum.getType(), null);
//            Model baseModel = returnValue.get(entityName);
//            String newModelName = SWAGGER_BASE_CLASS_NAME + entityName;
//            if (ObjectUtil.isNotEmpty(baseModel)) {
//                Property property = baseModel.getProperties().get(turnFieldName);
//                if (ObjectUtil.isNotEmpty(property)) {
//                    ModelImpl newModel = new ModelImpl();
//                    newModel.setType("object");
//                    newModel.setName(newModelName);
//                    newModel.setDescription("全量的字段");
//                    allBusinessFieldSortList.forEach(fieldSort->{
//                        Property property1 = turnCrmFieldToModelProperty(fieldSort.getType());
//                        property1.setName(fieldSort.getFieldName());
//                        property1.setDescription(fieldSort.getName());
//                        property1.setRequired(fieldSort.getIsNull().equals(1)?Boolean.TRUE:Boolean.FALSE);
//                        newModel.property(fieldSort.getFieldName(), property1);
//                    });
//                    returnValue.put(newModelName,newModel);
//                }
//                baseModel.getProperties().put(turnFieldName,new RefProperty(newModelName));
//            }
//        }
//    }
}

