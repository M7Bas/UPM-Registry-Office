package sa.edu.upm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputerScience {

    private File undergraduateFile = new File("Undergraduate.txt");

//    private static Scanner scanner = new Scanner("Undergraduate.txt");

    private String name;

    private List<Undergraduate> undergraduates;
    private List<Graduate> graduates;

    public ComputerScience(String name) {
        this.name = name;
        this.undergraduates = new ArrayList<>();
        this.graduates = new ArrayList<>();
    }

    public boolean addUndergraduateStudent (String ID, String name, String major){
        try {
            FileWriter writer = new FileWriter("Undergraduate.txt",true);
            if (findUndergraduate(ID) == null){
                writer.write(ID+" "+name+" "+major+"\n");
                writer.close();
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private Undergraduate findUndergraduate (String ID){
        try {
            Scanner scanner = new Scanner(undergraduateFile);
            while (scanner.hasNextLine()){
                 String[] undergraduate = scanner.nextLine().split(" "); // {ID, firstName, lastName, major}
                 if (undergraduate[0].equals(ID)){
                     scanner.close();
                     return new Undergraduate(undergraduate[0],undergraduate[1]+" "+undergraduate[2],undergraduate[3]);
                 }
                 scanner.close();
                 return null;
            }

        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public String generateID (){
        try {
            Scanner scanner = new Scanner(undergraduateFile);
            while (scanner.hasNextLine()){
                String[] student = scanner.nextLine().split(" "); // {ID, firstName, lastName, major}
//                if (student[0].equals(ID)){
//                    scanner.close();
//                    return student[0]
//                }
                scanner.close();
                return String.valueOf(Integer.parseInt(student[0])+1);
            }

        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return null;
    }
}
