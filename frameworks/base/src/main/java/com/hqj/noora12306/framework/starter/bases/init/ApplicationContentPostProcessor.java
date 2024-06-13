package com.hqj.noora12306.framework.starter.bases.init;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;

/**
 * 应用初始化后置处理器，防止Spring事件被多次执行
 * 整体逻辑也比较简单，通过锁来保证同一时间只有一个事件进行初始化。
 * 初始化后设置一个标识，下次如果再触发，就不再执行，类似于幂等处理的逻辑。
 *
 */
@RequiredArgsConstructor
public class ApplicationContentPostProcessor implements ApplicationListener<ApplicationReadyEvent> {

    private final ApplicationContext applicationContext;

    /**
     * 执行标识，确保Spring事件 {@link ApplicationReadyEvent} 有且执行一次
     */
    private boolean executeOnlyOnce = true;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        synchronized (ApplicationContentPostProcessor.class) {
            if (executeOnlyOnce) {
                applicationContext.publishEvent(new ApplicationInitializingEvent(this));
                executeOnlyOnce = false;
            }
        }
    }
}