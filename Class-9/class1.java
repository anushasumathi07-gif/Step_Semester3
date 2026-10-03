import java.util.*;

public class class1 {

    public static String findBook(List<String[]> catalog, String targetIsbn) {
        int low = 0;
        int high = catalog.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            String isbn = catalog.get(mid)[0];

            int comparison = isbn.compareTo(targetIsbn);

            if (comparison == 0) {
                return catalog.get(mid)[1];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {

        List<String[]> catalog = new ArrayList<>();

        catalog.add(new String[]{"0001112223", "Introduction to Algebra"});
        catalog.add(new String[]{"0002223334", "Beginning Python"});
        catalog.add(new String[]{"0003334445", "Classic Mythology"});
        catalog.add(new String[]{"0004445556", "Data and Society"});
        catalog.add(new String[]{"0005556667", "European History"});

        String targetIsbn = "0003334445";

        String result = findBook(catalog, targetIsbn);

        System.out.println(result);

        targetIsbn = "0009998887";

        result = findBook(catalog, targetIsbn);

        System.out.println(result);
    }
}