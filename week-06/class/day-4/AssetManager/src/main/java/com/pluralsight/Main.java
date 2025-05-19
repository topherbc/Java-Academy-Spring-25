package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<Asset>();

        assets.add(new House("new house", "2025", 50000, "1234 street rd.", 100, 100, 4));
        assets.add(new House("other house", "2020", 150000, "1234 road st.", 500, 300, 1));

        assets.add(new Vehicle("car", "2025", 8000, "toyota prius", 2008, 750000));
        assets.add(new Vehicle("crossover", "2024", 12000, "Honda CRF", 2012, 1000));

        for (Asset asset : assets) {
            //description
            //date
            //original cost
            //current value

            System.out.println(asset);

            String message = "";
            if (asset instanceof House) {
                House house = (House) asset;
                message = "House at " + house.getAddress();
            }
            else if (asset instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) asset;
                message = "Vehicle: " +
                        vehicle.getYear() + " " + vehicle.getMakeModel();
            }
            System.out.println(message);
        }

    }
}
