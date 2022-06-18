import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int estado = 0;
        int cidade = 0;


        System.out.println("Escolha um Estado digitando o número correspondente: \n" +
                " 1 - SP \n 2 - RJ \n 3 - RS");
        estado = sc.nextInt();

        if (estado == 1) {
            System.out.println("Escolha uma cidade do estado de São Paulo digitando o número correspondente: \n" +
                    " 1 - São Paulo \n 2 - Taubaté");
            cidade = sc.nextInt();

            if (cidade == 1) {
                System.out.println("SÃO PAULO - Capital \n" +
                        "População: 12.33 milhões \n" +
                        "Festa Popular: Virada Cultural Paulista\n" +
                        "IDH: 0,783");
            } else if (cidade == 2) {
                System.out.println("TAUBATÉ \n" +
                        "População: 317.915 \n" +
                        "Festa Popular: Festa do Folclore da Imaculada\n" +
                        "IDH: 0,800");
            } else {
                System.out.println("Opção inválida");
            }

        } else if (estado == 2) {
            System.out.println("Escolha uma cidade do estado do Rio de Janeiro digitando o número correspondente: \n" +
                    " 1 - Rio de Janeiro \n 2 - Teresópolis");
            cidade = sc.nextInt();

            if (cidade == 1) {
                System.out.println("RIO DE JANEIRO - Capital \n" +
                        "População: 6.748 milhões \n" +
                        "Festa Popular: Carnaval\n" +
                        "IDH: 0,799");
            } else if (cidade == 2) {
                System.out.println("TERESÓPOLIS \n" +
                        "População: 185.820 \n" +
                        "Festa Popular: Festival da Cidade\n" +
                        "IDH: 0,730");
            } else {
                System.out.println("Opção inválida");
            }

        } else if (estado == 3) {
            System.out.println("Escolha uma cidade do estado do Rio Grande do Sul digitando o número correspondente: \n" +
                    " 1 - Porto Alegre \n 2 - Gramado");
            cidade = sc.nextInt();

            if (cidade == 1) {
                System.out.println("PORTO ALEGRE \n" +
                        "População: 1.492.530\n" +
                        "Festa Popular: Semana Farroupilha\n" +
                        "IDH: 0,805");
            } else if (cidade == 2) {
                System.out.println("GRAMADO \n" +
                        "População: 36.555 \n" +
                        "Festa Popular: Natal Luz\n" +
                        "IDH: 0,841");
            } else {
                System.out.println("Opção inválida");
            }

        }else {
            System.out.println("Estado inválido");
        }
    }
}
