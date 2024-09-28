package ar.edu.utn.frc.tup.lc.iv.rabbitmq.consumer;

import ar.edu.utn.frc.tup.lc.iv.dtos.rabbit.RabbitMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Address;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class Consumer {

    @Autowired
    ObjectMapper objectMapper;

    /**
     * Este decorador permite pasar una lista de nombres de colas que el consumidor va a estar escuchando
     */
    @RabbitListener(queues = { "${tpi.queue.name}" })
    public void receive(@Payload Message msj) throws IOException {
      log.info("Mensaje recibido: {}", msj);
      RabbitMessage<Address> rabbitMessage = objectMapper.readValue(msj.getBody(), RabbitMessage.class);
      log.info("HEADERS: {}", msj.getMessageProperties().getHeaders());
      log.info("DATA: {}", rabbitMessage.toString());
      sleep();
    }

    /**
     * Tiempo de espera en el que se intenta leer la cola, previene posibles caídas de API por sobrecarga.
     */
    private void sleep(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
