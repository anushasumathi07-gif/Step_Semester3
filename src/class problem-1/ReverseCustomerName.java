public class ReverseCustomerName {

    static String reverseCustomerName(String customerName) {
        String reverse = "";

        for (int i = customerName.length() - 1; i >= 0; i--) {
            reverse += customerName.charAt(i);
        }

        return reverse;
    }

    public static void main(String[] args) {
        String name = "Sunil";

        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " +
                reverseCustomerName(name));
    }
}