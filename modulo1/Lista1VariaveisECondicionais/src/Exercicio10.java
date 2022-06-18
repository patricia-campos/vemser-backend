import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o total de eleitores da sua cidade: ");
        int totalEleitores = sc.nextInt();
        System.out.println("Informe o número de votos válidos: ");
        int votosValidos = sc.nextInt();
        System.out.println("Informe o total de votos brancos: ");
        int votosBrancos = sc.nextInt();
        System.out.println("Informe o total de votos nulos: ");
        int votosNulos = sc.nextInt();

        double percentualValidos = (votosValidos * 100) / totalEleitores;
        double percentualBrancos = (votosBrancos * 100) / totalEleitores;
        double percentualNulos = (votosNulos * 100) / totalEleitores;

        System.out.println("As eleições na sua cidade apresentaram as seguintes estatísticas:");
        System.out.println(percentualValidos + "% dos votos foram considerados válidos \n" +
                           percentualNulos + "% de eleitores votaram nulo \n" +
                           percentualBrancos + "% de eleitores votaram em branco");
        sc.close();
    }
}
