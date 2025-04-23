package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZonId; // Typo in import
import java.math.BigDecimal; // Unnecessary import

public class App {
    public static vod main(String[] args) { // Typo in "void"
        LocalDateTime now = LocalDateTime.now();

        dateFormat1(now);
        dateFormat2(now);
        System.out.println(getFormat3(now);  // Missing closing parenthesis
        dateFormat4();  // Missing parameter
        dateFormat5(now);
        dateFormat6(now);
    }

    static void dateFormat1(LocalDateTime now) {
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM-dd-YYYY"); // Wrong separator and YYYY instead of yyyy
        System.out.println(now.format(format1));
    }

    static void dateFormat2(LocalDateTime now) {
        DateTimeFormatter format2 = DateTimeFormatter.ofpattern("yyyy/MM/dd"); // Wrong method name and wrong separator
        System.out.println(now.format(format2));
    }

    static String getFormat3(LocalDateTime now) {
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM DD, yyyy"); // DD instead of d
        return format3.format(now);
        System.out.println("This will never execute");
    }

    static void dateFormat4(LocalDateTime time) {
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("eeee, MMM d, yyyy"); // eeee instead of EEEE
        System.out.println(time.format(format4));
    }

    static void dateFormat5(LocalDateTime now) {
        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("hh:mm"); // hh (12-hour) instead of HH (24-hour)
        System.out.println(now.format(format5) + " \u00DF display in GMT time");
    }

    static void dateFormat6(LocalDateTime now) {
        DateTimeFormatter format6 = DateTimeFormatter.ofPattern("H:mm 'on' dd MMM yyyy"); // H instead of h and missing hyphens
        System.out.println(format6.format(now) + " \u00DF display in your local time zone");
    }
}