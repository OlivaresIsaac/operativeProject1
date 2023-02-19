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

    private int countdown; //days
    private int workingTime; //hours
    private int interval; //minutes
    
    private double salary;

    public Manager(int countdown) {
        this.countdown = countdown;
        this.workingTime = 7;
        this.interval = 21;
        this.salary = 7;
    }

    public int getCountdown() {
        return countdown;
    }

    public void setCountdown(int countdown) {
        this.countdown = countdown;
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

}
