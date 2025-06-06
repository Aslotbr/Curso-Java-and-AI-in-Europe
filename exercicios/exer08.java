package exercicios;

import java.util.*;

public class exer08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Lê o número de tarefas
        int n = Integer.parseInt(sc.nextLine());

        // Lista para armazenar as tarefas como objetos Tarefa
        List<Tarefa> tarefas = new ArrayList<>();

        // Lê cada linha, separa por nome e prioridade, e adiciona à lista
        for (int i = 0; i < n; i++) {
            String linha = sc.nextLine();
            String[] partes = linha.split(",");
            String nome = partes[0].trim();
            int prioridade = Integer.parseInt(partes[1].trim());

            tarefas.add(new Tarefa(nome, prioridade));
        }

        // Ordena a lista pela prioridade crescente
        Collections.sort(tarefas, Comparator.comparingInt(t -> t.prioridade));

        // Imprime a lista ordenada no formato "tarefa - prioridade"
        for (Tarefa t : tarefas) {
            System.out.println(t.nome + " - " + t.prioridade);
        }

        sc.close();
    }

    // Classe auxiliar para armazenar nome e prioridade
    static class Tarefa {
        String nome;
        int prioridade;

        public Tarefa(String nome, int prioridade) {
            this.nome = nome;
            this.prioridade = prioridade;
        }
    }
}
