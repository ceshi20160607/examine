package com.unique.core.bo;

import com.unique.core.common.BasePage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author UNIQUE
 * @create 2023-03-10
 * @verson 1.0.0
 */
@Data
public class SearchBO  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 查询keyword
     */
    private String keyword ;

    /**
     * 模块类型
     */
    private Integer moduleType;


    @ApiModelProperty("当前页数")
    private Integer page = 1;

    @ApiModelProperty("每页展示条数")
    private Integer limit = 15;

    @ApiModelProperty(value = "是否分页，0:不分页 1 分页", allowableValues = "0,1")
    private Integer pageType = 1;

    public <T> BasePage<T> parse() {
        return new BasePage<>(page, limit);
    }

}
