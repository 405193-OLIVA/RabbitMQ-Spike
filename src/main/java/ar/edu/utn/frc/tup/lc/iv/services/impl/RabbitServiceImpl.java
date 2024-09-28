package ar.edu.utn.frc.tup.lc.iv.services.impl;

import ar.edu.utn.frc.tup.lc.iv.dtos.rabbit.RabbitMessage;
import ar.edu.utn.frc.tup.lc.iv.rabbitmq.publisher.Publisher;
import ar.edu.utn.frc.tup.lc.iv.services.RabbitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitServiceImpl implements RabbitService {

    @Autowired
    private Publisher publisher;

    @Override
    public void SendMsj(String source, RabbitMessage msj) throws JsonProcessingException {
        publisher.send(source, msj);
    }
}
