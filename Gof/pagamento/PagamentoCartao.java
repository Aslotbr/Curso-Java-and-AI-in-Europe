package Gof.pagamento;

public class PagamentoCartao implements PagamentoStrategy {
    public String pagar(double valor) {
        return "Pagamento de R$" + valor + " realizado com Cartão.";
    }
}
