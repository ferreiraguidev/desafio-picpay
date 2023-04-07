package com.example.lojistasservice.controller;


import com.example.lojistasservice.controller.dtos.UsuarioComumResponseDTO;
import com.example.lojistasservice.controller.dtos.UsuarioComumRequestDTO;
import com.example.lojistasservice.controller.mappers.UsuarioComumMapper;
import com.example.lojistasservice.domain.UsuarioComum;
import com.example.lojistasservice.gateway.UsuariosGateway;
import com.example.lojistasservice.repository.UsuarioComumRepository;
import com.example.lojistasservice.usecase.TransferenciaDeSaldo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


@RequiredArgsConstructor
@RestController
public class UsuarioComumController {

    private final UsuariosGateway gateway;

    private final TransferenciaDeSaldo transf;
    private final UsuarioComumRepository usuarioComumRepository;

    @ResponseStatus(CREATED)
    @PostMapping("salvar")
    public UsuarioComumResponseDTO inserirSaldo(@RequestBody final UsuarioComumRequestDTO resquestDTO) {
        UsuarioComum usuarioComum = UsuarioComumMapper.toDomain(resquestDTO);
        UsuarioComum savedUsuarioComum = gateway.save(usuarioComum);
        final var usuarioComumResponseDTO = UsuarioComumMapper.toDto(savedUsuarioComum);
        return usuarioComumResponseDTO;

    }

    @ResponseStatus(CREATED)
    @PostMapping("transferir")
    public void transferirSaldo(@RequestParam final Long to, @RequestParam final Long from, @RequestParam final double value ) {
        transf.execute(to, from,value);
    }

    @ResponseStatus(OK)
    @GetMapping("findAll")
    public  @ResponseBody List<UsuarioComum> findAll() {
       return usuarioComumRepository.findAll();
    }
}
