import java.util.Scanner;

public class Exercicio03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o valor consumido: ");
        double valorConsumido = sc.nextDouble();
        System.out.println("Digite o valor pago: ");
        double valorPago = sc.nextDouble();

        if (valorPago < valorConsumido) {
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido.");
        } else {
            double troco = valorPago - valorConsumido;
            System.out.printf("Troco: %.2f", troco);
        }

        sc.close();
    }
}
