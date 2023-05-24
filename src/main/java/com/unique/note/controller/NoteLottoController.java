package com.unique.note.controller;


import cn.hutool.core.bean.BeanUtil;
import com.unique.core.common.BasePage;
import com.unique.core.common.Result;
import com.unique.note.entity.bo.NoteSearchBo;
import com.unique.note.entity.po.NoteCar;
import com.unique.note.entity.vo.NoteCarVo;
import com.unique.note.service.INoteCarService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 购买彩票 前端控制器
 * </p>
 *
 * @author UNIQUE
 * @since 2023-04-23
 */
@RestController
@RequestMapping("/note-lotto")
public class NoteLottoController {

//    @Autowired
//    private INoteCarService iNoteCarService;
//
//
//    @PostMapping("/add")
//    @ApiOperation("保存数据")
//    public Result add(@RequestBody NoteCar car) {
//        iNoteCarService.save(car);
//        return Result.ok();
//    }
//
//    @PostMapping("/update")
//    @ApiOperation("修改数据")
//    public Result update(@RequestBody NoteCar car) {
//        iNoteCarService.updateById(car);
//        return Result.ok();
//    }
//
//    @PostMapping("/queryList")
//    @ApiOperation("查询工商照面信息")
//    public Result<BasePage<NoteCarVo>> queryList(@RequestBody NoteSearchBo searchBo) {
//        BasePage<NoteCarVo> carBasePage = iNoteCarService.queryList(searchBo);
//        return Result.ok(carBasePage);
//    }
//
//    @PostMapping("/queryById")
//    @ApiOperation("根据ID查询")
//    public Result<NoteCarVo> queryById(@RequestParam("id") @ApiParam(name = "id", value = "id") Long id) {
//        NoteCar car = iNoteCarService.getById(id);
//        return Result.ok(BeanUtil.copyProperties(car,NoteCarVo.class));
//    }
//
//    @PostMapping("/deleteById")
//    @ApiOperation("根据ID删除数据")
//    public Result deleteById(@ApiParam(name = "ids", value = "id列表") @RequestBody List<Long> ids) {
//        iNoteCarService.removeByIds(ids);
//        return Result.ok();
//    }
}
