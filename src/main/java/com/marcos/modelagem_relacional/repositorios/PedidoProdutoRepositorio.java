package com.marcos.modelagem_relacional.repositorios;

import com.marcos.modelagem_relacional.entidades.PedidoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoProdutoRepositorio extends JpaRepository<PedidoProduto, Long> {
}
