package com.bjpowernode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient//激活客户端
@EnableZuulProxy//激活zull支持
public class GateWay {

	public static void main(String[] args) {
		SpringApplication.run(GateWay.class, args);
	}

}
