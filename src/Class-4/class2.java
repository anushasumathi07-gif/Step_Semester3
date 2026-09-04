class class2 {

    String empId;
    double salary;

    // Constructor using this keyword
    public class2(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    // Method using this keyword
    public void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    public static void main(String[] args) {

        // Array of employees
        class2[] employees = {
            new class2("E-101", 40000),
            new class2("E-102", 55000),
            new class2("E-103", 62000),
            new class2("E-104", 48000)
        };

        // Apply the same bonus to every employee
        for (int i = 0; i < employees.length; i++) {

            employees[i].raiseSalary(5000);

            System.out.println(
                employees[i].empId
                + " | Final Salary: Rs "
                + employees[i].salary
            );
        }
    }
}