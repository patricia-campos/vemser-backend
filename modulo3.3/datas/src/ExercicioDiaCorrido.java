import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ExercicioDiaCorrido {

    public static void main(String[] args) {

        // Imprimir qual é o dia da semana e dia do ano (corrido) correspondente da data atual
        // + 15 dias e 10 horas.

        LocalDateTime dataAtual = LocalDateTime.now();

        dataAtual = dataAtual.plusDays(15).plusHours(10);
        //Adiciona 15 dis e 10hs
        //LocalDateTime dataDiasAdicionados= dataAtual.plus(Period.ofDays(15));
        //LocalDateTime dataHorasAdicionadas = dataDiasAdicionados.plusHours(10);

        //Informa modelo de formatação e aplica
        //DateTimeFormatter dataAcrescentadaHorasFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        //String dataHoraFormatada = dataHorasAdicionadas.format(dataAcrescentadaHorasFormatada);


        System.out.println("Dia da semana: " + dataAtual.getDayOfWeek());
        System.out.println("Estamos no dia " + dataAtual.getDayOfYear() + " do ano " + dataAtual.getYear());
        //System.out.println("O dia de hoje + 15 dias e 10 horas será " + dataHoraFormatada + ".");

    }
}
