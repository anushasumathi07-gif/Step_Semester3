class FeeAccount {

    // Payment for day-scholar account
    void pay(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }
}

// HostelFeeAccount inherits FeeAccount
class HostelFeeAccount extends FeeAccount {

    // Payment for hostel account
    void payInInstallments(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}

class class5 {

    static int hostelCount = 0;
    static int dayScholarCount = 0;

    // Process payment using instanceof
    static void processPayment(FeeAccount account, double amount) {

        if (account instanceof HostelFeeAccount) {

            HostelFeeAccount hostelAccount =
                    (HostelFeeAccount) account;

            hostelAccount.payInInstallments(amount);

            hostelCount++;

        } else {

            account.pay(amount);

            dayScholarCount++;
        }
    }

    public static void main(String[] args) {

        // Array containing both types of accounts
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        double amount = 60000;

        // Process every account in one loop
        for (int i = 0; i < accounts.length; i++) {
            processPayment(accounts[i], amount);
        }

        // Print counters after processing the complete batch
        System.out.println(
            "Hostel accounts processed: " + hostelCount
            + " | Day-scholar accounts processed: "
            + dayScholarCount
        );
    }
}
