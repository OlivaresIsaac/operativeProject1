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

    private Drive drive;
    private ProducerTypes producerTypes;

    public Producer(String pType, Drive drive, ProducerTypes producerTypes) {
        this.pType = pType;

        this.totalPaid = 0;
        this.daysGone = 0;

        this.drive = drive;
        this.producerTypes = producerTypes;
    }

    @Override
    public void run() {
        while (TLOUStudio.isWorking) {
            try {
                if (!this.pType.equals(PTypes.noType)) {
                    Semaphore semaphore = this.drive.getSemaphore();
                    DriveSection producerSection = this.drive.getProducerSection(this.pType);
                    ProducerType producerType = this.producerTypes.getProducerType(this.pType);

                    this.daysGone += 1;

                    if (this.daysGone >= producerType.getdaysForDelivery()) {
                        semaphore.acquire();
                        if (producerSection.partValidation()) {
                            producerSection.insertWork();
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
        ProducerType producerType = this.producerTypes.getProducerType(this.pType);

        this.totalPaid += producerType.getSalary();
    }

    public String getPType() {
        return this.pType;
    }

    public void setPType(String pType) {
        this.pType = pType;
    }

    public double getTotalPaid() {
        return this.totalPaid;
    }

}
