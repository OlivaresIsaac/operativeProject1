/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.RM;

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
    private int twitChaptersAcc;
    private boolean directorState;
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
            } else {
                // codigo de revisión
            }
            
            sleep(Main.rm.getDayDuration());
         
            } catch (InterruptedException ex){
                System.out.println("error");
            }
        
      
        }
    }
    
    
    /**
 *Checks the day counter of the PM, if its 0 resets it
     * @return 
 */
    public boolean checkCounter(){
        try {
            Main.rm.getCounterMutex().acquire();
            if (Main.rm.getPm().getDaysToPublish() == 0) {
                Main.rm.getPm().setDaysToPublish(getOriginalLaunchDays());
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
        return twitChaptersAcc;
    }

    public void setTwitChaptersAcc(int twitChaptersAcc) {
        this.twitChaptersAcc = twitChaptersAcc;
    }

    public boolean isDirectorState() {
        return directorState;
    }

    public void setDirectorState(boolean directorState) {
        this.directorState = directorState;
    }
    
    public int getOriginalLaunchDays() {
        return originalLaunchDays;
    }

    public void setOriginalLaunchDays(int originalLaunchDays) {
        this.originalLaunchDays = originalLaunchDays;
    }
    
}
