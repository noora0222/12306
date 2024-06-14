package com.hqj.noora12306.framework.starter.common.threadpool.proxy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程池拒绝策略代理执行器
 *
 * @公众号：马丁玩编程，回复：加群，添加马哥微信（备注：12306）获取项目资料
 */
@Slf4j
@AllArgsConstructor
public class RejectedProxyInvocationHandler implements InvocationHandler {

    /**
     * Target object
     */
    private final Object target;

    /**
     * Reject count
     */
    private final AtomicLong rejectCount;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        rejectCount.incrementAndGet();
        try {
            log.error("线程池执行拒绝策略, 此处模拟报警...");
            return method.invoke(target, args);
        } catch (InvocationTargetException ex) {
            throw ex.getCause();
        }
    }
}