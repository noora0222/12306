package com.hqj.noora12306.framework.starter.bases;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

/**
 * 单例对象容器
 *
 * 1. 全局访问：单例对象可以在应用程序的任何地方被访问，而不需要传递对象的引用。这样可以方便地共享对象的状态和功能，简化了对象之间的通信和协作。
 * 2. 节省资源：由于只有一个对象实例存在，可以减少重复创建对象的开销。在需要频繁创建和销毁对象的情况下，单例对象可以显著节省系统资源，提高性能。
 *
 * @公众号：马丁玩编程，回复：加群，添加马哥微信（备注：12306）获取项目资料
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Singleton {

    //TODO：单例对象容器用了ConcurrentHashMap
    private static final ConcurrentHashMap<String, Object> SINGLE_OBJECT_POOL = new ConcurrentHashMap();

    /**
     * 根据 key 获取单例对象
     */
    public static <T> T get(String key) {
        Object result = SINGLE_OBJECT_POOL.get(key);
        return result == null ? null : (T) result;
    }

    /**
     * 根据 key 获取单例对象
     *
     * <p> 为空时，通过 supplier 构建单例对象并放入容器
     */
    public static <T> T get(String key, Supplier<T> supplier) {
        Object result = SINGLE_OBJECT_POOL.get(key);
        if (result == null && (result = supplier.get()) != null) {
            SINGLE_OBJECT_POOL.put(key, result);
        }
        return result != null ? (T) result : null;
    }

    /**
     * 对象放入容器
     */
    public static void put(Object value) {
        put(value.getClass().getName(), value);
    }

    /**
     * 对象放入容器
     */
    public static void put(String key, Object value) {
        SINGLE_OBJECT_POOL.put(key, value);
    }
}
