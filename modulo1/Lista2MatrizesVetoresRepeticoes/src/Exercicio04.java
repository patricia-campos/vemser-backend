import java.util.Scanner;

public class Exercicio04 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vetor[]= new int [3];

        int posicaoDoMenorValor = 0;

        for ( int i = 0 ; i < vetor.length ; i++){
            System.out.print("Digite um valor para preencher o vetor: ");
            vetor[i]=sc.nextInt();
        }

        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] < vetor[posicaoDoMenorValor]) {
                posicaoDoMenorValor = i;
            }
        }

        System.out.println("A posição do menor valor dentro do vetor é " + posicaoDoMenorValor);

        sc.close();
    }
}
