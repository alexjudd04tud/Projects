package lab11.company;


//Q2a
public abstract class InvolvedParty {//the base class for all involved parties in the system
    private static int nextId = 1;//this automatically increments the id of the object I create making sure all new ids created are unique
    //static becaue its shared across all instances of the class
    private int id;
    private String name;
    private String email;

    public InvolvedParty(String name, String email) {//constructor for creating new instance of InvolvedParty(object)
        this.id = nextId++;
        this.name = name;
        this.email = email;
    }
//methods below for getting certain attributes of objects I create
    public int getId() {
        return id;
    }

    public String getName() {//gets name 
        return name;
    }

    public void setName(String name) {//this can change the name of the object

        this.name = name;
    }

    public String getEmail() {//gets email of the object
        return email;
    }

    public void setEmail(String email) {//can change the email of the object
        this.email = email;
    }
}