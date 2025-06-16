package exercicios;

import java.util.*;

public class exer10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Lê a linha com os endpoints separados por espaço
        String linha = sc.nextLine().trim();

        // Divida em array:
        String[] endpoints = linha.split(" ");

        // Crie um mapa para contar frequência (LinkedHashMap preserva a ordem de inserção):
        Map<String, Integer> frequencia = new LinkedHashMap<>();

        // Contabilize a frequência mantendo ordem de entrada:
        for (String endpoint : endpoints) {
            frequencia.put(endpoint, frequencia.getOrDefault(endpoint, 0) + 1);
        }

        // Encontre o endpoint com maior frequência:
        String maisAcessado = "";
        int max = 0;

        for (Map.Entry<String, Integer> entry : frequencia.entrySet()) {
            if (entry.getValue() > max) {
                maisAcessado = entry.getKey();
                max = entry.getValue();
            }
        }

        // Imprime o endpoint mais acessado
        System.out.println(maisAcessado);

        sc.close();
    }
}
