package cn.x.microservice.order.service;

import cn.x.microservice.common.bean.PageResponseResult;

/**
 * @author xqa
 * @since 2021/3/3
 */
public interface OrderService {

    PageResponseResult getUserOrderList(Long userId, Integer page, Integer rows);

}
