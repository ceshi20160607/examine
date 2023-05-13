package com.unique.note.mapper;

import com.unique.core.common.BasePage;
import com.unique.note.entity.bo.NoteSearchBo;
import com.unique.note.entity.po.NoteCar;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.unique.note.entity.vo.NoteCarVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 车加油笔记 Mapper 接口
 * </p>
 *
 * @author UNIQUE
 * @since 2023-04-23
 */
public interface NoteCarMapper extends BaseMapper<NoteCar> {

    BasePage<NoteCarVo> queryList(BasePage<Object> parse, @Param("search") NoteSearchBo searchBo);
}
