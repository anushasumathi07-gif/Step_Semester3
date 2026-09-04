class class3 {

    String code;
    String title;
    int credits;
    int labCredits;

    // Constructor for courses with lab credits
    public class3(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Constructor for theory-only courses
    public class3(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    // Method to calculate total credits
    public int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {

        // Theory-only course
        class3 course1 = new class3(
                "21CSC201J",
                "Data Structures",
                4
        );

        // Course with lab credits
        class3 course2 = new class3(
                "21CSC205L",
                "DSA Lab",
                3,
                1
        );

        // Printing total credits
        System.out.println(course1.code + " total credits: "
                + course1.totalCredits());

        System.out.println(course2.code + " total credits: "
                + course2.totalCredits());
    }
}