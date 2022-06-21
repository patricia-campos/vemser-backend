import java.util.Scanner;

public class Exercicio03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nome = "";
        double altura = 0;
        int idade = 0;
        double peso = 0;

        int totalJogadores = 0;

        double maiorAltura = 0;

        String jogadorMaisVelho = "";
        int idadeJogadorMaisVelho = 0;

        String jogadorMaisPesado = "";
        double pesoJogadorMaisPesado = 0;

        double alturaJogadores = 0;


        do {
            System.out.println("Informe o nome do jogador: ");
            nome = sc.nextLine();

            if (!nome.equalsIgnoreCase("sair")){

                System.out.println("Informe a altura do jogador: ");
                altura = sc.nextDouble();
                System.out.println("Informe a idade do jogador: ");
                idade = sc.nextInt();
                System.out.println("Informe o peso do jogador: ");
                peso = sc.nextDouble();
                sc.nextLine();
                System.out.println("----------------------------");

                totalJogadores ++;

                if (altura > maiorAltura) {
                    maiorAltura = altura;
                }

                if (idade > idadeJogadorMaisVelho) {
                    jogadorMaisVelho = nome;
                    idadeJogadorMaisVelho = idade;
                }
                if (peso > pesoJogadorMaisPesado) {
                    jogadorMaisPesado = nome;
                    pesoJogadorMaisPesado= peso;
                }

                alturaJogadores += altura;
            };

        } while (!nome.equalsIgnoreCase("sair"));

        System.out.println("A quantidade de jogadores cadastrados é: " + totalJogadores);
        System.out.printf("A altura do maior jogador é %.2fm \n", maiorAltura);
        System.out.printf("O jogador mais velho é %s e sua idade é %d \n", jogadorMaisVelho, idadeJogadorMaisVelho);
        System.out.printf("O jogador mais pesado é %s e seu peso é %.2fkg \n", jogadorMaisPesado, pesoJogadorMaisPesado);
        double mediaAltura = alturaJogadores / totalJogadores;
        System.out.printf("A média de altura dos jogadores é %.2fm ", mediaAltura);

        sc.close();
    }
}
