package cn.x.microservice.order.service;

import cn.x.microservice.common.bean.PageResponseResult;
import cn.x.microservice.order.entity.OrderInfo;

import java.util.List;

/**
 * @author xqa
 * @since 2021/3/3
 */
public interface OrderService {

    PageResponseResult<List<OrderInfo>> getUserOrderList(Long userId, Integer page, Integer rows);

}
