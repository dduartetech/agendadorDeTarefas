package com.diegoduarte.agendadorDeTarefas.business.service;

import com.diegoduarte.agendadorDeTarefas.business.dto.TarefasDTO;
import com.diegoduarte.agendadorDeTarefas.business.mapper.TarefasConverter;
import com.diegoduarte.agendadorDeTarefas.infrascture.entity.TarefasEntity;
import com.diegoduarte.agendadorDeTarefas.infrascture.enums.StatusNotEnum;
import com.diegoduarte.agendadorDeTarefas.infrascture.repository.TarefasRepository;
import com.diegoduarte.agendadorDeTarefas.infrascture.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefasConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa (TarefasDTO dto, String token) {
        String email = jwtUtil.extractUsername(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotEnum(StatusNotEnum.PENDENTE);
        dto.setEmailUsuario(email);

        TarefasEntity entity = tarefasConverter.paraTarefaEntity(dto);

        return tarefasConverter.paraTarefaDTO(
                tarefasRepository.save(entity));
    }
}
