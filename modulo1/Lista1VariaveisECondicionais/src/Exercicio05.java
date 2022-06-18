import java.util.Scanner;

public class Exercicio05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor da hora trabalhada: R$");
        double valorHora = sc.nextDouble();
        System.out.println("Digite o número de horas normais trabalhadas: ");
        int horasNormais = sc.nextInt();
        System.out.println("Digite o número de horas extras 50% trabalhadas: ");
        int horasExtras50 = sc.nextInt();
        System.out.println("Digite o número de horas extras 100% trabalhadas: ");
        int horasExtras100 = sc.nextInt();

        double salarioBruto = (horasNormais * valorHora) + (horasExtras50 * valorHora *1.5)
                + (horasExtras100 * valorHora *2);
        System.out.printf("Salário total bruto: R$%.2f", salarioBruto);

        sc.close();
    }
}
