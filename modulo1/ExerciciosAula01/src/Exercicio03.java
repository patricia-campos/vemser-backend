import java.util.Scanner;

public class Exercicio03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número para saber se é par ou ímpar: ");
        int numero = sc.nextInt();

        if (numero % 2 == 0) {
            System.out.printf("%d é um número par", numero);
        } else {
            System.out.printf("%d é um número ímpar", numero);
        }

        sc.close();

    }
}
