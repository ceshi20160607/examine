package com.unique.admin.entity.bo;

import com.unique.examine.common.enums.FieldEnum;
import com.unique.examine.common.enums.SearchFieldEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 *
 * @author UNIQUE
 * @date 2023/3/27
 */
@Data
public class UserBO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String username;
    /**
     * 名称
     */
    private String password;

    /**
     * 值
     */
    private Integer logintType;

    /**
     * 模块类型
     */
    private Integer deviceType;
}
