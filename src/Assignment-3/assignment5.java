class assignment5 {

    // Instance fields
    String empName;
    double salary;

    // Static fields shared by all employees
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor
    assignment5(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;

        // Increment count whenever an object is created
        employeeCount++;
    }

    // Static method
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        // Creating three Employee objects
        assignment5 employee1 = new assignment5("Divya", 50000);
        assignment5 employee2 = new assignment5("Arjun", 45000);
        assignment5 employee3 = new assignment5("Priya", 55000);

        // Calling static method using class name
        assignment5.printCompanyInfo();
    }
}