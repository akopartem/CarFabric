package xyz.akopartem.car;

import java.util.HashMap;
import java.util.Objects;

/**
 * The base class of the car.
 * @version 1.0.0
 * @author akopartem
 * @since 1.0.0
 */
public class Car {
    /**
     * Side.
     */
    Side side = Side.NORTH;
    /**
     * Speed.
     */
    private double speed = 0.0;
    /**
     * Fuel type.
     */
    private final FuelType fuelType;
    /**
     * Color.
     */
    private CarColor color;
    /**
     * Brand.
     */
    final private String brand;
    /**
     * Model.
     */
    final private String model;
    /**
     * Condition of the doors .
     */
    private final HashMap<Integer, Boolean> doors = new HashMap<>();
    /**
     * Position.
     */
    private final HashMap<Character, Integer> position = new HashMap<>();

    /**
     * Creates a car object.
     * @param brand Brand
     * @param model Model
     * @param color Color
     * @param fuelType Fuel type
     * @param doors Number of doors
     */
    private Car(String brand, String model, CarColor color, FuelType fuelType, int doors) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.fuelType = fuelType;
        this.position.put('x', 0);
        this.position.put('y', 0);
        this.position.put('z', 0);
        for (int i = 1; i <= doors; i++) {
            this.doors.put(i, false);
        }
    }

    /**
     * Changes the speed of the car.
     * @param speed Speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * Changes the direction of the car.
     * @param s Side
     */
    public void rotate(Side s) {
        side = s;
    }

    /**
     * Returns the direction of the car at the time of the call.
     * @return Current direction of the car
     */
    public Side getSide() {
        return side;
    }

    /**
     * Returns the car brand.
     * @return Car brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Returns the car model.
     * @return Car model
     */
    public String getModel() {
        return model;
    }

    /**
     * Changes the color of the car.
     * @param color New color
     */
    public void editColor(CarColor color) {
        this.color = color;
    }

    /**
     * Creates and returns a car object.
     * @param brand Brand
     * @param model Model
     * @param color Color
     * @param fuelType Fuel type
     * @param doors Number of doors
     * @return Car object
     * @see #Car(String, String, CarColor, FuelType, int) 
     */
    public static Car creatCar(String brand, String model, CarColor color, FuelType fuelType, int doors) {
        return new Car(brand, model, color, fuelType, doors);
    }

    /**
     * Returns the status of the specified door.
     * @param n Door number
     * @return Door condition
     */
    public boolean getDoorInfo(int n) {
        return this.doors.get(n);
    }

    /**
     * Opens the door.
     * @param n Door number.
     */
    public void openDoor(int... n) {
        for (int i : n) {
            if (i <= doors.size()) {
                doors.put(i, true);
            } else {
                throw new NullPointerException("Указанная дверь не существует");
            }
        }
    }

    /**
     * Closes the door.
     * @param n Door number.
     */
    public void closeDoor(int... n) {
        for (int i : n) {
            if (i <= doors.size()) {
                doors.put(i, false);
            } else {
                throw new NullPointerException("Указанная дверь не существует");
            }
        }
    }

    /**
     * Returns the status of all doors.
     * @return Состояние всех дверей
     */
    public HashMap<Integer, Boolean> getDoorsInfo() {
        return new HashMap<>(doors);
    }

    /**
     * Closes all the doors.
     * @see #closeDoor(int...)
     */
    public void closeAllDoors() {
        for (int i = 0; i < this.doors.size(); i++) {
            closeDoor(i);
        }
    }

    /**
     * Открывает все двери.
     * @see #openDoor(int...)
     */
    public void openAllDoors() {
        for (int i = 0; i < this.doors.size(); i++) {
            openDoor(i);
        }
    }

    /**
     * Starts the process of driving the car for the specified number of hours.
     * @param hrs Number of hours
     */
    public void move(int hrs) {
        switch (side) {
            case UP -> position.put('y', position.get('y') + (int) speed * hrs);
            case DOWN -> position.put('y', position.get('y') - (int) speed * hrs);
            case NORTH -> position.put('z', position.get('z') + (int) speed * hrs);
            case SOUTH -> position.put('z', position.get('z') - (int) speed * hrs);
            case WEST -> position.put('x', position.get('x') + (int) speed * hrs);
            case EAST -> position.put('x', position.get('x') - (int) speed * hrs);
        }
    }

    /**
     * Returns the current value along the specified axis.
     * @param c Axis on the plane
     * @return Current position on the axis
     */
    public int getPosition(char c) {
        if (c == 'x' || c == 'y' || c == 'z') {
            return position.get(c);
        } else {
            throw new NullPointerException("Указанная координата не существует");
        }
    }

    /**
     * Compares the current object with the specified one.
     * @param o Car object
     * @return Are the objects identical?
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.speed, speed) == 0 && fuelType == car.fuelType && color == car.color && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(doors, car.doors) && Objects.equals(position, car.position);
    }

    /**
     * Returns the hash code of the object.
     * @return hash code of the object
     */
    @Override
    public int hashCode() {
        return Objects.hash(speed, fuelType, color, brand, model, doors, position);
    }

    /**
     * Converts the object fields to a string.
     * @return Object Fields
     */
    @Override
    public String toString() {
        return "car: {" +
                "speed: " + speed +
                ",\nfuelType: " + fuelType +
                ",\ncolor: " + color +
                ", \nbrand: '" + brand + '\'' +
                ",\nmodel: '" + model + '\'' +
                ",\ndoors: " + doors +
                ",\nposition: " + position +
                "\n}";
    }
}

