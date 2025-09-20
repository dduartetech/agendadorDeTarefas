package com.diegoduarte.agendadorDeTarefas.business.mapper;

import com.diegoduarte.agendadorDeTarefas.business.dto.TarefasDTO;
import com.diegoduarte.agendadorDeTarefas.infrascture.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void uptadeTarefas(TarefasDTO tarefasDTO, @MappingTarget TarefasEntity tarefasEntity);
}
