package com.unique.field.controller;


import cn.hutool.core.bean.BeanUtil;
import com.unique.core.common.Result;
import com.unique.field.entity.po.Field;
import com.unique.field.service.IFieldService;
import com.unique.note.entity.po.NoteCar;
import com.unique.note.entity.vo.FieldVo;
import com.unique.note.entity.vo.NoteCarVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 自定义字段表 前端控制器
 * </p>
 *
 * @author UNIQUE
 * @since 2023-08-28
 */
@RestController
@RequestMapping("/field")
public class FieldController {

    @Autowired
    private IFieldService iFieldService;


    @GetMapping("/queryField")
    @ApiOperation("根据ID查询")
    public Result<List<Field>> queryField(@RequestParam("type") @ApiParam(name = "type", value = "type")  Long type) {
        List<Field> fieldList = iFieldService.lambdaQuery().eq(Field::getModuleType, type).list();
        return Result.ok(fieldList);
    }

}
