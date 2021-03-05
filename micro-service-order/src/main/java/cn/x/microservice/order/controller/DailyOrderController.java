package cn.x.microservice.order.controller;


import cn.x.microservice.common.bean.ResponseResult;
import cn.x.microservice.order.service.DailyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author x
 * @since 2021-03-05
 */
@RestController
@RequestMapping("/order/daily-order")
public class DailyOrderController {

    @Autowired
    private DailyOrderService dailyOrderService;

    @GetMapping("/user")
    public ResponseResult getUserOrderList(Long userId, Integer page, Integer rows) {
        return new ResponseResult<>(dailyOrderService.getUserOrderList(userId, page, rows));
    }

    @GetMapping("/{orderId}")
    public ResponseResult getOrderByOrderId(@PathVariable("orderId") Long orderId) {
        return new ResponseResult<>(dailyOrderService.getById(orderId));
    }

}
