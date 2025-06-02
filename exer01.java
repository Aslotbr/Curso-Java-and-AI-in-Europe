import java.util.Scanner;

public class exer01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número para ver a tabuada de 1 até 10: ");
        int numero = sc.nextInt();

        System.out.println("\nTabuada do " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
        sc.close();
    }
}
