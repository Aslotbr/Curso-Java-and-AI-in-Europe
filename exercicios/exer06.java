package exercicios;

import java.util.Scanner;

public class exer06 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String entrada = scanner.nextLine(); // leitura da entrada

        try {
            double celsius = Double.parseDouble(entrada);

            if (celsius < -273.15) {
                System.out.println("Entrada invalida");
            } else {
                double fahrenheit = (celsius * 9 / 5) + 32;
                System.out.printf("%.1f\n", fahrenheit);
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida");
        }

        scanner.close();
    }
}
