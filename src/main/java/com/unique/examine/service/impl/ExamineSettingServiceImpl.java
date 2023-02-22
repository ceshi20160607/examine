package com.unique.examine.service.impl;

import com.unique.examine.entity.po.ExamineSetting;
import com.unique.examine.mapper.ExamineSettingMapper;
import com.unique.examine.service.IExamineSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审批高级设置及异常处理规则 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-02-15
 */
@Service
public class ExamineSettingServiceImpl extends ServiceImpl<ExamineSettingMapper, ExamineSetting> implements IExamineSettingService {

}
