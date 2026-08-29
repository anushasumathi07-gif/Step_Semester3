import java.util.Scanner;

public class Problem5 {

    static void classifyWordLengths(String review) {
        String[] words = review.split(" ");
        int shortWord = 0, medium = 0, longWord = 0;

        for (String word : words) {
            int length = word.length();

            if (length <= 4)
                shortWord++;
            else if (length <= 8)
                medium++;
            else
                longWord++;
        }

        System.out.println("Short: " + shortWord +
                " | Medium: " + medium +
                " | Long: " + longWord);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter review: ");
        String review = sc.nextLine();

        classifyWordLengths(review);
        sc.close();
    }
}