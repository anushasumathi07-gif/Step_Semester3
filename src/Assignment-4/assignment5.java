class Payment {

    // Method for cash payment
    void pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
    }
}

// CardPayment inherits Payment
class CardPayment extends Payment {

    // Method for card payment with 2% processing fee
    void payWithProcessingFee(double amount) {
        double total = amount + (amount * 0.02);

        System.out.println(
            "Charged (card, incl. fee): Rs " + total
        );
    }
}

class assignment5 {

    // Process transaction using instanceof
    static double processTransaction(Payment payment, double amount) {

        if (payment instanceof CardPayment) {

            // Safe casting
            CardPayment card = (CardPayment) payment;

            card.payWithProcessingFee(amount);

            // Return amount including 2% fee
            return amount + (amount * 0.02);

        } else {

            payment.pay(amount);

            // Return normal amount
            return amount;
        }
    }

    public static void main(String[] args) {

        // Array containing CardPayment and Payment objects
        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };

        double[] amounts = {100, 50, 200, 75, 120};

        double totalCollected = 0;

        // Process every transaction
        for (int i = 0; i < payments.length; i++) {

            totalCollected += processTransaction(
                payments[i],
                amounts[i]
            );
        }

        System.out.println(
            "Total Collected: Rs " + totalCollected
        );
    }
}