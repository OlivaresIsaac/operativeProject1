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

    private String pType;

    private int limit;
    private int current;

    public DriveSection(String pType, int limit) {
        this.pType = pType;

        this.limit = limit;
        this.current = 0;
    }

    public boolean partValidation() {
        return this.current + 1 <= this.limit;
    }

    public void insertWork() {
        this.current += 1;
    }

    public void excludeWork() {
        this.current -= 1;
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
}
