package cn.x.microservice.order.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class ActivityOrder implements Serializable {

    private static final long serialVersionUID = -7710882384102828935L;

    private Long orderId;

    private Long orderNo;

    private Long skuId;

    private String skuName;

    private Integer skuNum;

    private BigDecimal unitPrice;

    private BigDecimal price;

    private Integer state;

    private Integer userId;

    private Integer activityId;

    private Date cTime;

    private Date mTime;

}