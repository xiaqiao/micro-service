package cn.x.microservice.order.service.impl;

import cn.x.microservice.common.bean.PageResponseResult;
import cn.x.microservice.order.entity.DailyOrder;
import cn.x.microservice.order.mapper.DailyOrderMapper;
import cn.x.microservice.order.service.DailyOrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author x
 * @since 2021-03-05
 */
@Service
public class DailyOrderServiceImpl implements DailyOrderService {

    @Autowired
    private DailyOrderMapper dailyOrderMapper;

    @Override
    public PageResponseResult<List<DailyOrder>> getUserOrderList(Long userId, Integer page, Integer rows) {
        Page<DailyOrder> pageInfo = PageHelper.startPage(page, rows);
        dailyOrderMapper.selectDailyOrderListByUser(userId);
        return new PageResponseResult<>(pageInfo.getResult(), pageInfo.getTotal());
    }
}
