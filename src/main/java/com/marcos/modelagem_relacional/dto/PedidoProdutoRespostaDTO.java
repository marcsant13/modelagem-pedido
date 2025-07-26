package com.marcos.modelagem_relacional.dto;

import lombok.Data;

import java.util.List;

@Data
public class PedidoProdutoRespostaDTO {
    private String codigoPedido;
    private String nomeUsuario;
    private List<String> nomeProdutos;
}
