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


    
    
    public PM (int daysToPublish) {
        this.daysToPublish = daysToPublish;
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
            try {
            payPmADay();
            
                
            updateCounter();
            sleep(Main.rm.getDayDuration());
         
            } catch (InterruptedException ex){
                System.out.println("error");
            }
        
      
        }
    }
    
     public String getPmState() {
        return pmState;
    }



    public void setPmState(String state) {
        this.pmState = state;
    }

    
        public float getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(float totalPay) {
        this.totalPay = totalPay;
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
    
    
}
