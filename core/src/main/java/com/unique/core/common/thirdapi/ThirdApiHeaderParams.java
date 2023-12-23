package com.unique.core.common.thirdapi;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ThirdApiHeaderParams implements Serializable {
    private String key;
    private String value;
    private Boolean headerFlag;
}
