package com.unique.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ApproveProperties.class)
public class ApproveConfig {
    @Autowired
    @Qualifier(value = "approveProperties")
    public void setApproveConfig(ApproveProperties approveProperties){
        ApproveConfig.approveProperties = approveProperties;
    }

    public static ApproveProperties approveProperties;
}
