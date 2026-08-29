
public class Problem4 {

    static void analyzeInventory(int[] a, int[] b) {
        int totalA = 0, totalB = 0;
        int max = a[0], index = 0;
        String section = "A";

        for (int i = 0; i < a.length; i++) {
            totalA += a[i];
            totalB += b[i];

            if (a[i] > max) {
                max = a[i];
                index = i;
                section = "A";
            }

            if (b[i] > max) {
                max = b[i];
                index = i;
                section = "B";
            }
        }

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);
        System.out.println("Status: " +
                (totalA == totalB ? "Balanced" : "Not Balanced"));
        System.out.println("Highest Quantity: " + max +
                " (Section " + section + ", Item " + (index + 1) + ")");
    }

    public static void main(String[] args) {
        int[] a = {20, 15, 30};
        int[] b = {25, 10, 30};

        analyzeInventory(a, b);
    }
}