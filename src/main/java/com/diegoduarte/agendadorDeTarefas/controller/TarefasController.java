package com.diegoduarte.agendadorDeTarefas.controller;

import com.diegoduarte.agendadorDeTarefas.business.dto.TarefasDTO;
import com.diegoduarte.agendadorDeTarefas.business.service.TarefasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefasDTO> gravarTarefas (@RequestBody TarefasDTO dto,
                                                     @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefa(dto, token));
    }
}
