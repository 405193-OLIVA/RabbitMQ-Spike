package ar.edu.utn.frc.tup.lc.iv.configs;

import ar.edu.utn.frc.tup.lc.iv.dtos.rabbit.RabbitMessage;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RabbitMQConfig {

    /**
     * Configuración de la cola donde vamos a publicar
     */
    @Value("${tpi.queue.name}")
    private String queueName;

    /**
     * Se crea la cola como un objeto
     */
    @Bean
    public Queue queue(){
        return  new Queue(queueName, true);
    }

    /**
     * Se configuran las clases necesarias para realizar la serialización del mensaje
     */
    @Bean
    public SimpleMessageConverter converter() {
        SimpleMessageConverter converter = new SimpleMessageConverter();
        converter.setAllowedListPatterns(List.of("java.util.LinkedHashMap", "java.util.HashMap", "java.time.Ser",
                "ar.edu.utn.frc.tup.lc.iv.dtos.rabbit.RabbitMessage"));
        return converter;
    }
}
