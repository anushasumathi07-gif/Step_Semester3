
interface WashType {
    int getDuration();
    double getCharge();
    String getName();
}

class QuickWash implements WashType {
    public int getDuration() {
        return 30;
    }

    public double getCharge() {
        return 20;
    }

    public String getName() {
        return "Quick";
    }
}

class NormalWash implements WashType {
    public int getDuration() {
        return 45;
    }

    public double getCharge() {
        return 30;
    }

    public String getName() {
        return "Normal";
    }
}

class HeavyWash implements WashType {
    public int getDuration() {
        return 60;
    }

    public double getCharge() {
        return 45;
    }

    public String getName() {
        return "Heavy";
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class WashCycle {
    Student student;
    WashingMachine machine;
    WashType washType;

    WashCycle(Student student, WashingMachine machine,
              WashType washType) {
        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }
}

class WashingMachine {
    private String machineId;
    private WashCycle currentCycle;

    WashingMachine(String machineId) {
        this.machineId = machineId;
    }

    void startWash(Student student, WashType washType) {
        if (currentCycle != null) {
            System.out.println("Machine " + machineId
                    + " is currently busy.");
            return;
        }

        currentCycle = new WashCycle(student, this, washType);

        System.out.println(washType.getName() + " wash started on "
                + machineId + " for " + student.name + " ("
                + washType.getDuration() + " min).");
        System.out.printf("Charge: ₹%.2f%n", washType.getCharge());
    }

    void completeCycle() {
        if (currentCycle == null) {
            System.out.println(machineId + " is already free.");
            return;
        }

        currentCycle = null;
        System.out.println(machineId + " cycle completed.");
        System.out.println(machineId + " is now free.");
    }
}

public class assignment1 {
    public static void main(String[] args) {
        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        m1.startWash(asha, new QuickWash());
        m1.startWash(ravi, new HeavyWash());
        m2.startWash(ravi, new HeavyWash());
        m1.completeCycle();
        m1.startWash(neha, new NormalWash());
    }
}