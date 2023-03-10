/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.RM.DriveObject;
import classes.TLOU.TLOUStudio;
import interfaces.PieChart;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import org.jfree.chart.JFreeChart;

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
    public static DriveObject[] loadStudioInitialParameters(String direction){
        DriveObject[] formatedParameters = new DriveObject[6];
        String data = loadTextFromFile(direction);
        System.out.println(data);
        String[] dataFragment = data.split("\n");
        for (int i = 0; i<dataFragment.length; i++){
            String[] partParameters = dataFragment[i].split(",");
            DriveObject wholePart = new DriveObject(partParameters[0],Integer.parseInt(partParameters[1]),Integer.parseInt(partParameters[2]), Integer.parseInt(partParameters[3]));
            formatedParameters[i] = wholePart;
        }
        
        return formatedParameters;
            
    }
    
    
        /**
     * Returns an array of 2 main parameters, ms of a day 
     * and days until launch
     * @return parameters[]
 */
    public static int[] loadGeneralInitialParameters(){
        String direction = "src\\assets\\initialParametersGeneral.txt";
        String data = loadTextFromFile(direction);
        String[] split = data.split(",");
        int [] values = new int[2];

        values[0] = Integer.parseInt(split[0].replace("\n", ""));
        values[1] = Integer.parseInt(split[1].replace("\n", ""));

        String newValue = (String.valueOf(values[1])+" días");
        GlobalUI.getMainPage().getRMDashBoard1().getDaysToLaunchLabel().setText(newValue);
        GlobalUI.getMainPage().getTLOUDashBoard().getDaysToLaunchLabel().setText(newValue);
        FunctionsUI.updateDaytoLaunchAndDayTime(values[1], (values[0]/1000));
        
        return values;
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
      /**
     * Saves all initial parameters into their respective TXT
     * @param durationDayinSec
     * @param daysToLaunch
     * @param driveMax
     * @param rmProducersQty
     * @param tlouProducersQty
 */
    public static void saveInitialParameters(int durationDayinSec, int daysToLaunch, int[] driveMax, int[] rmProducersQty, int []tlouProducersQty){
        int durationDayInms = durationDayinSec*1000;
        String path = "src\\assets\\initialParametersGeneral.txt";
        String generalParamters = (String.valueOf(durationDayInms)+","+String.valueOf(daysToLaunch));
        
        try {
            PrintWriter pw = new PrintWriter(path);
            pw.print(generalParamters);
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la información");
        }
        saveInitialParametersRM(driveMax, rmProducersQty);
        saveInitialParametersTLOU(driveMax, tlouProducersQty);
        JOptionPane.showMessageDialog(null, "Guardado Éxitoso!");
        FunctionsUI.updateDaytoLaunchAndDayTime(daysToLaunch, durationDayinSec);
        Main.rm.setDayDuration(durationDayInms);
        Main.rm.getPm().setDaysToPublish(daysToLaunch);
        Main.rm.getDirector().setOriginalLaunchDays(daysToLaunch);
        
        TLOUStudio.timeSleep = durationDayInms;
        Main.tlou.getCounter().setOriginalCountdown(daysToLaunch);
    }
          /**
     * Saves all initial parameters of RmStudio into their respective TXT
     * @param driveMax
     * @param rmProducersQty
 */
    public static void saveInitialParametersRM(int[] driveMax, int[] rmProducersQty){
       String parameters = "";
       for (int i = 0; i<driveMax.length; i++) {
           parameters+=(PTypes.getChapterPartByOrder(i)+","+"0"+","+driveMax[i]+","+rmProducersQty[i]+"\n");
       }
       String path = "src\\assets\\initialParametersRM.txt";
        try {
            PrintWriter pw = new PrintWriter(path);
            pw.print(parameters);
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la información");
        }
        Main.rm.updateSpinnerAndProducersType(rmProducersQty);
//        JFreeChart newProducerChart = PieChart.createProducersPieChart("Productores", rmProducersQty);
        GlobalUI.getMainPage().getRMDashBoard1().getProducerPie().setChart(PieChart.createChart(PieChart.createDataset(rmProducersQty), "Productores"));
        Main.rm.getDrive().updateDriveMaxLabels(driveMax);
        Main.rm.setMonthlySalaries();
       
        
    }
    
              /**
     * Saves all initial parameters of TLOU Studio into their respective TXT
     * @param driveMax
     * @param tlouProducersQty
 */
    public static void saveInitialParametersTLOU(int[] driveMax, int []tlouProducersQty){
               String parameters = "";
       for (int i = 0; i<driveMax.length; i++) {
           parameters+=(PTypes.getChapterPartByOrder(i)+","+"0"+","+driveMax[i]+","+tlouProducersQty[i]+"\n");
       }
       String path = "src\\assets\\initialParametersTLOU.txt";
        try {
            PrintWriter pw = new PrintWriter(path);
            pw.print(parameters);
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la información");
        }
        
       
        Main.tlou.updateSpinnerAndProducersType(tlouProducersQty);
        GlobalUI.getMainPage().getTLOUDashBoard().getProducerPie().setChart(PieChart.createChart(PieChart.createDataset(tlouProducersQty), "Productores"));
        Main.tlou.getDrive().updateDriveMaxLabels(driveMax);
//        Main.tlou.getCounter().setSalaryPerMonth(Main.tlou.getPaid());
        // monthly
    
    }
}
