package cn.x.microservice.order.service;

import cn.x.microservice.common.bean.PageResponseResult;
import cn.x.microservice.order.entity.DailyOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author x
 * @since 2021-03-05
 */
public interface DailyOrderService extends IService<DailyOrder> {

    PageResponseResult<List<DailyOrder>> getUserOrderList(Long userId, Integer page, Integer rows);

}
