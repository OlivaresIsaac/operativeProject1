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

    private final int numProducers;
    private final int numAssemblers;
    private final int numProducerTypes;
    private final int numDriveSections;

    private final ProducerType[] producerTypes;
    private final DriveSection[] driveSections;

    private Producer[] producers;
    private Assembler[] assemblers;
    private Manager manager;
    private Director director;

    public TLOUStudio(int countdown, int initAmount, int creditAmount, int startAmount, int endAmount, int twistAmount, int assemblersAmount) {
        this.numProducers = 16;
        this.numProducerTypes = this.numDriveSections = 5;
        this.numAssemblers = this.numProducers - this.numProducerTypes;

        this.producerTypes = this.setProducerTypes();
        this.driveSections = this.setDriveSections();

        this.producers = setProducers(initAmount, creditAmount, startAmount, endAmount, twistAmount);
        this.assemblers = setAssemblers(assemblersAmount);
        this.manager = new Manager();
        this.director = new Director();
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
    
    private ProducerType getProducerType(String id) {
        for (int i = 0; i <= this.numProducerTypes; i++) {
            ProducerType aux = this.producerTypes[i];
            if (aux.getId().equals(id)) {
                return aux;
            }
        }
        return null;
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
    
    private DriveSection getDriveSection(String id) {
        for (int i = 0; i <= this.numDriveSections; i++) {
            DriveSection aux = this.driveSections[i];
            if (aux.getId().equals(id)) {
                return aux;
            }
        }
        return null;
    }
    
    private void addProducer(Producer[] aux, String id) {
        for (int i = 0; i < this.numProducers; i++) {
            Producer producer = aux[i];
            if (producer == null) {
                ProducerType producerType = this.getProducerType(id);
                DriveSection driveSection = this.getDriveSection(id);

                Producer newProducer = new Producer(id, driveSection, producerType);
                
                producer = newProducer;
                
                return;
            }
        }
    }

    private Producer[] setProducers(int initAmount, int creditAmount, int startAmount, int endAmount, int twistAmount) {
        Producer[] aux = new Producer[this.numProducers];

        int totalAmount = initAmount + creditAmount + startAmount + endAmount + twistAmount;
        int noType = this.numProducers - totalAmount;

        for (int i = 0; i < initAmount; i++) {
            this.addProducer(aux, PTypes.intro);
        }
        for (int i = 0; i < creditAmount; i++) {
            this.addProducer(aux, PTypes.credit);
        }
        for (int i = 0; i < startAmount; i++) {
            this.addProducer(aux, PTypes.start);
        }
        for (int i = 0; i < endAmount; i++) {
            this.addProducer(aux, PTypes.end);
        }
        for (int i = 0; i < twistAmount; i++) {
            this.addProducer(aux, PTypes.twist);
        }
        for (int i = 0; i < noType; i++) {
            this.addProducer(aux, PTypes.noType);
        }
        
        return aux;
    }
    
    private void assignProducer(String id) {
        for (int i = 0; i < this.numProducers; i++) {
            Producer producer = this.producers[i];
            if (producer.getId().equals(PTypes.noType)) {
                DriveSection driveSection = this.getDriveSection(id);
                ProducerType producerType = this.getProducerType(id);
                
                producer.setId(id);
                producer.setDriveSection(driveSection);
                producer.setProducerType(producerType);
                
                return;
            }
        }
    }

    private void unassignProducer(String id) {
        for (int i = 0; i < this.numProducers; i++) {
            Producer producer = this.producers[i];
            if (producer.getId().equals(id)) {
                producer.setId(PTypes.noType);
                producer.setDriveSection(null);
                producer.setProducerType(null);
                
                return;
            }
        }
    }
    
    private void addAssembler(Assembler[] aux, boolean isActive) {
        for (int i = 0; i < this.numAssemblers; i++) {
            Assembler assembler = aux[i];
            if (assembler == null) {
                Assembler newAssembler = new Assembler(isActive);
                
                assembler = newAssembler;
                
                return;
            }
        }
    }

    private Assembler[] setAssemblers(int assemblersAmount) {
        Assembler[] aux = new Assembler[this.numAssemblers];
        int noActiveAmount = this.numAssemblers - assemblersAmount;

        for (int i = 0; i < assemblersAmount; i++) {
            this.addAssembler(aux, true);
        }
        
        for (int i = 0; i < noActiveAmount; i++) {
            this.addAssembler(aux, false);
        }

        return aux;
    }
    
    private double payDay() {
        double totalPaidToday = 0;
        double payDay = 0;

        for (int i = 0; i <= this.numProducers; i++) {
            Producer producer = this.producers[i];
            if (producer != null && !producer.getId().equals(PTypes.noType)) {
                payDay = producer.getProducerType().getSalary();
                totalPaidToday += payDay;
                producer.setTotalPaid(producer.getTotalPaid() + payDay);
            }
        }

        for (int i = 0; i <= this.numAssemblers; i++) {
            Assembler assembler = this.assemblers[i];
            if (assembler != null && assembler.getIsActive()) {
                payDay = assembler.getSalary();
                totalPaidToday += payDay;
                assembler.setTotalPaid(assembler.getTotalPaid() + payDay);
            }
        }
        
        payDay = this.manager.getSalary();
        totalPaidToday += payDay;
        this.manager.setTotalPaid(this.manager.getTotalPaid() + payDay);

        payDay = this.director.getSalary();
        totalPaidToday += payDay;
        this.director.setTotalPaid(this.director.getTotalPaid() + payDay);

        return totalPaidToday;
    }
    
    private double getTotalPaid() {
        double totalPaid = 0;

        for (int i = 0; i <= this.numProducers; i++) {
            Producer producer = this.producers[i];
            totalPaid += producer.getTotalPaid();
        }

        for (int i = 0; i <= this.numAssemblers; i++) {
            Assembler assembler = this.assemblers[i];
            totalPaid += assembler.getTotalPaid();
        }
        
        totalPaid += this.manager.getTotalPaid();
        
        totalPaid += this.director.getTotalPaid();
        
        return totalPaid;
    }

    public void startTest() {

    }

}
