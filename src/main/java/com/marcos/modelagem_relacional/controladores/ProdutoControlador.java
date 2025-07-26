package com.marcos.modelagem_relacional.controladores;

import com.marcos.modelagem_relacional.dto.ProdutoDTO;
import com.marcos.modelagem_relacional.entidades.Produto;
import com.marcos.modelagem_relacional.servicos.ServicoProduto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoControlador {

    private final ServicoProduto servicoProduto;

    public ProdutoControlador(ServicoProduto servicoProduto) {
        this.servicoProduto = servicoProduto;
    }

    @PostMapping("/salvar")
    public ResponseEntity<Produto> salvarProduto(@RequestBody ProdutoDTO produtoDTO){
        var produtoSalvo = servicoProduto.salvarProduto(produtoDTO);
        return ResponseEntity.ok(produtoSalvo);
    }
}
