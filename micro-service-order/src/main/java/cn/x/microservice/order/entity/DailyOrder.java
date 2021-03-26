package cn.x.microservice.order.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author x
 * @since 2021-03-05
 */
@Data
public class DailyOrder implements Serializable {

    private static final long serialVersionUID = 2896542904229434598L;

    private Long orderId;

    private Long orderNo;

    private Long skuId;

    private String skuName;

    private Integer skuNum;

    private BigDecimal unitPrice;

    private BigDecimal price;

    private Integer state;

    private Integer userId;

    private LocalDateTime cTime;

    private LocalDateTime mTime;


}
