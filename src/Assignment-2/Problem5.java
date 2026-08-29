import java.util.Scanner;

public class Problem5 {

    // Normalize the reference
    static String normalizeReference(String raw) {
        String reference = raw.trim();

        // Convert only the first 3 characters to uppercase
        if (reference.length() >= 3) {
            reference = reference.substring(0, 3).toUpperCase()
                    + reference.substring(3);
        }

        return reference;
    }

    // Validate and format the reference
    static String validateAndFormat(String reference) {

        // Check length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining characters are digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        // Extract bank code, date and sequence number
        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);

        // Format using StringBuilder
        StringBuilder result = new StringBuilder();
        result.append("[").append(bankCode).append("] ");
        result.append("DATE: ")
              .append(date.substring(0, 2)).append("/")
              .append(date.substring(2, 4)).append("/")
              .append(date.substring(4, 6));
        result.append(" | SEQ: ").append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        String reference = normalizeReference(raw);
        System.out.println(validateAndFormat(reference));

        sc.close();
    }
}