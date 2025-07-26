package com.marcos.modelagem_relacional.repositorios;

import com.marcos.modelagem_relacional.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
}
