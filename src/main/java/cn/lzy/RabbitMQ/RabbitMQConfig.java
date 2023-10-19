package cn.lzy.RabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 陈远翔
 * @date 2023/10/18 18:59
 */

@Configuration
public class RabbitMQConfig {
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}

//第一种
/*@Configuration
public class RabbitMQConfig {
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    //交换器
    @Bean
    public Exchange fanout_exchange(){
        return ExchangeBuilder.fanoutExchange("fanout_exchange").build();
    }
    //qq队列
    @Bean
    public Queue fanout_queue_qq(){
        return new Queue("fanout_queue_qq");
    }
    //微信队列
    @Bean
    public Queue fanout_queue_wx(){
        return new Queue("fanout_queue_wx");
    }
    //邮件队列
    @Bean
    public Queue fanout_queue_email(){
        return new Queue("fanout_queue_email");
    }


}*/

//第二种
/*
@Configuration
public class RabbitMQConfig {
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    //交换器
    @Bean
    public Exchange fanout_exchange(){
        return ExchangeBuilder.fanoutExchange("fanout_exchange").build();
    }
    //qq队列
    @Bean
    public Queue fanout_queue_qq(){
        return new Queue("fanout_queue_qq");
    }
    //微信队列
    @Bean
    public Queue fanout_queue_wx(){
        return new Queue("fanout_queue_wx");
    }
    //邮件队列
    @Bean
    public Queue fanout_queue_email(){
        return new Queue("fanout_queue_email");
    }

    //队列绑定交换器
    @Bean
    public Binding bindingQq(){
        return
                BindingBuilder.bind(fanout_queue_qq()).to(fanout_exchange()).with("").noargs();
    }

    @Bean
    public Binding bindingWx(){
        return
                BindingBuilder.bind(fanout_queue_wx()).to(fanout_exchange()).with("").noargs();
    }
    @Bean
    public Binding bindingEmail(){
        return
                BindingBuilder.bind(fanout_queue_email()).to(fanout_exchange()).with("").noargs();
    }
}
*/
