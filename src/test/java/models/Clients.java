package models;

public class Clients {
    private String name;
    private String telephoneNumber;
    private String emailAddress;

    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Clients(String name, String telephoneNumber, String emailAddress) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.emailAddress = emailAddress;
    }
}
