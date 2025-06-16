package exercicios;

import java.util.*;

public class exer09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leia a linha com os nomes separados por espaço:
        String linha = sc.nextLine().trim();

        // Divida os nomes em um array:
        String[] nomes = linha.split(" ");

        // Ordene os nomes alfabeticamente:
        Arrays.sort(nomes);

        // Use o StringBuilder para construir a saída no formato JSON simples:
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        // Itere e adicione aspas e vírgulas entre os nomes:
        for (int i = 0; i < nomes.length; i++) {
            sb.append("\"").append(nomes[i]).append("\"");
            if (i < nomes.length - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");

        // Imprime a lista formatada
        System.out.println(sb.toString());

        sc.close();
    }
}
