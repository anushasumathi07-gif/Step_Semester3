
import java.time.LocalTime;
import java.util.*;

class Customer {
    private String name;

    Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

abstract class Seat {
    private String seatId;

    Seat(String seatId) {
        this.seatId = seatId;
    }

    public String getSeatId() {
        return seatId;
    }

    public abstract double getPrice();
}

class RegularSeat extends Seat {
    RegularSeat(String id) {
        super(id);
    }

    public double getPrice() {
        return 150;
    }
}

class PremiumSeat extends Seat {
    PremiumSeat(String id) {
        super(id);
    }

    public double getPrice() {
        return 250;
    }
}

class ReclinerSeat extends Seat {
    ReclinerSeat(String id) {
        super(id);
    }

    public double getPrice() {
        return 400;
    }
}

class Show {
    private String name;
    private LocalTime startTime;
    private Map<String, Seat> seats = new HashMap<>();
    private Set<String> bookedSeats = new HashSet<>();

    Show(String name, LocalTime startTime) {
        this.name = name;
        this.startTime = startTime;
    }

    public void addSeat(Seat seat) {
        seats.put(seat.getSeatId(), seat);
    }

    public boolean isAvailable(String id) {
        return seats.containsKey(id) && !bookedSeats.contains(id);
    }

    public boolean bookSeats(List<String> ids) {
        if (ids.size() > 6 || ids.isEmpty()) {
            System.out.println("Booking must contain 1 to 6 seats.");
            return false;
        }

        for (String id : ids) {
            if (!isAvailable(id)) {
                System.out.println("Seat " + id
                        + " is already booked for this show.");
                return false;
            }
        }

        bookedSeats.addAll(ids);
        return true;
    }

    public void releaseSeats(List<Seat> seatsToRelease) {
        for (Seat seat : seatsToRelease) {
            bookedSeats.remove(seat.getSeatId());
        }
    }

    public Seat getSeat(String id) {
        return seats.get(id);
    }

    public boolean hasStarted() {
        return !LocalTime.now().isBefore(startTime);
    }
}

class Booking {
    private Customer customer;
    private Show show;
    private List<Seat> seats;
    private boolean cancelled = false;

    Booking(Customer customer, Show show, List<String> ids) {
        this.customer = customer;
        this.show = show;
        this.seats = new ArrayList<>();

        if (show.hasStarted()) {
            System.out.println("Cannot book: show has already started.");
            return;
        }

        if (ids.size() > 6 || ids.isEmpty()) {
            System.out.println("Booking must contain 1 to 6 seats.");
            return;
        }

        for (String id : ids) {
            Seat seat = show.getSeat(id);
            if (seat == null) {
                System.out.println("Seat " + id + " does not exist.");
                return;
            }
        }

        if (show.bookSeats(ids)) {
            for (String id : ids) {
                seats.add(show.getSeat(id));
            }

            System.out.println("Booking confirmed for "
                    + customer.getName() + ": "
                    + String.join(", ", ids) + ".");
            System.out.printf("Total: ₹%.2f%n", getTotal());
        }
    }

    public double getTotal() {
        double total = 0;
        for (Seat seat : seats) {
            total += seat.getPrice();
        }
        return total;
    }

    public void cancel() {
        if (cancelled || seats.isEmpty()) {
            System.out.println("Booking cannot be cancelled.");
            return;
        }

        if (show.hasStarted()) {
            System.out.println("Cannot cancel after the show starts.");
            return;
        }

        show.releaseSeats(seats);
        cancelled = true;

        System.out.println(customer.getName()
                + "'s booking cancelled. Seats "
                + getSeatIds() + " released.");
    }

    private String getSeatIds() {
        List<String> ids = new ArrayList<>();
        for (Seat seat : seats) {
            ids.add(seat.getSeatId());
        }
        return String.join(", ", ids);
    }
}

public class assignment3 {
    public static void main(String[] args) {
        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        Show show = new Show("7 PM Movie", LocalTime.of(19, 0));

        show.addSeat(new RegularSeat("A1"));
        show.addSeat(new RegularSeat("A2"));
        show.addSeat(new PremiumSeat("F5"));
        show.addSeat(new ReclinerSeat("R1"));

        Booking b1 = new Booking(
                asha, show, Arrays.asList("A1", "A2", "F5"));

        Booking b2 = new Booking(
                ravi, show, Arrays.asList("A2"));

        Booking b3 = new Booking(
                ravi, show, Arrays.asList("R1"));

        b1.cancel();

        Booking b4 = new Booking(
                neha, show, Arrays.asList("A2"));
    }
}