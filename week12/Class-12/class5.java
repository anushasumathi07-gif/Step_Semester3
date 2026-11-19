import java.util.*;

class Participant {
    String name;
    int score;

    Participant(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class class5 {

    static void insertionSort(Participant[] participants) {
        for (int i = 1; i < participants.length; i++) {
            Participant key = participants[i];
            int j = i - 1;

            while (j >= 0 && participants[j].score < key.score) {
                participants[j + 1] = participants[j];
                j--;
            }

            participants[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Participant[] participants = new Participant[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();

            participants[i] = new Participant(name, score);
        }

        insertionSort(participants);

        int rank = 1;

        for (int i = 0; i < n; i++) {
            if (i > 0 && participants[i].score != participants[i - 1].score) {
                rank = i + 1;
            }

            System.out.println(rank + " " +
                               participants[i].name + " " +
                               participants[i].score);
        }
    }
}