class class2 {

    private double balance;

    // Constructor
    public class2(double openingBalance) {
        if (openingBalance < 0) {
            balance = 0;
            System.out.println("Warning: Negative opening balance. Balance set to 0.");
        } else {
            balance = openingBalance;
        }
    }

    // Add money to wallet
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: Amount must be greater than 0");
        } else {
            balance = balance + amount;
            System.out.println("Balance after top-up: " + balance);
        }
    }

    // Deduct money from wallet
    public void deduct(double amount) {
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else if (amount <= 0) {
            System.out.println("Deduct rejected: Amount must be greater than 0");
        } else {
            balance = balance - amount;
            System.out.println("Balance after deduction: " + balance);
        }
    }

    // Read-only access to balance
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        class2 wallet = new class2(500);

        wallet.topUp(200);
        wallet.deduct(1000);

        System.out.println("Final balance: " + wallet.getBalance());
    }
}