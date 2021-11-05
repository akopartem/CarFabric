package xyz.akopartem.car;

import java.util.Arrays;

/**
 * @hidden
 */
public class Main {

    public static void main(String[] args) {
        Car c = Car.creatCar("m", "2", CarColor.WHITE, FuelType.GASOLINE, 5);
        c.closeDoor();
        c.closeAllDoors();
        c.getSide();
    }
}
