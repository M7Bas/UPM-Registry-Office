package sa.edu.upm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static File undergraduateFile = new File("Undergraduate.txt");
    public static File graduateFile = new File("Graduate.txt");
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ComputerScience UPM = new ComputerScience("UPM Computer Science");

        loadUndergraduate(UPM);
        loadGraduate(UPM);

        boolean quit = false;
        printMenu();
        while (!quit){
            try{
                System.out.print("Enter a choice (0 for menu):");
                if (scanner.hasNextInt()){
                    int choice = scanner.nextInt();

                    switch (choice){
                        case 0:
                            printMenu();
                            break;
                        case 1:
                            String[] inputs = askInputUndergraduate(); // {name, major}
                            UPM.addUndergraduateStudent(UPM.generateID(undergraduateFile),inputs[0],inputs[1],inputs[2]);
                            System.out.println("Successfully added");
                            break;
                        case 2:
                            String[] inputs2 = askInputGraduate(); // {name, major}
                            UPM.addGraduateStudent(UPM.generateID(graduateFile),inputs2[0],inputs2[1],inputs2[2]);
                            System.out.println("Successfully added");
                            break;
                        case 3:
                            // add course to undergraduate student
                            break;
                        case 4:
                            // find graduate student
                            break;
                        case 5:
                            // find undergraduate student
                            break;
                        case 6:
                            save(UPM);
                            break;
                        case 7:
                            save(UPM);
                            quit = true;
                            break;
                        default:
                            System.out.println("WRONG ENTRY!");
                    }
                }
                else {
                    throw new IOException();
                }
            } catch (IOException e){
                System.out.println("Wrong Entry");
            }
        }
    }

    public static String[] askInputUndergraduate (){
        System.out.println("Enter the first name:");
        String firstName = scanner.next();
        System.out.println("Enter the last name");
        String lastName = scanner.next();
        System.out.println("" +
                "1- Cyber Security\n" +
                "2- Software Engineering\n" +
                "3- Artificial intelligence");
        String major = null;
        while (true) {
            int choice = scanner.nextInt();
            if (choice == 1) major = "Cyber-Security";
            else if (choice == 2) major = "Software-Engineering";
            else if (choice == 3) major = "Artificial-intelligence";
            if (major != null){
                break;
            }
            System.out.println("Wrong Entry!");
        }
        return new String[]{firstName, lastName, major};
    }

    public static String[] askInputGraduate (){
        System.out.println("Enter the first name:");
        String firstName = scanner.next();
        System.out.println("Enter the last name:");
        String lastName = scanner.next();
        System.out.println("Enter the title:");
        String title = scanner.next();
        return new String[]{firstName, lastName, title};
    }

    public static void printMenu(){
        System.out.println("0- Print the menu.\n" +
                "1- add an undergraduate student.\n" +
                "2- add a graduate student.\n" +
                "3- add course to undergraduate student.\n" +
                "4- Find undergraduate student.\n" +
                "5- Find graduate student.\n" +
                "6- Save.\n" +
                "7- Save and quit.");
    }

    public static boolean loadUndergraduate(ComputerScience UPM){

        try {
            Scanner loader = new Scanner(undergraduateFile);
            while (loader.hasNextLine()){
                String[] undergraduate = loader.nextLine().split(" ");
                UPM.addUndergraduateStudent(undergraduate[0],undergraduate[1],undergraduate[2],undergraduate[3]);
            }
            loader.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean loadGraduate(ComputerScience UPM){

        try {
            Scanner scanner = new Scanner(graduateFile);
            while (scanner.hasNextLine()){
                String[] graduate = scanner.nextLine().split(" ");
                UPM.addGraduateStudent(graduate[0], graduate[1], graduate[2], graduate[3]);

            }

            scanner.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void save(ComputerScience UPM){
        try {
            FileWriter writerUndergraduate = new FileWriter("Undergraduate.txt");

            for(Undergraduate undergraduate: UPM.getUndergraduates()){
                writerUndergraduate.write(undergraduate.toString());
            }
            writerUndergraduate.close();


        } catch (IOException e) {
            System.out.println("Problem with reading the \"Undergraduate.txt\"");
            e.printStackTrace();
        }

        try {
            FileWriter writerGraduate = new FileWriter("Graduate.txt");

            for(Graduate graduate: UPM.getGraduates()){
                writerGraduate.write(graduate.toString());
            }
            writerGraduate.close();


        } catch (IOException e) {
            System.out.println("Problem with reading the \"Graduate.txt\"");
            e.printStackTrace();
        }
    }
}
