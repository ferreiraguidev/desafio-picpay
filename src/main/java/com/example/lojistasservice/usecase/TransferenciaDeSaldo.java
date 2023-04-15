package com.example.lojistasservice.usecase;


import com.example.lojistasservice.client.VerificationClient;
import com.example.lojistasservice.domain.enums.TiposUsuarios;
import com.example.lojistasservice.gateway.UsuariosGateway;
import com.example.lojistasservice.exceptions.LojistaTransferException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.List;


@RequiredArgsConstructor
@Component
public class TransferenciaDeSaldo {

    private final UsuariosGateway usuariosGateway;
    private final VerificationClient verificationClient;

    public void execute(Long to, Long from, double value) {
        val usuarioTransfer = usuariosGateway.findById(to);
        val usuarioRecieve = usuariosGateway.findById(from);

        if (usuarioTransfer.getTipoUsuario() == TiposUsuarios.LOJISTA) {
            throw new LojistaTransferException("Lojista não pode transferir saldo!");
        }
        if (usuarioTransfer.getSaldo() > 0 && value <= usuarioTransfer.getSaldo()) {
            double saldo = usuarioTransfer.getSaldo() - value;
            usuarioTransfer.setSaldo(saldo);

            double saldo2 = usuarioRecieve.getSaldo() + value;
            usuarioRecieve.setSaldo(saldo2);

            val verification = verificationClient.getVerification();

            if (verification.message().equals("Autorizado")) {
                val usuarios = List.of(usuarioTransfer,usuarioRecieve);
                usuarios.forEach(usuariosGateway::save);
            }
        } else {
            throw new IllegalArgumentException("Saldo menor que disponível!");
        }
    }
}
