class assignment4 {

    String studentName;
    int seatNumber;

    // Constructor
    assignment4(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {

        // Create one Hall Ticket object
        assignment4 priya = new assignment4("Priya", 0);

        // copy points to the same object
        assignment4 copy = priya;

        // Change seat number through copy
        copy.seatNumber = 45;

        // Create a separate object with identical values
        assignment4 separate = new assignment4("Priya", 45);

        // Print seat number using first variable
        System.out.println("Priya's seatNumber (via first variable): "
                + priya.seatNumber);

        // Compare object references
        System.out.println("copy == priya: " + (copy == priya));

        System.out.println("separate == priya: "
                + (separate == priya));
    }
}
