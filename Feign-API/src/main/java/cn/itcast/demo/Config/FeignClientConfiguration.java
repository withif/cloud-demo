package cn.itcast.demo.Config;

import feign.Logger.*;
import org.springframework.context.annotation.*;
public class FeignClientConfiguration {
    @Bean
    public Level feignLoggerLevel(){
        return Level.BASIC;
    }
}
