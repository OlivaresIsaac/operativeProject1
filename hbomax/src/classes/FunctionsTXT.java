/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.RM.DriveObject;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author isaac
 */
public class FunctionsTXT {
    
    /**
     * Converts a String from loadTextFromFile and converts it
     * into an array of DriveObjects
     * @param direction
     * @return DriveObject[]
 */
    public static DriveObject[] loadInitialParameters(String direction){
        DriveObject[] formatedParamters = new DriveObject[6];
        String data = loadTextFromFile(direction);
        System.out.println(data);
        String[] dataFragment = data.split("\n");
        for (int i = 0; i<dataFragment.length; i++){
            String[] partParameters = dataFragment[i].split(",");
            DriveObject wholePart = new DriveObject(partParameters[0],Integer.parseInt(partParameters[1]),Integer.parseInt(partParameters[2]));
            formatedParamters[i] = wholePart;
        }
        
        return formatedParamters;
            
    }
    
   /**
     * Given a path reads a file and converts its content
     * into a string
     * @param direction
     * @return String
 */
    public static String loadTextFromFile(String direction){
        String text = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direction));
            String currentLine;
            while ((currentLine = bf.readLine()) != null) {
               text += (currentLine+"\n");
            }
        } catch (Exception e) {
            text = "";
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }

        return text;
    }
}
