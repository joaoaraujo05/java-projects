import javax.xml.crypto.Data;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Program {
    public static void main(String[] args) {

        LocalDate d04 = LocalDate.parse("2024-07-06"); // data-hora para texto ISO
        LocalDateTime d05 = LocalDateTime.parse("2024-07-06T01:30:26");
        Instant d06 = Instant.parse("2024-07-06T01:30:26Z"); //padrao UTC

        // calculos com data-hora, acrecentando tmepo para gerar uma nova data-hora

        //uma semana antes
        LocalDate pastWeekLocalDate = d04.minusDays(7);
        LocalDate nestWeekLocalData = d04.plusDays(7);


        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nestWeekLocalData = " + nestWeekLocalData);

        //LocaDateTime
        LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
        LocalDateTime nestWeekLocalDataTime = d05.plusDays(7);

        System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
        System.out.println("nestWeekLocalDataTime = " + nestWeekLocalDataTime);

        //Instant
        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nestWeekInstant = d06.plus(7, ChronoUnit.DAYS);

        System.out.println("pastWeekInstant = " + pastWeekInstant);
        System.out.println("nestWeekInstant = " + nestWeekInstant);

        // calculos com data-hora, descobrindo a duracao a partir de duas data-hora
        Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay());// convertendo para local date
        System.out.println("t1 dias = " + t1.toDays());

        Duration t2 = Duration.between(pastWeekLocalDateTime, d05);
        System.out.println("t2 dias = " + t2.toDays());

        Duration t3 = Duration.between(pastWeekInstant, d06);
        System.out.println("t3 dias = " + t3.toDays());

        Duration t4 = Duration.between(d06, pastWeekInstant);
        System.out.println("t4 dias = " + t4.toDays());
    }
}
