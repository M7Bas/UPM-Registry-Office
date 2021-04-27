package sa.edu.upm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputerScience {



//    private static Scanner scanner = new Scanner("Undergraduate.txt");

    private String name;

    private ArrayList<Undergraduate> undergraduates;
    private ArrayList<Graduate> graduates;

    public ComputerScience(String name) {
        this.name = name;
        this.undergraduates = new ArrayList<>();
        this.graduates = new ArrayList<>();
    }
    /*
    public boolean addUndergraduateStudent (String ID, String firstName, String lastName, String major){
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
     */

    public void addUndergraduateStudent (String ID, String firstName, String lastName, String major){
            undergraduates.add(new Undergraduate(ID, firstName,lastName, major));
    }

    public void addGraduateStudent (String ID, String firstName, String lastName, String title){
            graduates.add(new Graduate(ID, firstName, lastName, title));
    }

    public Undergraduate findUndergraduate (String ID){
        for (Undergraduate undergraduate : undergraduates){
            if (undergraduate.getID() == ID) {
                return undergraduate;
            }
        }
        return null;
    }


/*
    private Undergraduate findUndergraduate (String ID){
        try {
            Scanner scanner = new Scanner(undergraduateFile);
            while (scanner.hasNextLine()){
                 String[] undergraduate = scanner.nextLine().split(" "); // {ID, firstName, lastName, major}
                 if (undergraduate[0].equals(ID)){
                     scanner.close();
                     return new Undergraduate(undergraduate[0],undergraduate[1],undergraduate[2],undergraduate[3]);
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

 */

    public String generateID (File fileName){
        try {
        Scanner scanner = new Scanner(fileName);

        String ID = null;
        if (scanner.hasNextLine()){
            while(scanner.hasNextLine()){
                ID = scanner.nextLine().split(" ")[0];
            }
            scanner.close();
            return String.valueOf(Integer.parseInt(ID)+1);

        }

        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return  "111";
    }


    public ArrayList<Undergraduate> getUndergraduates() {
        return undergraduates;
    }

    public ArrayList<Graduate> getGraduates() {
        return graduates;
    }
}
