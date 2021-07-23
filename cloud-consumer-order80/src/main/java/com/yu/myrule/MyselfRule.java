package com.yu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡规则
 *  注意：不能被ComponentScan扫描到(不能和启动类放在同一个包下面)，
 *      同时启动类中加入注解@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();//负载均衡规则定义为随机
    }
}
