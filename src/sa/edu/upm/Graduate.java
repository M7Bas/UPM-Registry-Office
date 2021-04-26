package sa.edu.upm;

public class Graduate extends Student{
    private String title;

    public Graduate(String ID, String firstName, String lastName, String title) {
        super(ID, firstName, lastName);
        this.title = title;
    }
}
