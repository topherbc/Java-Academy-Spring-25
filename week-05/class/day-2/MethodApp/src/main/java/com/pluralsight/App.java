package com.pluralsight;

public class App {
    public static void main(String[] args) {
        int coolNumber1 = 1;
        int coolNumber2 = 4;

        int output = add2Ys(10, 1);

        String response = sendMessage("LEarning is kinda Hard");

        System.out.println("RESPONSE: " + response);

//        System.out.println(concat("Jameir", "Eubanks"));

        System.out.println(microwave("hot dog", 20));

        concat(1.0, 1.0);

    }

    public static String microwave(String food, int time) {
        if (time > 1) {
            return "COOKED" + food;
        } else {
            return "UNCOOKED, REHEAT" + food;
        }
    }

    public static String microwave(String food, String food2, int time) {
        if (time > 1) {
            return "COOKED" + food;
        } else {
            return "UNCOOKED, REHEAT" + food;
        }
    }

    public static int add2Ys(int x, int y) {
        return x + y + y;
    }

    public static String concat(String x, String y) {
        return x + " " + y;
    }

    public static String concat(double x, double y) {
        return x + " " + y;
    }

    public static String sendMessage(String message) {
        System.out.println(message);
        return "delivered";
    }

}
