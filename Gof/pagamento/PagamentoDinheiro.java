package Gof.pagamento;

public class PagamentoDinheiro implements PagamentoStrategy {
    public String pagar(double valor) {
        return "Pagamento de R$" + valor + " realizado em Dinheiro.";
    }
}
