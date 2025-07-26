package com.marcos.modelagem_relacional.repositorios;

import com.marcos.modelagem_relacional.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findById(Long id);
}
