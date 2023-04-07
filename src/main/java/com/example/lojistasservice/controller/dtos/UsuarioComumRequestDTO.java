package com.example.lojistasservice.controller.dtos;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor
@Getter
@Setter
public class UsuarioComumRequestDTO{

        private Long id;
        private String nomeCompleto;
        private String cpfCnpj;
        private double saldo;
        private Integer desconto;
        private String email;
        private String tipoUsuario;
}
