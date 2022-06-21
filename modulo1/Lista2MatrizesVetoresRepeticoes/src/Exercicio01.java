import java.util.Scanner;

public class Exercicio01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        System.out.println("Digite o nome do produto: ");
        String nomeProduto = sc.nextLine();
        System.out.println("Insira o valor unitário do produto: ");
        double valorProduto = sc.nextDouble();
        System.out.printf("O produto %s está em desconto progressivo! Confira: \n\n", nomeProduto);

        double desconto = 0.05;
        int quantidade = 1;

        for (int i=0; i < 10; i++){

            double valorUnitarioComDesconto = valorProduto - (valorProduto * desconto);
            double valorTotalComDesconto = valorUnitarioComDesconto * quantidade;

            System.out.printf("%d R$ %.2f R$ %.2f \n", quantidade, valorUnitarioComDesconto, valorTotalComDesconto);
            quantidade ++;
            desconto += 0.05;

        }

        sc.close();

    }
}
