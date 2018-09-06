package site.wattsnwc.java8.newdateapi;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeTest {
    public static void main(String[] args) {
        Clock clock = Clock.systemUTC();
        Instant instant = clock.instant();
        System.out.println(instant.toString());

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.toString());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toString());

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime.toString());
    }
}