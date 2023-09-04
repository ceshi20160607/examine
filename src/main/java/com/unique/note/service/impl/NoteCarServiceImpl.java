package com.unique.note.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.unique.core.common.BasePage;
import com.unique.core.common.ResultBaseCode;
import com.unique.core.exception.BaseException;
import com.unique.field.entity.po.Field;
import com.unique.field.service.IFieldService;
import com.unique.note.entity.bo.NoteSearchBo;
import com.unique.note.entity.po.NoteCar;
import com.unique.note.entity.vo.FieldVo;
import com.unique.note.entity.vo.NoteCarVo;
import com.unique.note.enums.NoteCodeEnum;
import com.unique.note.mapper.NoteCarMapper;
import com.unique.note.service.INoteCarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车加油笔记 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-04-23
 */
@Service
public class NoteCarServiceImpl extends ServiceImpl<NoteCarMapper, NoteCar> implements INoteCarService {

    @Autowired
    private IFieldService iFieldService;

    @Override
    public BasePage<NoteCarVo> queryList(NoteSearchBo searchBo) {
        BasePage<NoteCarVo> noteCarVoBasePage = getBaseMapper().queryList(searchBo.parse(), searchBo);
        return noteCarVoBasePage;
    }

    @Override
    public List<FieldVo> queryInformation(Long id) {
        LambdaQueryWrapper<NoteCar> qw = new LambdaQueryWrapper<>();
        qw.eq(NoteCar::getId,id);
        Map<String, Object> byId = getMap(qw);
        if (ObjectUtil.isEmpty(byId)) {
            throw new BaseException(NoteCodeEnum.NOTE_ERROR_PARAM);
        }
        List<Field> fieldList = iFieldService.lambdaQuery().eq(Field::getModuleType, 4).list();
        List<FieldVo> ret = new ArrayList<>();
        fieldList.forEach(r->{
            FieldVo item = BeanUtil.copyProperties(r, FieldVo.class);
            if (ObjectUtil.isNotEmpty(byId.get(r.getFieldName()))) {
                item.setValueSingle(byId.get(r.getFieldName()).toString());
            }
            ret.add(item);
        });
        return ret;
    }
}
