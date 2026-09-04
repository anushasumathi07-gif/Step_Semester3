class assignment3 {

    String vehicleNo;
    double ratePerMinute;

    // Constructor
    public assignment3(String vehicleNo, double ratePerMinute) {
        this.vehicleNo = vehicleNo;
        this.ratePerMinute = ratePerMinute;
    }

    // Final method to calculate fine
    final double calculateFine(int overstayMinutes) {
        return overstayMinutes * ratePerMinute;
    }

    // Final method to print receipt
    final void printReceipt(int overstayMinutes) {
        double fine = calculateFine(overstayMinutes);

        System.out.println(vehicleNo + " - Fine: Rs " + fine);
    }

    public static void main(String[] args) {

        String[] vehicleNos = {
            "TN09AB1234",
            "TN22CD5678",
            "TN09EF9012",
            "TN10GH3456"
        };

        double[] ratePerMinute = {2, 2, 3, 2};

        int[] overstayMinutes = {15, 0, -5, 8};

        // Loop through all parking tickets
        for (int i = 0; i < vehicleNos.length; i++) {

            assignment3 ticket = new assignment3(
                    vehicleNos[i],
                    ratePerMinute[i]
            );

            // Check whether the vehicle overstayed
            if (overstayMinutes[i] > 0) {
                ticket.printReceipt(overstayMinutes[i]);
            } else {
                System.out.println(vehicleNos[i]
                        + " - No fine, within allotted time");
            }
        }
    }
}