package com.unique.approve.handler;

import cn.hutool.core.collection.CollectionUtil;
import com.unique.approve.entity.dto.ExamineContext;
import com.unique.approve.entity.po.ExamineRecordNode;
import com.unique.approve.enums.ExamineNodeTypeEnum;

import java.util.List;

/**
 * @author UNIQUE
 * @date 2024/03/05
 */
public abstract class AbstractHandler {
    private AbstractHandler nextHandler;

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public AbstractHandler getNextHandler() {
        return nextHandler;
    }


    public abstract ExamineNodeTypeEnum examineNodeTypeEnum();
    public abstract void build(ExamineContext context);


    public abstract void handle(ExamineContext context);
}
