
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Student {
    private String name;

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

abstract class Assignment {
    private String title;
    private int maxMarks;
    private LocalDate dueDate;

    Assignment(String title, int maxMarks, LocalDate dueDate) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public abstract double applyPenalty(int marks, long lateDays);
}

class CodingAssignment extends Assignment {
    CodingAssignment(String title, int maxMarks, LocalDate dueDate) {
        super(title, maxMarks, dueDate);
    }

    public double applyPenalty(int marks, long lateDays) {
        return marks * Math.pow(0.90, lateDays);
    }
}

class WrittenAssignment extends Assignment {
    WrittenAssignment(String title, int maxMarks, LocalDate dueDate) {
        super(title, maxMarks, dueDate);
    }

    public double applyPenalty(int marks, long lateDays) {
        return marks * Math.pow(0.80, lateDays);
    }
}

class Submission {
    private Student student;
    private Assignment assignment;
    private LocalDate submissionDate;
    private String status;
    private double finalMarks;

    Submission(Student student, Assignment assignment,
               LocalDate submissionDate) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
        this.status = "Submitted";

        long lateDays = Math.max(0,
                ChronoUnit.DAYS.between(
                        assignment.getDueDate(), submissionDate));

        System.out.println(student.getName() + "'s submission for '"
                + assignment.getTitle() + "' received ("
                + (lateDays == 0 ? "on time" : lateDays + " days late")
                + "). Status: " + status);
    }

    public void grade(int marks) {
        if (!status.equals("Submitted")) {
            System.out.println("Cannot grade this submission.");
            return;
        }

        if (marks < 0 || marks > assignment.getMaxMarks()) {
            System.out.println("Invalid marks.");
            return;
        }

        long lateDays = Math.max(0,
                ChronoUnit.DAYS.between(
                        assignment.getDueDate(), submissionDate));

        finalMarks = assignment.applyPenalty(marks, lateDays);
        status = "Graded";

        System.out.printf("%s graded: %.0f/%d",
                student.getName(), finalMarks,
                assignment.getMaxMarks());

        if (lateDays > 0) {
            int penalty = assignment instanceof CodingAssignment ? 10 : 20;
            System.out.printf(" after %d%% late penalty",
                    (int) (lateDays * penalty));
        }

        System.out.println(". Status: " + status + ".");
    }

    public void resubmit(LocalDate newDate) {
        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: '"
                    + assignment.getTitle()
                    + "' has already been graded.");
        } else {
            submissionDate = newDate;
            System.out.println("Resubmission received.");
        }
    }
}

public class assignment2 {
    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Assignment coding = new CodingAssignment(
                "Linked List Lab", 50,
                LocalDate.of(2026, 3, 10));

        Assignment written = new WrittenAssignment(
                "Design Essay", 50,
                LocalDate.of(2026, 3, 12));

        Submission s1 = new Submission(
                asha, coding, LocalDate.of(2026, 3, 10));

        Submission s2 = new Submission(
                ravi, written, LocalDate.of(2026, 3, 14));

        s1.grade(45);
        s2.grade(40);

        s1.resubmit(LocalDate.of(2026, 3, 11));
    }
}