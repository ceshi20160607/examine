package com.unique.approve.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.unique.approve.entity.bo.ExamineNodeBO;
import com.unique.approve.entity.po.ExamineNode;
import com.unique.core.utils.BaseUtil;

import java.util.ArrayList;
import java.util.List;

public class ApproveUtil {

    public static List<ExamineNode> recursionBuildHadSubList(List<ExamineNodeBO> list, Long id){
        List<ExamineNode> ret = new ArrayList<>();
        for (ExamineNodeBO t : list) {
            ExamineNode node = BeanUtil.copyProperties(t,ExamineNode.class);
            Long nextId = BaseUtil.getNextId();
            node.setId(nextId);
            node.setNodeBeforeId(id);
            ret.add(node);
            if (ObjectUtil.isNotEmpty(node.getNodeUserList())) {
                node.getNodeUserList().forEach(e -> {
                    e.setId(BaseUtil.getNextId());
                    e.setNodeId(nextId);
                });
            }
            if (ObjectUtil.isNotEmpty(t.getSubNodeList())) {
                ret.addAll(recursionBuildHadSubList(t.getSubNodeList(), nextId));
            }
        }
        return ret;
    }
}
