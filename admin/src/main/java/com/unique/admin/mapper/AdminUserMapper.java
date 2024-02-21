package com.unique.admin.mapper;

import com.unique.admin.entity.po.AdminUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.unique.admin.entity.vo.AdminUserVO;
import com.unique.core.common.BasePage;
import com.unique.core.bo.SearchBO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author UNIQUE
 * @since 2023-03-25
 */
public interface AdminUserMapper extends BaseMapper<AdminUser> {

    BasePage<List<AdminUserVO>> queryPageList(BasePage<Object> parse, @Param("search") SearchBO search);
}
