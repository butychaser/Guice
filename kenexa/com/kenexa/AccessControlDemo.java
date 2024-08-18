package com.kenexa;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class AccessControlDemo {
    private int a = 0;
    public static void main(String[] args){
        LocalDateTime d = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = d.format(myFormatObj);
        System.out.println("After formatting: " + formattedDate);
        System.out.println(d.toLocalTime());
    }
}
