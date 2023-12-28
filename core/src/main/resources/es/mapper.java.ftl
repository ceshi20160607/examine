package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};
<#if mapperAnnotation>
import org.apache.ibatis.annotations.Mapper;
</#if>

import com.kakarote.crm.common.CrmModel;
import com.kakarote.core.entity.BasePage;
import com.kakarote.crm.entity.BO.CrmSearchBO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
/**
 * <p>
 * ${table.comment!} Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if mapperAnnotation>
@Mapper
</#if>
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {



BasePage<Map<String, Object>> queryPageList(BasePage<Object> parse, @Param("search") CrmSearchBO search);
 /**
 * 根据客户id，获取客户摘要
 *
 * @param id 主键ID
 * @return data
 */
 CrmModel queryDigestById(@Param("id") Long id);
 /**
 * 通过id查询客户数据
 *
 * @param id     id
 * @return data
 */
 CrmModel queryById(@Param("id") Long id);
}
</#if>
