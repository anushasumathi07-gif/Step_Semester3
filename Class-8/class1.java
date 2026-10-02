abstract class Vehicle {
    int vehicleId;
    boolean available = true;

    Vehicle(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    abstract double calculateRentalCharge(int days);
}

class Sedan extends Vehicle {
    Sedan(int id) {
        super(id);
    }

    double calculateRentalCharge(int days) {
        return days * 50;
    }
}

class SUV extends Vehicle {
    SUV(int id) {
        super(id);
    }

    double calculateRentalCharge(int days) {
        return days * 80;
    }
}

class Truck extends Vehicle {
    Truck(int id) {
        super(id);
    }

    double calculateRentalCharge(int days) {
        return days * 120;
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Rental {
    Vehicle vehicle;
    Customer customer;
    int days;
    boolean active = true;

    Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
    }

    void returnVehicle() {
        vehicle.available = true;
        active = false;
    }
}

class RentalSystem {
    Rental rentVehicle(Vehicle vehicle, Customer customer, int days) {
        if (days <= 0) {
            System.out.println("Invalid rental days");
            return null;
        }

        if (!vehicle.available) {
            System.out.println("Vehicle not available");
            return null;
        }

        vehicle.available = false;
        Rental rental = new Rental(vehicle, customer, days);

        System.out.println("Vehicle rented successfully");
        System.out.println("Customer: " + customer.name);
        System.out.println("Rental charge: Rs. "
                + vehicle.calculateRentalCharge(days));

        return rental;
    }

    void returnVehicle(Rental rental, Customer customer) {
        if (rental == null || !rental.active
                || !rental.customer.name.equals(customer.name)) {
            System.out.println("Invalid return");
            return;
        }

        rental.returnVehicle();
        System.out.println("Vehicle returned successfully");
    }
}

public class class1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Sedan(101);
        Customer customer = new Customer("Anu");
        RentalSystem system = new RentalSystem();

        Rental rental = system.rentVehicle(vehicle, customer, 3);
        system.returnVehicle(rental, customer);
    }
}