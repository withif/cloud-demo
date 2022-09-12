package cn.itcast.demo.clients;

import cn.itcast.demo.Config.*;
import cn.itcast.demo.pojo.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * @FeignClient中如果配置了configuration = FeignClientConfiguration.class
 * value="userService",configuration = FeignClientConfiguration.class,则FeignClientConfiguration类中的配置将会成为userService的配置，是局部配置
 *
 */
@Component
@FeignClient(value="userservice",configuration = FeignClientConfiguration.class)     //服务名：userService  FeignClient接口替换掉restTemplate,局部配置
public interface userClient {       //基于feign的远程调用

    @GetMapping("/user/{userId}")
    User getUserById(@PathVariable Long userId);

}
