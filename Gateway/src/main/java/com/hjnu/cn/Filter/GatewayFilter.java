package com.hjnu.cn.Filter;

import org.springframework.cloud.gateway.filter.*;
import org.springframework.core.*;
import org.springframework.http.*;
import org.springframework.http.server.reactive.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;
import org.springframework.web.server.*;
import reactor.core.publisher.*;

/**
 * 实现Ordered接口来取代@Order注解
 */
@Component
public class GatewayFilter implements GlobalFilter , Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> params = request.getQueryParams();
        //获取参数中需要的那个
        String username = params.getFirst("username");
        //判断
        if("password".equals(username)) {
            Mono<Void> filter = chain.filter(exchange);//过滤器放行
            return filter;
        }
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);  //设置状态码
        //拦截请求
        return exchange.getResponse().setComplete();
    }

    /**
     * 数字越小，优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
