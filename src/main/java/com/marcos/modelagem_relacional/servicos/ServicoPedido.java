package com.marcos.modelagem_relacional.servicos;

import com.marcos.modelagem_relacional.dto.PedidoDTO;
import com.marcos.modelagem_relacional.entidades.Pedido;
import com.marcos.modelagem_relacional.repositorios.PedidoRepositorio;
import com.marcos.modelagem_relacional.repositorios.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ServicoPedido {

    private final PedidoRepositorio pedidoRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;

    public ServicoPedido(PedidoRepositorio pedidoRepositorio, UsuarioRepositorio usuarioRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public Pedido salvarPedido(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();
        pedido.setCodigoPedido(UUID.randomUUID().toString().replace("-", "").substring(0, 5));
        pedido.setUsuario(usuarioRepositorio.findById(pedidoDTO.getIdUsuario()).orElseThrow());
        return pedidoRepositorio.save(pedido);
    }
}
