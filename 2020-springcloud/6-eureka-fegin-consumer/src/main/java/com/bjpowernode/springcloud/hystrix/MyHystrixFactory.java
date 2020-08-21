package com.bjpowernode.springcloud.hystrix;

import com.bjpowernode.springcloud.controller.service.TestService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MyHystrixFactory implements FallbackFactory<TestService> {
    @Override
    public TestService create(Throwable throwable) {
        return new TestService() {
            @Override
            public String test() {
                return "test方法被熔断了"+throwable.getMessage();
            }
        };
    }
}
