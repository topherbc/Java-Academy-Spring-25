package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
//        String[] sesameStreetCharacters = {"Big Bird", "Elmo", "Cookie Monster", "Oscar"};

//        System.out.println(sesameStreetCharacters[2]);

//        sesameStreetCharacters[2] = "Grouch";

        ArrayList<String> sesameStreetCharacters = new ArrayList<String>();

        sesameStreetCharacters.add("Big Bird");
        sesameStreetCharacters.add("Toph Bird");
        sesameStreetCharacters.add("Oscar");
        sesameStreetCharacters.add("Bert");
        sesameStreetCharacters.add("Cookie Monster");
        sesameStreetCharacters.add("Rocky");
        sesameStreetCharacters.add("Count");

        System.out.println(sesameStreetCharacters.get(4));
        System.out.println(sesameStreetCharacters);

        sesameStreetCharacters.set(1, "Ernie");

        System.out.println(sesameStreetCharacters);

        Collections.sort(sesameStreetCharacters);
        Collections.fill(sesameStreetCharacters, "Big Bird");

        System.out.println(sesameStreetCharacters);

        sesameStreetCharacters.add("Zoey");
        sesameStreetCharacters.add("Mr. Beaker");

        sesameStreetCharacters.remove(6);

        System.out.println(sesameStreetCharacters);

        int x = 6;

        System.out.println(10 + x);

    }
}
