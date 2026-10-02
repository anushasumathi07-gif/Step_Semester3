
import java.util.ArrayList;
import java.util.List;

class Customer {
    String name;

    Customer(String name) {
        this.name = name;
    }
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class OrderItem {
    Product product;
    int quantity;

    OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double getTotal() {
        return product.price * quantity;
    }
}

interface PaymentMethod {
    boolean processPayment(double amount, String orderId);
}

class CreditCardPayment implements PaymentMethod {
    public boolean processPayment(double amount, String orderId) {
        System.out.println("Payment initiated via Credit Card for Order "
                + orderId + ".");
        return true;
    }
}

class PayPalPayment implements PaymentMethod {
    public boolean processPayment(double amount, String orderId) {
        System.out.println("Payment initiated via PayPal for Order "
                + orderId + ".");
        return false;
    }
}

class BankTransferPayment implements PaymentMethod {
    public boolean processPayment(double amount, String orderId) {
        System.out.println("Payment initiated via Bank Transfer for Order "
                + orderId + ".");
        return true;
    }
}

class Order {
    String orderId;
    Customer customer;
    List<OrderItem> items = new ArrayList<>();
    private String status = "Pending";

    Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        System.out.println("Order created for " + customer.name + ".");
    }

    void addProduct(Product product, int quantity) {
        if (quantity > 0) {
            items.add(new OrderItem(product, quantity));
        }
    }

    double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    void makePayment(PaymentMethod method) {
        if (items.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        if (status.equals("Paid")) {
            System.out.println("Order is already paid.");
            return;
        }

        boolean success = method.processPayment(getTotal(), orderId);

        if (success) {
            status = "Paid";
            System.out.println("Payment for Order " + orderId
                    + " successful.");
        } else {
            System.out.println("Payment for Order " + orderId
                    + " failed.");
        }

        System.out.println("Order status: " + status);
    }
}

public class class5 {
    public static void main(String[] args) {
        Customer x = new Customer("Customer X");
        Order orderX = new Order("X", x);

        orderX.addProduct(new Product("Product A", 100), 2);
        orderX.addProduct(new Product("Product B", 200), 1);
        orderX.makePayment(new CreditCardPayment());

        Customer y = new Customer("Customer Y");
        Order orderY = new Order("Y", y);
        orderY.makePayment(new CreditCardPayment());

        Customer z = new Customer("Customer Z");
        Order orderZ = new Order("Z", z);
        orderZ.addProduct(new Product("Product C", 300), 1);
        orderZ.makePayment(new PayPalPayment());
    }
}