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
public class Director extends Thread {

    private Counter counter;
    private Drive drive;

    private double totalPaid;

    private final double salary;

    private boolean isChecking;

    public Director(Counter counter, Drive drive) {
        this.counter = counter;
        this.drive = drive;

        this.totalPaid = 0;

        this.salary = 100;

        this.isChecking = false;
    }

    public void run() {
        while (TLOUStudio.isWorking) {
            try {
                Semaphore semaphore = this.counter.getSemaphore();
                int localTimeSleep = TLOUStudio.timeSleep;
                boolean isZero = false;
                

                semaphore.acquire();
                isZero = this.counter.getCountdown() == 0;
                semaphore.release();

                if (isZero) {
                    GlobalUI.getMainPage().getTLOUDashBoard().getDirectorStateLabel().setText("Entregando los capítulos");
                    this.drive.resetChapterDrive();
                    this.counter.resetCountdown();
                    this.counter.updateTotalGain();

                    Thread.sleep(localTimeSleep);
                    GlobalUI.getMainPage().getTLOUDashBoard().getDirectorStateLabel().setText("Trabajando");

                } else {
                    int randomNumber1 = this.getRandomNumber(12, 18);
                    int sleepTime = this.relativeTime(randomNumber1);

                    Thread.sleep(sleepTime);

                    float randomNumber2 = ((float) this.getRandomNumber(30, 90) / (float) 60);
                    int sleepCheckingTime = this.relativeTime(randomNumber2);

                    this.isChecking = true;
                    
                    GlobalUI.getMainPage().getTLOUDashBoard().getDirectorStateLabel().setText("Vigilando a PM");
                    Thread.sleep(sleepCheckingTime);

                    this.isChecking = false;
                    
                    GlobalUI.getMainPage().getTLOUDashBoard().getDirectorStateLabel().setText("Trabajando");
                    int restOfTheDay = localTimeSleep - sleepTime - sleepCheckingTime;

                    Thread.sleep(restOfTheDay);
                }

                this.payDay();

            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    private int relativeTime(float time) {
        return (int) ((TLOUStudio.timeSleep * time) / (float) 24);
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public boolean getIsChecking() {
        return isChecking;
    }

    public void payDay() {
        this.totalPaid += this.salary;
    }

    public double getSalary() {
        return salary;
    }
    
    

}
