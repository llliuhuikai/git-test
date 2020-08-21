package com.bjpowernode.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {
    @RequestMapping(value = "/dosome")
    public  String dosome(){
        System.out.println(10/0);
        return "带有熔断机制的服务提供者";
    }
    @RequestMapping(value = "/dosome2")
    public  String dosome2(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "带有熔断机制的服务提供者延时操作";
    }
    @RequestMapping(value = "/dosome3")
    public  String dosome3(){
        System.out.println(10/0);
        return "带有熔断机制的服务提供者";
    }

}
