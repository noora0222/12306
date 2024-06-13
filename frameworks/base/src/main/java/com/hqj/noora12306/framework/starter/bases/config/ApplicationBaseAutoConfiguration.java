package com.hqj.noora12306.framework.starter.bases.config;

import com.hqj.noora12306.framework.starter.bases.safa.FastJsonSafeMode;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * 应用基础自动装配
 */
public class ApplicationBaseAutoConfiguration {

    /**
     * 如果配置文件中配置了 framework.fastjson.safa-mode=true 那么则开启安全模式，反之无任何变化。
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    //TODO：这里有点疑问ConditionalOnProperty
    @ConditionalOnProperty(value = "framework.fastjson.safa-mode", havingValue = "true")
    public FastJsonSafeMode congoFastJsonSafeMode() {
        return new FastJsonSafeMode();
    }
}