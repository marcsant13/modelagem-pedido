package com.marcos.modelagem_relacional.controladores;

import com.marcos.modelagem_relacional.dto.PedidoProdutoDTO;
import com.marcos.modelagem_relacional.dto.PedidoProdutoRespostaDTO;
import com.marcos.modelagem_relacional.servicos.PedidoProdutoServico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adicionar-produtos")
public class PedidoProdutoControlador {

    private final PedidoProdutoServico pedidoProdutoServico;

    public PedidoProdutoControlador(PedidoProdutoServico pedidoProdutoServico) {
        this.pedidoProdutoServico = pedidoProdutoServico;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<PedidoProdutoRespostaDTO> adicionarProdutosPedido(@RequestBody PedidoProdutoDTO pedidoProdutoDTO){
        var produtosPedido = pedidoProdutoServico.adicionarProdutosPedido(pedidoProdutoDTO);
        return ResponseEntity.ok(produtosPedido);
    }
}
