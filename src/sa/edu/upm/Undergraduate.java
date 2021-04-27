package sa.edu.upm;

import java.util.ArrayList;
import java.util.List;

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
        return false; // if found the same course with the same student return false.
    }

    public Course findCourse(String courseName){
        for (int i=0; i<courses.size();i++){
            if (courses.get(i).getName().equals(courseName)) {
                return courses.get(i);
            }
        }
        return null; // if find nothing return false.
    }

    @Override
    public String emailMaker() {
        return "UN."+ super.emailMaker();
    }

    @Override
    public String toString() {
        return super.toString() +" "+ major + "\n"; // the new line to arrange the file nicely.
    }

    public List<Course> getCourses() {
        return courses;
    }
}
