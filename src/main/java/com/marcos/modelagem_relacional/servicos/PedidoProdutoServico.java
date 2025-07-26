package com.marcos.modelagem_relacional.servicos;

import com.marcos.modelagem_relacional.dto.PedidoProdutoDTO;
import com.marcos.modelagem_relacional.dto.PedidoProdutoRespostaDTO;
import com.marcos.modelagem_relacional.entidades.PedidoProduto;
import com.marcos.modelagem_relacional.repositorios.PedidoProdutoRepositorio;
import com.marcos.modelagem_relacional.repositorios.PedidoRepositorio;
import com.marcos.modelagem_relacional.repositorios.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoProdutoServico {

    private final PedidoProdutoRepositorio pedidoProdutoRepositorio;
    private final PedidoRepositorio pedidoRepositorio;
    private final ProdutoRepositorio produtoRepositorio;

    public PedidoProdutoServico(PedidoProdutoRepositorio pedidoProdutoRepositorio, PedidoRepositorio pedidoRepositorio, ProdutoRepositorio produtoRepositorio) {
        this.pedidoProdutoRepositorio = pedidoProdutoRepositorio;
        this.pedidoRepositorio = pedidoRepositorio;
        this.produtoRepositorio = produtoRepositorio;
    }

    public PedidoProdutoRespostaDTO adicionarProdutosPedido(PedidoProdutoDTO pedidoProdutoDTO){
        PedidoProdutoRespostaDTO pedidoProdutoRespostaDTO = new PedidoProdutoRespostaDTO();
        var nomeUsuarioPedido = pedidoRepositorio.findByCodigoPedido(pedidoProdutoDTO.getCodigoPedido()).orElseThrow().getUsuario().getNome();
        var codigoPedido = pedidoRepositorio.findByCodigoPedido(pedidoProdutoDTO.getCodigoPedido()).orElseThrow().getCodigoPedido();
        pedidoProdutoRespostaDTO.setNomeUsuario(nomeUsuarioPedido);
        pedidoProdutoRespostaDTO.setCodigoPedido(codigoPedido);
        List<String> nomeProduto = new ArrayList<>();
        for (Long idProduto: pedidoProdutoDTO.getIdProdutos()){
            PedidoProduto pedidoProduto = new PedidoProduto();
            pedidoProduto.setPedido(pedidoRepositorio.findByCodigoPedido(pedidoProdutoDTO.getCodigoPedido()).orElseThrow());
            pedidoProduto.setProduto(produtoRepositorio.findById(idProduto).orElseThrow());
            pedidoProdutoRepositorio.save(pedidoProduto);
            nomeProduto.add(produtoRepositorio.findById(idProduto).orElseThrow().getDescricao());
        }
        pedidoProdutoRespostaDTO.setNomeProdutos(nomeProduto);
        return pedidoProdutoRespostaDTO;
    }
}
