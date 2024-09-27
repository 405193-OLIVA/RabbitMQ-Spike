package ar.edu.utn.frc.tup.lc.iv.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    /**
     * Configuración de la cola donde vamos a publicar
     */
    @Value("${tpi.queue.name}")
    private String msj;

    /**
     * Se crea la cola como un objeto
     * @return
     */
    @Bean
    public Queue queue(){
        return  new Queue(msj, true);
    }
}
