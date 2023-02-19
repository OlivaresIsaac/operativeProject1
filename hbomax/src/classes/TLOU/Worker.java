/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.TLOU;

/**
 *
 * @author dsre1
 */
public class Worker<T> {
    private T type;
    
    private int remainingDays;
    private boolean isWorking;

    public Worker(T type) {
        this.type = type;
        this.remainingDays = 0;
        this.isWorking = false;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public int getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(int remainingDays) {
        this.remainingDays = remainingDays;
    }

    public boolean isIsWorking() {
        return isWorking;
    }

    public void setIsWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }
    
}
