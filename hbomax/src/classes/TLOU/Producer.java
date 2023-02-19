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

    private DriveSection driveSection;
    private ProducerType producerType;

    public Producer(DriveSection driveSection, ProducerType producerType) {
        this.driveSection = driveSection;
        this.producerType = producerType;
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
