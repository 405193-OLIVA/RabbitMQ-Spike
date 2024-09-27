package ar.edu.utn.frc.tup.lc.iv.services;

import ar.edu.utn.frc.tup.lc.iv.dtos.rabbit.RabbitMessage;
import org.springframework.stereotype.Service;

@Service
public interface RabbitService {

    void SendMsj(RabbitMessage msj);
}
