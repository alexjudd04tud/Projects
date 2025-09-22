package lab11.company;
//Q2b
public class Person extends InvolvedParty {
    private String birthday;

    public Person(String name, String email, String birthday) {
        super(name, email);
        this.birthday = birthday;
    }

    public Person(String name, String email) {
        this(name, email, ""); // Default date of birth
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}