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

    private final Counter counter;
    private final Director director;

    private double totalPaid;
    private boolean isWorking;

    private int workingTime;
    private float intervalTime;

    private double salary;

    public Manager(Counter counter, Director director) {
        this.counter = counter;
        this.director = director;

        this.totalPaid = 0;
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
                    if (!this.isWorking && this.director.getIsChecking()) {
                        discountToday += 1;
                    }
                    Thread.sleep(sleepIntervalTime);
                }

                this.isWorking = true;
                this.discountTotalPaid(discountToday);
                this.payDay();

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
        this.totalPaid += this.salary;
    }

    public boolean getIsWorking() {
        return isWorking;
    }

}
