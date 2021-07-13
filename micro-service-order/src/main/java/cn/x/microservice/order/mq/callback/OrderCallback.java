package cn.x.microservice.order.mq.callback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

/**
 * @author xqa
 * @since 2021/7/13
 */
@Slf4j
@Component
public class OrderCallback implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String msgId = correlationData != null ? correlationData.getId() : "";
        if (ack) {
            log.info("消息：{}发送到交换机成功", msgId);
        } else {
            log.error("消息：{}发送到交换机失败，原因是：{}", msgId, cause);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.error("消息：{}被交换机：{}，路由键：{}退回，原因是：{}",
                new String(message.getBody(), StandardCharsets.UTF_8),
                exchange, routingKey, replyText);
    }
}
