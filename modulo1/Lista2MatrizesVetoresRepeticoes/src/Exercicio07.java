import java.util.Scanner;

public class Exercicio07 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int matriz[][] = new int[4][4];

        int somaDeValores = 0;

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.println("Digite um valor:");
                matriz[linha][coluna] = sc.nextInt();
            }
        }

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                if (matriz[linha][coluna] > 10) {
                    somaDeValores++;
                }
            }
        }

        System.out.printf("A matriz possui %d valores maiores que 10", somaDeValores);

        sc.close();
    }
}
