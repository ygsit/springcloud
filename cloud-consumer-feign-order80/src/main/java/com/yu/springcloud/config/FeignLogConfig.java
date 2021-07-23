package com.yu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置OpenFeign日志打印功能
 * 日志级别：NONE(默认),BASIC,HEADERS, FULL
 */
@Configuration
public class FeignLogConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
