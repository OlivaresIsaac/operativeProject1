/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.RM;

/**
 *
 * @author isaac
 */
public class Drive {
    private final DriveObject[] driveSections;

    public DriveObject[] getDriveSections() {
        return driveSections;
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
    
    
}
