package com.yzzer.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    }
}
