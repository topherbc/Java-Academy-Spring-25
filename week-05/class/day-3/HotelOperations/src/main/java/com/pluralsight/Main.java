package com.pluralsight;

public class Main {
    public static void main(String[] args) {
        Reservation r = new Reservation("king", 10, true);

        Employee jameir = new Employee(123, "Jameir Eubanks", "Polymer Department", 900.00);

        Employee toph = new Employee(124, "Toph", "Strapping Yard", 2.50);

        toph.punchIn(0.0);
        toph.punchOut(23.99);
        System.out.println(toph.getTotalPay());

        int x = 0;

        jameir.punchIn(7.0);
        jameir.punchOut(15.0);

        System.out.println(jameir.getTotalPay());

        RubixCube myCube = new RubixCube("square", 9);

        myCube.getShape();
    }
}
