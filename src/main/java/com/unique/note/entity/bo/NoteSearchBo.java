package com.unique.note.entity.bo;

import com.unique.core.common.bo.SearchBO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author UNIQUE
 * @create 2023-05-04
 * @verson 1.0.0
 */
@Data
public class NoteSearchBo extends SearchBO {

    private String startTime;
    private String endTime;

}
