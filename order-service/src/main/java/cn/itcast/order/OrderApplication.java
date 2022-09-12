package cn.itcast.order;


import cn.itcast.demo.Config.*;
import cn.itcast.demo.clients.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.*;
//@EnableFeignClients(defaultConfiguration = FeignClientConfiguration.class)
/**
 *
 * @EnableFeignClients中如果配置了defaultConfiguration = FeignClientConfiguration.class，则FeignClientConfiguration类中的配置将会全局生效
 * clients = userClient.class指定客户端是哪个类，指定feignclient字节码
 */
@EnableFeignClients(clients = {userClient.class},defaultConfiguration = FeignClientConfiguration.class)                 //开启feign客户端的功能,
@MapperScan("cn.itcast.order")
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 创建RestTemplate并注入spring
     * @return
     */
    @Bean
    @LoadBalanced       //开启负载均衡
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }

   /*
   // 在配置类中配置IRule，则所有的服务都会用这个负载均衡策略，默认是轮询负载均衡
   @Bean
    public IRule getRule() {
        return new RandomRule();
    }*/
}