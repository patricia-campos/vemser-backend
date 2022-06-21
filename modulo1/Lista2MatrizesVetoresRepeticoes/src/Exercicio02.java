import java.util.Random;
import java.util.Scanner;

public class Exercicio02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int palpite = 0;
        int tentativa = 10;

        System.out.println("Adivinhe em que número estou pensando de 0 até 100... ┬┴┬┴┤ (· _├┬┴┬┴ \n" +
                               "Você terá 10 tentativas e receberá pistas entre elas! \n");

            Random numeroAleatorio = new Random();
            int numeroSecreto = numeroAleatorio.nextInt(101);

                do {
                    System.out.printf("Você tem %d tentativas. \n", tentativa);

                    System.out.println("Dê o seu palpite: ");
                    palpite = sc.nextInt();

                    if (palpite > numeroSecreto) {
                        System.out.printf("Vixi... Você errou!  (* -_-)  \n" +
                                "O número que estou pensando é menor que %d! \n\n", palpite);

                    } else if (palpite < numeroSecreto) {
                        System.out.printf("Não foi dessa vez...  (* -_-)  \n" +
                                "O número que estou pensando é maior que %d! \n\n", palpite);

                    } else {
                        System.out.printf("U-A-U! ヽ (゚ 〇 ゚) ノ  " +
                                "Parabens! Voce adivinhou o número em que estou pensando!");
                    }

                    tentativa --;

                    if (tentativa == 0) {
                        break;
                    }

                } while (palpite != numeroSecreto);

                sc.close();

            }

        }


