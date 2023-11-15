package com.unique.core.common.bo;

import com.unique.core.common.enums.FieldEnum;
import com.unique.core.common.enums.SearchFieldEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author UNIQUE
 * @create 2023-03-10
 * @verson 1.0.0
 */
@Data
public class BaseSearch implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String fieldName ;
    /**
     * 名称
     */
    private FieldEnum fieldEnum ;

    /**
     * 条件
     */
    private SearchFieldEnum searchFieldEnum ;

    /**
     * 值
     */
    private String value ;

    /**
     * 模块类型
     */
    private Integer moduleType;
}
