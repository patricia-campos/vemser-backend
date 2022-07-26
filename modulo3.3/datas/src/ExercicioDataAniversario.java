import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ExercicioDataAniversario {

    public static void main(String[] args) {

        // 1- Pedir ao usuário para informar sua data de aniversário,
        // fazer o cálculo de quantos dias e meses faltam até a próxima data.

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe seu aniversário: (DD/MM/AAAA)");
        String dataInformada = sc.nextLine();

        LocalDate hoje = LocalDate.now();

        //Informa modelo de formatação e aplica

        DateTimeFormatter dataAniversarioFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAniversario = LocalDate.parse(dataInformada, dataAniversarioFormatada);


        Period proximaData = Period.between(hoje,dataAniversario.plusYears(1));

        System.out.println("Faltam " + proximaData.getMonths() + " meses e " + proximaData.getDays()+ " dias para o seu próximo aniversário!");

    }
}
