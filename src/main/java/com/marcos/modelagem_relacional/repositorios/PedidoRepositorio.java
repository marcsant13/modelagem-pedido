package com.marcos.modelagem_relacional.repositorios;

import com.marcos.modelagem_relacional.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {
    Optional<Pedido> findByCodigoPedido(String codigoProduto);
}
