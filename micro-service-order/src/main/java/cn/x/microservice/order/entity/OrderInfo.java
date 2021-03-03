package cn.x.microservice.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xqa
 * @since 2021/3/3
 */
@Data
public class OrderInfo {
    @TableId
    private Long orderId;
    private Long orderNo;
    private Long skuId;
    private String skuName;
    private Integer skuNum;
    private BigDecimal unitPrice;
    private BigDecimal price;
    private Integer state;
    private Integer userId;
    private Date cTime;
    private Date mTime;

}
