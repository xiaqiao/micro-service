package cn.x.microservice.order.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author x
 * @since 2021-03-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DailyOrder implements Serializable {

    private static final long serialVersionUID = 1L;

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
