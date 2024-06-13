package com.hqj.noora12306.framework.starter.bases.safa;

import org.springframework.beans.factory.InitializingBean;


/**
 * FastJSON 安全模式，会关闭该 autoType 特性。
 */
public class FastJsonSafeMode implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.setProperty("fastjson2.parser.safeMode", "true");
    }
}