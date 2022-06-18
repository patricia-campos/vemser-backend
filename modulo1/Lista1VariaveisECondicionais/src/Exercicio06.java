import java.util.Scanner;

public class Exercicio06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String traducao = "";

        System.out.println("Digite a palavra a ser traduzida: ");
        String palavra = sc.nextLine();

        switch(palavra.toLowerCase()) {
            case "cachorro":
                traducao = "Dog";
                break;
            case "tempo":
                traducao = "Time";
                break;
            case "amor":
                traducao = "Love";
                break;
            case "cidade":
                traducao = "City";
                break;
            case "feliz":
                traducao = "Happy";
                break;
            case "triste":
                traducao = "Sad";
                break;
            case "deveria":
                traducao = "Should";
                break;
            case "could":
                traducao = "Poderia";
                break;
            case "dog":
                traducao = "Cachorro";
                break;
            case "time":
                traducao = "Tempo";
                break;
            case "love":
                traducao = "Amor";
                break;
            case "city":
                traducao = "Cidade";
                break;
            case "happy":
                traducao = "Feliz";
                break;
            case "sad":
                traducao = "Triste";
                break;
            case "should":
                traducao = "Deveria";
                break;
            case "poderia":
                traducao = "Could";
                break;

            default:
                traducao = "Essa palavra não é válida.";
        }

        System.out.println("Tradução: " + traducao);

        sc.close();
    }
}

