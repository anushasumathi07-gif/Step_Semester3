import java.util.Scanner;

public class Problem4 {

    static String maskPhoneNumber(String phone) {

        // Check if phone number has exactly 10 digits
        if (phone.length() != 10 || !phone.matches("\\d{10}")) {
            return "Invalid phone number";
        }

        // Get last 4 digits
        String lastFour = phone.substring(6);

        // Build masked number using StringBuilder
        StringBuilder masked = new StringBuilder("XXXXXX" + lastFour);

        // Insert hyphen after XXXXXX
        masked.insert(6, "-");

        return masked.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.println(maskPhoneNumber(phone));

        sc.close();
    }
}