package cn.x.microservice.order.service.impl;

import cn.x.microservice.common.bean.PageResponseResult;
import cn.x.microservice.order.entity.OrderInfo;
import cn.x.microservice.order.mapper.OrderInfoMapper;
import cn.x.microservice.order.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xqa
 * @since 2021/3/3
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public PageResponseResult getUserOrderList(Long userId, Integer page, Integer rows) {
        Page<OrderInfo> pageInfo = new Page<>(page, rows);
        QueryWrapper<OrderInfo> orderWrapper = new QueryWrapper<>();
        orderWrapper.eq("user_id", userId);
        orderInfoMapper.selectPage(pageInfo, orderWrapper);
        return PageResponseResult.success(pageInfo.getRecords(), pageInfo.getTotal());
    }
}
