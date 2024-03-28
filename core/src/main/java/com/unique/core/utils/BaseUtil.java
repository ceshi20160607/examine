package com.unique.core.utils;

import cn.hutool.core.util.IdUtil;
import com.unique.core.config.ApproveConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * @author ceshi
 * @description 基础工具类
 * @date 2022/11/26 9:23
 */

public class BaseUtil {

    /**
     * 获取long类型的id，雪花算法
     * @return id
     */
    public static Long getNextId(){
        return IdUtil.getSnowflake(ApproveConfig.approveProperties.workerId, ApproveConfig.approveProperties.datacenterId).nextId();
    }


}
