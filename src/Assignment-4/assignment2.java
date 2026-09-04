class assignment2 {

    String itemName;
    int stock;

    // Constructor using this keyword
    public assignment2(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    // Restock method using this keyword
    public void restock(int stock) {
        this.stock = this.stock + stock;
    }

    public static void main(String[] args) {

        // Array of 4 Item objects
        assignment2[] items = {
            new assignment2("Samosa", 15),
            new assignment2("Tea Powder", 40),
            new assignment2("Bread", 8),
            new assignment2("Biscuit Packs", 25)
        };

        // Restock every item by 20
        for (int i = 0; i < items.length; i++) {

            items[i].restock(20);

            System.out.println(items[i].itemName
                    + " | Final Stock: "
                    + items[i].stock);
        }
    }
}