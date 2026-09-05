public class class5 {


public static String processNightlySettlement(BookingReceipt[] receipts) {

    int processed = 0;
    int nullSkipped = 0;
    int group = 0;
    int individual = 0;

    for (BookingReceipt receipt : receipts) {

        if (receipt == null) {
            nullSkipped++;
        } else if (receipt instanceof GroupBookingReceipt) {
            processed++;
            group++;
        } else {
            processed++;
            individual++;
        }
    }

    return processed + " processed | " +
           nullSkipped + " null skipped | " +
           group + " group | " +
           individual + " individual";
}

public static void main(String[] args) {

    BookingReceipt b = new BookingReceipt(
            "CH-1001",
            new String[]{"A1", "A2"}
    );

    // Testing defensive copy
    String[] seats = b.getSeatNumbers();
    seats[0] = "X";

    System.out.println(b.getSeatNumbers()[0]);

    // Creating a new updated receipt
    BookingReceipt updated = b.withUpdatedSeat(1, "A3");

    System.out.println(
            java.util.Arrays.toString(b.getSeatNumbers())
    );

    System.out.println(
            java.util.Arrays.toString(updated.getSeatNumbers())
    );

    // Nightly settlement
    BookingReceipt[] receipts = {
            new GroupBookingReceipt(
                    "CH-2002",
                    new String[]{"B1", "B2"},
                    2
            ),
            null,
            new BookingReceipt(
                    "CH-3003",
                    new String[]{"C1"}
            )
    };

    System.out.println(processNightlySettlement(receipts));
}


}

class BookingReceipt {


private final String bookingId;
private final String[] seatNumbers;

public BookingReceipt(String bookingId, String[] seatNumbers) {

    this.bookingId = bookingId;

    // Defensive copy in constructor
    this.seatNumbers = seatNumbers.clone();
}

public String[] getSeatNumbers() {

    // Defensive copy in getter
    return seatNumbers.clone();
}

public BookingReceipt withUpdatedSeat(
        int index,
        String newSeat) {

    // Copy existing array
    String[] updatedSeats = seatNumbers.clone();

    // Update the copy
    updatedSeats[index] = newSeat;

    // Return a brand-new object
    return new BookingReceipt(bookingId, updatedSeats);
}


}

class GroupBookingReceipt extends BookingReceipt {


private final int groupSize;

public GroupBookingReceipt(
        String bookingId,
        String[] seatNumbers,
        int groupSize) {

    super(bookingId, seatNumbers);
    this.groupSize = groupSize;
}


}
