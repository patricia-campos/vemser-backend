import java.util.Scanner;

public class Exercicio02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite a primeira nota: ");
        double nota1 = sc.nextDouble();

        System.out.println("Digite a segunda nota: ");
        double nota2 = sc.nextDouble();

        System.out.println("Digite a terceira nota: ");
        double nota3 = sc.nextDouble();

        System.out.println("Digite a quarta nota: ");
        double nota4 = sc.nextDouble();

        double media = (nota1 + nota2 + nota3 + nota4) / 4;

        if (media >= 7) {
            System.out.printf("Parabéns %s, você foi aprovado! Sua média final é %.2f.", nome, media);
        } else if (media >= 5.1 && media <= 6.9) {
            System.out.printf("%s, você está em recuperação. Sua média final é %.2f.", nome, media);
        } else {
            System.out.printf("%s, você reprovou. Sua média final é %.2f.", nome, media);
        }

        sc.close();

    }
}
