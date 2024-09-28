package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.dtos.rabbit.RabbitMessage;
import ar.edu.utn.frc.tup.lc.iv.services.RabbitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rabbit")
public class RabbitController {

    @Autowired
    private RabbitService rabbitService;

    @PostMapping
    public ResponseEntity<String> sendMsj(@RequestHeader String source, @RequestBody RabbitMessage msj) throws JsonProcessingException {
        rabbitService.SendMsj(source, msj);
        return ResponseEntity.ok("Mensaje Enviado");
    }
}
