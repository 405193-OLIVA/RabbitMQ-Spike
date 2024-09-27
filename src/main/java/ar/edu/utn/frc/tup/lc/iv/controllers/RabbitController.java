package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.dtos.rabbit.RabbitMessage;
import ar.edu.utn.frc.tup.lc.iv.services.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rabbit")
public class RabbitController {

    @Autowired
    private RabbitService rabbitService;

    @PostMapping
    public ResponseEntity<String> sendMsj(@RequestBody RabbitMessage msj){
        rabbitService.SendMsj(msj);
        return ResponseEntity.ok("Mensaje Enviado");
    }
}
