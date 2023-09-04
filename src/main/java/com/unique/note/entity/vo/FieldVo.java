package com.unique.note.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.unique.field.entity.po.Field;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 自定义字段表
 * </p>
 *
 * @author UNIQUE
 * @since 2023-08-28
 */
@Data
@ApiModel(value = "Field对象", description = "自定义字段表")
public class FieldVo extends Field {


    @ApiModelProperty("值")
    private String valueSingle;


    @ApiModelProperty("值--列")
    private List<Object> valueList;


}
