package cn.x.microservice.order.mq;

import cn.x.microservice.order.config.RabbitMqConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author xqa
 * @since 2021/7/13
 */
@Slf4j
@Component
public class OrderConsumer {

    @RabbitListener(queues = {RabbitMqConfig.QUEUE_CREATE_ORDER})
    public void createOrder(Message message, Channel channel) {
        try {
            log.info("创建订单：{}", new String(message.getBody(), StandardCharsets.UTF_8));
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RabbitListener(queues = {RabbitMqConfig.QUEUE_CANCEL_ORDER})
    public void cancelOrder(Message message, Channel channel) {
        try {
            log.info("取消订单：{}", new String(message.getBody(), StandardCharsets.UTF_8));
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
