package com.unique.approve.mapper;

import com.unique.approve.entity.bo.ExamineSearchBO;
import com.unique.approve.entity.po.Examine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.unique.approve.entity.vo.ExamineVO;
import com.unique.core.common.BasePage;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 审批表 Mapper 接口
 * </p>
 *
 * @author UNIQUE
 * @since 2024-01-30
 */
public interface ExamineMapper extends BaseMapper<Examine> {

    BasePage<ExamineVO> queryPageList(BasePage<Object> parse, @Param("search") ExamineSearchBO searchBO);
}
