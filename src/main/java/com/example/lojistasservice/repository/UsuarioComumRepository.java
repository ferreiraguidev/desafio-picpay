package com.example.lojistasservice.repository;


import com.example.lojistasservice.domain.UsuarioComum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioComumRepository extends JpaRepository<UsuarioComum, Long> {
}
