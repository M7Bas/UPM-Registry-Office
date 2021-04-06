package sa.edu.upm;

public class Graduate extends Student{
    private String title;

    public Graduate(String ID, String name, String title) {
        super(name, ID);
        this.title = title;
    }
}
