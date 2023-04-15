package com.example.lojistasservice.controller.dtos;


public record UsuarioComumRequestDTO(Long id,
                                     String nomeCompleto,
                                     String cpfCnpj,
                                     Double saldo,
                                     Integer desconto,
                                     String email,
                                     String tipoUsuario) {
}
