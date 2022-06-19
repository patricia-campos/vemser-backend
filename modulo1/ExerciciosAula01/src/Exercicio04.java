import java.util.Scanner;

public class Exercicio04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o primeiro valor: ");
        double valor1 = sc.nextDouble();
        System.out.println("Informe o segundo valor: ");
        double valor2 = sc.nextDouble();
        System.out.println("Informe a operação conforme lista abaixo: \n" +
                            "1 - Soma \n" +
                            "2 - Subtração \n" +
                            "3 - Divisão \n" +
                            "4 - Multiplicação");
        int operacao = sc.nextInt();
        double resultado = 0;

        switch (operacao) {
            case 1:
                resultado = valor1 + valor2;
                System.out.printf("O resultado da soma entre %.2f e %.2f é %.2f", valor1 , valor2, resultado);
                break;
            case 2:
                resultado = valor1 - valor2;
                System.out.printf("O resultado da subtração entre %.2f e %.2f é %.2f", valor1 , valor2, resultado);
                break;
            case 3:
                resultado = valor1 / valor2;
                System.out.printf("O resultado da divisão entre %.2f e %.2f é %.2f", valor1 , valor2, resultado);
                break;
            case 4:
                resultado = valor1 * valor2;
                System.out.printf("O resultado da multiplicação entre %.2f e %.2f é %.2f", valor1 , valor2, resultado);
                break;
        }

        sc.close();
    }
}
