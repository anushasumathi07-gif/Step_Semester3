class class5 {

    // Instance fields
    String name;
    double attendance;

    // Static fields shared by all objects
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor
    class5(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;

        // Increment whenever a Student object is created
        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {

        // Creating two objects
        class5 student1 = new class5("Ravi", 85.5);
        class5 student2 = new class5("Anitha", 90.0);

        // Calling static method through class name
        class5.printCollegeInfo();
    }
}