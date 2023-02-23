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
public class Assembler {
    
    private double totalPaid;
    private boolean isActive;

    private final double salary;
    private final int daysToCap;

    public Assembler(boolean isActive) {
        this.totalPaid = 0;
        this.isActive = isActive;
        
        this.salary = 8;
        this.daysToCap = 2;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public double getSalary() {
        return salary;
    }

    public int getDaysToCap() {
        return daysToCap;
    }
}
