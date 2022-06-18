import java.util.Scanner;

public class Exercicio08 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o valor de base do retângulo: ");
        double base = sc.nextDouble();
        System.out.println("Informe a altura do retângulo: ");
        double altura = sc.nextDouble();

        double area = base * altura;
        System.out.printf("A área do retângulo de base %.2f e altura %.2f é %.2f.", base, altura, area);

        sc.close();
    }
}
