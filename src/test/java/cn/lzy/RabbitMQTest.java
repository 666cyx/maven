package cn.lzy;

import cn.lzy.RabbitMQ.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 陈远翔
 * @date 2023/10/18 12:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void topicPublisher1() {
        //给qq队列发消息
        rabbitTemplate.convertAndSend("topic_exchange", "info.qq",
                "topics send  qq message");}
    @Test
        public void topicPublisher2() {
//给微信队列发消息
        rabbitTemplate.convertAndSend("topic_exchange", "info.wx",
                "topics send  wx message");}
    @Test
    public void topicPublisher3() {
//给邮件队列发消息
        rabbitTemplate.convertAndSend("topic_exchange",
                "info.email",
                "topics send  email message");}
    @Test
    public void topicPublisher4() {
        //给所有的队列发消息
        rabbitTemplate.convertAndSend("topic_exchange",
                "info.qq.wx.email",
                "topics send  qq and wx and email message");}
    @Test
    public void topicPublisher5() {
//给qq队列、微信队列发消息
        rabbitTemplate.convertAndSend("topic_exchange",
                "info.qq.wx",
                "topics send  qq and wx and email message");
    }

}

//路由模式
/*
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {
@Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void routingPublisher() {
        rabbitTemplate.convertAndSend("routing_exchange",
                "error_routing_key",
                "routing send  error message");
    }

}
*/


/*
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {
@Autowired
    private AmqpAdmin amqpAdmin;
    @Test
    public void amqpAdmin() {
        amqpAdmin.declareExchange(new FanoutExchange("fanout_exchange"));//交换器
        amqpAdmin.declareQueue(new Queue("fanout_queue_qq"));//QQ队列
        amqpAdmin.declareQueue(new Queue("fanout_queue_wx"));//微信队列
        amqpAdmin.declareQueue(new Queue("fanout_queue_email"));//邮件队列
        amqpAdmin.declareBinding(new Binding("fanout_queue_qq",
                Binding.DestinationType.QUEUE,"fanout_exchange","",null));
        amqpAdmin.declareBinding(new Binding("fanout_queue_wx",
                Binding.DestinationType.QUEUE,"fanout_exchange","",null));
        amqpAdmin.declareBinding(new Binding("fanout_queue_email",
                Binding.DestinationType.QUEUE,"fanout_exchange","",null));}

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void psubPublisher() {
        User user=new User();
        user.setId(1);
        user.setUsername("孤煞星");
        rabbitTemplate.convertAndSend("fanout_exchange","",user);
    }

}
*/
