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
                boolean isZero = false;

                semaphore.acquire();
                isZero = this.counter.getCountdown() == 0;
                semaphore.release();

                if (isZero) {
                    this.drive.resetChapterDrive();
                    this.counter.resetCountdown();

                    Thread.sleep(TLOUStudio.timeSleep);
                    
                    System.out.print("a");

                } else {
                    int randomNumber1 = this.getRandomNumber(12, 18);
                    int sleepTime = this.relativeTime(randomNumber1);

                    Thread.sleep(sleepTime);

                    float randomNumber2 = ((float) this.getRandomNumber(30, 90) / (float) 60);
                    int sleepCheckingTime = this.relativeTime(randomNumber2);

                    this.isChecking = true;

                    Thread.sleep(sleepCheckingTime);

                    this.isChecking = false;

                    int restOfTheDay = TLOUStudio.timeSleep - sleepTime - sleepCheckingTime;

                    Thread.sleep(restOfTheDay);
                    
                    System.out.print("b");
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

}
