package sa.edu.upm;

import java.util.List;

public class Undergraduate extends Student{
    private String major;
    private List<Course> courses;

    public Undergraduate(String ID,String name, String major) {
        super(name, ID);
        this.major = major;
    }

    @Override
    public String toString() {
        return super.toString() +" "+ major;
    }
}
