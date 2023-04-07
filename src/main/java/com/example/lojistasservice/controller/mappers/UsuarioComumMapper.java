package com.example.lojistasservice.controller.mappers;


import com.example.lojistasservice.controller.dtos.UsuarioComumRequestDTO;
import com.example.lojistasservice.controller.dtos.UsuarioComumResponseDTO;
import com.example.lojistasservice.domain.UsuarioComum;
import com.example.lojistasservice.domain.enums.TiposUsuarios;
import org.springframework.stereotype.Component;


@Component
public class UsuarioComumMapper {

    public static UsuarioComum toDomain(final UsuarioComumRequestDTO requestDTO) {
        return new UsuarioComum(null, requestDTO.getNomeCompleto(), requestDTO.getCpfCnpj(),
                requestDTO.getEmail(), requestDTO.getSaldo(), requestDTO.getDesconto(),
                TiposUsuarios.valueOf(requestDTO.getTipoUsuario()));
    }

    public static UsuarioComumResponseDTO toDto(final UsuarioComum usuarioComum) {
        return new UsuarioComumResponseDTO(usuarioComum.getNomeCompleto(), usuarioComum.getCpfCnpj(),
                usuarioComum.getEmail(), usuarioComum.getSaldo(), usuarioComum.getDesconto(),
                usuarioComum.getTipoUsuario().toString());
    }
}
