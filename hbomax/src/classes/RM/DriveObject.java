/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.RM;

import classes.PTypes;

/**
 *
 * @author isaac
 */
public class DriveObject {
    private volatile int  producedQty;
    private int MaxCapacity;
    private String partName;

    public DriveObject(String partName, int producedQty, int MaxCapacity) {
        this.producedQty = producedQty;
        this.MaxCapacity = MaxCapacity;
        this.partName = partName;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getProducedQty() {
        return producedQty;
    }

    public void setProducedQty(int producedQty) {
        this.producedQty = producedQty;
    }

    public int getMaxCapacity() {
        return MaxCapacity;
    }

    public void setMaxCapacity(int MaxCapacity) {
        this.MaxCapacity = MaxCapacity;
    }
    
    public boolean isSpaceAvailable(){
        if (getMaxCapacity() == -1) {
            return true;
        }
        
        if (getPartName().equals(PTypes.intro) || getPartName().equals(PTypes.credit)) {
            return (getProducedQty() < getMaxCapacity()-1);
        } 
        
        return (getProducedQty() < getMaxCapacity());
    }
    
    
}
