/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.RM;

import classes.PTypes;
import java.util.concurrent.Semaphore;

/**
 *
 * @author isaac
 */
public class Drive {
    private final DriveObject[] driveSections;
    final private Semaphore driveSemaphore = new Semaphore(1);

    public DriveObject[] getDriveSections() {
        return driveSections;
    }
    
        public Semaphore getDriveSemaphore() {
        return driveSemaphore;
    }


    public Drive(DriveObject[] currentParameters) {
        this.driveSections = currentParameters;
    }
    
    public void showDriveParts(){
        System.out.println("Drive Parts:\n");
        for(int i = 0; i < getDriveSections().length; i++){
            System.out.println(i+". "+getDriveSections()[i].getPartName()+ " Produced: " + getDriveSections()[i].getProducedQty()+"GB. of Max: "+getDriveSections()[i].getMaxCapacity()+" GB");
        }
    }
    
    
    /**
 *Given the partName and the production qty adds it to the drive storage
 * returns a boolean to indicate if the operation was completed sucessfully
     * @param partName
     * @param production
     * @param isChapterWithTwist
 */
    public void addProduction(String partName, int production, boolean isChapterWithTwist){
        if (partName.equals(PTypes.noType)) {
            return;
        }
        
        // agregar parte que considera al chapter, y restar de las otras partes
        // considerar un contador para saber cuando toca twist
        
        for (DriveObject section : getDriveSections()) {
            if (section.getPartName().equals(partName)) {
                if (section.isSpaceAvailable()) {
                    if (partName.equals(PTypes.chapter)) {
                        // create chapter
                        if (isChapterWithTwist) {
                            if (arePartsForTwistChapterAvailable()) {
                                produceTwistChapter();
                            }
                        } else {
                            // normal chapter
                            if (arePartsForNormalChapterAvailable()) {
                                 produceNormalChapter();
                            }
                        }
                    } else {
                        // add new part to drive
                        section.setProducedQty(section.getProducedQty()+production);
                    
                    }
                        return;
                }
                return;
            }
        }
        System.out.println("no se encontró la sección: "+partName);
    }
    
    public boolean arePartsForNormalChapterAvailable(){
        boolean canProceed = true;
        
        for (DriveObject chapterPart : getDriveSections()) {
            if (chapterPart.getPartName().equals(PTypes.intro)) {
                if (chapterPart.getProducedQty() <= 0) {
                    canProceed = false;
                    break;
                }
            } else if (chapterPart.getPartName().equals(PTypes.start)) {
                if (chapterPart.getProducedQty() <= 1) {
                    canProceed = false;
                    break;
                }
            } else if (chapterPart.getPartName().equals(PTypes.credit)) {
                if (chapterPart.getProducedQty() <= 0) {
                    canProceed = false;
                    break;
                } 
            } else if (chapterPart.getPartName().equals(PTypes.end)) {
                if (chapterPart.getProducedQty() <= 0) {
                    canProceed = false;
                    break;
                }
            }
        }
        
        return canProceed;
    }
    
       public boolean arePartsForTwistChapterAvailable(){
         boolean canProceed = true;
        
        for (DriveObject chapterPart : getDriveSections()) {
            if (chapterPart.getPartName().equals(PTypes.intro)) {
                if (chapterPart.getProducedQty() <= 0) {
                    canProceed = false;
                    break;
                }
            } else if (chapterPart.getPartName().equals(PTypes.start)) {
                if (chapterPart.getProducedQty() <= 1) {
                    canProceed = false;
                    break;
                }
            } else if (chapterPart.getPartName().equals(PTypes.credit)) {
                if (chapterPart.getProducedQty() <= 0) {
                    canProceed = false;
                    break;
                } 
            } else if (chapterPart.getPartName().equals(PTypes.twist)) {
                if (chapterPart.getProducedQty() <= 0) {
                    canProceed = false;
                    break;
                }
            }
        }
        
        return canProceed;
    }
       
    public void produceNormalChapter(){
        
        for (DriveObject chapterPart : getDriveSections()) {
            if (chapterPart.getPartName().equals(PTypes.intro)) {
                chapterPart.setProducedQty(chapterPart.getProducedQty()-1);
            } else if (chapterPart.getPartName().equals(PTypes.start)) {
                chapterPart.setProducedQty(chapterPart.getProducedQty()-2);
            } else if (chapterPart.getPartName().equals(PTypes.credit)) {
                chapterPart.setProducedQty(chapterPart.getProducedQty()-1);
            } else if (chapterPart.getPartName().equals(PTypes.end)) {
                chapterPart.setProducedQty(chapterPart.getProducedQty()-1);
            }
            
            if (chapterPart.getPartName().equals(PTypes.chapter)) {
                 chapterPart.setProducedQty(chapterPart.getProducedQty()+1);
            }
        }
        
    }
        
    public void produceTwistChapter(){
        
        for (DriveObject chapterPart : getDriveSections()) {
            if (chapterPart.getPartName().equals(PTypes.intro)) {
                chapterPart.setProducedQty(chapterPart.getProducedQty()-1);
            } else if (chapterPart.getPartName().equals(PTypes.start)) {
                chapterPart.setProducedQty(chapterPart.getProducedQty()-2);
            } else if (chapterPart.getPartName().equals(PTypes.credit)) {
                chapterPart.setProducedQty(chapterPart.getProducedQty()-1);
            } else if (chapterPart.getPartName().equals(PTypes.twist)) {
                chapterPart.setProducedQty(chapterPart.getProducedQty()-1);
            }
            
             if (chapterPart.getPartName().equals(PTypes.chapter)) {
                 chapterPart.setProducedQty(chapterPart.getProducedQty()+1);
            }
        }
        
    }
    
    
}
