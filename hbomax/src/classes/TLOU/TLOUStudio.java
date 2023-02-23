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
public class TLOUStudio extends Thread {
    
    private final int countdown;
    
    static public int timeSleep;
    static public boolean working;

    private final int numProducers;
    private final int numAssemblers;
    private final int numProducerTypes;
    private final int numProducerSections;

//    private final ProducerType[] producerTypes;

    private Drive drive;
    private ProducerTypes producerTypes;
    private Producer[] producers;
    private Assembler[] assemblers;
    private Manager manager;
    private Director director;

    public TLOUStudio(int countdown, int timeSleep, int initAmount, int creditAmount, int startAmount, int endAmount, int twistAmount, int assemblersAmount) {
        this.countdown = countdown;
        
        this.timeSleep = timeSleep;
        this.working = true;
        
        this.numProducers = 16;
        this.numProducerTypes = 5;
        this.numAssemblers = this.numProducers - this.numProducerTypes;
        this.numProducerSections = 5;

        this.producerTypes = new ProducerTypes(this.numProducerTypes);
        this.drive = new Drive(numProducerSections);

        this.producers = this.setProducers(initAmount, creditAmount, startAmount, endAmount, twistAmount);
        this.assemblers = this.setAssemblers(assemblersAmount);
        this.manager = new Manager();
        this.director = new Director();
    }
    
    private void addProducer(Producer[] aux, String pType) {
        for (int i = 0; i < this.numProducers; i++) {
            if (aux[i] == null) {
                Producer producer = new Producer(pType, this.drive, this.producerTypes);
                
                aux[i] = producer;
                return ;
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
    
    private void assignProducer(String pType) {
        for (int i = 0; i < this.numProducers; i++) {
            Producer producer = this.producers[i];
            if (producer.getPType().equals(PTypes.noType)) {
                
                producer.setPType(pType);
                return;
                
            }
        }
    }

    private void unassignProducer(String pType) {
        for (int i = 0; i < this.numProducers; i++) {
            Producer producer = this.producers[i];
            if (producer.getPType().equals(pType)) {
               
                producer.setPType(PTypes.noType);
                return;
                
            }
        }
    }
    
    private void addAssembler(Assembler[] aux, boolean isActive) {
        for (int i = 0; i < this.numAssemblers; i++) {
            if (aux[i] == null) {
                Assembler assembler = new Assembler(this.drive, isActive);
                
                aux[i] = assembler;
                
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
    
    private double getTotalPaid() {
        double totalPaid = 0;

        for (int i = 0; i < this.numProducers; i++) {
            Producer producer = this.producers[i];
            totalPaid += producer.getTotalPaid();
        }

        for (int i = 0; i < this.numAssemblers; i++) {
            Assembler assembler = this.assemblers[i];
            totalPaid += assembler.getTotalPaid();
        }
        
        totalPaid += this.manager.getTotalPaid();
        
        totalPaid += this.director.getTotalPaid();
        
        return totalPaid;
    }
    
    private void startProducers() {
        for (int i = 0; i < this.numProducers; i++) {
            Producer producer = this.producers[i];
            producer.start();
        }
    }
    
    private void startAssemblers() {
        for (int i = 0; i < this.numAssemblers; i++) {
            Assembler assembler = this.assemblers[i];
            assembler.start();
        }
    }

    @Override
    public void run() {
        this.startProducers();
        this.startAssemblers();
        
        while(TLOUStudio.working) {
            try {
                double totalPaid = this.getTotalPaid();
                System.out.println(totalPaid);
                Thread.sleep(TLOUStudio.timeSleep);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }

}
