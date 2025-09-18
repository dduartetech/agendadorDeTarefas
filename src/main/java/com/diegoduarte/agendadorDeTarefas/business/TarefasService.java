package com.diegoduarte.agendadorDeTarefas.business;

import com.diegoduarte.agendadorDeTarefas.business.dto.TarefasDTO;
import com.diegoduarte.agendadorDeTarefas.business.mapper.TarefasConverter;
import com.diegoduarte.agendadorDeTarefas.infrascture.entity.TarefasEntity;
import com.diegoduarte.agendadorDeTarefas.infrascture.enums.StatusNotEnum;
import com.diegoduarte.agendadorDeTarefas.infrascture.repository.TarefasRepository;
import com.diegoduarte.agendadorDeTarefas.infrascture.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<TarefasDTO> buscaTarefasAgendadasPorPeriodo (LocalDateTime dataInicial, LocalDateTime dataFinal) {
        return tarefasConverter.paraTarefaDTOList(
                tarefasRepository.findByDataEventoBetween(dataInicial, dataFinal));
    }

    public List<TarefasDTO> buscaTarefasPorEmail (String token) {
        String email = jwtUtil.extractUsername(token.substring(7));

        List<TarefasEntity> listaTarefas = tarefasRepository.findByEmailUsuario(email);

        return tarefasConverter.paraTarefaDTOList(listaTarefas);

    }
}
