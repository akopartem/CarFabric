package xyz.akopartem.car;


import java.util.HashMap;
import java.util.Objects;

public class Car {
    private double speed = 0.0;
    private FuelType fuelType;
    private CarColor color;
    private Condition condition;
    private String brand;
    private String model;
    private String name = String.format("%s %s", brand, model);
    private HashMap<Integer, Boolean> doors = new HashMap<>();
    ;
    private HashMap<Character, Integer> position = new HashMap<>();

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

    public static Car creatCar(String brand, String model, CarColor color, FuelType fuelType, int doors) {
        return new Car(brand, model, color, fuelType, doors);
    }

    public boolean getDoorInfo(int n) {
        return this.doors.get(n);
    }

    public void openDoor(int... n) {
        for (int i : n) {
            if (i <= doors.size()) {
                doors.put(i, true);
            } else {
                return;
            }
        }
    }

    public void closeDoor(int... n) {
        for (int i : n) {
            if (i <= doors.size()) {
                doors.put(i, false);
            } else {
                return;
            }
        }
    }

    public HashMap getDoorsInfo() {
        return doors;
    }

    public void closeAllDoors() {
        for (int i = 0; i < this.doors.size(); i++) {
            doors.put(i + 1, false);
        }
    }

    public void openAllDoors() {
        for (int i = 0; i < this.doors.size(); i++) {
            doors.put(i + 1, true);
        }
    }

    public void move(int x, int y, int z) {
        position.put('x', position.get('x') + x);
        position.put('y', position.get('y') + y);
        position.put('z', position.get('z') + z);
    }

    public int getPosition(char c) {
        if (c == 'x' || c == 'y' || c == 'z') {
            return position.get(c);
        } else {
            throw new NullPointerException("Указанная координата не существует");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.speed, speed) == 0 && fuelType == car.fuelType && color == car.color && condition == car.condition && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(name, car.name) && Objects.equals(doors, car.doors) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed, fuelType, color, condition, brand, model, name, doors, position);
    }

    @Override
    public String toString() {
        return "Car {" +
                "speed: " + speed +
                ",\nfuelType: " + fuelType +
                ",\ncolor: " + color +
                ",\ncondition: " + condition +
                ", \nbrand: '" + brand + '\'' +
                ",\nmodel: '" + model + '\'' +
                ",\nname: '" + name + '\'' +
                ",\ndoors: " + doors +
                ",\nposition: " + position +
                '}';
    }
}

