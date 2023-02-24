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
public class PM extends Thread{
    private volatile int daysToPublish;
    private float totalPay;
    private float dolarPerHour; 
   
    private final boolean active = true;
    private String pmState;
    private int faults;


    public PM (int daysToPublish) {
        this.daysToPublish = daysToPublish;
        this.faults = 0;
        this.dolarPerHour = 7;
        this.totalPay = 0;
    }
    
    
    /**
 *
 * Keeps Track of the days until launch of episodes
 */
    public void updateCounter(){
        try {
            setPmState("changing counter");
            Main.rm.getCounterMutex().acquire();
            setPmState("Cambiando contador");
            sleep((Main.rm.getDayDuration())/4); // 6 hours
            setDaysToPublish(getDaysToPublish()-1);

            String newValue = (String.valueOf(getDaysToPublish())+" días");
            GlobalUI.getMainPage().getRMDashBoard1().getDaysToLaunchLabel().setText(newValue);
            
            
            Main.rm.getCounterMutex().release();

            
        } catch (InterruptedException ex) {
            Logger.getLogger(PM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        public int getDaysToPublish() {
        return daysToPublish;
    }

    public void setDaysToPublish(int daysToPublish) {
        this.daysToPublish = daysToPublish;
    }

    @Override
    public void run() {
        
           while(this.active){
           
            payPmADay();
            updateCounter();
            restOfDay();

        }
    }
    
       /**
 *
 * Makes the PM watch series or work, alternating between the day
 * in intervalas of 20 minutes
 */
    public void restOfDay(){
        boolean work = true;
        
       
        for (int i = 0; i<54;i++) {
            if (work) {
                setPmState("Trabajando");
            } else {
                setPmState("Viendo series");
                if (Main.rm.getDirector().getDirectorState().equals("Vigilando al PM")) {
                Main.rm.getDirector().giveFaultToPm();       
                }
                    
            }
            work = !work;
            try {
                sleep((Main.rm.getDayDuration())/72); // 20 minutes intervals
            } catch (InterruptedException ex) {
                Logger.getLogger(PM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     public String getPmState() {
        return pmState;
    }



    public void setPmState(String state) {
        this.pmState = state;
        GlobalUI.getMainPage().getRMDashBoard1().getPmStateLabel().setText(state);
    }

    
        public float getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(float totalPay) {
        this.totalPay = totalPay;
        String label = "$"+String.valueOf(getTotalPay());
        GlobalUI.getMainPage().getRMDashBoard1().getPmSalaryLabel().setText(label);
    }

    public float getDolarPerHour() {
        return dolarPerHour;
    }

    public void setDolarPerHour(float dolarPerHour) {
        this.dolarPerHour = dolarPerHour;
    }
    
    public void payPmADay(){
        setTotalPay(getTotalPay()+(getDolarPerHour()*24));
     
    }
    
    public int getFaults() {
        return faults;
    }

    public void setFaults(int faults) {
        this.faults = faults;
        String label = (String.valueOf(faults) + " faltas");
        GlobalUI.getMainPage().getRMDashBoard1().getPmFaultsLabel().setText(label);
    }
    
    
}
