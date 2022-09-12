package cn.itcast.user.web;

import cn.itcast.user.pojo.*;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cloud.context.config.annotation.*;
import org.springframework.format.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.text.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope     //配置自动刷新
public class UserController {
    @Autowired
    private UserService userService;

//    @Value("${date.format}")
//    String dateformat;
     @Autowired
     private DateProperties dateProperties;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,
                          @RequestHeader(value = "Name",required = false) String name) {
        System.out.println(name);
        return userService.queryById(id);
    }

    @GetMapping("/location")
    public String getLocation() {
        return new SimpleDateFormat(dateProperties.getFormat()).format(new Date());
    }

    @GetMapping("/dateproperties")
    public  DateProperties getDateProperties() {
        return dateProperties;
    }
}
