package com.unique.approve.handler;

import com.unique.approve.enums.ExamineNodeTypeEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class HandlerService implements ApplicationContextAware {
    private Map<ExamineNodeTypeEnum, AbstractHandler> handlerMap = new ConcurrentHashMap<>();

    public AbstractHandler getHandlerService(ExamineNodeTypeEnum typeEnum) {
        return handlerMap.get(typeEnum);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, AbstractHandler> beans = applicationContext.getBeansOfType(AbstractHandler.class);
        beans.forEach((k, v) -> {
            handlerMap.put(v.examineNodeTypeEnum(), v);
        });
    }
}
