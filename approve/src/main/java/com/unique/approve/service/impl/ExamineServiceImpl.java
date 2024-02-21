package com.unique.approve.service.impl;

import com.unique.approve.entity.bo.ExamineSaveBO;
import com.unique.approve.entity.dto.ExamineContext;
import com.unique.approve.entity.dto.ExamineNodeFill;
import com.unique.approve.entity.po.*;
import com.unique.approve.mapper.ExamineMapper;
import com.unique.approve.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.unique.approve.utils.ExamineUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 审批表 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2024-01-30
 */
@Service
public class ExamineServiceImpl extends ServiceImpl<ExamineMapper, Examine> implements IExamineService {



    @Override
    @Transactional
    public void addOrUpdate(ExamineSaveBO saveBO) {
        //保存
    }


}
