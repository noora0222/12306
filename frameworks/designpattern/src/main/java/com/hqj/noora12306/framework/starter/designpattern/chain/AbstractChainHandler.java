package com.hqj.noora12306.framework.starter.designpattern.chain;

import org.springframework.core.Ordered;


/**
 * ClassName: AbstractChainHandler
 * Package: com.hqj.noora12306.framework.starter.designpattern.chain
 * Description:
 *
 * @Author:HQJ
 * @Create:2024/6/13 - 22:48
 * @Version v1.0
 */
public interface AbstractChainHandler<T> extends Ordered {

    /**
     * 执行责任链逻辑
     */
    void handler(T requestParam);

    /**
     * 责任链组件标识
     */
    String mark();
}
