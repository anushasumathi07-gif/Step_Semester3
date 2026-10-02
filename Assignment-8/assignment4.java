
interface MembershipPlan {
    double calculateFee();
    String getName();
}

class MonthlyPlan implements MembershipPlan {
    public double calculateFee() {
        return 1000;
    }

    public String getName() {
        return "Monthly";
    }
}

class QuarterlyPlan implements MembershipPlan {
    public double calculateFee() {
        return 3000 * 0.90;
    }

    public String getName() {
        return "Quarterly";
    }
}

class AnnualPlan implements MembershipPlan {
    public double calculateFee() {
        return 12000 * 0.75;
    }

    public String getName() {
        return "Annual";
    }
}

class Member {
    private String name;
    private Membership membership;

    Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void buyMembership(MembershipPlan plan) {
        membership = new Membership(this, plan);
        System.out.printf("%s membership created for %s. Fee: ₹%.2f. Status: %s.%n",
                plan.getName(), name, plan.calculateFee(),
                membership.getStatus());
    }

    public void checkIn() {
        if (membership != null) {
            membership.checkIn();
        }
    }

    public void freeze() {
        if (membership != null) {
            membership.freeze();
        }
    }

    public void unfreeze() {
        if (membership != null) {
            membership.unfreeze();
        }
    }

    public void expire() {
        if (membership != null) {
            membership.expire();
        }
    }
}

class Membership {
    private Member member;
    private MembershipPlan plan;
    private String status;

    Membership(Member member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
        this.status = "Active";
    }

    public String getStatus() {
        return status;
    }

    public void checkIn() {
        if (status.equals("Active")) {
            System.out.println(member.getName()
                    + " checked in successfully.");
        } else {
            System.out.println("Check-in denied: "
                    + member.getName() + "'s membership is "
                    + status + ".");
        }
    }

    public void freeze() {
        if (status.equals("Active")) {
            status = "Frozen";
            System.out.println(member.getName()
                    + "'s membership frozen. Status: " + status + ".");
        } else if (status.equals("Expired")) {
            System.out.println("Cannot freeze an Expired membership.");
        } else {
            System.out.println("Membership is already Frozen.");
        }
    }

    public void unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";
            System.out.println(member.getName()
                    + "'s membership unfrozen. Status: " + status + ".");
        } else if (status.equals("Expired")) {
            System.out.println("Cannot unfreeze an Expired membership.");
        } else {
            System.out.println("Membership is already Active.");
        }
    }

    public void expire() {
        if (!status.equals("Expired")) {
            status = "Expired";
            System.out.println(member.getName()
                    + "'s membership expired. Status: " + status + ".");
        }
    }
}

public class assignment4 {
    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        asha.buyMembership(new QuarterlyPlan());
        ravi.buyMembership(new MonthlyPlan());

        asha.checkIn();
        asha.freeze();
        asha.checkIn();

        ravi.expire();
        ravi.freeze();
    }
}