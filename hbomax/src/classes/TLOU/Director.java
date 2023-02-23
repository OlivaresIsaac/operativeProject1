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
public class Director {
    
    private double totalPaid;

    private final double salary;
    private final double discountToManager;

    public Director() {
        this.salary = 100;
        this.discountToManager = 1;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }
    
    public double getSalary() {
        return salary;
    }

    public double getDiscountToManager() {
        return discountToManager;
    }
    
    public void payDay() {
        this.totalPaid += this.salary;
    }

}
