public class Exercicio07 {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        System.out.println("O primeiro valor de a é: " + a);
        System.out.println("O primeiro valor de b é: " + b + "\n");

        int x = a;
        a = b;
        b = x;

        System.out.println("O novo valor de a é: " + a);
        System.out.println("O novo valor de b é: " + b);

    }
}
