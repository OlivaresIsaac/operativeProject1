/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.TLOU;

import classes.GlobalUI;
import classes.PTypes;
import java.util.concurrent.Semaphore;

/**
 *
 * @author dsre1
 */
public class DriveSection {
    
    private final Counter counter;

    private final String pType;

    private int limit;
    private boolean limited;
    
    private int current;
    
    private final int neededToChapter;
    
    public DriveSection(String pType, Counter counter, int limit, int neededToChapter) {
        this.pType = pType;
        
        this.counter = counter;

        this.limit = limit;
        this.setLimitInterface(String.valueOf(this.limit));
                
        this.limited = true;
        
        this.current = 0;
        
        this.neededToChapter = neededToChapter;
    }

    public boolean partValidation(int deliverables) {
        if (!limited) {
            return true;
        }
        return this.current + deliverables <= this.limit;
    }

    public void insertWork(int deliverables) {
        this.current += deliverables;
        if(this.pType.equals(PTypes.chapter)) {
            this.counter.updateTotalChapter(1);
        }
        this.setQtyInterface(String.valueOf(this.current));
    }
    
    public void excludeWork() {
        this.current -= this.neededToChapter;
        this.setQtyInterface(String.valueOf(this.current));
    }
    
    private void setQtyInterface(String newValue) {
//        System.out.print(this.pType);

        if(this.pType.equals(PTypes.intro)) {
            GlobalUI.getMainPage().getTLOUDashBoard().getIntroDriveQtyLabel().setText(newValue);
        }
        if(this.pType.equals(PTypes.credit)) {
            GlobalUI.getMainPage().getTLOUDashBoard().getCreditDriveQtyLabel().setText(newValue);
        }
        if(this.pType.equals(PTypes.start)) {
            GlobalUI.getMainPage().getTLOUDashBoard().getStartDriveQtyLabel().setText(newValue);
        }
        if(this.pType.equals(PTypes.end)) {
            GlobalUI.getMainPage().getTLOUDashBoard().getEndDriveQtyLabel().setText(newValue);
        }
        if(this.pType.equals(PTypes.twist)) {
            GlobalUI.getMainPage().getTLOUDashBoard().getTwistDriveQtyLabel().setText(newValue);
        }
    }
    
    private void setLimitInterface(String newValue) {
//        System.out.print(this.pType);
        if(this.pType.equals(PTypes.intro)) {
            GlobalUI.getMainPage().getTLOUDashBoard().getIntroDriveMaxLabel().setText(newValue);
        }
        if(this.pType.equals(PTypes.credit)) {
            GlobalUI.getMainPage().getTLOUDashBoard().getCreditDriveMaxLabel().setText(newValue);
        }
        if(this.pType.equals(PTypes.start)) {
            GlobalUI.getMainPage().getTLOUDashBoard().getStartDriveMaxLabel().setText(newValue);
        }
        if(this.pType.equals(PTypes.end)) {
            GlobalUI.getMainPage().getTLOUDashBoard().getEndDriveMaxLabel().setText(newValue);
        }
        if(this.pType.equals(PTypes.twist)) {
            GlobalUI.getMainPage().getTLOUDashBoard().getTwistDriveMaxLabel().setText(newValue);
        }
    }

    public String getPType() {
        return pType;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }
    
    public int getNeededToChapter() {
        return neededToChapter;
    }
    
    
}
