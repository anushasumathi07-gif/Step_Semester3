public class assignment3 {


public static void main(String[] args) {

    BookInventory b = new BookInventory(3);

    // Check out all 3 copies
    b.checkOut();
    b.checkOut();
    b.checkOut();

    // 4th checkout is rejected
    b.checkOut();

    System.out.println(b.getCopiesAvailable());

    // Check in all 3 copies
    b.checkIn();
    b.checkIn();
    b.checkIn();

    // 4th check-in is rejected
    b.checkIn();

    System.out.println(b.getCopiesAvailable());
}

}

class BookInventory {


private int copiesTotal;
private int copiesAvailable;

BookInventory(int copiesTotal) {

    if (copiesTotal <= 0) {
        throw new IllegalArgumentException(
            "Copies total must be greater than 0"
        );
    }

    this.copiesTotal = copiesTotal;
    this.copiesAvailable = copiesTotal;
}


void checkOut() {

    // Reject if no copies are available
    if (copiesAvailable > 0) {
        copiesAvailable--;
    }
}


void checkIn() {

    // Reject if inventory is already full
    if (copiesAvailable < copiesTotal) {
        copiesAvailable++;
    }
}


int getCopiesAvailable() {
    return copiesAvailable;
}


}
