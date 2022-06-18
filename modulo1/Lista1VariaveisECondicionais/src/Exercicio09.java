
import java.util.Scanner;

public class Exercicio09 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe, sequencialmente, quantos ANOS, MESES e DIAS de vida você tem hoje:");
        int anosDeVida = sc.nextInt();
        int mesesDeVida = sc.nextInt();
        int diasDeVida = sc.nextInt();

        int anosParaDias = anosDeVida * 365;
        int mesesParaDias = mesesDeVida * 30;

        int totalDeDiasVividos = anosParaDias + mesesParaDias + diasDeVida;

        System.out.printf("Você já viveu o total de %d dias", totalDeDiasVividos);

        sc.close();
    }
}
