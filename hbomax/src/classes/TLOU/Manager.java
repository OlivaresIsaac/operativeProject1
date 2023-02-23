/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.TLOU;

import java.util.concurrent.Semaphore;

/**
 *
 * @author dsre1
 */
public class Manager extends Thread {
    
    private Counter counter;
    
    private double totalPaid;
    private boolean isWorking;

    private int workingTime;
    private double intervalTime;
    
    private double salary;

    public Manager(Counter counter) {
        this.counter = counter;
        
        this.totalPaid = 0;
        this.isWorking = true;
        
        this.workingTime = 7;
        this.intervalTime = 0.35;
        this.salary = 7;
    }
    
    public void run() {
        while(TLOUStudio.working) {
            try{
                Semaphore semaphore = this.counter.getSemaphore();
                semaphore.acquire();
                Thread.sleep(this.relativeTime(this.workingTime));
                this.counter.dayPassed();
                semaphore.release();
                
                int restOfTheDay = 24 - this.workingTime;
                int numIntervals = (int) (restOfTheDay / intervalTime);
                
                for (int i = 0; i < numIntervals; i++) {
                    this.isWorking = !this.isWorking;
                    Thread.sleep(this.relativeTime(this.intervalTime));
                }
                
                this.isWorking = true;
                this.payDay();
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    
    private int relativeTime(double time) {
        return (int) ((TLOUStudio.timeSleep * time) / 24);
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public int getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }
    
    public void payDay() {
        this.totalPaid += this.salary;
    }

}
