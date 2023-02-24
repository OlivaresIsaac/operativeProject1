/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.TLOU;

import classes.PTypes;
import java.util.concurrent.Semaphore;

/**
 *
 * @author dsre1
 */
public class Assembler extends Thread {

    private final Drive drive;

    private double totalPaid;
    private boolean isActive;
    private int daysGone;

    private final double salary;
    private final int daysForDelivery;

    public Assembler(Drive drive, boolean isActive) {
        this.drive = drive;

        this.totalPaid = 0;
        this.isActive = isActive;
        this.daysGone = 0;

        this.salary = 8;
        this.daysForDelivery = 2;
    }

    @Override
    public void run() {
        while (TLOUStudio.isWorking) {
            try {
                if (isActive) {
                    Semaphore semaphore = this.drive.getSemaphore();

                    this.daysGone += 1;

                    if (this.daysGone >= this.daysForDelivery) {
                        semaphore.acquire();
                        if (this.drive.allPartsValidation()) {
                            this.drive.excludeParts();
                            System.out.print("chapter" + ": " + this.drive.getChapterSection().getCurrent());
                            this.drive.getChapterSection().insertWork(1);
//                            System.out.print("chapter" + ": " + this.drive.getChapterSection().getCurrent());
//                            System.out.print("\n");
                            this.daysGone = 0;
                        }
                        semaphore.release();
                    }

                    this.payDay();
                }
                Thread.sleep(TLOUStudio.timeSleep);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    private void payDay() {
        this.totalPaid += this.salary * 24;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public double getSalary() {
        return salary;
    }
    
    
}
