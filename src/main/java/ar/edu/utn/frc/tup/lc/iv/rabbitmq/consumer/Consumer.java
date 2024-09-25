package ar.edu.utn.frc.tup.lc.iv.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    /**
     * Este decorador permite pasar una lista de nombres de colas que el consumidor va a estar escuchando
     */
    @RabbitListener(queues = { "${tpi.queue.name}" })
    public void receive(@Payload String msj){
      log.info("Mensaje recibido: {}", msj);

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
