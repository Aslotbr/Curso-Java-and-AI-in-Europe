package Gof.service;

import Gof.factory.Comida;
import Gof.pagamento.PagamentoStrategy;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private static PedidoService instancia;

    private PedidoService() {}

    public static PedidoService getInstance() {
        if (instancia == null) {
            instancia = new PedidoService();
        }
        return instancia;
    }

    public String fazerPedido(Comida comida, PagamentoStrategy pagamento) {
        String descricao = comida.getDescricao();
        String resultadoPagamento = pagamento.pagar(40.0);
        return "Pedido: " + descricao + " | " + resultadoPagamento;
    }
}
