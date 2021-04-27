package sa.edu.upm;

public class Student {
    private String ID;
    private String firstName;
    private String lastName;
    private String email;

    public Student(String ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String emailMaker(){
        return this.ID + "@upm.edu.sa";
    }

    public String getID() {
        return ID;
    }

    public String toString(){
        return ID +" "+ firstName + " " + lastName;
    }


}
