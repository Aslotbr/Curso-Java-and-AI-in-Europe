package exercicios;

import java.util.*;

public class exer07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Lê a quantidade de horários
        int n = Integer.parseInt(sc.nextLine());

        // TreeSet para armazenar horários únicos e ordenados
        Set<String> horarios = new TreeSet<>();

        // Lê cada horário e adiciona ao conjunto
        for (int i = 0; i < n; i++) {
            String horario = sc.nextLine();
            horarios.add(horario);
        }

        // Imprime os horários únicos em ordem crescente
        for (String horario : horarios) {
            System.out.println(horario);
        }

        // Imprime o total de horários únicos
        System.out.println("Total de horarios unicos: " + horarios.size());

        sc.close();
    }
}

