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

    private final double salary;
    private final double discountToManager;
    private final int originalCounter;

    public Director(int originalCounter) {
        this.salary = 100;
        this.discountToManager = 1;
        this.originalCounter = originalCounter;
    }

    public double getSalary() {
        return salary;
    }

    public double getDiscountToManager() {
        return discountToManager;
    }

    public int getOriginalCounter() {
        return originalCounter;
    }
}
