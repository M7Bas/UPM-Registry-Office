package sa.edu.upm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ComputerScience UPM = new ComputerScience("UPM Computer Science");


        loadUndergraduate(UPM);
        loadGraduate(UPM);



        boolean quit = false;
        printMenu();
        while (!quit){
            try{
                if (scanner.hasNextInt()){
                    int choice = scanner.nextInt();

                    switch (choice){
                        case 0:
                            printMenu();
                            break;
                        case 1:
                            String[] inputs = askInput(); // {name, major}
                            UPM.addUndergraduateStudent(UPM.generateID(),inputs[0],inputs[1],inputs[2])
                            System.out.println("Successfully added");
                            break;
                        case 2:
                            // add graduate student
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
                            saveAndQuit(UPM);
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

    public static String[] askInput (){
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
            if (choice == 1) major = "Cyber Security";
            else if (choice == 2) major = "Software Engineering";
            else if (choice == 3) major = "Artificial intelligence";
            if (major != null){
                break;
            }
            System.out.println("Wrong Entry!");
        }
        return new String[]{firstName, lastName, major};
    }

    public static void printMenu(){
        System.out.print("0- Print the menu.\n" +
                "1- add an undergraduate student.\n" +
                "2- add a graduate student.\n" +
                "3- add course to undergraduate student.\n" +
                "4- Find undergraduate student.\n" +
                "5- Find graduate student.\n" +
                "6- Save and quit.\n" +
                "Enter a choice :");
    }

    public static boolean loadUndergraduate(ComputerScience UPM){
        File undergraduateFile = new File("Undergraduate.txt");
        try {
            Scanner scanner = new Scanner(undergraduateFile);
            while (scanner.hasNextLine()){
                String[] undergraduate = scanner.nextLine().split(" ");
                UPM.addUndergraduateStudent(undergraduate[0],undergraduate[1],undergraduate[2],undergraduate[3]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean loadGraduate(ComputerScience UPM){
        File graduateFile = new File("Graduate.txt");
        try {
            Scanner scanner = new Scanner(graduateFile);
            while (scanner.hasNextLine()){
                String[] graduate = scanner.nextLine().split(" ");
                UPM.addGraduateStudent(graduate[0], graduate[1], graduate[2], graduate[3]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void saveAndQuit(ComputerScience UPM){
        try {
            FileWriter writer = new FileWriter("Undergraduate.txt",true);

//                writer.write(ID+" "+name+" "+major+"\n");
//                writer.close();
            for(Undergraduate undergraduate: UPM.getUndergraduates()){
                writer.write(undergraduate.toString());
            }
            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
