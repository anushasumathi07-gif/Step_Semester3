import java.util.Arrays;

public class assignment5 {

public static void main(String[] args) {

    LoanReceipt r = new LoanReceipt(
            "LIB-8841",
            new String[]{"BK-100", "BK-101"}
    );

    // Test defensive copy
    String[] ids = r.getBookIds();
    ids[0] = "HACKED";

    System.out.println(r.getBookIds()[0]);

    // Create a corrected new receipt
    LoanReceipt corrected =
            r.withCorrectedBookId(1, "BK-102");

    System.out.println(Arrays.toString(r.getBookIds()));
    System.out.println(Arrays.toString(corrected.getBookIds()));

    // Nightly circulation processing
    LoanReceipt[] receipts = {
        new ReferenceOnlyLoanReceipt(
            "LIB-001",
            new String[]{"BK-200"},
            "Reading Room 3"
        ),
        null,
        new LoanReceipt(
            "LIB-002",
            new String[]{"BK-201"}
        )
    };

    System.out.println(
        CirculationLedger.processNightlyCirculation(receipts)
    );
}


}

class LoanReceipt {

private final String memberId;
private final String[] bookIds;

public LoanReceipt(String memberId, String[] bookIds) {

    this.memberId = memberId;

    // Defensive copy in
    this.bookIds = bookIds.clone();
}

public String[] getBookIds() {

    // Defensive copy out
    return bookIds.clone();
}

public LoanReceipt withCorrectedBookId(
        int index,
        String newId) {

    String[] correctedIds = bookIds.clone();

    correctedIds[index] = newId;

    return new LoanReceipt(
        memberId,
        correctedIds
    );
}


}

class ReferenceOnlyLoanReceipt extends LoanReceipt {


private final String roomNumber;

public ReferenceOnlyLoanReceipt(
        String memberId,
        String[] bookIds,
        String roomNumber) {

    super(memberId, bookIds);

    this.roomNumber = roomNumber;
}


}

class CirculationLedger {


private static String branchCode;

// Static block for one-time class-level initialization
static {
    branchCode = "PT-LIBRARY";
}

static String processNightlyCirculation(
        LoanReceipt[] receipts) {

    int processed = 0;
    int nullSkipped = 0;
    int referenceOnly = 0;
    int regular = 0;

    for (LoanReceipt receipt : receipts) {

        if (receipt == null) {
            nullSkipped++;
        }
        else if (receipt instanceof ReferenceOnlyLoanReceipt) {
            processed++;
            referenceOnly++;
        }
        else {
            processed++;
            regular++;
        }
    }

    return processed + " processed | " +
           nullSkipped + " null skipped | " +
           referenceOnly + " reference-only | " +
           regular + " regular";
}


}
