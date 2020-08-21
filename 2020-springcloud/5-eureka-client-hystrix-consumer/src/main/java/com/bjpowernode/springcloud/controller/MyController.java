package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.hystrix.MyHystrix;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {
@Autowired
    private RestTemplate restTemplate;
@RequestMapping(value = "/test")
@HystrixCommand(fallbackMethod = "error")
public  String  dosome(){
    String result= restTemplate.getForEntity("http://5-eureka-client-hystrix-provider/dosome",String.class).getBody();
    return result+"提供者信息";
}
public String error(){
    return "服务熔断了";
}
    @RequestMapping(value = "/test2")
    @HystrixCommand(fallbackMethod = "error1",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })

    public  String  dosome2(){
        String result= restTemplate.getForEntity("http://5-eureka-client-hystrix-provider/dosome2",String.class).getBody();
        return result+"提供者信息";
    }
    public String error1(){
        return "服务熔断了";
    }
    /*自定义熔断器*/
    @RequestMapping(value = "/test3")

    public  String  dosome3(){
        String url="http://5-eureka-client-hystrix-provider/dosome3";
        MyHystrix myHystrix=new MyHystrix(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")),url,restTemplate);
        String result= (String) myHystrix.execute();
        return result+"消费者";
    }
}
