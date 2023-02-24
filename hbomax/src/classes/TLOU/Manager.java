/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.TLOU;

import classes.GlobalUI;
import java.util.concurrent.Semaphore;

/**
 *
 * @author dsre1
 */
public class Manager extends Thread {

    private final Counter counter;
    private final Director director;

    private double totalPaid;
    private int totalFaults;

    private boolean isWorking;

    private int workingTime;
    private float intervalTime;

    private double salary;

    public Manager(Counter counter, Director director) {
        this.counter = counter;
        this.director = director;

        this.totalPaid = 0;
        this.totalFaults = 0;
        this.isWorking = true;

        this.workingTime = 7;
        this.intervalTime = (float) 21 / (float) 60;
        this.salary = 7;
    }

    @Override
    public void run() {
        while (TLOUStudio.isWorking) {
            try {
                Semaphore semaphore = this.counter.getSemaphore();

                int sleepWorkingTime = this.relativeTime(this.workingTime);

                semaphore.acquire();
                GlobalUI.getMainPage().getTLOUDashBoard().getManagerStateLabel().setText("Cambiando contador");
                Thread.sleep(sleepWorkingTime);
                if (this.counter.getCountdown() != 0) {
                    this.counter.dayPassed();
                }
                semaphore.release();

                int sleepIntervalTime = this.relativeTime(this.intervalTime);

                int numIntervals = (int) ((TLOUStudio.timeSleep - sleepWorkingTime) / sleepIntervalTime);
                int discountToday = 0;

                for (int i = 0; i < numIntervals; i++) {
                    this.isWorking = !this.isWorking;
                    if (this.isWorking) {
                        GlobalUI.getMainPage().getTLOUDashBoard().getManagerStateLabel().setText("Trabajando");
                    } else {
                        GlobalUI.getMainPage().getTLOUDashBoard().getManagerStateLabel().setText("Viendo series");
                    }
                    if (!this.isWorking && this.director.getIsChecking()) {
                        discountToday += 1;
                    }
                    Thread.sleep(sleepIntervalTime);
                }

                this.isWorking = true;
                GlobalUI.getMainPage().getTLOUDashBoard().getManagerStateLabel().setText("Trabajando");

                this.totalFaults += discountToday;
                GlobalUI.getMainPage().getTLOUDashBoard().getManagerFaultsLabel().setText(String.valueOf(this.totalFaults) + " faltas");
                
                this.discountTotalPaid(discountToday);

                this.payDay();
                GlobalUI.getMainPage().getTLOUDashBoard().getManagerSalaryLabel().setText(String.valueOf("$" + this.totalPaid) );

                int restOfTheDay = TLOUStudio.timeSleep - sleepWorkingTime - (sleepIntervalTime * numIntervals);

                Thread.sleep(restOfTheDay);

            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public void discountTotalPaid(int discount) {
        this.totalPaid -= discount;
    }

    private int relativeTime(float time) {
        return (int) ((TLOUStudio.timeSleep * time) / (float) 24);
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void payDay() {
        this.totalPaid += this.salary * 24;
    }

    public boolean getIsWorking() {
        return isWorking;
    }

}
