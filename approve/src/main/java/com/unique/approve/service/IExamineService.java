package com.unique.approve.service;

import com.unique.approve.entity.bo.ExamineSaveBO;
import com.unique.approve.entity.bo.ExamineSearchBO;
import com.unique.approve.entity.po.Examine;
import com.baomidou.mybatisplus.extension.service.IService;
import com.unique.approve.entity.vo.ExamineVO;
import com.unique.core.common.BasePage;

import java.util.List;

/**
 * <p>
 * 审批表 服务类
 * </p>
 *
 * @author UNIQUE
 * @since 2024-01-30
 */
public interface IExamineService extends IService<Examine> {

    void addOrUpdate(ExamineSaveBO saveBO);

    BasePage<ExamineVO> queryPageList(ExamineSearchBO searchBO);

    void deteleByIds(List<Long> ids);
}
