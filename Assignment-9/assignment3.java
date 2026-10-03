import java.util.*;

public class assignment3 {

    public static List<Object> mostPopular(List<String> orders) {

        Map<String, Integer> count = new HashMap<>();

        for (String item : orders) {
            count.put(item, count.getOrDefault(item, 0) + 1);
        }

        String popularItem = orders.get(0);
        int maxCount = count.get(popularItem);

        for (String item : orders) {
            if (count.get(item) > maxCount) {
                popularItem = item;
                maxCount = count.get(item);
            }
        }

        return Arrays.asList(popularItem, maxCount);
    }

    public static void main(String[] args) {

        List<String> orders = Arrays.asList(
            "dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"
        );

        System.out.println(mostPopular(orders));

        orders = Arrays.asList(
            "tea", "coffee", "coffee", "tea"
        );

        System.out.println(mostPopular(orders));
    }
}