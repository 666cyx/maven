package cn.lzy.RabbitMQ;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author 陈远翔
 * @date 2023/10/18 18:59
 */
@Service
public class RabbitMQService {
    @RabbitListener(bindings = @QueueBinding(value =
    @Queue("topic_queue_qq"), exchange =
    @Exchange(value = "topic_exchange", type = "topic"),
            key = "info.#.qq.#"))
    public void topicConsumerQq(String message) {
        System.out.println("接收到QQ订阅需求处理消息： " + message);
    }

    @RabbitListener(bindings =@QueueBinding(value =
    @Queue("topic_queue_wx"),exchange =
    @Exchange(value = "topic_exchange",type = "topic"),
            key = "info.#.wx.#"))
    public void topicConsumerWx(String message) {
        System.out.println("接收到微信订阅需求处理消息： "+message);
    }

        @RabbitListener(bindings = @QueueBinding(value =
        @Queue("topic_queue_email"), exchange =
        @Exchange(value = "topic_exchange", type = "topic"),
                key = "info.#.email.#"))
        public void topicConsumerEmail(String message) {
            System.out.println("接收到邮件订阅需求处理消息： " + message);
        }

}



//路由模式
/*@Service
public class RabbitMQService {
    @RabbitListener(bindings =@QueueBinding(value =
    @Queue("routing_queue_error"),exchange =
    @Exchange(value = "routing_exchange",type = "direct"),
            key = "error_routing_key"))
    public void routingConsumerError(String message) {
        System.out.println("接收到error级别日志消息： "+message);
    }
    @RabbitListener(bindings =@QueueBinding(value =
    @Queue("routing_queue_all"),exchange =
    @Exchange(value = "routing_exchange",type = "direct"),
            key = {"error_routing_key","info_routing_key","warning_routing_key"}))
    public void routingConsumerAll(String message) {
        System.out.println("接收到info、error、warning等级别日志消息： "+message);
    }

}*/




//第一种
/*@Service
public class RabbitMQService {
    @RabbitListener(queues = "fanout_queue_qq")
    public void psubConsumerqq(Message message) {
        byte[] body = message.getBody();
        String s = new String(body);
        System.out.println("QQ接收到消息： "+s);
    }

    @RabbitListener(queues = "fanout_queue_wx")
    public void psubConsumerwx(Message message) {
        byte[] body = message.getBody();
        String s = new String(body);
        System.out.println("微信接收到消息： "+s);
    }


    @RabbitListener(queues = "fanout_queue_email")
    public void psubConsumeremail(Message message) {
        byte[] body = message.getBody();
        String s = new String(body);
        System.out.println("邮件接收到消息： "+s);
    }

}*/

//第二种
/*
@Service
public class RabbitMQService {
    @RabbitListener(bindings =@QueueBinding(value =
    @Queue("fanout_queue_qq"), exchange =
    @Exchange(value = "fanout_exchange",type = "fanout")))
    public void psubConsumerQqAno(User user) {
        System.out.println("QQ接收到消息： "+user);
    }

    @RabbitListener(bindings =@QueueBinding(value =
    @Queue("fanout_queue_wx"),exchange =
    @Exchange(value = "fanout_exchange",type = "fanout")))
    public void psubConsumerWxAno(User user) {
        System.out.println("短微信接收到消息： "+user);
    }

    @RabbitListener(bindings =@QueueBinding(value =
    @Queue("fanout_queue_email"), exchange =
    @Exchange(value = "fanout_exchange",type = "fanout")))
    public void psubConsumerEmailAno(User user) {
        System.out.println("邮件接收到消息： "+user);
        }
}*/
