class GymMember {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("Monthly fee must be positive");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public void displayInfo() {
        System.out.println("Standard Member | Sessions: " + sessionsAttended);
    }
}


class PremiumMember extends GymMember {
    protected String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public void displayInfo() {
        System.out.println("Premium Member | Trainer: " + trainerName
                + " | Sessions: " + sessionsAttended);
    }
}


class EliteMember extends PremiumMember {
    private String lockerNumber;

    public EliteMember(String memberId, int monthlyFee,
                       String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("Elite Member | Trainer: " + trainerName
                + " | Locker: " + lockerNumber
                + " | Sessions: " + sessionsAttended);
    }
}


class GroupClassMember extends GymMember {
    private String className;

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    @Override
    public void displayInfo() {
        System.out.println("Group Class Member | Class: " + className
                + " | Sessions: " + sessionsAttended);
    }
}


public class assignment2 {

    static String classifyGeneration(GymMember member) {

        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        }

        return "Gym Member";
    }


    static int getTotalSessionsAttended(GymMember[] members) {

        int total = 0;

        for (GymMember member : members) {
            total += member.getSessionsAttended();
        }

        return total;
    }


    public static void main(String[] args) {

        GymMember member = new GymMember("MEM1", 1000);
        PremiumMember premiumMember =
                new PremiumMember("MEM2", 2000, "Coach Riya");
        EliteMember eliteMember =
                new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember groupClassMember =
                new GroupClassMember("MEM4", 1500, "Zumba");

        member.displayInfo();
        premiumMember.displayInfo();
        eliteMember.displayInfo();
        groupClassMember.displayInfo();

        System.out.println(classifyGeneration(eliteMember));
        System.out.println(classifyGeneration(groupClassMember));

        premiumMember.attendSession();
        premiumMember.attendSession();
        premiumMember.attendSession();

        eliteMember.attendSession();
        eliteMember.attendSession();

        groupClassMember.attendSession();
        groupClassMember.attendSession();
        groupClassMember.attendSession();
        groupClassMember.attendSession();

        GymMember[] members = {
            premiumMember,
            eliteMember,
            groupClassMember
        };

        System.out.println(getTotalSessionsAttended(members));
    }
}
