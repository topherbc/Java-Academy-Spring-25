package com.pluralsight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class WorkingApp {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        displayMonthDayYear(now);
        displayYearMonthDay(now);
        System.out.println(getMonthNameDayYear(now));
        displayWeekdayMonthDayYear(now);
        displayTime(now);
        displayTimeWithDate(now);
    }

    /**
     * Displays the date in MM-dd-yyyy format
     * @param now The current date and time
     */
    static void displayMonthDayYear(LocalDateTime now) {
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println(now.format(format1));
    }

    /**
     * Displays the date in yyyy/MM/dd format
     * @param now The current date and time
     */
    static void displayYearMonthDay(LocalDateTime now) {
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(now.format(format2));
    }

    /**
     * Returns the date as a string in "Month DD, yyyy" format
     * @param now The current date and time
     * @return Formatted date string
     */
    static String getMonthNameDayYear(LocalDateTime now) {
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        return now.format(format3);
    }

    /**
     * Displays the date in "Weekday, Month d, yyyy" format
     * @param now The current date and time
     */
    static void displayWeekdayMonthDayYear(LocalDateTime now) {
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy");
        System.out.println(now.format(format4));
    }

    /**
     * Displays the time in hours:minutes format converted to GMT time zone
     * @param now The current date and time
     */
    static void displayTime(LocalDateTime now) {
        // Convert local time to GMT time zone
        ZonedDateTime gmtTime = now.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("GMT"));
        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("hh:mm a");
        System.out.println(gmtTime.format(format5));
    }

    /**
     * Displays the time and date with local time zone notation and zone ID
     * @param now The current date and time
     */
    static void displayTimeWithDate(LocalDateTime now) {
        // Get the local time zone ID
        ZoneId localZone = ZoneId.systemDefault();
        ZonedDateTime zonedTime = now.atZone(localZone);

        DateTimeFormatter format6 = DateTimeFormatter.ofPattern("H:mm 'on' dd MMM yyyy");
        System.out.println(zonedTime.format(format6));
    }
}