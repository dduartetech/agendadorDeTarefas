package com.diegoduarte.agendadorDeTarefas.infrascture.client;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    UsuarioDTO buscaPorEmail(@RequestParam("email")  String email,
                             @RequestHeader("Authorization") String token);
}
