package com.diegoduarte.agendadorDeTarefas.business.mapper;

import com.diegoduarte.agendadorDeTarefas.business.dto.TarefasDTO;
import com.diegoduarte.agendadorDeTarefas.infrascture.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "dataEvento", target = "dataEvento")
    @Mapping(source = "dataCriacao", target = "dataCriacao")

    TarefasEntity paraTarefaEntity (TarefasDTO tarefasDTO);
    TarefasDTO paraTarefaDTO (TarefasEntity tarefasEntity);

    List<TarefasEntity> paraTarefaEntityList (List<TarefasDTO> tarefasDTO);
    List<TarefasDTO> paraTarefaDTOList (List<TarefasEntity> tarefasEntity);
}
