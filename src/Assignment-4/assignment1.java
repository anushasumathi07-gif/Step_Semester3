class assignment1 {

    String name;
    String teamName;
    boolean registered;

    // Constructor for participants with a team
    public assignment1(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        this.registered = true;
    }

    // Constructor for solo participants
    public assignment1(String name) {
        this(name, "Unassigned");
    }

    // Print participant details
    public void printStatus() {
        System.out.println(name + " | " + teamName
                + " | Registered: " + registered);
    }

    public static void main(String[] args) {

        String[] names = {"Ravi", "Meera", "Karthik", "Divya"};

        String[] teamNames = {
            "ByteBusters",
            "",
            "CodeCrafters",
            ""
        };

        for (int i = 0; i < names.length; i++) {

            assignment1 participant;

            if (teamNames[i].isEmpty()) {
                participant = new assignment1(names[i]);
            } else {
                participant = new assignment1(
                        names[i],
                        teamNames[i]
                );
            }

            participant.printStatus();
        }
    }
}