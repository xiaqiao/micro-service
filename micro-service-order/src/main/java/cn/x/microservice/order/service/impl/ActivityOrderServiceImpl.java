package cn.x.microservice.order.service.impl;

import cn.x.microservice.order.entity.ActivityOrder;
import cn.x.microservice.order.mapper.ActivityOrderMapper;
import cn.x.microservice.order.service.ActivityOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author x
 * @since 2021-03-05
 */
@Service
public class ActivityOrderServiceImpl extends ServiceImpl<ActivityOrderMapper, ActivityOrder> implements ActivityOrderService {

}
