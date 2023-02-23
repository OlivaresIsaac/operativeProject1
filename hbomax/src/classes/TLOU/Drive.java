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
    
    private final int numProducerSections;
    private final DriveSection[] producerSections;
    
    private final DriveSection chapterSection;
    
    private final Semaphore semaphore;
    
    public Drive(int numProducerSections) {
        
        this.numProducerSections = numProducerSections;
        this.producerSections = this.setProducerSections();
        
        this.chapterSection = this.setChapterSection();
        
        this.semaphore = new Semaphore(1);
    }
    
    private boolean isCapWithPlotTwist() {
        return this.chapterSection.getCurrent() % 5 == 0;
    }
    
    public boolean allPartsValidation() {
        for (int i = 0; i < this.numProducerSections; i++) {
            DriveSection producerSection = this.producerSections[i];
            if (!this.isCapWithPlotTwist() && producerSection.getPType().equals(PTypes.twist)) {
                continue;
            }
            if (producerSection.getCurrent() < 1) {
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
        this.chapterSection.insertWork();
    }
    
    private DriveSection[] setProducerSections() {
        DriveSection intro = new DriveSection(PTypes.intro, 30);
        DriveSection credit = new DriveSection(PTypes.credit, 25);
        DriveSection start = new DriveSection(PTypes.start, 50);
        DriveSection end = new DriveSection(PTypes.end, 55);
        DriveSection twist = new DriveSection(PTypes.twist, 40);

        DriveSection[] aux = {intro, credit, start, end, twist};

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
    
    private DriveSection setChapterSection() {
        // TODO PONER CHAPTER COMO SIN LIMITE
        DriveSection chapter = new DriveSection(PTypes.chapter, 100);
        
        return chapter;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public DriveSection getChapterSection() {
        return chapterSection;
    }
    
}
