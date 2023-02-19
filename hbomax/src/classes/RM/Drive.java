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
     * @return boolean
 */
    public boolean addProduction(String partName, int production){
        if (partName.equals(PTypes.noType)) {
            return false;
        }
        
        // agregar parte que considera al chapter, y restar de las otras partes
        // considerar un contador para saber cuando toca twist
        
        for (DriveObject section : getDriveSections()) {
            if (section.getPartName().equals(partName)) {
                if (section.isSpaceAvailable()) {
                    section.setProducedQty(section.getProducedQty()+production);
                    return true;
                }
                return false;
            }
        }
        System.out.println("no se encontró la sección: "+partName);
        return false;
    }
    
    
}
