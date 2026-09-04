class class3 {

    String regNo;
    double totalFee;

    // Constructor
    public class3(String regNo, double totalFee) {
        this.regNo = regNo;
        this.totalFee = totalFee;
    }

    // Final method to calculate late fee
    final double calculateLateFee(int daysLate) {
        return totalFee * daysLate / 100;
    }

    // Final method to print fee summary
    final void printSummary(int daysLate) {
        double lateFee = calculateLateFee(daysLate);

        System.out.println(
            regNo + " | Total Fee: Rs " + totalFee
            + " | Late Fee: Rs " + lateFee
        );
    }

    public static void main(String[] args) {

        String[] regNos = {
            "RA001",
            "RA002",
            "RA003",
            "RA004"
        };

        double[] totalFees = {
            200000,
            150000,
            180000,
            220000
        };

        int[] daysLate = {10, 0, -2, 5};

        // Process all accounts in one loop
        for (int i = 0; i < regNos.length; i++) {

            class3 account = new class3(
                regNos[i],
                totalFees[i]
            );

            // Calculate fee only if daysLate is positive
            if (daysLate[i] > 0) {
                account.printSummary(daysLate[i]);
            } else {
                System.out.println(
                    regNos[i] + " - On time, no late fee"
                );
            }
        }
    }
}
