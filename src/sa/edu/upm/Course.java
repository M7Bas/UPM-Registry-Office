package sa.edu.upm;

public class Course {
    private String name;
    private int credit;

    public Course(String name, int credit) {
        this.name = name;
        this.credit = credit;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name+" "+credit;
    }
}
