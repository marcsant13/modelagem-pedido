package com.marcos.modelagem_relacional.dto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoDTO {

    private String descricao;
    private String codigoDoProduto;
    private BigDecimal preco;


}
