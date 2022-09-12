package cn.itcast.user;

import cn.itcast.demo.Config.*;
import cn.itcast.demo.clients.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.context.config.annotation.*;
import org.springframework.cloud.openfeign.*;

@EnableFeignClients(clients ={userClient.class},defaultConfiguration = FeignClientConfiguration.class)
@MapperScan("cn.itcast.user.mapper")
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
