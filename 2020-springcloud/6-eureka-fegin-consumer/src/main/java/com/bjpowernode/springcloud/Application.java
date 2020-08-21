package com.bjpowernode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient//激活eureka客户端
@EnableFeignClients//激活feign的支持（声明式服务消费）

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
