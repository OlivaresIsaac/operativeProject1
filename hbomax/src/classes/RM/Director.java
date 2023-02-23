/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.RM;

import classes.GlobalUI;
import classes.Main;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author isaac
 */
public class Director extends Thread{
    private float totalPay;
    private float dailyPay;
    private final boolean active = true;
    private int normalChaptersAcc;
    private int twistChaptersAcc;
    private String directorState;
    private int originalLaunchDays;


    
    public Director(int originalLaunchDays) {
    this.dailyPay = 100;
    this.totalPay = 0;
    this.originalLaunchDays = originalLaunchDays;
    }
    
        @Override
    public void run() {
        
         while(this.active){
            try {
            payDirectorADay();
            boolean reportToHBOmax = checkCounter();
            if (reportToHBOmax) {
                // codigo de entrega
                launchChapters();
                
            } else {
                normalWork();
                // codigo de revisión
            }
            
            sleep(Main.rm.getDayDuration()); // this should change
         
            } catch (InterruptedException ex){
                System.out.println("error");
            }
        
      
        }
    }
    
       /**
     * Gives the chapter to HBO max and updates UI
     */
    public void launchChapters(){
        try {
            // hace entrega de capitulos
            
            sleep(Main.rm.getDayDuration());
        } catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
       /**
       * Works most of the day, and checks the PM in randoms periods of time
     */
    public void normalWork(){
        
    }
    
    
    /**
 *Checks the day counter of the PM, if its 0 resets it
     * @return boolean
 */
    public boolean checkCounter(){
        try {
            Main.rm.getCounterMutex().acquire();
            if (Main.rm.getPm().getDaysToPublish() <= 0) {
                Main.rm.getPm().setDaysToPublish(getOriginalLaunchDays());
                launchAccChapters();
                Main.rm.getCounterMutex().release();
                return true;
            }
            Main.rm.getCounterMutex().release();
            return false;
           
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public float getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(float totalPay) {
        this.totalPay = totalPay;
    }

    public float getDailyPay() {
        return dailyPay;
    }

    public void setDailyPay(float dailyPay) {
        this.dailyPay = dailyPay;
    }
    
    public void payDirectorADay(){
        setTotalPay(getTotalPay()+getDailyPay());
    }
    
     public int getNormalChaptersAcc() {
        return normalChaptersAcc;
    }

    public void setNormalChaptersAcc(int normalChaptersAcc) {
        this.normalChaptersAcc = normalChaptersAcc;
    }

    public int getTwitChaptersAcc() {
        return twistChaptersAcc;
    }

    public void setTwistChaptersAcc(int twitChaptersAcc) {
        this.twistChaptersAcc = twitChaptersAcc;
    }

    public String getDirectorState() {
        return directorState;
    }

    public void setDirectorState(String directorState) {
        this.directorState = directorState;
        GlobalUI.getMainPage().getRMDashBoard1().getDirectorStateLabel().setText(directorState);
    }
    
    public int getOriginalLaunchDays() {
        return originalLaunchDays;
    }

    public void setOriginalLaunchDays(int originalLaunchDays) {
        this.originalLaunchDays = originalLaunchDays;
    }
    
    public void addChapterWithTwist(){
        setTwistChaptersAcc(getTwitChaptersAcc()+1);
    }
    
    public void addNormalChapter(){
        setNormalChaptersAcc(getNormalChaptersAcc()+1);
    }
    
    
        /**
 * Launch all chapters made when the deadline meets, also
 * changes the ui label
 */
    public void launchAccChapters(){
        GlobalUI.getMainPage().getRMDashBoard1().getRegularChapterLaunchLabel().setText(String.valueOf(getNormalChaptersAcc()));
        GlobalUI.getMainPage().getRMDashBoard1().getTwistChapterLaunchLabel().setText(String.valueOf(getTwitChaptersAcc()));
        float totalIncomeThisLaunch = Main.rm.getLaunchIncome();
        String sufix = (totalIncomeThisLaunch >= 1000) ? "M" : "K"; 
        float formatedIncome = (totalIncomeThisLaunch >= 1000) ? (totalIncomeThisLaunch/1000) : totalIncomeThisLaunch;
        // 
        String launchIncomeLabel = ("$"+String.valueOf(Math.round(formatedIncome*100)/100)+sufix);

        GlobalUI.getMainPage().getRMDashBoard1().getLaunchIncomeLabel().setText(launchIncomeLabel);
        setNormalChaptersAcc(0);
        setTwistChaptersAcc(0);
    }
    
}
