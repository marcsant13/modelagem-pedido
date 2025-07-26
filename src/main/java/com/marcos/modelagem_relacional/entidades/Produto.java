package com.marcos.modelagem_relacional.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produto")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String descricao;

    @Column(name = "codigo_produto", unique = true)
    private String codigoDoProduto;

    private BigDecimal preco;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<PedidoProduto> pedidoProdutos;

}
