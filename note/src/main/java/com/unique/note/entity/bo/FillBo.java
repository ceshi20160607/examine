package com.unique.note.entity.bo;

import com.unique.core.bo.SearchBO;
import lombok.Data;

import java.util.List;

/**
 * @author UNIQUE
 * @create 2023-05-04
 * @verson 1.0.0
 */
@Data
public class FillBo extends SearchBO {

    private List<Integer> fillList;

}
