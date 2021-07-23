package com.yu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient //让注册中心发现，并扫描到该服务
@SpringBootApplication
public class SentinelMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain8401.class, args);
    }
}
