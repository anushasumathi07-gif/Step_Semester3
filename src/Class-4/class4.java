class class4 {

    // Static fields
    static String collegeName;
    static String academicYear;

    // Instance field
    String studentName;

    // Static block - runs only once
    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2026-2027";

        System.out.println("College info loaded");
    }

    // Constructor
    public class4(String studentName) {
        this.studentName = studentName;
    }

    public static void main(String[] args) {

        String[] names = {
            "Ravi",
            "Meera",
            "Karthik",
            "Divya",
            "Anitha"
        };

        // Create student objects using a loop
        for (int i = 0; i < names.length; i++) {

            class4 student = new class4(names[i]);

            System.out.println(
                "Student record created: " + student.studentName
            );
        }
    }
}