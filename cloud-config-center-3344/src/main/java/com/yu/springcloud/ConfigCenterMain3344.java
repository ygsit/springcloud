package com.yu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 配置读取规则：
 *   获取配置信息：/{label}/{application}-{profile}    例如：http://localhost:3344/master/config-dev
 *   获取配置文件信息：/{label}/{application}-{profile}.yml   例如：http://localhost:3344/master/config-dev.yml
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer //开启配置服务
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
