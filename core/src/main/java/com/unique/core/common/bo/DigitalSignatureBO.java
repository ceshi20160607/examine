package com.unique.core.common.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.wildfly.common.annotation.NotNull;

import java.io.Serializable;

@Data
@ApiModel("客户增量同步BO")
public class DigitalSignatureBO implements Serializable {

    @NotNull
    @ApiModelProperty("业务操作 save(保存) update（更新）")
    private String operate;
    @NotNull
    @ApiModelProperty("json字符串数据data加密")
    private String data;
    @NotNull
    @ApiModelProperty("数据签名")
    private String sign;
}
