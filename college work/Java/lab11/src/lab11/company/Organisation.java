package lab11.company;
//Q2c
public class Organisation extends InvolvedParty {
    private String contactName;

    public Organisation(String name, String email, String contactName) {
        super(name, email);
        this.contactName = contactName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}