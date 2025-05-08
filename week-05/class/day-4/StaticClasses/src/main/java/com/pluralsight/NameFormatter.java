package com.pluralsight;

public class NameFormatter {

    //Constructor
    private NameFormatter() {}

    //LastName, Prefix FirstName MiddleName, Suffix

    //Overloaded format method
    public static String format(String firstName,
                                String lastName) {
        return lastName + ", " + firstName;
    }

    //LastName, Prefix FirstName MiddleName, Suffix
    //Overloaded format method
    public static String format(String prefix,
                                String firstName,
                                String middleName,
                                String lastName,
                                String suffix) {

        return lastName + ", " + prefix + " " + firstName + " " + middleName + ", " + suffix;
    }


    //Overloaded format method
    public static String format(String fullName) {
        return "";
    }


}
