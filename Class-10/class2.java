import java.util.*;

interface Chargeable {
    void bookChargingBay();
}

class Vehicle {
    String passNumber;
    String owner;
    String type;
    int fee;

    Vehicle(String passNumber, String owner, String type) {
        this.passNumber = passNumber;
        this.owner = owner;
        this.type = type;

        if (type.equals("Bike") || type.equals("EBike")) {
            fee = 300;
        } else {
            fee = 1000;
        }
    }

    void displayPass() {
        System.out.println(passNumber + " (" + type + ") pass fee " + fee);
    }
}

class ElectricVehicle extends Vehicle implements Chargeable {

    ElectricVehicle(String passNumber, String owner, String type) {
        super(passNumber, owner, type);
    }

    public void bookChargingBay() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

public class class2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new HashMap<>();

        while (sc.hasNext()) {
            String operation = sc.next();

            if (operation.equals("PASS")) {
                String type = sc.next();
                String passNumber = sc.next();
                String owner = sc.next();

                Vehicle vehicle;

                if (type.equals("EBike") || type.equals("ECar")) {
                    vehicle = new ElectricVehicle(passNumber, owner, type);
                } else {
                    vehicle = new Vehicle(passNumber, owner, type);
                }

                vehicles.put(passNumber, vehicle);
                vehicle.displayPass();

            } else if (operation.equals("CHARGE")) {
                String passNumber = sc.next();

                Vehicle vehicle = vehicles.get(passNumber);

                if (vehicle == null) {
                    System.out.println("Vehicle not found");
                } else if (vehicle instanceof Chargeable) {
                    ((Chargeable) vehicle).bookChargingBay();
                } else {
                    System.out.println(passNumber + " rejected: charging unsupported");
                }
            }
        }

        sc.close();
    }
}