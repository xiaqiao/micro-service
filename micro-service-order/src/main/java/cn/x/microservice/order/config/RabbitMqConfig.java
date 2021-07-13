package cn.x.microservice.order.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xqa
 * @since 2021/7/9
 */
@Configuration
public class RabbitMqConfig {

    public static final String EXCHANGE_ORDER = "order_exchange";

    public static final String EXCHANGE_CREATE_ORDER = "create_order_exchange";

    public static final String EXCHANGE_CANCEL_ORDER = "cancel_order_exchange";

    public static final String QUEUE_CREATE_ORDER = "create_order_queue";

    public static final String QUEUE_CANCEL_ORDER = "cancel_order_queue";

    public static final String CANCEL_ORDER_ROUTING_KEY = "#.cancel.order.#";

    public static final String CREATE_ORDER_ROUTING_KEY = "#.create.order.#";

    //声明创建订单交换机
    @Bean(EXCHANGE_ORDER)
    public TopicExchange orderExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_ORDER).durable(true).build();
    }

    //声明取消订单交换机（死信交换机）
//    @Bean(EXCHANGE_CREATE_ORDER)
//    public TopicExchange EXCHANGE_CANCEL_ORDER() {
//        return ExchangeBuilder.topicExchange(EXCHANGE_CANCEL_ORDER).durable(true).build();
//    }

    //声明创建订单队列
    @Bean(QUEUE_CREATE_ORDER)
    public Queue createOrderQueue() {
        Map<String, Object> arguments = new HashMap<>(3);
        arguments.put("x-dead-letter-exchange", EXCHANGE_ORDER);
        arguments.put("x-dead-letter-routing-key", CANCEL_ORDER_ROUTING_KEY);
        arguments.put("x-message-ttl", 1800000);
        return QueueBuilder.durable(QUEUE_CREATE_ORDER).withArguments(arguments).build();
    }

    //声明取消订单队列（死信队列）
    @Bean(QUEUE_CANCEL_ORDER)
    public Queue cancelOrderQueue() {
        return QueueBuilder.durable(QUEUE_CANCEL_ORDER).build();
    }

    @Bean
    public Binding createOrderBinding(@Qualifier(QUEUE_CREATE_ORDER) Queue queue,
                                      @Qualifier(EXCHANGE_ORDER) TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(CREATE_ORDER_ROUTING_KEY);
    }

    @Bean
    public Binding cancelOrderBinding(@Qualifier(QUEUE_CANCEL_ORDER) Queue queue,
                                      @Qualifier(EXCHANGE_ORDER) TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(CANCEL_ORDER_ROUTING_KEY);
    }
}
