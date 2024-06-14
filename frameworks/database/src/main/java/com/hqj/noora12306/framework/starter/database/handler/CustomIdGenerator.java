package com.hqj.noora12306.framework.starter.database.handler;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

/**
 * 自定义雪花算法生成器
 *
 * @公众号：马丁玩编程，回复：加群，添加马哥微信（备注：12306）获取项目资料
 */
public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Number nextId(Object entity) {
        return SnowflakeIdUtil.nextId();
    }
}