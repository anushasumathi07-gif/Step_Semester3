public class assignment1 {


static String classifyAccess(String fieldModifier, String accessorContext) {

    if (fieldModifier.equals("private")) {
        if (accessorContext.equals("SAME_CLASS")) {
            return "ALLOWED";
        }
        return "DENIED";
    }

    if (fieldModifier.equals("default")) {
        if (accessorContext.equals("SAME_CLASS") ||
            accessorContext.equals("SAME_PACKAGE")) {
            return "ALLOWED";
        }
        return "DENIED";
    }

    if (fieldModifier.equals("protected")) {
        if (accessorContext.equals("SAME_CLASS") ||
            accessorContext.equals("SAME_PACKAGE")) {
            return "ALLOWED";
        }
        return "DENIED";
    }

    if (fieldModifier.equals("public")) {
        return "ALLOWED";
    }

    return "DENIED";
}

static String summarizeByModifier(String[][] attempts) {

    String[] modifiers = {
        "private", "default", "protected", "public"
    };

    int[] allowed = new int[4];
    int[] denied = new int[4];

    for (String[] attempt : attempts) {

        String modifier = attempt[0];
        String context = attempt[1];

        int index = 0;

        if (modifier.equals("private")) {
            index = 0;
        } else if (modifier.equals("default")) {
            index = 1;
        } else if (modifier.equals("protected")) {
            index = 2;
        } else if (modifier.equals("public")) {
            index = 3;
        }

        String result = classifyAccess(modifier, context);

        if (result.equals("ALLOWED")) {
            allowed[index]++;
        } else {
            denied[index]++;
        }
    }

    return "private: " + allowed[0] + " allowed / " + denied[0] + " denied | " +
           "default: " + allowed[1] + " allowed / " + denied[1] + " denied | " +
           "protected: " + allowed[2] + " allowed / " + denied[2] + " denied | " +
           "public: " + allowed[3] + " allowed / " + denied[3] + " denied";
}

public static void main(String[] args) {

    String[][] attempts = {
        {"private", "SAME_CLASS"},
        {"private", "SAME_PACKAGE"},
        {"default", "SAME_PACKAGE"},
        {"default", "DIFFERENT_PACKAGE"},
        {"protected", "SAME_PACKAGE"},
        {"protected", "SAME_CLASS"},
        {"public", "DIFFERENT_PACKAGE"}
    };

    System.out.println(summarizeByModifier(attempts));
}


}

class LibraryMember {


private String membershipPin;
String branchCode;
protected double finesOwed;
public String displayName;


}
