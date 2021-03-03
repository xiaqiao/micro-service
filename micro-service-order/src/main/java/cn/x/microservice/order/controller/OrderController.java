package cn.x.microservice.order.controller;

import cn.x.microservice.common.bean.ResponseResult;
import cn.x.microservice.order.mapper.OrderInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private OrderInfoMapper orderInfoMapper;

    @GetMapping("/{id}")
    public ResponseResult order(@PathVariable Long id) {
        return ResponseResult.success(orderInfoMapper.selectById(id));
    }

}
