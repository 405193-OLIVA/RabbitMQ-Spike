package ar.edu.utn.frc.tup.lc.iv.services;

import org.springframework.stereotype.Service;

@Service
public interface RabbitService {

    void SendMsj(String msj);
}
