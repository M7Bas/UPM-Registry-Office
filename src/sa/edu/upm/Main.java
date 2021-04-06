package sa.edu.upm;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ComputerScience UPM = new ComputerScience("UPM Computer Science");



        boolean quit = false;
        while (!quit){
            try{
                if (scanner.hasNextInt()){
                    int choice = scanner.nextInt();

                    switch (choice){
                        case 0:
//                            printMenu();
                            break;
                        case 1:
                            String[] inputs = askInput(); // {name, major}
                            if (UPM.addUndergraduateStudent(UPM.generateID(),inputs[0],inputs[1])){
                                System.out.println("Successfully added");
                            } else {
                                System.out.println("A student with same ID exists");
                            }
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
                            // quit
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
        return new String[]{firstName + " " + lastName, major};
    }
}
