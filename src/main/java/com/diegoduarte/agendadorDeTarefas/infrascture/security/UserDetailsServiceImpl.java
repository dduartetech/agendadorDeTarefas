package com.diegoduarte.agendadorDeTarefas.infrascture.security;

import com.diegoduarte.agendadorDeTarefas.business.dto.UsuarioDTO;
import com.diegoduarte.agendadorDeTarefas.infrascture.client.UsuarioClient;
import com.diegoduarte.cadastroDeUsuario.infrastructure.entity.Usuario;
import com.diegoduarte.cadastroDeUsuario.infrastructure.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl {

    @Autowired
    private UsuarioClient usuarioClient;

    public UserDetails carregaDadosUsuario (String email, String token) {
        UsuarioDTO usuarioDTO = usuarioClient.buscaPorEmail(email, token);

        return User
                .withUsername(usuarioDTO.getEmail()) // Define o nome de usuário como o e-mail
                .password(usuarioDTO.getSenha()) // Define a senha do usuário
                .build();
    }
}
