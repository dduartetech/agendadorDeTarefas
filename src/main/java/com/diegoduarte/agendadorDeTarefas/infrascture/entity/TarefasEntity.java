package com.diegoduarte.agendadorDeTarefas.infrascture.entity;

import com.diegoduarte.agendadorDeTarefas.infrascture.enums.StatusNotEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("tarefa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasEntity {

    @Id
    private String id;
    private String emailUsuario;
    private String nomeTarefa;
    private String desc;
    private LocalDateTime dataCriacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;
    private LocalDateTime dataAlteracao;
    private StatusNotEnum statusNotEnum;
}
