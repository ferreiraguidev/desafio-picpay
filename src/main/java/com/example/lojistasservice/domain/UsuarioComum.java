package com.example.lojistasservice.domain;


import com.example.lojistasservice.domain.enums.TiposUsuarios;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;



@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class UsuarioComum {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nomeCompleto;

    @Column(unique = true)
    private String cpfCnpj;

    @Column(unique = true)
    private String email;

    private Double saldo;

    private Integer desconto;

    @Enumerated(EnumType.STRING)
    private TiposUsuarios  tipoUsuario;
}
