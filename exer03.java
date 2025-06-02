import java.util.Scanner;

public class exer03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int inicio = sc.nextInt();

        System.out.print("Digite o segundo número (maior que o primeiro): ");
        int fim = sc.nextInt();

        if (fim <= inicio) {
            System.out.println("O segundo número deve ser maior que o primeiro.");
            sc.close();
            return;
        }

        System.out.print("Você quer ver os números pares ou ímpares? (Digite 'par' ou 'impar'): ");
        String escolha = sc.next();

        System.out.println("\nNúmeros em ordem decrescente:");
        for (int i = fim; i >= inicio; i--) {
            if (escolha.equalsIgnoreCase("par") && i % 2 == 0) {
                System.out.println(i);
            } else if (escolha.equalsIgnoreCase("impar") && i % 2 != 0) {
                System.out.println(i);
            }
        }

        sc.close();
    }
}
