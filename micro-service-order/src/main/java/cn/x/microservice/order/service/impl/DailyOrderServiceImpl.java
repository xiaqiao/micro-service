package cn.x.microservice.order.service.impl;

import cn.x.microservice.common.bean.PageResponseResult;
import cn.x.microservice.order.entity.DailyOrder;
import cn.x.microservice.order.mapper.DailyOrderMapper;
import cn.x.microservice.order.service.DailyOrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class DailyOrderServiceImpl extends ServiceImpl<DailyOrderMapper, DailyOrder> implements DailyOrderService {

    @Override
    public PageResponseResult<List<DailyOrder>> getUserOrderList(Long userId, Integer page, Integer rows) {
        Page<DailyOrder> pageInfo = new Page<>(page, rows);
        QueryWrapper<DailyOrder> dailyOrderQueryWrapper = new QueryWrapper<>();
        dailyOrderQueryWrapper.eq("user_id", userId)
                .orderByDesc("c_time");
        baseMapper.selectPage(pageInfo, dailyOrderQueryWrapper);
        return new PageResponseResult<>(pageInfo.getRecords(), pageInfo.getTotal());
    }
}
