class EmergencyAlert extends Thread {

    public EmergencyAlert() {
        setName("EmergencyAlert");
        setPriority(Thread.MAX_PRIORITY);
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(
                "Thread Name: " + getName()
                + " | Priority: " + getPriority()
                + " | Activity: Critical patient alert"
            );
        }
    }
}

class VitalMonitor extends Thread {

    public VitalMonitor() {
        setName("VitalMonitor");
        setPriority(Thread.NORM_PRIORITY);
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(
                "Thread Name: " + getName()
                + " | Priority: " + getPriority()
                + " | Activity: Checking vital signs"
            );
        }
    }
}

class ReportGenerator extends Thread {

    public ReportGenerator() {
        setName("ReportGenerator");
        setPriority(Thread.MIN_PRIORITY);
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(
                "Thread Name: " + getName()
                + " | Priority: " + getPriority()
                + " | Activity: Generating routine report"
            );
        }
    }
}

public class program1 {

    public static void main(String[] args) {

        EmergencyAlert emergency = new EmergencyAlert();
        VitalMonitor vital = new VitalMonitor();
        ReportGenerator report = new ReportGenerator();

        emergency.start();
        vital.start();
        report.start();
    }
}