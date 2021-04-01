//package cn.x.microservice.gateway.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @author xqa
// * @since 2021/2/26
// */
//@Component
//@Order(0)
//@Slf4j
//public class LogFilter implements GlobalFilter {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        log.info("url:{}", request.getURI().toString());
//        MultiValueMap<String, String> paramsMap = request.getQueryParams();
//        StringBuilder paramSb = new StringBuilder();
//        paramsMap.keySet().forEach(key -> {
//            paramSb.append(key);
//            paramSb.append("=");
//            paramSb.append(paramsMap.get(key).get(0));
//            paramSb.append("&");
//        });
//        log.info("params:{}", paramSb.toString());
//
//        HttpHeaders headers = request.getHeaders();
//        log.info("Authorization:{}", String.join(";", headers.getOrEmpty("Authorization")));
//
//        return chain.filter(exchange);
//    }
//}
