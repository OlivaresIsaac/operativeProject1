/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.TLOU;

import classes.FunctionsTXT;
import classes.GlobalUI;
import classes.PTypes;
import classes.RM.DriveObject;
import interfaces.XYChart;

/**
 *
 * @author dsre1
 */
public class TLOUStudio extends Thread {

    static public int timeSleep;
    static public boolean isWorking;
    
    private int introAmount;
    private int creditAmount;
    private int startAmount;
    private int endAmount;
    private int twistAmount;

    private final int numProducers;
    private final int numAssemblers;
    private final int numProducerTypes;
    private final int numProducerSections;

    private Drive drive;

    public Drive getDrive() {
        return drive;
    }
    private ProducerTypes producerTypes;
    private Counter counter;



    private Producer[] producers;
    private Assembler[] assemblers;
    private Manager manager;
    private Director director;
    
    public static double[] utilityOverTime = new double [200];
    int totalDayCounter = 0;

    public TLOUStudio(int countdown, int timeSleep) {
        
        String initialParametersFile = "src\\assets\\initialParametersTLOU.txt";
        DriveObject[] driveParts = FunctionsTXT.loadStudioInitialParameters(initialParametersFile);
        int introAmount = driveParts[0].getInitialProducerQty();
        int startAmount = driveParts[1].getInitialProducerQty();
        int creditAmount = driveParts[2].getInitialProducerQty();
        int twistAmount = driveParts[3].getInitialProducerQty();
        int endAmount =  driveParts[4].getInitialProducerQty();
        int assemblersAmount = driveParts[5].getInitialProducerQty();
        
        int [] driveMaxSections = new int[6];
        for (int i = 0; i< 6; i++) {
            driveMaxSections[i] = driveParts[i].getMaxCapacity();
        }
        

        this.timeSleep = timeSleep;
        this.isWorking = true;
        
        this.introAmount = introAmount;
        this.creditAmount = creditAmount;
        this.startAmount = startAmount;
        this.endAmount = endAmount;
        this.twistAmount = twistAmount;

        this.numProducers = 16;
        this.numProducerTypes = 5;
        this.numAssemblers = this.numProducers - this.numProducerTypes;
        this.numProducerSections = 5;

        this.producerTypes = new ProducerTypes(this.numProducerTypes);
        this.counter = new Counter(countdown);
        this.drive = new Drive(this.counter, this.numProducerSections, driveMaxSections);

        this.producers = this.setProducers(introAmount, creditAmount, startAmount, endAmount, twistAmount);
        this.assemblers = this.setAssemblers(assemblersAmount);
        this.director = new Director(this.counter, this.drive);
        this.manager = new Manager(this.counter, this.director);
    }

    private void addProducer(Producer[] aux, String pType) {
        for (int i = 0; i < this.numProducers; i++) {
            if (aux[i] == null) {
                Producer producer = new Producer(pType, this.drive, this.producerTypes);

                aux[i] = producer;
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
    
    public double getPaid() {
        double totalPaidToday = 0;
        
        for(int i = 0; i < this.numProducers; i++) {
            Producer producer = this.producers[i];
            
            if (!producer.getPType().equals(PTypes.noType)) {
                ProducerType producerType = this.producerTypes.getProducerType(producer.getPType());
                totalPaidToday += producerType.getSalary() * 24;
            }
        }
        
        for(int i = 0; i < this.numAssemblers; i++) {
            Assembler assembler = this.assemblers[i];
            
            if (assembler.getIsActive()) {
                totalPaidToday += assembler.getSalary() * 24;
            }
        }
        
        totalPaidToday += this.manager.getSalary() * 24;
        totalPaidToday += this.director.getSalary();
        
        return totalPaidToday;
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

    private void startDirector() {
        this.director.start();
    }

    private void startManager() {
        this.manager.start();
    }
    
    public void registerTodayUility(){
        this.utilityOverTime[this.totalDayCounter] = this.counter.getTotal() / 1000000;
        this.totalDayCounter += 1;
        GlobalUI.getMainPage().getTLOUDashBoard().getUtilityChart().setChart(XYChart.createChart(XYChart.createDataset(this.utilityOverTime), "Utilidad vs Tiempo"));
    }

    public double[] getUtilityOverTime() {
        return utilityOverTime;
    }
    

    @Override
    public void run() {
        this.startProducers();
        this.startAssemblers();
        this.startDirector();
        this.startManager();

        while (TLOUStudio.isWorking) {
            try {
                this.counter.updateTotalPaid(this.getTotalPaid());
                this.counter.setSalaryPerMonth(this.getPaid());
                this.registerTodayUility();
                Thread.sleep(TLOUStudio.timeSleep);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }
   
    public void updateProducersPieChart(){
        
    }
    
        public Counter getCounter() {
        return counter;
    }
    
    
}
