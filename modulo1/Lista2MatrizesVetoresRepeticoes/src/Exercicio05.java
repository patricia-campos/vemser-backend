import java.util.Scanner;

public class Exercicio05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vetor[]= new int [20];

        for ( int i = 0 ; i < vetor.length ; i++){
            System.out.print("Digite um valor para preencher o vetor: ");
            vetor[i]=sc.nextInt();
        }

        for(int i = vetor.length-1 ; i >= 0; i--){
            System.out.println(vetor[i]);
        }

        sc.close();
    }
}
