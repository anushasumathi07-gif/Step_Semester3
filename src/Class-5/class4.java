public class class4 {


public static void main(String[] args) {

    MovieBookingProfile p =
            new MovieBookingProfile("Rahul Dev");

    System.out.println(p.getName());

    p.setConfirmed(true);
    System.out.println(p.isConfirmed());

    p.setOtp("4471");
}


}

class MovieBookingProfile {


private String name;
private boolean confirmed;
private String otp;

// Public no-argument constructor
public MovieBookingProfile() {
    name = "";
    confirmed = false;
}

// Convenience constructor
public MovieBookingProfile(String name) {
    this();
    this.name = name;
}

// Getter and Setter for name
public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

// Getter and Setter for confirmed
public boolean isConfirmed() {
    return confirmed;
}

public void setConfirmed(boolean confirmed) {
    this.confirmed = confirmed;
}

// Write-only OTP property
public void setOtp(String otp) {
    this.otp = otp;
}


}
