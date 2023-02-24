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
public class Drive {

    private Counter counter;

    private final int numProducerSections;
    private final DriveSection[] producerSections;

    private final DriveSection chapterSection;

    private final Semaphore semaphore;

    public Drive(Counter counter, int numProducerSections, int [] maxDrive) {
        this.counter = counter;

        this.numProducerSections = numProducerSections;
        this.producerSections = this.setProducerSections(maxDrive);

        this.chapterSection = this.setChapterSection(maxDrive[5]);

        this.semaphore = new Semaphore(1);
    }

    private boolean isCapWithPlotTwist() {
        return (this.chapterSection.getCurrent() + 1) % 5 == 0;
    }

    public void resetChapterDrive() {
        this.chapterSection.setCurrent(0);
    }

    public boolean allPartsValidation() {
        for (int i = 0; i < this.numProducerSections; i++) {
            DriveSection producerSection = this.producerSections[i];

            if (!this.isCapWithPlotTwist() && producerSection.getPType().equals(PTypes.twist)) {
                continue;
            }
            if (producerSection.getCurrent() < producerSection.getNeededToChapter()) {
                return false;
            }
        }
        return true;
    }

    public void excludeParts() {
        for (int i = 0; i < this.numProducerSections; i++) {
            DriveSection producerSection = this.producerSections[i];
            if (!this.isCapWithPlotTwist() && producerSection.getPType().equals(PTypes.twist)) {
                continue;
            }
            producerSection.excludeWork();
        }
    }

    public void insertChapter() {
        this.chapterSection.insertWork(1);
    }

    private DriveSection[] setProducerSections(int [] driveMax) {
        DriveSection intro = new DriveSection(PTypes.intro, this.counter, driveMax[0], 1);
        DriveSection start = new DriveSection(PTypes.start, this.counter, driveMax[1], 2);
        DriveSection credit = new DriveSection(PTypes.credit, this.counter, driveMax[2], 1);
        DriveSection twist = new DriveSection(PTypes.twist, this.counter, driveMax[3], 2);
        DriveSection end = new DriveSection(PTypes.end, this.counter, driveMax[4], 2);
       

        DriveSection[] aux = {intro, start, credit, twist, end };

        return aux;
    }

    public DriveSection getProducerSection(String pType) {
        for (int i = 0; i < this.numProducerSections; i++) {
            DriveSection aux = this.producerSections[i];
            if (aux.getPType().equals(pType)) {
                return aux;
            }
        }
        return null;
    }

    private DriveSection setChapterSection(int chaptersLimit) {
        // TODO: PONER CHAPTER COMO SIN LIMITE
        DriveSection chapter = new DriveSection(PTypes.chapter, this.counter, 100, chaptersLimit);

        return chapter;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public DriveSection getChapterSection() {
        return chapterSection;
    }
    
    
    public void updateDriveMaxLabels(int[] driveMax){
         for (int i = 0; i<this.producerSections.length; i++) {
            
             this.producerSections[i].setLimit(driveMax[i]);
             
            if (driveMax[i] == -1) {
                this.producerSections[i].setLimitInterface("Sin límite");
                this.producerSections[i].setLimited(false);
              
            } else {
                this.producerSections[i].setLimitInterface(String.valueOf(driveMax[i]));
              this.producerSections[i].setLimited(true);
            }
        }
    }
    

}
