package com.diegoduarte.agendadorDeTarefas.infrascture.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "usuario", url = "${usuario.url}")
public class UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTO buscaPorEmail(@RequestParam("email")  String email,
                             @RequestHeader("Authorization") String token);
}
