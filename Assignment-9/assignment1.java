public class assignment1 {

    public static int[] findTopper(int[][] marks) {
        int bestRow = 0;
        int bestTotal = 0;

        for (int row = 0; row < marks.length; row++) {
            int total = 0;

            for (int col = 0; col < marks[row].length; col++) {
                total += marks[row][col];
            }

            if (total > bestTotal) {
                bestTotal = total;
                bestRow = row;
            }
        }

        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {

        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        int[] result = findTopper(marks);

        System.out.println("(" + result[0] + ", " + result[1] + ")");
    }
}