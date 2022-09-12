package cn.itcast.order.web;


import cn.itcast.demo.clients.*;
import cn.itcast.demo.pojo.*;
import cn.itcast.order.pojo.*;
import cn.itcast.order.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

@RestController
@RequestMapping("order")
//@EnableFeignClients
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
//    @Qualifier("cn.itcast.order.clients.userClient")
    @Autowired
    private userClient userclient;

   @Autowired
   private OrderService orderService;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回
        Order order = orderService.queryOrderById(orderId);
        //利用RestTemplate发送http请求,get请求则使用getForObject
//        String url = "http://userService/user/"+order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
        //使用feign远程调用接口
        User user = userclient.getUserById(order.getUserId());
        order.setUser(user);
        return order;
    }
}
