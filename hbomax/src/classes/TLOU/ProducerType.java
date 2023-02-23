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

    private final String pType;

    private final double salary;

    private final int deliverables;
    private final int daysForDelivery;
    
    

    public ProducerType(String pType, double salary, int deliverables, int daysForDelivery) {
        this.pType = pType;
        this.salary = salary;
        this.deliverables = deliverables;
        this.daysForDelivery = daysForDelivery;
        
    }

    public String getPType() {
        return pType;
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
