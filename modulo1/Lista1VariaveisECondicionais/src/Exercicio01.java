import java.util.Scanner;

public class Exercicio01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite sua idade: ");
        int idade = sc.nextInt();

        System.out.println("Digite sua cidade: ");
        String cidade = sc.next();

        System.out.println("Digite seu estado: ");
        String estado = sc.next();

        System.out.printf("Olá! Seu nome é %s, você tem %d anos, é da cidade de %s, situada no estado de %s.",
                nome, idade, cidade, estado);

        sc.close();
    }
}
