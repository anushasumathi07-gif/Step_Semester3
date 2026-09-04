class assignment3 {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employees
    public assignment3(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for interns
    public assignment3(String empId, String empName) {

        // Calls the 3-argument constructor
        this(empId, empName, 0);

        // Set intern status to true
        this.isIntern = true;
    }

    // Method to print employee details
    public void printProfile() {
        System.out.println(empId + " | " + empName
                + " | Rs " + salary
                + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {

        // Permanent employee
        assignment3 employee1 =
                new assignment3("E-101", "Divya", 65000);

        // Intern employee
        assignment3 employee2 =
                new assignment3("E-102", "Arjun");

        employee1.printProfile();
        employee2.printProfile();
    }
}