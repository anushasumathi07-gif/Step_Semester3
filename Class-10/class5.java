

class Staff {
    String name;
    String type;
    int pay;

    Staff(String name, String type, int pay) {
        this.name = name;
        this.type = type;
        this.pay = pay;
    }

    public String toString() {
        return "Payslip[name=" + name + ", type=" + type
                + ", pay=" + pay + "]";
    }
}

class FullTime extends Staff {
    FullTime(String name, int salary) {
        super(name, "FullTime", salary);
    }
}

class PartTime extends Staff {
    PartTime(String name, int hours, int rate) {
        super(name, "PartTime", hours * rate);
    }
}

class Intern extends Staff {
    Intern(String name, int stipend) {
        super(name, "Intern", stipend);
    }
}

public class class5 {
    public static void main(String[] args) {
        Staff[] staff = {
            new FullTime("Asha", 50000),
            new PartTime("Ravi", 80, 300),
            new Intern("Neha", 15000)
        };

        int total = 0;
        int topper = 0;

        for (int i = 0; i < staff.length; i++) {
            System.out.println(staff[i]);
            total += staff[i].pay;

            if (staff[i].pay > staff[topper].pay) {
                topper = i;
            }
        }

        System.out.println("Total " + total);
        System.out.println("top earner " + staff[topper].name);
    }
}
