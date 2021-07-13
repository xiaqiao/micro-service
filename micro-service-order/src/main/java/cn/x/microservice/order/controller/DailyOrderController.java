package cn.x.microservice.order.controller;


import cn.x.microservice.common.bean.ResponseResult;
import cn.x.microservice.order.config.RabbitMqConfig;
import cn.x.microservice.order.entity.DailyOrder;
import cn.x.microservice.order.mq.callback.OrderConfirmCallback;
import cn.x.microservice.order.service.DailyOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author x
 * @since 2021-03-05
 */
@Slf4j
@RestController
@RequestMapping("/order/daily-order")
public class DailyOrderController {

    @Autowired
    private DailyOrderService dailyOrderService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private OrderConfirmCallback orderConfirmCallback;

    @GetMapping("/user")
    public ResponseResult getUserOrderList(Long userId, Integer page, Integer rows) {
        return new ResponseResult<>(dailyOrderService.getUserOrderList(userId, page, rows));
    }

    @PostMapping("/createOrder")
    public ResponseResult createOrder(@RequestBody DailyOrder order) {
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_ORDER,
                "create.order.daily",
                order.getOrderId(),
                new CorrelationData(order.getOrderId() + ""));
        return new ResponseResult();
    }

}
