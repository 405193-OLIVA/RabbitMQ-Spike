package ar.edu.utn.frc.tup.lc.iv.dtos.rabbit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbitMessage<T> implements Serializable {

    /**
     * Id de entidad que solicita
     */
    private Long id;

    private LocalDateTime dateTime;

    private List<T> data;
}
