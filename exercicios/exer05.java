package exercicios;

import java.util.Scanner;

public class exer05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();

        if (email.endsWith("@company.com")) {
            System.out.println("E-mail valido");
        } else {
            System.out.println("E-mail invalido");
        }

        sc.close();
    }
}
