package Gof.factory;

public class ComidaFactory {
    public static Comida criarComida(TiposComida tipo) {
        return switch (tipo) {
            case PIZZA -> new Comida() {
                public String getDescricao() {
                    return "Pizza de Calabresa";
                }
            };
            case HAMBURGUER -> new Comida() {
                public String getDescricao() {
                    return "Hambúrguer Artesanal";
                }
            };
            case SUSHI -> new Comida() {
                public String getDescricao() {
                    return "Sushi Especial";
                }
            };
        };
    }
}