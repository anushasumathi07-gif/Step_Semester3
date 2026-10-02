
import java.time.LocalDate;

interface LeavePolicy {
    boolean isLeaveAllowed(int days);
}

class FullTimeEmployee implements LeavePolicy {
    public boolean isLeaveAllowed(int days) {
        return days <= 20;
    }
}

class PartTimeEmployee implements LeavePolicy {
    public boolean isLeaveAllowed(int days) {
        return days <= 5;
    }
}

class Contractor implements LeavePolicy {
    public boolean isLeaveAllowed(int days) {
        return days <= 2;
    }
}

class Employee {
    String name;
    LeavePolicy policy;

    Employee(String name, LeavePolicy policy) {
        this.name = name;
        this.policy = policy;
    }
}

class LeaveRequest {
    private Employee employee;
    private LocalDate startDate, endDate;
    private String status = "Pending";

    LeaveRequest(Employee employee, LocalDate start,
                 LocalDate end) {
        this.employee = employee;
        this.startDate = start;
        this.endDate = end;
    }

    int getDays() {
        return (int) (endDate.toEpochDay()
                - startDate.toEpochDay() + 1);
    }

    String getStatus() {
        return status;
    }

    void review(String reviewer, boolean approve) {
        if (!status.equals("Pending")) {
            System.out.println("Request already reviewed");
            return;
        }

        if (approve) {
            status = "Approved";
            System.out.println(employee.name
                    + "'s leave request (" + startDate
                    + "-" + endDate + ") approved by "
                    + reviewer + ".");
        } else {
            status = "Rejected";
            System.out.println(employee.name
                    + "'s leave request (" + startDate
                    + "-" + endDate + ") rejected by "
                    + reviewer + ".");
        }
    }

    void changeStatus(String newStatus) {
        if (!status.equals("Pending")
                || newStatus.equals("Pending")) {
            System.out.println("Cannot change leave request "
                    + "status from " + status + " to "
                    + newStatus + ".");
        } else {
            status = newStatus;
        }
    }
}

class LeaveManager {
    void submitRequest(Employee employee,
                       LocalDate start, LocalDate end) {
        if (end.isBefore(start)) {
            System.out.println("Invalid leave dates");
            return;
        }

        int days = (int) (end.toEpochDay()
                - start.toEpochDay() + 1);

        if (!employee.policy.isLeaveAllowed(days)) {
            System.out.println("Leave policy limit exceeded");
            return;
        }

        LeaveRequest request =
                new LeaveRequest(employee, start, end);

        System.out.println("Leave request submitted for "
                + employee.name + " (" + start + "-"
                + end + "). Status: " + request.getStatus());

        if (employee.name.equals("John")) {
            request.review("Alice", true);
        } else {
            request.review("Bob", false);
        }

        System.out.println("Status: " + request.getStatus());

        if (employee.name.equals("John")) {
            request.changeStatus("Pending");
        }
    }
}

public class class2 {
    public static void main(String[] args) {
        LeaveManager manager = new LeaveManager();

        Employee john = new Employee("John",
                new FullTimeEmployee());
        Employee jane = new Employee("Jane",
                new PartTimeEmployee());

        manager.submitRequest(john,
                LocalDate.of(2027, 1, 1),
                LocalDate.of(2027, 1, 5));

        manager.submitRequest(jane,
                LocalDate.of(2027, 2, 10),
                LocalDate.of(2027, 2, 11));
    }
}