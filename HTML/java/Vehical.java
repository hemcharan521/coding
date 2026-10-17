// Base class
class vehicleBase {
    String brand;
    int speed;

    // Constructor for Vehicle
    vehicleBase(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // Method to display Vehicle info
    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
    }
}

// Derived class (single inheritance)
class Car extends vehicleBase {
    int doors;
    String fuelType;

    // Constructor for Car calls Vehicle's constructor
    Car(String brand, int speed, int doors, String fuelType) {
        super(brand, speed); // calls Vehicle constructor
        this.doors = doors;
        this.fuelType = fuelType;
    }

    // Overriding display method
    @Override
    void display() {
       super.display(); // calls parent display
        System.out.println("Doors: " + doors);
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Derived class (multilevel inheritance)
class ElectricCar extends Car {
    int batteryCapacity;

    // Constructor for ElectricCar calls Car constructor
    ElectricCar(String brand, int speed, int doors, String fuelType, int batteryCapacity) {
        super(brand, speed, doors, fuelType); // calls Car constructor
        this.batteryCapacity = batteryCapacity;
    }

    // Overriding display again
    @Override
    void display() {
        super.display(); // calls Car display
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println(speed);//shows that we can use one display and print all at once just for fun we use this many display 
        //of course only possible if the variables are not private
    }
}

// Driver class
public class Vehical {
    public static void main(String[] args) {
        ElectricCar e1 = new ElectricCar("Tesla", 200, 4, "Electric", 100);
        e1.display();
    }
}
