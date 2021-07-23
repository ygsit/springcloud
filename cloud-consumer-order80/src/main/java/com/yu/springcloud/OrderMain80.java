package com.yu.springcloud;

import com.yu.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient //表示eureka客户端
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyselfRule.class) //表示使用MyselfRule的负载均衡规则
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
