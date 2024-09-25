package ar.edu.utn.frc.tup.lc.iv.rabbitmq.publisher;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class Publisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * Se inyecta la cola configurada en PublisherConfig
     */
    @Autowired
    private Queue queue;

    public void send(String msj){
        rabbitTemplate.convertAndSend(queue.getName(), msj);
    }
}
