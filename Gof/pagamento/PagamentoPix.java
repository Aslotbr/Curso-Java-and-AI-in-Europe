package Gof.pagamento;

public class PagamentoPix implements PagamentoStrategy {
    public String pagar(double valor) {
        return "Pagamento de R$" + valor + " realizado via Pix.";
    }
}
