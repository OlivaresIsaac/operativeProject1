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
public class Producer {

    private String id;

    private double totalPaid;

    private DriveSection driveSection;
    private ProducerType producerType;

    public Producer(String id, DriveSection driveSection, ProducerType producerType) {
        this.id = id;

        this.totalPaid = 0;

        this.driveSection = driveSection;
        this.producerType = producerType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }

    public DriveSection getDriveSection() {
        return driveSection;
    }

    public void setDriveSection(DriveSection driveSection) {
        this.driveSection = driveSection;
    }

    public ProducerType getProducerType() {
        return producerType;
    }

    public void setProducerType(ProducerType producerType) {
        this.producerType = producerType;
    }

}
