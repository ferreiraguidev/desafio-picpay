package com.example.lojistasservice.controller.dtos;


public record UsuarioComumResponseDTO(
        String nomeCompleto,
        String cpfCnpj,
        String email,
        double saldo,
        double desconto,
        String tipoUsuario) {
}
