package sa.edu.upm;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ComputerScience {
    private String name;

    private ArrayList<Undergraduate> undergraduates;
    private ArrayList<Graduate> graduates;

    public ComputerScience(String name) {
        this.name = name;
        this.undergraduates = new ArrayList<>();
        this.graduates = new ArrayList<>();
    }

    public void addUndergraduateStudent (String ID, String firstName, String lastName, String major){
            undergraduates.add(new Undergraduate(ID, firstName,lastName, major));
    }

    public void addGraduateStudent (String ID, String firstName, String lastName, String title){
            graduates.add(new Graduate(ID, firstName, lastName, title));
    }

    public Undergraduate findUndergraduate (String ID){
        for (int i = 0 ; i<undergraduates.toArray().length; i ++){
            if (undergraduates.get(i).getID().equals(ID)){
                return undergraduates.get(i);
            }
        }
        return null; // return null if find nothing.
    }

    public Graduate findGraduate (String ID){
        for (int i = 0 ; i<graduates.toArray().length; i++){
            if (graduates.get(i).getID().equals(ID)){
                return graduates.get(i);
            }
        }
        return null; // return null if find nothing.
    }


    public String generateID (File fileName){
        try {
            Scanner scanner = new Scanner(fileName);

            String ID = null;
            if (scanner.hasNextLine()){
                while(scanner.hasNextLine()){ // while loop to get the last ID in the file.
                    ID = scanner.nextLine().split(" ")[0];
                }
                scanner.close();
                return String.valueOf(Integer.parseInt(ID)+1);

            }

        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return  "111"; // if file is empty return the first ID 111.
    }


    public ArrayList<Undergraduate> getUndergraduates() {
        return undergraduates;
    }

    public ArrayList<Graduate> getGraduates() {
        return graduates;
    }

    public String getName() {
        return name;
    }
}
