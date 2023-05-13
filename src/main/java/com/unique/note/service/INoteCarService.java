package com.unique.note.service;

import com.unique.core.common.BasePage;
import com.unique.note.entity.bo.NoteSearchBo;
import com.unique.note.entity.po.NoteCar;
import com.baomidou.mybatisplus.extension.service.IService;
import com.unique.note.entity.vo.NoteCarVo;

/**
 * <p>
 * 车加油笔记 服务类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-04-23
 */
public interface INoteCarService extends IService<NoteCar> {

    BasePage<NoteCarVo> queryList(NoteSearchBo searchBo);
}
