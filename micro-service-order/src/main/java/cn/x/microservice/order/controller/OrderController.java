package cn.x.microservice.order.controller;

import cn.x.microservice.common.bean.ResponseResult;
import cn.x.microservice.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xqa
 * @since 2021/3/3
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/user")
    public ResponseResult userOrderList(Long userId, Integer page, Integer rows) {
        return ResponseResult.success(orderService.getUserOrderList(userId, page, rows));
    }

}
