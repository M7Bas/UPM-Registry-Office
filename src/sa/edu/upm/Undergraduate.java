package sa.edu.upm;

import java.util.List;

public class Undergraduate extends Student{
    private List<Course> courses;

    public Undergraduate(String name, String ID) {
        super(name, ID);
    }
}
