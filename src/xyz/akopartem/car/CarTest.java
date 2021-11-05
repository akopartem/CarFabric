package xyz.akopartem.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    Car c = Car.creatCar("BMW", "X5", CarColor.WHITE, FuelType.ELECTRICITY, 4);

    @org.junit.jupiter.api.Test
    void creatCar() {
        assertEquals(Car.creatCar("BMW", "X5", CarColor.WHITE, FuelType.ELECTRICITY, 4), c);
    }

    @org.junit.jupiter.api.Test
    void getDoorInfo() {
        assertEquals(false, c.getDoorInfo(3));
    }

    @org.junit.jupiter.api.Test
    void getDoorsInfo() {
        assertEquals(false, c.getDoorsInfo().get(1));
        assertEquals(false, c.getDoorsInfo().get(2));
        assertEquals(false, c.getDoorsInfo().get(3));
        assertEquals(false, c.getDoorsInfo().get(4));
    }

    @org.junit.jupiter.api.Test
    void openDoor() {
        c.openDoor(2, 4);
        assertEquals(true, c.getDoorsInfo().get(2));
        assertEquals(true, c.getDoorsInfo().get(4));
    }

    @org.junit.jupiter.api.Test
    void closeDoor() {
        c.closeDoor(2, 4);
        assertEquals(false, c.getDoorsInfo().get(2));
        assertEquals(false, c.getDoorsInfo().get(4));
    }

    @org.junit.jupiter.api.Test
    void openAllDoors() {
        c.openAllDoors();
        for (int i = 0; i < c.getDoorsInfo().size(); i++) {
            assertEquals(true, c.getDoorInfo(i + 1));
        }
    }

    @org.junit.jupiter.api.Test
    void closeAllDoors() {
        c.closeAllDoors();
        for (int i = 0; i < c.getDoorsInfo().size(); i++) {
            assertEquals(false, c.getDoorInfo(i + 1));
        }
    }

    @org.junit.jupiter.api.Test
    void getPosition() {

    }

    @org.junit.jupiter.api.Test
    void move() {
        int x = (int) Math.random() * 100;
        int y = (int) Math.random() * 100;
        int z = (int) Math.random() * 100;
        c.move(x, y, z);
        int nx = c.getPosition('x');
        int ny = c.getPosition('y');
        int nz = c.getPosition('z');
        assertEquals(x, nx);
        assertEquals(y, ny);
        assertEquals(z, nz);
    }


}