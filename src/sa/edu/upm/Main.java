package sa.edu.upm;

//importing reqiured libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    //naming files
    public static File undergraduateFile = new File("Undergraduate.txt");
    public static File graduateFile = new File("Graduate.txt");
    public static File studentCourses = new File("StudentCourses.txt");
    public static Scanner scanner = new Scanner(System.in); //creating scanner object

    public static void main(String[] args) {
        ComputerScience UPM = new ComputerScience("UPM Computer Science");//creating object

        //if files didn't exist, they won't be loaded and if-statement would be wrong.
        if ( //if all files are loaded, boolean will be True
        loadUndergraduate(UPM) &&
        loadGraduate(UPM) &&
        loadCoursesToUnderaduateStudents(UPM)) {
            System.out.println("Welcome to "+ UPM.getName());
        } else { //using the save method to create files for the first time without writing anything in them.
          save(UPM);
        }

        boolean quit = false; //boolean to control the mainloop
        printMenu(); //to output the options for the user
        while (!quit){ // the mainloop
            try{
                System.out.print("Enter a choice (0 for menu):");
                if (scanner.hasNextInt()){
                    int choice = scanner.nextInt(); //taking input from the user

                    switch (choice){
                        case 0:  //print menu
                            printMenu(); //using printMenu method
                            break;
                        case 1: //add undergraduate student
                            String[] inputs = askInputUndergraduate(); //taking inputs as an array {name, major}
                            //using generateID method for ID, and using the user's inputs to create a new Undergraduate object
                            UPM.addUndergraduateStudent(UPM.generateID(undergraduateFile),inputs[0],inputs[1],inputs[2]); 
                            System.out.println("Successfully added.");
                            save(UPM); //to write the new information in the files
                            break;
                        case 2: //add graduate student
                            String[] inputs2 = askInputGraduate(); //taking inputs as an array {name, title}
                            //using generateID method for ID, and using the user's inputs to create a new Graduate object
                            UPM.addGraduateStudent(UPM.generateID(graduateFile),inputs2[0],inputs2[1],inputs2[2]);
                            System.out.println("Successfully added.");
                            save(UPM); //to write the new information in the files
                            break;
                        case 3: //add course to an undergraduate student
                            System.out.println("Enter the ID of the undergraduate student: ");
                            
                            //taking the users input and searching for a student with the same ID number using findUndergraduate method in ComputerScience class
                            //then creating a new object from the object that was returned from that method
                            Undergraduate undergraduateStudent = UPM.findUndergraduate(scanner.next()); 
                            if (undergraduateStudent != null){ //if a student with the same ID exists, the boolean is True
                                System.out.println("Enter the course name:"); 
                                String CourseName = scanner.next(); //taking the course name to add it to the file StudentCourses
                                System.out.println("Enter the credit hours:");
                                int creditHours = scanner.nextInt(); //taking the course credit to add it to the file StudentCourses
                                Course courseToAdd = new Course(CourseName, creditHours); //creating new Course object
                                if (undergraduateStudent.addCourse(courseToAdd)){ //using the addCourse(courseToAdd) to check if the course is added before or not
                                    System.out.println("Course has been added successfully.");
                                } else { //the if-statement is False when the course is already added 
                                    System.out.println("Cannot add course. Course already added!");
                                }
                            } else { //a student with the same ID does not exist
                                System.out.println("Student not found.");
                            }
                            save(UPM); //to write the new information in the files
                            break;
                        case 4: //to find undergraduate student information, with their email
                            System.out.print("Enter the ID of the student: ");
                            String UndergraduateID = scanner.next(); //taking the ID from the user
                            
                            //taking the users input and searching for a student with the same ID number using findUndergraduate method in ComputerScience class
                            //then creating an undergraduate object from the object that was returned from that method
                            undergraduateStudent = UPM.findUndergraduate(UndergraduateID); 
                            if (undergraduateStudent != null){ //if a student with the same ID exists, the boolean is True
                                System.out.println(undergraduateStudent.toString()+ "\t" + undergraduateStudent.emailMaker()); //print the information using overloaded methods in the Undergraduate class
                            } else { //a student with the same ID does not exist
                                System.out.println("Student not found"); 
                            }
                            break;
                        case 5: //to find graduate student information, with their email
                            System.out.print("Enter the ID of the student: ");
                            String graduateID = scanner.next(); //taking the ID from the user
                            
                            //taking the users input and searching for a student with the same ID number using findGraduate method in ComputerScience class
                            //then creating a graduate object from the object that was returned from that method
                            Graduate graduateStudent = UPM.findGraduate(graduateID);
                            if (graduateStudent != null){ //if a student with the same ID exists, the boolean is True
                                System.out.println(graduateStudent.toString()+ "\t" + graduateStudent.emailMaker()); //print the information using overloaded methods in the Graduate class
                            } else { //a student with the same ID does not exist
                                System.out.println("Student not found.");
                            }
                            break;
                        case 6:
                            save(UPM); //to write the new information in the files
                            break;
                        case 7:
                            save(UPM); //to write the new information in the files, and to change the value of the boolean that controls the main loop
                            quit = true;
                            break;
                        default:
                            System.out.println("WRONG ENTRY!"); //if the user entered a wrong value
                    }
                }
                else { //the user's input was not an int (error while reading the input)
                    throw new IOException(); 
                }
            } catch (IOException e){
                System.out.println("Wrong Entry"); 
            }
        }
    }

    public static String[] askInputUndergraduate (){ //taking inputs from the user
        System.out.println("Enter the first name:");
        String firstName = scanner.next();
        System.out.println("Enter the last name");
        String lastName = scanner.next();
        System.out.println("" +
                "1- Cyber Security\n" +
                "2- Software Engineering\n" +
                "3- Artificial intelligence");
        String major = null;
        while (true) { //making the user choose from the following untill they choose a valid option
            int choice = scanner.nextInt();
            if (choice == 1) major = "Cyber-Security";
            else if (choice == 2) major = "Software-Engineering";
            else if (choice == 3) major = "Artificial-intelligence";
            if (major != null){ //if the user does not choose a valid option, the boolean will be false, and the loop will re-iterate
                break;
            }
            System.out.println("Wrong Entry!");
        }
        return new String[]{firstName, lastName, major}; //it will return the following inputs
    }

    public static String[] askInputGraduate (){ //taking inputs from the user
        System.out.println("Enter the first name:");
        String firstName = scanner.next();
        System.out.println("Enter the last name:");
        String lastName = scanner.next();
        System.out.println("Enter the title:");
        String title = scanner.next();
        return new String[]{firstName, lastName, title}; //it will return the following inputs
    }

    public static void printMenu(){ //to print the menu of choices
        System.out.println("0- Print the menu.\n" +
                "1- add an undergraduate student.\n" +
                "2- add a graduate student.\n" +
                "3- add course to undergraduate student.\n" +
                "4- Find undergraduate student.\n" +
                "5- Find graduate student.\n" +
                "6- Save.\n" +
                "7- Save and quit.");
    }

    public static boolean loadUndergraduate(ComputerScience UPM){ //to read the files at the beggining of the program
        try { //reading undergraduateFile
            Scanner loader = new Scanner(undergraduateFile);
            while (loader.hasNextLine()){ //untill the file has no more lines
                String[] undergraduate = loader.nextLine().split(" "); //changing the information in the file to an array
                UPM.addUndergraduateStudent(undergraduate[0],undergraduate[1],undergraduate[2],undergraduate[3]); //creating objects from the information in the array
            }
            loader.close();
            return true; //the file is loaded succesfully
        } catch (FileNotFoundException e) {
            return false; //the file does not exist
        }
    }

    public static boolean loadGraduate(ComputerScience UPM){

        try { //reading graduateFile
            Scanner loader = new Scanner(graduateFile);
            while (loader.hasNextLine()){ //untill the file has no more lines
                String[] graduate = loader.nextLine().split(" "); //changing the information in the file to an array
                UPM.addGraduateStudent(graduate[0], graduate[1], graduate[2], graduate[3]); //creating objects from the information in the array
            }
            loader.close();
            return true; //the file is loaded succesfully
        } catch (FileNotFoundException e) {
            return false; //the file does not exist
        }
    }

    public static boolean loadCoursesToUnderaduateStudents(ComputerScience UPM){
        try { //reading studentcourses
            Scanner loader = new Scanner(studentCourses);
            while (loader.hasNextLine()){ //untill the file has no more lines
                String[] studentCourse = loader.nextLine().split(" "); //changing the information in the file to an array {Student ID, Course Name, Course credit}
                Course course = new Course(studentCourse[1],Integer.parseInt(studentCourse[2])); //creating objects from the information in the array
                UPM.findUndergraduate(studentCourse[0]).addCourse(course); //adding course to the student with that ID (studentCourse[0])
            }
            loader.close();
            return true; //the file is loaded succesfully
        } catch (FileNotFoundException e) {
            return false; //the file does not exist
        }
    }

    public static void save(ComputerScience UPM){ //to write the new information in the files (and create the files if they didn't exist)
        try { //write in Undergraduate file
            FileWriter writerUndergraduate = new FileWriter("Undergraduate.txt"); //creating the writer
            //writing the information stored in the arrays into the file
            for(Undergraduate undergraduate: UPM.getUndergraduates()){
                writerUndergraduate.write(undergraduate.toString());
            }
            writerUndergraduate.close();


        } catch (IOException e) {
            System.out.println("Problem with reading the \"Undergraduate.txt\"");
            e.printStackTrace();
        }

        try { //write in Graduate file
            FileWriter writerGraduate = new FileWriter("Graduate.txt"); //creating the writer
            //writing the information stored in the arrays into the file
            for(Graduate graduate: UPM.getGraduates()){
                writerGraduate.write(graduate.toString());
            }
            writerGraduate.close();


        } catch (IOException e) {
            System.out.println("Problem with reading the \"Graduate.txt\"");
            e.printStackTrace();
        }

        try { //write in StudentCourses file
            FileWriter writerStudentCourses = new FileWriter("StudentCourses.txt"); //creating the writer
            //writing the information stored in the arrays into the file
            for (Undergraduate undergraduate:UPM.getUndergraduates()){
                for (Course course: undergraduate.getCourses()){
                    writerStudentCourses.write(undergraduate.getID()+" "+course.toString()+"\n");
                }
            }
            writerStudentCourses.close();


        } catch (IOException e) {
            System.out.println("Problem with reading the \"StudentCourses.txt\"");
            e.printStackTrace();
        }
    }
}
