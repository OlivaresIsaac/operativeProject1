/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.TLOU;

import java.util.concurrent.Semaphore;

/**
 *
 * @author dsre1
 */
public class DriveSection {
    private String id;

    private int limit;
    private int current;
    
    private Semaphore semaphore;
    
    public DriveSection(String id, int limit) {
        this.id = id;
        
        this.limit = limit;
        this.current = 0;
        
        this.semaphore = new Semaphore(1);
    }
    
    public void insertWork() {
        if (this.current + 1 <= this.limit) {
            this.current += 1;
        }
    }
    
    public String getId() {
        return id;
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

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    
    
}
