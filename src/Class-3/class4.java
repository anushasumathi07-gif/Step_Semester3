class class4 {

    String name;
    int booksIssued;

    // Constructor
    class4(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {

        // Create one object
        class4 ravi = new class4("Ravi", 0);

        // duplicate points to the same object
        class4 duplicate = ravi;

        // Change value through duplicate
        duplicate.booksIssued = 3;

        // Create a separate object with identical values
        class4 separate = new class4("Ravi", 3);

        // Print values
        System.out.println("Ravi's booksIssued (via first variable): "
                + ravi.booksIssued);

        System.out.println("duplicate == ravi: "
                + (duplicate == ravi));

        System.out.println("separate == ravi: "
                + (separate == ravi));
    }
}