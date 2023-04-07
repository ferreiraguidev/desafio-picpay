package com.example.lojistasservice.usecase;


import com.example.lojistasservice.client.VerificationClient;
import com.example.lojistasservice.domain.enums.TiposUsuarios;
import com.example.lojistasservice.gateway.UsuariosGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@RequiredArgsConstructor
@Component
public class TransferenciaDeSaldo {

    private final UsuariosGateway usuariosGateway;

    private final VerificationClient verificationClient;

    public void execute(Long to, Long from, double value) {
        final var usuarioTransfer = usuariosGateway.findById(to);
        final var usuarioRecieve = usuariosGateway.findById(from);

        if (usuarioTransfer.getTipoUsuario() == TiposUsuarios.LOJISTA) {
            //TODO: Create custom Exception
            throw new IllegalArgumentException("Lojista não pode enviar saldo!");
        }
        if (usuarioTransfer.getSaldo() > 0 && value <= usuarioTransfer.getSaldo()) {
            double saldo = usuarioTransfer.getSaldo() - value;
            usuarioTransfer.setSaldo(saldo);

            double saldo2 = usuarioRecieve.getSaldo() + value;
            usuarioRecieve.setSaldo(saldo2);

            final var verification = verificationClient.getVerification();

            if (verification.message().equals("Autorizado")) {
                final var usuarios = List.of(usuarioTransfer, usuarioRecieve);
                usuarios.forEach(usuariosGateway::save);
            }
        } else {
            throw new IllegalArgumentException("Saldo menor que disponível!");
        }
    }
}
