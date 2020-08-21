package com.bjpowernode.springcloud.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

public class MyHystrix extends HystrixCommand {
    private String url;
    private RestTemplate restTemplate;

    public MyHystrix(Setter setter, String url, RestTemplate restTemplate) {
        super(setter);
        this.url=url;
        this.restTemplate=restTemplate;

    }

    @Override
    protected Object run() throws Exception {
        return restTemplate.getForObject(url,String.class);
    }

    @Override
    protected Object getFallback() {
        System.out.println(this.getFailedExecutionException().getClass());
        System.out.println(this.getFailedExecutionException().getMessage());
        return "自定义异常熔断器熔断服务";
    }
}
