package com.unique.javassist.swaggerparams;

import com.fasterxml.classmate.TypeResolver;
import javassist.*;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterContext;

import java.util.*;
import java.util.stream.Collectors;


@Component
@Order
@AllArgsConstructor
public class ApiParamsModelBuilder implements ParameterBuilderPlugin {
    private static final Logger logger = LoggerFactory.getLogger(ApiParamsModelBuilder.class);

    //临时用到的类
    public static final String CRM_MODEL_FILED_VO = "com.kakarote.crm.entity.VO.CrmModelFiledVO";
    public static final String CRM_FIELD_EXTEND = "com.kakarote.crm.entity.PO.CrmFieldExtend";
    public static final String CRM_FIELD_NAME_KEY_ENTITY = "entity";
    public static final String CRM_FIELD_NAME_KEY_FIELD = "field";


    public static final String JAVASSIST_PARENT_SUFFIX = "Base";
    public static final String JAVASSIST_SUB_SUFFIX = "Model";
    public static final String JAVASSIST_DOCUMENT_BODY_KEY = "body";
    public static final String JAVASSIST_ANNOTATION_KEY_VALUE = "value";
    public static final String JAVASSIST_ANNOTATION_KEY_REQUIRED = "required";

    private final TypeResolver typeResolver;

    @Override
    public void apply(ParameterContext context) {

//        try {
//            // 从方法或参数上获取指定注解的Optional
//            Optional<ApiParamsModel> optional = context.getOperationContext().findAnnotation(ApiParamsModel.class);
//            if (!optional.isPresent()) {
//                optional = context.resolvedMethodParameter().findAnnotation(ApiParamsModel.class);
//            }
//            if (optional.isPresent()) {
//                Class originClass = context.resolvedMethodParameter().getParameterType().getErasedType();
//                String baseClassName = originClass.getName();
//                String simpleName = originClass.getSimpleName();
//                //配置参数
//                ApiParamsModel apiAnnotation = optional.get();
//                CrmEnum crmEnum = apiAnnotation.label();
//
//                ClassPool pool = ClassPool.getDefault();
//                pool.getCtClass(CRM_MODEL_FILED_VO);
//                pool.getCtClass(CRM_FIELD_EXTEND);
//                String basename = simpleName+ crmEnum.getIndex() + JAVASSIST_PARENT_SUFFIX;
//                String entityname = simpleName+ crmEnum.getIndex() + JAVASSIST_SUB_SUFFIX;
//                CtClass globalCtClass = pool.getCtClass(baseClassName);
//
//                CtClass baseclass = pool.makeClass(basename);
//                baseclass.setModifiers(Modifier.PUBLIC);
//                CtClass entityClass = pool.makeClass(entityname);
//                entityClass.setModifiers(Modifier.PUBLIC);
//
//                // 将生成的Class添加到SwaggerModels
//                context.getDocumentationContext().getAdditionalModels().add(typeResolver.resolve(createItemModel(crmEnum.getType(), entityClass)));
//                context.getDocumentationContext().getAdditionalModels().add(typeResolver.resolve(createCumtomModel(globalCtClass, baseclass, entityClass)));
//                // 修改Json参数的ModelRef为动态生成的class
//                context.parameterBuilder().parameterType(JAVASSIST_DOCUMENT_BODY_KEY).modelRef(new ModelRef(basename)).name(basename).description(JAVASSIST_DOCUMENT_BODY_KEY);
//                logger.error("@ApiParamsModel Error");
//
//            }
//        } catch (Exception e) {
//            logger.error("@ApiParamsModel Error", e);
//        }
    }


    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }

    /**
     * 创建子模型
     *
     * @param label       标签
     * @param entityClass 实体类
     * @return {@link Class}
     * @throws NotFoundException
     * @throws CannotCompileException
     */
    private Class createItemModel(Integer label, CtClass entityClass) throws NotFoundException, CannotCompileException {
//        List<CrmFieldSort> allFieldSortList = ApplicationContextHolder.getBean(CrmFieldSortServiceImpl.class).queryAllFieldSortList(label, UserUtil.getUserId());
//        for (CrmFieldSort crmFieldSort : allFieldSortList) {
//            CtField field = new CtField(turnCrmFieldToCtClass(crmFieldSort.getType()), crmFieldSort.getFieldName(), entityClass);
//            field.setModifiers(Modifier.PUBLIC);
//            //配置属性
//            ConstPool constPool = entityClass.getClassFile().getConstPool();
//            AnnotationsAttribute attr = new AnnotationsAttribute(constPool, AnnotationsAttribute.visibleTag);
//            javassist.bytecode.annotation.Annotation annotation = new javassist.bytecode.annotation.Annotation(ApiModelProperty.class.getName(), constPool);
//            annotation.addMemberValue(JAVASSIST_ANNOTATION_KEY_VALUE, new StringMemberValue(crmFieldSort.getName(), constPool));
//            if (crmFieldSort.getIsNull().equals(1)) {
//                annotation.addMemberValue(JAVASSIST_ANNOTATION_KEY_REQUIRED, new BooleanMemberValue(Boolean.TRUE, constPool));
//            }
//            attr.addAnnotation(annotation);
//            field.getFieldInfo().addAttribute(attr);
//
//            entityClass.addField(field);
//        }
        return entityClass.toClass();
    }

    /**
     * 创建返回模型
     *
     * @param globalCtClass 全球 CT 类
     * @param baseclass     基类
     * @param entityClass   实体类
     * @return {@link Class}
     * @throws NotFoundException
     * @throws CannotCompileException
     * @throws ClassNotFoundException
     */
    private Class createCumtomModel(CtClass globalCtClass, CtClass baseclass, CtClass entityClass) throws NotFoundException, CannotCompileException, ClassNotFoundException {
//        List<CtField> allField = getAllFields(globalCtClass);
//        for (CtField ctField : allField) {
//            String name = ctField.getName();
//            CtClass item = ctField.getType();
//            if (CRM_FIELD_NAME_KEY_ENTITY.equals(name)) {
//                item = entityClass;
//            } else if (CRM_FIELD_NAME_KEY_FIELD.equals(name)) {
//                CrmModelFiledVO[] field = {new CrmModelFiledVO()};
//                item = ClassPool.getDefault().getCtClass(field.getClass().getName());
//            }
//            CtField oldfield = new CtField(item, name, baseclass);
//            oldfield.setModifiers(Modifier.PUBLIC);
//            baseclass.addField(oldfield);
//        }
//        CtField shuzu = new CtField(ClassPool.getDefault().get("java.util.List"), "shuzu", baseclass);
//        shuzu.setModifiers(Modifier.PUBLIC);
//        baseclass.addField(shuzu);
        return baseclass.toClass();
    }

    /**
     * 获取所有字段
     *
     * @param clazz
     * @return {@link List}<{@link CtField}>
     * @throws NotFoundException
     */
    public List<CtField> getAllFields(CtClass clazz) throws NotFoundException {
        List<CtField> fieldList = new ArrayList<>();
        while (clazz != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        return fieldList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<CtField>(Comparator.comparing(CtField::getName))), ArrayList::new));
    }

    /**
     * 将 CRM 字段转换为 CtClass 类
     *
     * @param fieldType 字段类型
     * @return {@link CtClass}
     * @throws NotFoundException
     */
    private CtClass turnCrmFieldToCtClass(Integer fieldType) throws NotFoundException {
        String s = "java.lang.String";
//        switch (FieldEnum.parse(fieldType)) {
//            case NUMBER:
//                s = "int";
//                break;
//            case FLOATNUMBER:
//                s = "double";
//                break;
//            default:
//        }
        return ClassPool.getDefault().get(s);
    }

}
