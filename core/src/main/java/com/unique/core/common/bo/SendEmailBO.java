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
public class SendEmailBO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 邮箱
     */
    private String[] emails;

}
