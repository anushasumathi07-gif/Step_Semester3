class class1 {
    String studentName;
    String company;
    double packageLpa;

    // Constructor
    class1(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    // Instance method
    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ "
                + packageLpa + " LPA");
    }

    public static void main(String[] args) {

        // Creating objects
        class1 p1 = new class1("Ravi", "TCS", 4.5);
        class1 p2 = new class1("Anitha", "Zoho", 6.2);
        class1 p3 = new class1("Karthik", "Infosys", 4.0);

        // Array of objects
        class1[] records = {p1, p2, p3};

        // Printing records
        for (class1 record : records) {
            record.printRecord();
        }
    }
}