package com.example.lojistasservice.gateway;

import com.example.lojistasservice.domain.UsuarioComum;
import com.example.lojistasservice.repository.UsuarioComumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UsuariosGateway {

    private final UsuarioComumRepository repository;

    public UsuarioComum save(final UsuarioComum usuarioComum) {
        return repository.save(usuarioComum);
    }

    public UsuarioComum findById(final Long id){
        return repository.findById(id).get();
    }
}
