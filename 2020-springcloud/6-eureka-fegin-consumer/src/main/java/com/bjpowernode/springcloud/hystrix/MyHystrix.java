package com.bjpowernode.springcloud.hystrix;

import com.bjpowernode.springcloud.controller.service.TestService;
import org.springframework.stereotype.Component;

@Component
public class MyHystrix implements TestService {
    @Override
    public String test() {
        return "自定义熔断器";
    }
}
