package com.marcos.modelagem_relacional.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pedido_produto")
@Data
public class PedidoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

}
