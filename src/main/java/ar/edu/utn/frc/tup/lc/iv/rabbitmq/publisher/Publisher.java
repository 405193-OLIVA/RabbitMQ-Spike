package ar.edu.utn.frc.tup.lc.iv.rabbitmq.publisher;

import ar.edu.utn.frc.tup.lc.iv.dtos.rabbit.RabbitMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
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

    @Autowired
    ObjectMapper objectMapper;

    /**
     * Se inyecta la cola configurada en PublisherConfig
     */
    @Autowired
    private Queue queue;

    public void send(String header, RabbitMessage rabbitMessage) throws JsonProcessingException {
        Message msj = MessageBuilder.withBody(objectMapper.writeValueAsBytes(rabbitMessage))
                        .setHeader("source", header)
                        .setHeader("testH", "testV")
                        .build();
        rabbitTemplate.convertAndSend(queue.getName(), msj);
    }
}
