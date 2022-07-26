import java.time.LocalDate;
import java.time.Period;

public class ExercicioComparaDatas {
    public static void main(String[] args) {

        // 2- Informar duas datas e comparar quantos dias, meses e anos elas tem de diferença
        // uma da outra.


        LocalDate data1 = LocalDate.parse("2023-01-01");
        LocalDate data2 = LocalDate.parse("2024-10-01");

        int meses = Period.between(data1, data2).getMonths();
        int dias = Period.between(data1, data2).getDays();
        int anos = Period.between(data1, data2).getYears();

        System.out.println("Entre as datas " + data1 + " e " + data2 + " há " + anos + " ano(s), "  + meses + " meses" +
                " e " +  dias + " dias de diferença.");

    }
}
