package com.springboot.demo;

import com.alibaba.fastjson.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * @program demo-test
 * @description:
 * @author: jason.qi
 * @create: 2019-09-16 20:17
 */
@SpringBootTest(classes = TestTime.class)
@RunWith(SpringRunner.class)
public class TestTime {
    public static void main(String[] args) {

//        String datetime =  "2019-01-29";
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate date1 = LocalDate.parse(datetime, dtf);
//        LocalDate date2 = LocalDate.parse("2019-03-14", dtf);
//        Period period = Period.between(date1,date2);
//        System.out.println("相差年数 ： " + period.getYears());
//        System.out.println("相差月数 ： " + period.getMonths());
//        System.out.println("相差日数 ： " + period.getDays());
//
//        DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime date3 = LocalDateTime.parse("2019-01-29 00:00:00", dtfTime);
//        LocalDateTime date4 = LocalDateTime.parse("2019-03-14 00:00:00", dtfTime);
//        Duration duration = Duration.between(date3,date4);
//        System.out.println(date3 + " 与 " + date4 + " 间隔  " + "\n"
//                + " 天 :" + duration.toDays() + "\n"
//                + " 时 :" + duration.toHours() + "\n"
//                + " 分 :" + duration.toMinutes() + "\n"
//                + " 毫秒 :" + duration.toMillis() + "\n"
//                + " 纳秒 :" + duration.toNanos() + "\n"
//        );

//        String datetime =  "2018-01-13 21:27:30";
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime ldt = LocalDateTime.parse(datetime, dtf);
//        System.out.println(ldt);

        /**
         * 日期转成string格式
         */
//        LocalDateTime localDateTime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//        String executionNo = formatter.format(localDateTime);
//        System.out.println("executionNo："+executionNo);


    }

    @Test
    public void testLocalDateTime(){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime start = LocalDateTime.now();
        String date = df.format(start);
        System.out.println("日期->String 年月日："+date);

        //报错
//        LocalDateTime time = LocalDateTime.parse(date,df);
//        System.out.println("String->时间："+time);

        //通过
        String regStringTime = "2013-06-25 00:00:00";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.parse(regStringTime,dtf);
        System.out.println("String->时间："+time);
    }

    @Test
    public void testTTTT(){
        Integer month = 12;
        Integer day = 20;


    }
}
