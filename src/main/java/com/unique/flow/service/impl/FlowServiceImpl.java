package com.unique.flow.service.impl;

import com.unique.flow.entity.po.Flow;
import com.unique.flow.mapper.FlowMapper;
import com.unique.flow.service.IFlowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 流程表 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2023-10-07
 */
@Service
public class FlowServiceImpl extends ServiceImpl<FlowMapper, Flow> implements IFlowService {

}
