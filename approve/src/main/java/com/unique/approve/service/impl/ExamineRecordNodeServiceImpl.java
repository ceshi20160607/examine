package com.unique.approve.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.unique.approve.entity.dto.ExamineNodeFill;
import com.unique.approve.entity.po.ExamineRecordNode;
import com.unique.approve.mapper.ExamineRecordNodeMapper;
import com.unique.approve.service.IExamineRecordNodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 审批节点表 服务实现类
 * </p>
 *
 * @author UNIQUE
 * @since 2024-01-30
 */
@Service
public class ExamineRecordNodeServiceImpl extends ServiceImpl<ExamineRecordNodeMapper, ExamineRecordNode> implements IExamineRecordNodeService {

    @Override
    public void fillNodeUser(ExamineNodeFill examineNodeFill) {
        //补全自选的审批流
        ExamineRecordNode byId = getById(examineNodeFill.getNodeId());
        if (ObjectUtil.isNotEmpty(byId)) {
            lambdaUpdate().set(ExamineRecordNode::getUserId, examineNodeFill.getUserId())
                    .eq(ExamineRecordNode::getId,examineNodeFill.getNodeId())
                    .update();
        }
    }
}
