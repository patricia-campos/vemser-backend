import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ExercicioDataAniversario {

    public static void main(String[] args) {

        // 1- Pedir ao usuário para informar sua data de aniversário,
        // fazer o cálculo de quantos dias e meses faltam até a próxima data.

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe quando será seu próximo aniversário: (DD/MM/AAAA)");
        String dataInformada = sc.nextLine();

        LocalDate hoje = LocalDate.now();

        DateTimeFormatter dataAniversarioFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAniversario = LocalDate.parse(dataInformada, dataAniversarioFormatada);

        int meses = Period.between(hoje, dataAniversario).getMonths();
        int dias = Period.between(hoje, dataAniversario).getDays();

        System.out.println("Faltam " + meses + " meses e " + dias + " dias para o seu próximo aniversário!");

    }
}
