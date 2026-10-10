
import java.util.*;

public class class4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = {"Asha", "Ravi", "Neha"};
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        int[] total = new int[names.length];
        double[] average = new double[3];

        int topper = 0;

        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < 3; j++) {
                total[i] += marks[i][j];
                average[j] += marks[i][j];
            }

            if (total[i] > total[topper]) {
                topper = i;
            }

            System.out.println("Total " + names[i] + " " + total[i]);
        }

        System.out.print("Averages ");
        for (int j = 0; j < 3; j++) {
            average[j] /= names.length;
            System.out.printf("%.2f", average[j]);

            if (j < 2) {
                System.out.print(", ");
            }
        }

        System.out.println();
        System.out.println("Topper " + names[topper]
                + " (" + total[topper] + ")");

        sc.close();
    }
}
