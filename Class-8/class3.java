
import java.util.*;

abstract class Question {
    int questionId;
    String text;
    int points;

    Question(int id, String text, int points) {
        this.questionId = id;
        this.text = text;
        this.points = points;
    }

    abstract boolean evaluate(String answer);
}

class MultipleChoiceQuestion extends Question {
    String correctAnswer;

    MultipleChoiceQuestion(int id, String text, int points,
                           String correctAnswer) {
        super(id, text, points);
        this.correctAnswer = correctAnswer;
    }

    boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class TrueFalseQuestion extends Question {
    String correctAnswer;

    TrueFalseQuestion(int id, String text, int points,
                      String correctAnswer) {
        super(id, text, points);
        this.correctAnswer = correctAnswer;
    }

    boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class ShortAnswerQuestion extends Question {
    String correctAnswer;

    ShortAnswerQuestion(int id, String text, int points,
                        String correctAnswer) {
        super(id, text, points);
        this.correctAnswer = correctAnswer;
    }

    boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer.trim());
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Examination {
    String examName;
    List<Question> questions = new ArrayList<>();

    Examination(String examName) {
        this.examName = examName;
    }

    void addQuestion(Question question) {
        questions.add(question);
    }
}

class Attempt {
    Student student;
    Examination exam;
    Map<Integer, String> answers = new HashMap<>();
    boolean submitted = false;

    Attempt(Student student, Examination exam) {
        this.student = student;
        this.exam = exam;
        System.out.println(exam.examName
                + " started by " + student.name + ".");
    }

    void recordAnswer(int questionId, String answer) {
        if (submitted) {
            System.out.println(
                    "Cannot change answers for a submitted examination.");
            return;
        }

        for (Question q : exam.questions) {
            if (q.questionId == questionId) {
                answers.put(questionId, answer);
                System.out.println("Answer recorded for Question "
                        + questionId + ".");
                return;
            }
        }

        System.out.println("Question not found.");
    }

    void submit() {
        if (submitted) {
            System.out.println("Examination already submitted.");
            return;
        }

        submitted = true;
        System.out.println(exam.examName + " submitted by "
                + student.name + ".");

        int total = 0;
        int score = 0;

        System.out.println("Result:");

        for (Question q : exam.questions) {
            total += q.points;
            String answer = answers.get(q.questionId);

            if (answer != null && q.evaluate(answer)) {
                score += q.points;
                System.out.println("Question " + q.questionId
                        + ": Correct (" + q.points + " points)");
            } else {
                System.out.println("Question " + q.questionId
                        + ": Incorrect (0 points)");
            }
        }

        System.out.println("Total score: " + score + "/" + total);
    }
}

public class class3 {
    public static void main(String[] args) {
        Student student = new Student("Student 1");
        Examination exam = new Examination("Exam A");

        exam.addQuestion(new MultipleChoiceQuestion(
                1, "Choose the correct option", 5, "C"));

        exam.addQuestion(new TrueFalseQuestion(
                2, "Java is a programming language", 5, "False"));

        Attempt attempt = new Attempt(student, exam);

        attempt.recordAnswer(1, "C");
        attempt.recordAnswer(2, "True");
        attempt.submit();
        attempt.recordAnswer(1, "A");
    }
}