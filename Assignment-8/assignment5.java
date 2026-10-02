
import java.util.*;

class Student {
    private String name;
    private String department;
    private List<NotificationChannel> channels;

    Student(String name, String department,
            List<NotificationChannel> channels) {
        this.name = name;
        this.department = department;
        this.channels = channels;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public List<NotificationChannel> getChannels() {
        return channels;
    }
}

class Notice {
    private String title;
    private Set<String> departments;

    Notice(String title, Set<String> departments) {
        this.title = title;
        this.departments = departments;
    }

    public boolean isValid() {
        return title != null && !title.trim().isEmpty()
                && departments != null && !departments.isEmpty();
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getDepartments() {
        return departments;
    }
}

interface NotificationChannel {
    void send(String studentName, String message);
}

class EmailChannel implements NotificationChannel {
    public void send(String name, String message) {
        System.out.println("[Email → " + name + "] " + message);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(String name, String message) {
        System.out.println("[SMS → " + name + "] " + message);
    }
}

class AppChannel implements NotificationChannel {
    public void send(String name, String message) {
        System.out.println("[App → " + name + "] " + message);
    }
}

class NoticeBoard {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void postNotice(Notice notice) {
        if (!notice.isValid()) {
            System.out.println("Cannot post notice: "
                    + "At least one target department is required.");
            return;
        }

        System.out.println("Notice '" + notice.getTitle()
                + "' posted to "
                + String.join(", ", notice.getDepartments()) + ".");

        for (Student student : students) {
            if (notice.getDepartments().contains(
                    student.getDepartment())) {
                for (NotificationChannel channel : student.getChannels()) {
                    channel.send(student.getName(), notice.getTitle());
                }
            }
        }
    }
}

public class assignment5 {
    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        Student asha = new Student("Asha", "CSE",
                Arrays.asList(new EmailChannel(), new AppChannel()));

        Student ravi = new Student("Ravi", "ECE",
                Arrays.asList(new SmsChannel()));

        board.addStudent(asha);
        board.addStudent(ravi);

        board.postNotice(new Notice("Lab Closed Tomorrow",
                new LinkedHashSet<>(Arrays.asList("CSE"))));

        board.postNotice(new Notice("Fee Deadline Extended",
                new LinkedHashSet<>(Arrays.asList("CSE", "ECE"))));

        board.postNotice(new Notice("Sports Day",
                new LinkedHashSet<>()));
    }
}