
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

interface Room {
    int getRoomNumber();
    double calculatePrice(int days);
    String getCategory();
}

class StandardRoom implements Room {
    int roomNumber;

    StandardRoom(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double calculatePrice(int days) {
        return days * 100;
    }

    public String getCategory() {
        return "Standard Room";
    }
}

class DeluxeRoom implements Room {
    int roomNumber;

    DeluxeRoom(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double calculatePrice(int days) {
        return days * 200;
    }

    public String getCategory() {
        return "Deluxe Room";
    }
}

class Suite implements Room {
    int roomNumber;

    Suite(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double calculatePrice(int days) {
        return days * 350;
    }

    public String getCategory() {
        return "Suite";
    }
}

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Reservation {
    Customer customer;
    Room room;
    LocalDate startDate, endDate;
    LocalDate cancellationDeadline;
    boolean active = true;

    Reservation(Customer customer, Room room,
                LocalDate start, LocalDate end) {
        this.customer = customer;
        this.room = room;
        this.startDate = start;
        this.endDate = end;
        this.cancellationDeadline = start.minusDays(1);
    }

    boolean overlaps(LocalDate start, LocalDate end) {
        return active && start.isBefore(endDate)
                && end.isAfter(startDate);
    }

    void cancel(LocalDate today) {
        if (!active) {
            System.out.println("Reservation already cancelled.");
        } else if (today.isAfter(cancellationDeadline)) {
            System.out.println("Cancellation deadline has passed.");
        } else {
            active = false;
            System.out.println("Reservation for " + customer.name
                    + ", " + room.getCategory() + " "
                    + room.getRoomNumber() + " ("
                    + startDate + "-" + endDate
                    + ") cancelled successfully.");
        }
    }
}

class Hotel {
    List<Reservation> reservations = new ArrayList<>();

    boolean isAvailable(Room room, LocalDate start, LocalDate end) {
        if (!end.isAfter(start)) {
            return false;
        }

        for (Reservation r : reservations) {
            if (r.room.getRoomNumber() == room.getRoomNumber()
                    && r.room.getCategory().equals(room.getCategory())
                    && r.overlaps(start, end)) {
                return false;
            }
        }
        return true;
    }

    void checkAvailability(Room room, LocalDate start,
                           LocalDate end) {
        if (isAvailable(room, start, end)) {
            System.out.println(room.getCategory() + " "
                    + room.getRoomNumber() + " is available from "
                    + start + " to " + end + ".");
        } else {
            System.out.println(room.getCategory() + " "
                    + room.getRoomNumber() + " is not available from "
                    + start + " to " + end + ".");
        }
    }

    Reservation bookRoom(Customer customer, Room room,
                         LocalDate start, LocalDate end) {
        if (!isAvailable(room, start, end)) {
            System.out.println("Reservation failed for "
                    + customer.name + ".");
            return null;
        }

        int days = (int) (end.toEpochDay() - start.toEpochDay());

        Reservation reservation =
                new Reservation(customer, room, start, end);
        reservations.add(reservation);

        System.out.println("Reservation confirmed for "
                + customer.name + ", " + room.getCategory()
                + " " + room.getRoomNumber() + " ("
                + start + "-" + end + ").");
        System.out.println("Price: $"
                + room.calculatePrice(days));

        return reservation;
    }
}

public class class4 {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        Customer a = new Customer("Customer A");
        Customer b = new Customer("Customer B");
        Customer c = new Customer("Customer C");

        Room standard = new StandardRoom(101);
        Room deluxe = new DeluxeRoom(201);

        LocalDate start1 = LocalDate.of(2027, 1, 1);
        LocalDate end1 = LocalDate.of(2027, 1, 5);

        hotel.checkAvailability(standard, start1, end1);

        Reservation r1 = hotel.bookRoom(a, standard, start1, end1);

        hotel.bookRoom(b, standard,
                LocalDate.of(2027, 1, 3),
                LocalDate.of(2027, 1, 7));

        if (r1 != null) {
            r1.cancel(LocalDate.of(2026, 12, 20));
        }

        hotel.bookRoom(c, deluxe,
                LocalDate.of(2027, 2, 10),
                LocalDate.of(2027, 2, 12));
    }
}