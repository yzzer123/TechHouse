package com.yzzer.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTimeTest {

    @Test
    public void test1() {
        Date date = new Date();
        System.out.println(date);

        long milliTime = date.getTime();
        System.out.println(date.getTime());

        System.out.println(new Date(milliTime));
    }

    @Test
    public void test2() {
        // extends java.util.Date
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

        System.out.println(date);
        System.out.println(date.getTime());

    }

    @Test
    public void test3() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        System.out.println(sdf.format(new Date()));

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf2.format(new Date()));

        Date date2 = sdf2.parse("2024-01-24 18:16:31");
        System.out.println(date2);
    }

    @Test
    public void test4() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        System.out.println(instance.getTime());  // java.util.Date
    }


    @Test
    public void test5() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        System.out.println(LocalDate.of(2023, 12, 11));
    }

    @Test
    public void test6() {
        Instant now = Instant.now();
        System.out.println(now);

        System.out.println(ZoneId.getAvailableZoneIds());
        ZonedDateTime ctt = now.atZone(ZoneId.systemDefault());
        System.out.println(ctt);
    }

    @Test
    public void test7() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));
        TemporalAccessor temp = dateTimeFormatter.parse("2022-10-11 12:22:34");
        LocalDateTime datetime = LocalDateTime.from(temp);
        System.out.println(datetime);
    }

}
