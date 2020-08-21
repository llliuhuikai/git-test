package com.bjpowernode.springcloud.controller.service;

import com.bjpowernode.springcloud.hystrix.MyHystrix;
import com.bjpowernode.springcloud.hystrix.MyHystrixFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * name为注册中心的某个服务的名字
 * FeignClient 标记当前接口是一个feign声明式服务接口
 * spring会自动为当前接口创建动态代理对象
 */
@FeignClient(name = "6-eureka-fegin-provider",fallbackFactory = MyHystrixFactory.class)
public interface TestService {
    /**
     * value和提供者请求名相同
     * @return 为提供者反水数据的具体类型
     */
    @RequestMapping(value = "/dosome")
    String test();


}
