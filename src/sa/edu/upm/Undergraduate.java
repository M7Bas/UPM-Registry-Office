package sa.edu.upm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Undergraduate extends Student{
    private String major;
    private List<Course> courses;

    public Undergraduate(String ID, String firstName, String lastName, String major) {
        super(ID, firstName, lastName);
        this.major = major;
    }

    @Override
    public String toString() {
        return super.toString() +" "+ major + "\n";
    }
}
