class assignment1 {

    String title;
    String author;
    int copiesAvailable;

    // Constructor
    assignment1(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    // Instance method
    void printEntry() {
        System.out.println(title + " by " + author + " - "
                + copiesAvailable + " copies available");
    }

    public static void main(String[] args) {

        // Creating four objects
        assignment1 book1 = new assignment1(
                "Clean Code", "Robert C. Martin", 3);

        assignment1 book2 = new assignment1(
                "Effective Java", "Joshua Bloch", 5);

        assignment1 book3 = new assignment1(
                "Refactoring", "Martin Fowler", 0);

        assignment1 book4 = new assignment1(
                "Design Patterns", "GoF", 2);

        // Array of objects
        assignment1[] books = {book1, book2, book3, book4};

        // Printing each book
        for (assignment1 book : books) {
            book.printEntry();
        }
    }
}