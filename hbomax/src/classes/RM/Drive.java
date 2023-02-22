/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.RM;

import classes.GlobalUI;
import classes.Main;
import classes.PTypes;
import java.util.concurrent.Semaphore;
import javax.swing.JLabel;

/**
 *
 * @author isaac
 */
public final class Drive {
    private final DriveObject[] driveSections;
    final private Semaphore driveSemaphore = new Semaphore(1);
    private final JLabel[] uiDriveQtyLabels = new JLabel[5];
    private final JLabel totalChapters = GlobalUI.getMainPage().getRMDashBoard1().getTotalChapterQty();

    public JLabel getTotalChapters() {
        return totalChapters;
    }


    private final JLabel[] uiDriveMaxLabels = new JLabel[5];
    
    public Drive(DriveObject[] currentParameters) {
        this.driveSections = currentParameters;
        fillDriveQtyLabels();
        fillDriveMaxLabels();
    }
    
        public JLabel[] getUiDriveQtyLabels() {
        return uiDriveQtyLabels;
    }

    public JLabel[] getUiDriveMaxLabels() {
        return uiDriveMaxLabels;
    }


    public DriveObject[] getDriveSections() {
        return driveSections;
    }
    
        public Semaphore getDriveSemaphore() {
        return driveSemaphore;
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
        
        int count = 0;
        
        for (DriveObject section : getDriveSections()) {
            if (section.getPartName().equals(partName)) {
                if (section.isSpaceAvailable()) {
                    if (partName.equals(PTypes.chapter)) {
                        // create chapter
                        if (isChapterWithTwist) {
                            if (arePartsForTwistChapterAvailable()) {
                                produceTwistChapter();
                                Main.rm.setPlotTwistChapterCounter(0);
                                int chapterQty = Integer.parseInt(GlobalUI.getMainPage().getRMDashBoard1().getTwistChapterQty().getText());
                                GlobalUI.getMainPage().getRMDashBoard1().getTwistChapterQty().setText(String.valueOf(chapterQty + 1));
                            }
                        } else {
                            // normal chapter
                            if (arePartsForNormalChapterAvailable()) {
                                 produceNormalChapter();
                                 int chapterQty = Integer.parseInt(GlobalUI.getMainPage().getRMDashBoard1().getNormalChapterQty().getText());
                                 GlobalUI.getMainPage().getRMDashBoard1().getNormalChapterQty().setText(String.valueOf(chapterQty + 1));
                                 Main.rm.newChapterCreated();
                            }
                        }
                        getTotalChapters().setText(String.valueOf(section.getProducedQty()));
                        
                    } else {
                        // add new part to drive
                        section.setProducedQty(section.getProducedQty()+production);
                        getUiDriveQtyLabels()[count].setText(String.valueOf(section.getProducedQty()));
                    }
                        return;
                }
                return;
            }
            count++;
        }
        System.out.println("no se encontró la sección: "+partName);
    }
    
        /**
     * Checks if there are enough parts for a normal chapter
     * to be produced
     * @return boolean
        */
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
            /**
     * Checks if there are enough parts for a twist chapter
     * to be produced
     * @return boolean
        */
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
             /**
     * Chnnges qty of drive to create a normal chapter
        */  
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
     /**
     * Chnnges qty of drive to create a twist chapter
     */  
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
    
    /**
     * Gets labels in UI in other to be updated later
        */  
    public void fillDriveQtyLabels(){
        getUiDriveQtyLabels()[0] = GlobalUI.getMainPage().getRMDashBoard1().getIntroDriveQty();
        getUiDriveQtyLabels()[1] = GlobalUI.getMainPage().getRMDashBoard1().getStartDriveQty();
        getUiDriveQtyLabels()[2] = GlobalUI.getMainPage().getRMDashBoard1().getCreditDriveQty();
        getUiDriveQtyLabels()[3] = GlobalUI.getMainPage().getRMDashBoard1().getTwistDriveQty();
        getUiDriveQtyLabels()[4] = GlobalUI.getMainPage().getRMDashBoard1().getEndDriveQty();
        
        
    }
    
     /**
     * Gets labels in UI and updates them
        */  
    public void fillDriveMaxLabels(){
        getUiDriveMaxLabels()[0] = GlobalUI.getMainPage().getRMDashBoard1().getIntroDriveMax();
        getUiDriveMaxLabels()[1] = GlobalUI.getMainPage().getRMDashBoard1().getStartDriveMax();
        getUiDriveMaxLabels()[2] = GlobalUI.getMainPage().getRMDashBoard1().getCreditDriveMax();
        getUiDriveMaxLabels()[3] = GlobalUI.getMainPage().getRMDashBoard1().getTwistDriveMax();
        getUiDriveMaxLabels()[4] = GlobalUI.getMainPage().getRMDashBoard1().getEndDriveMax();
      
        updateDriveMaxLabels();
        
        int[] spinnerQty = new int[6];
        for (int i = 0; i<getDriveSections().length;i++){
            if (getDriveSections()[i].getMaxCapacity() != -1 ) {
                 spinnerQty[i] = getDriveSections()[i].getMaxCapacity();
            } else {
                 spinnerQty[i] = 1;
                  GlobalUI.getMainPage().getMainDashBoard1().getDriveController().returnCheckBoxByOrder(i).setSelected(true);
            }
           
        }
        GlobalUI.getMainPage().getMainDashBoard1().getDriveController().setSpinnersQtys(spinnerQty);
       
    }
    
    public void updateDriveMaxLabels(){
         for (int i = 0; i<getDriveSections().length-1; i++) {
             
            
            
            if (getDriveSections()[i].getMaxCapacity() == -1) {
                getUiDriveMaxLabels()[i].setText("Sin límite");
            } else {
                getUiDriveMaxLabels()[i].setText(String.valueOf(getDriveSections()[i].getMaxCapacity()));
            }
        }
    }
    
    public void updateDriveMaxLabels(int[] driveMax){
         for (int i = 0; i<getDriveSections().length-1; i++) {
            
             getDriveSections()[i].setMaxCapacity(driveMax[i]);
             
            if (driveMax[i] == -1) {
                getUiDriveMaxLabels()[i].setText("Sin límite");
            } else {
                getUiDriveMaxLabels()[i].setText(String.valueOf(driveMax[i]));
            }
        }
    }
    
    public int getTotalAmountOfChapters(){
        return getDriveSections()[getDriveSections().length-1].getProducedQty();
    }    
    
    
    
}
