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
public class Producer extends Thread {

    private String pType;

    private double totalPaid;
    private int daysGone;

    private DriveSection driveSection;
    private ProducerType producerType;

    public Producer(String pType, DriveSection driveSection, ProducerType producerType) {
        this.pType = pType;

        this.totalPaid = 0;
        this.daysGone = 0;

        this.driveSection = driveSection;
        this.producerType = producerType;
    }
    
    @Override
    public void run() {
        while(TLOUStudio.working) {
            try{
                if(this.pType != PTypes.noType) {
                    Semaphore semaphore = this.driveSection.getSemaphore();
                    this.daysGone += 1;
                    if(daysGone >= this.producerType.getdaysForDelivery()) {
                        semaphore.acquire();
                        this.driveSection.insertWork();
                        semaphore.release();
                        this.daysGone = 0;
                    }
                    this.payDay();
                }
                Thread.sleep(TLOUStudio.timeSleep);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
    
    private void payDay() {
        totalPaid += this.producerType.getSalary();
    }

    public String getPType() {
        return pType;
    }

    public void setPType(String pType) {
        this.pType = pType;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public DriveSection getDriveSection() {
        return driveSection;
    }

    public void setDriveSection(DriveSection driveSection) {
        this.driveSection = driveSection;
    }

    public ProducerType getProducerType() {
        return producerType;
    }

    public void setProducerType(ProducerType producerType) {
        this.producerType = producerType;
    }

}
