import java.util.Scanner;

public class Exercicio08 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int matriz[][] = new int[5][4];

        double MediaFinal = 0;

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {

                if (coluna == 0){

                    System.out.println("Digite a matrícula do aluno:");
                    matriz[linha][coluna] = sc.nextInt();

                } else if (coluna == 1){

                    System.out.println("Digite a média das provas:");
                    matriz[linha][coluna] = sc.nextInt();

                } else if (coluna == 2){

                    System.out.println("Digite a média dos trabalhos:");
                    matriz[linha][coluna] = sc.nextInt();

                } else {

                    System.out.println("Digite a nota final:");
                    matriz[linha][coluna] = sc.nextInt();
                    System.out.println("-------------------------------");
                }


            }
        }

        double notaFinal = 0;
        double mediaNotaFinal = 0;
        double maiorNotaFinal = 0;
        int maiorMatricula = 0;
        int matricula = 0;
        double somaNotaFinal = 0;
        double valor1 = 0;
        double valor2 = 0;

        for (int linha = 0; linha < matriz.length; linha++) {

            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {

                if (coluna == 0) {
                    matricula = matriz[linha][coluna];

                } else if (coluna == 1) {
                    valor1 = (matriz[linha][coluna] * 0.6);

                } else if (coluna == 2) {
                    valor2 = (matriz[linha][coluna] * 0.4);

                }
            }

            notaFinal = valor1 + valor2;

            somaNotaFinal += notaFinal;

            if (notaFinal > maiorNotaFinal) {
                maiorMatricula = matricula;
                maiorNotaFinal = notaFinal;
            }

        }

        mediaNotaFinal = somaNotaFinal / 5 ;
        System.out.printf("A média de notas finais é %.2f \n", mediaNotaFinal);
        System.out.printf("A  matrícula que obteve a maior nota final é %d ", maiorMatricula);

    }
}