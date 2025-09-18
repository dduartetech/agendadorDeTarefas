package com.diegoduarte.agendadorDeTarefas.business.mapper;

import com.diegoduarte.agendadorDeTarefas.business.dto.TarefasDTO;
import com.diegoduarte.agendadorDeTarefas.infrascture.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity (TarefasDTO tarefasDTO);
    TarefasDTO paraTarefaDTO (TarefasEntity tarefasEntity);
}
