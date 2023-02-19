/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.TLOU;

import classes.PTypes;

/**
 *
 * @author dsre1
 */
public class TLOUStudio {
    
    private final int numWorkers;
    private final int numProducerTypes;
    private final int numDriveSections;

//    private Producer[] producers;
    private final ProducerType[] producerTypes;
    private final DriveSection[] driveSections;
    
    private Worker[] workers;
    private Manager manager;
    

    public TLOUStudio(int countdown) {
        this.numWorkers = 16;
        this.numProducerTypes = this.numDriveSections = 5;
        
        this.producerTypes = this.setProducerTypes();
        this.driveSections = this.setDriveSections();
        
        this.workers = this.setWorkers();
        this.manager = new Manager(countdown);
        
//        this.producers = this.setProducers();
    }

    private ProducerType[] setProducerTypes() {
        ProducerType intro = new ProducerType(PTypes.intro, 5, 3, 1);
        ProducerType credit = new ProducerType(PTypes.credit, 3, 3, 1);
        ProducerType start = new ProducerType(PTypes.start, 7, 1, 4);
        ProducerType end = new ProducerType(PTypes.end, 7.5, 1, 3);
        ProducerType twist = new ProducerType(PTypes.twist, 10, 1, 3);

        ProducerType[] aux = {intro, credit, start, end, twist};

        return aux;
    }

    private DriveSection[] setDriveSections() {
        DriveSection intro = new DriveSection(PTypes.intro, 30);
        DriveSection credit = new DriveSection(PTypes.credit, 25);
        DriveSection start = new DriveSection(PTypes.start, 50);
        DriveSection end = new DriveSection(PTypes.end, 55);
        DriveSection twist = new DriveSection(PTypes.twist, 40);

        DriveSection[] aux = {intro, credit, start, end, twist};

        return aux;
    }
    
    private Worker[] setWorkers() {
        Worker[] aux = new Worker[this.numWorkers];
        
        for (int i = 0; i < this.numWorkers; i++) {
            ProducerType producerType = this.getProducerTypes(PTypes.intro);
            DriveSection section = this.getDriveSection(PTypes.intro);
            
            Producer producer = new Producer(section, producerType);
            Worker worker = new Worker(producer);
            
            aux[i] = worker;
        }
        
//        for (int i = 14; i < 16; i++) {
//            Assembler assembler = new Assembler();
//            Worker worker = new Worker(assembler);
//            
//            aux[i] = worker;
//        }
        
        return aux;
    }
    
    private ProducerType getProducerTypes(String id) {
        for (int i = 0; i <= this.numProducerTypes; i++) {
            ProducerType aux = this.producerTypes[i];
            if (aux.getId().equals(id)) {
                return aux;
            }
        }
        return null;
    }

    private DriveSection getDriveSection(String id) {
        for (int i = 0; i <= this.numDriveSections; i++) {
            DriveSection aux = this.driveSections[i];
            if (aux.getId().equals(id)) {
                return aux;
            }
        }
        return null;
    }

//    private Producer[] setProducers() {
//        Producer[] aux = new Producer[16];
//
//        for (int i = 0; i < 16; i++) {
//            ProducerType producerType = this.getProducerTypes(PTypes.intro);
//            DriveSection section = this.getDriveSection(PTypes.intro);
//            
//            Producer producer = new Producer(section, producerType);
//            
//            aux[i] = producer;
//        }
//
//        return aux;
//    }

//    private void changeProducerType(String initPType, String finalPType) {
//        for (int i = 0; i <= 5; i++) {
//            Producer aux = this.producers[i];
//            if (aux.getDriveSection().getId().equals(initPType)) {
//                DriveSection section = this.getDriveSection(finalPType);
//                aux.setDriveSection(section);
//            }
//        }
//    }

    public void startTest() {

    }

}
