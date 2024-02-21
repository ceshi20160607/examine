package com.unique.admin.entity.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.unique.core.enums.DeviceTypeEnum;
import com.unique.core.enums.LoginTypeEnum;
import lombok.Data;

/**
 * 用户
 *
 * @author UNIQUE
 * @date 2023/3/27
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)//jackson忽略参数
public class UserBO {

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
    private LoginTypeEnum loginType;

    /**
     * 模块类型
     */
    private DeviceTypeEnum deviceType;
}
