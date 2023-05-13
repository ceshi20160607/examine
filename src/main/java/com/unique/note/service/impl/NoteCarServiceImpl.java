package com.unique.note.service.impl;

import com.unique.core.common.BasePage;
import com.unique.note.entity.bo.NoteSearchBo;
import com.unique.note.entity.po.NoteCar;
import com.unique.note.entity.vo.NoteCarVo;
import com.unique.note.mapper.NoteCarMapper;
import com.unique.note.service.INoteCarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

    @Override
    public BasePage<NoteCarVo> queryList(NoteSearchBo searchBo) {
        BasePage<NoteCarVo> noteCarVoBasePage = getBaseMapper().queryList(searchBo.parse(), searchBo);
        return noteCarVoBasePage;
    }
}
