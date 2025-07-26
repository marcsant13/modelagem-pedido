package com.marcos.modelagem_relacional.controladores;

import com.marcos.modelagem_relacional.dto.PedidoDTO;
import com.marcos.modelagem_relacional.dto.PedidoRespostaDTO;
import com.marcos.modelagem_relacional.entidades.Pedido;
import com.marcos.modelagem_relacional.servicos.ServicoPedido;
import com.marcos.modelagem_relacional.servicos.ServicoProduto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedido")
public class PedidoControlador {

    private final ServicoPedido servicoPedido;

    public PedidoControlador(ServicoPedido servicoPedido) {
        this.servicoPedido = servicoPedido;
    }

    @PostMapping("/criar")
    public ResponseEntity<PedidoRespostaDTO> criarPedido(@RequestBody PedidoDTO pedidoDTO){
        var pedidoRealizado = servicoPedido.salvarPedido(pedidoDTO);
        PedidoRespostaDTO pedidoRespostaDTO = new PedidoRespostaDTO();
        pedidoRespostaDTO.setCodigoPedido(pedidoRealizado.getCodigoPedido());
        pedidoRespostaDTO.setNomeUsuario(pedidoRealizado.getUsuario().getNome());
        return ResponseEntity.ok(pedidoRespostaDTO);
    }
}
