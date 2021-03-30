package sa.edu.upm;

public class Student {
    private String name;
    private String ID;
    private String email;

    public Student(String name, String ID) {
        this.name = name;
        this.ID = ID;
        this.email = emailMaker();
    }

    private String emailMaker(){
        return this.ID + "@upm.edu.sa";
    }
}
