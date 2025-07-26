package com.marcos.modelagem_relacional.dto;

import lombok.Data;

import java.util.List;

@Data
public class PedidoProdutoDTO {
    private String codigoPedido;
    private List<Long> idProdutos;
}
