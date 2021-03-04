package lab1.models;

public abstract class User {
    protected static int counter = 0;
    protected int id;
    protected String firstName;
    protected String lastName;

    User(String fName, String lName) {
        this.firstName = fName;
        this.lastName = lName;
        this.id = counter;
        counterInc();
    }

    abstract String getInfo();
    abstract void getStatus();

    public void counterInc() {
        counter++;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
    public int getId() {
        return id;
    }
}
