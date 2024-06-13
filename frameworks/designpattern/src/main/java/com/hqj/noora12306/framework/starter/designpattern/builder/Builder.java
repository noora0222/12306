package com.hqj.noora12306.framework.starter.designpattern.builder;

import java.io.Serializable;


/**
 * Builder 模式抽象接口
 * 建造者模式
 * @param <T>
 */
public interface Builder<T> extends Serializable {

    /**
     * 构建方法
     *
     * @return 构建后的对象
     */
    T build();
}