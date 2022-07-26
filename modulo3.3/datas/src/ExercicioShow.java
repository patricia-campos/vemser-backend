import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ExercicioShow {

    public static void main(String[] args) {

        //Mostrar quantos anos, meses dias e horas para 14/09/2024 18:30 em Londres

        //Data e hora do show
        LocalDateTime dataHoraShow = LocalDateTime.of(2024, 9, 14, 18, 30, 00);

        //Fuso de Londres
        ZoneId londres = ZoneId.of("Europe/London");

        //Data e hora do show para o fuso de Londres
        ZonedDateTime dataHoraShowEmLondres = ZonedDateTime.of(dataHoraShow, londres);

        //Data e hora atuais no Brasil para comparar
        LocalDateTime dataHoraAtualBrasil = LocalDateTime.now();

        long anos = dataHoraAtualBrasil.until(dataHoraShowEmLondres, ChronoUnit.YEARS);
        dataHoraAtualBrasil = dataHoraAtualBrasil.plusYears(anos);

        long meses = dataHoraAtualBrasil.until(dataHoraShowEmLondres, ChronoUnit.MONTHS);
        dataHoraAtualBrasil = dataHoraAtualBrasil.plusMonths(meses);

        long dias = dataHoraAtualBrasil.until(dataHoraShowEmLondres, ChronoUnit.DAYS);
        dataHoraAtualBrasil = dataHoraAtualBrasil.plusDays(dias);

        long horas = dataHoraAtualBrasil.until(dataHoraShowEmLondres, ChronoUnit.HOURS);
        dataHoraAtualBrasil = dataHoraAtualBrasil.plusHours(horas);

        long minutos = dataHoraAtualBrasil.until(dataHoraShowEmLondres, ChronoUnit.MINUTES);
        dataHoraAtualBrasil = dataHoraAtualBrasil.plusMinutes(minutos);

        long segundos = dataHoraAtualBrasil.until(dataHoraShowEmLondres, ChronoUnit.SECONDS);
        dataHoraAtualBrasil = dataHoraAtualBrasil.plusSeconds(segundos);

        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraShowFormatada = dataHoraShow.format(formatar);

        System.out.println("""
                ------------------------------------------\s

                Paranoid & 100% Muito Louco Tour in London\s
                com Black Sabbath & Wesley Safadão\s

                ------------------------------------------\s
                """);

        System.out.printf("Data e hora do evento: " + dataHoraShowFormatada +
                        "\n\nFaltam %d anos, %d mes, %d dias, %d horas, %d minutos e %d segundos para o show",
                        anos, meses, dias, horas, minutos, segundos);

    }
}
