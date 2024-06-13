package com.hqj.noora12306.framework.starter.bases.init;

import org.springframework.context.ApplicationEvent;

/**
 * 应用初始化事件
 * 有些场景是依赖 Spring 容器初始化完成后调用的，ContextRefreshedEvent 这个时间就比较合适。但是大家发现没有，它除了初始化调用，容器刷新也会调用。
 * 为了避免容器刷新造成二次调用初始化逻辑，我们对一些比较常用的事件简单封装了一层逻辑。
 */
public class ApplicationInitializingEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public ApplicationInitializingEvent(Object source) {
        super(source);
    }
}