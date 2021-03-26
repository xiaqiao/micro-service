package cn.x.microservice.order.mapper;

import cn.x.microservice.order.entity.DailyOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author x
 * @since 2021-03-05
 */
public interface DailyOrderMapper {

    List<DailyOrder> selectDailyOrderListByUser(@Param("uid") Long uid);

}
