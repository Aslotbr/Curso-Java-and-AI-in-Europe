package exercicios;
import java.util.Scanner;

public class exer04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número inicial: ");
        int inicial = sc.nextInt();

        while (true) {
            System.out.print("Digite um número: ");
            int numero = sc.nextInt();

            if (numero < inicial) {
                System.out.println("Número ignorado (menor que o inicial).");
                continue;
            }

            if (numero % inicial != 0) {
                System.out.println("Número não divisível por " + inicial + ". Encerrando.");
                break;
            }

            System.out.println("Número válido: " + numero);
        }

        sc.close();
    }
}
