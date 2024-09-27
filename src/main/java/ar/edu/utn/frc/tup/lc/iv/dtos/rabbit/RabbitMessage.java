package ar.edu.utn.frc.tup.lc.iv.dtos.rabbit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbitMessage<T> implements Serializable {

    private Long id;

    private LocalDateTime dateTime;

    private T data;
}
