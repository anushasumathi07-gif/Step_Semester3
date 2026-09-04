class assignment4 {

    // Static fields
    static String libraryName;
    static String validUntil;

    // Instance field
    String studentName;

    // Static block - runs only once
    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";

        System.out.println("Library info loaded");
    }

    // Constructor
    public assignment4(String studentName) {
        this.studentName = studentName;
    }

    public static void main(String[] args) {

        String[] names = {
            "Ananya",
            "Rohan",
            "Priya",
            "Arjun",
            "Sneha"
        };

        // Create MembershipCard objects
        for (int i = 0; i < names.length; i++) {

            assignment4 card = new assignment4(names[i]);

            System.out.println(
                "Membership card issued: " + card.studentName
            );
        }
    }
}
