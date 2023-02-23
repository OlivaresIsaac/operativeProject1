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

    private final double salary;

    private final int deliverables;
    private final int daysForDelivery;

    public ProducerType(String id, double salary, int deliverables, int daysForDelivery) {
        this.id = id;
        this.salary = salary;
        this.deliverables = deliverables;
        this.daysForDelivery = daysForDelivery;
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

    public int getdaysForDelivery() {
        return daysForDelivery;
    }

}
