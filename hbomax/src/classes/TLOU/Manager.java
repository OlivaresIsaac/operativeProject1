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
public class Manager {
    
    private double totalPaid;

    private int workingTime; //hours
    private int interval; //minutes
    
    private double salary;

    public Manager() {
        this.workingTime = 7;
        this.interval = 21;
        this.salary = 7;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public int getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(int workingTime) {
        this.workingTime = workingTime;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public double getSalary() {
        return salary;
    }
    
    public void payDay() {
        this.totalPaid += this.salary;
    }

}
