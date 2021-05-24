package cn.x.microservice.order.controller;


import cn.x.microservice.order.service.ActivityOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author x
 * @since 2021-03-05
 */
@RestController
@RequestMapping("/order/activity-order")
@Slf4j
public class ActivityOrderController {

    @Autowired
    private ActivityOrderService activityOrderService;

    @RequestMapping("/test")
    public void test() {
        System.out.println("结束");
    }



}
