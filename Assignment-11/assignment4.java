

public class assignment4 {

    static int kthHighest(int[] marks, int k) {
        int target = marks.length - k;
        int low = 0;
        int high = marks.length - 1;

        while (low <= high) {
            int pivot = partition(marks, low, high);

            if (pivot == target) {
                return marks[pivot];
            } else if (pivot > target) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }

        return -1;
    }

    static int partition(int[] marks, int low, int high) {
        int pivot = marks[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (marks[j] <= pivot) {
                i++;

                int temp = marks[i];
                marks[i] = marks[j];
                marks[j] = temp;
            }
        }

        int temp = marks[i + 1];
        marks[i + 1] = marks[high];
        marks[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        int[] marks1 = {72, 95, 60, 88, 79};
        int[] marks2 = {50, 90, 90, 70};

        System.out.println(kthHighest(marks1, 2));
        System.out.println(kthHighest(marks2, 2));
    }
}
