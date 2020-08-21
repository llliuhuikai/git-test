package com.bjpowernode.springcloud.configclass;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @LoadBalanced //使用Ribbon的负载均衡从注册中心中获取服务，默认为轮询
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Bean

    public IRule iRule(){
        return new RandomRule();
    }
}
