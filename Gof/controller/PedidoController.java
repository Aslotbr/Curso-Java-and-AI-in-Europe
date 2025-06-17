package Gof.controller;

import Gof.factory.Comida;
import Gof.factory.ComidaFactory;
import Gof.factory.TiposComida;
import Gof.pagamento.*;
import Gof.service.PedidoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @GetMapping
    public String realizarPedido(@RequestParam String tipoComida, @RequestParam String tipoPagamento) {
        TiposComida tipo = TiposComida.valueOf(tipoComida.toUpperCase());
        Comida comida = ComidaFactory.criarComida(tipo);

        PagamentoStrategy pagamento = switch (tipoPagamento.toLowerCase()) {
            case "pix" -> new PagamentoPix();
            case "cartao" -> new PagamentoCartao();
            case "dinheiro" -> new PagamentoDinheiro();
            default -> throw new IllegalArgumentException("Forma de pagamento inválida");
        };

        PedidoService service = PedidoService.getInstance();
        return service.fazerPedido(comida, pagamento);
    }
}

