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
public class ProducerType {

    private final String id;

    private final double salary; //hours

    private final int deliverables; //quantity
    private final int timeForDeliver; //days

    public ProducerType(String id, double salary, int deliverables, int timeForDeliver) {
        this.id = id;
        this.salary = salary;
        this.deliverables = deliverables;
        this.timeForDeliver = timeForDeliver;
    }

    public String getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public int getDeliverables() {
        return deliverables;
    }

    public int getTimeForDeliver() {
        return timeForDeliver;
    }

}
