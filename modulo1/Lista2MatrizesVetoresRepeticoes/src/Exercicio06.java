import java.util.Scanner;

public class Exercicio06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean encontrouValor = false;

        int[] vetor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Digite um valor para saber se ele existe dentro do vetor: ");
        int valor = sc.nextInt();

        for (int i = 0; i < vetor.length; i++) {

            if (vetor[i] == valor) {
                System.out.println("O valor digitado foi encontrado no vetor!");
                encontrouValor = true;
                break;
            }
        }

        if (encontrouValor == false) {
            System.out.println("O valor não foi encontrado no vetor");
        }

    }
}
