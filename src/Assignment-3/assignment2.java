class assignment2 {

    private double basicSalary;
    private double bonus;

    // Constructor
    public assignment2(double basicSalary) {
        if (basicSalary < 0) {
            this.basicSalary = 0;
            System.out.println("Warning: Negative salary. Salary set to 0.");
        } else {
            this.basicSalary = basicSalary;
        }

        this.bonus = 0;
    }

    // Add bonus
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: Amount must be greater than 0");
        } else {
            bonus = bonus + amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    // Deduct tax percentage from basic salary
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage. Enter a value between 0 and 100.");
        } else {
            basicSalary = basicSalary - (basicSalary * percent / 100);
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    // Read-only access to net salary
    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {

        assignment2 account = new assignment2(50000);

        account.creditBonus(5000);
        account.deductTax(10);

        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
