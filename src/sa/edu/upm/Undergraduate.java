package sa.edu.upm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Undergraduate extends Student{
    private String major;
    private List<Course> courses;

    public Undergraduate(String ID, String firstName, String lastName, String major) {
        super(ID, firstName, lastName);
        this.major = major;
        this.courses = new ArrayList<>();
    }

    public boolean addCourse (Course course){
        if (findCourse(course.getName()) == null){
            courses.add(course);
            return true;
        }
        return false;
    }

    public Course findCourse(String courseName){
        for (int i=0; i<courses.size();i++){
            if (courses.get(i).getName().equals(courseName)) {
                return courses.get(i);
            }
        }
        return null;
    }

    @Override
    public String emailMaker() {
        return "UN."+ super.emailMaker();
    }

    @Override
    public String toString() {
        return super.toString() +" "+ major + "\n";
    }

    public List<Course> getCourses() {
        return courses;
    }
}
