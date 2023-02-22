package com.unique.examine.service.impl;

import com.unique.examine.entity.po.Examine;
import com.unique.examine.mapper.ExamineMapper;
import com.unique.examine.service.IExamineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审批表 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-02-15
 */
@Service
public class ExamineServiceImpl extends ServiceImpl<ExamineMapper, Examine> implements IExamineService {

}
