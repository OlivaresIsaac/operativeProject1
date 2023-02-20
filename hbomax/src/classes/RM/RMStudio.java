/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.RM;

import classes.FunctionsTXT;
import classes.FunctionsUI;
import classes.GlobalUI;
import classes.PTypes;
import interfaces.ProducersQtyController;
import javax.swing.JLabel;
import javax.swing.JSpinner;

/**
 *
 * @author isaac
 */
public final class RMStudio extends Thread{
   
    final private Producer[] producers;
    final private boolean active = true;
    final private  Drive drive;
    private int plotTwistChapterCounter;
    private int dayDuration;
    private int daysUntilLaunch;
    private final JLabel utilityLabel;
    private final ProducersQtyController producersController;


    
    public RMStudio(int dayDuration, int daysUntilLaunch){
        
        this.utilityLabel = GlobalUI.getMainPage().getRMDashBoard1().getTotalUtility();
        this.producersController = GlobalUI.getMainPage().getRMDashBoard1().getProducersQtyController1();
        this.dayDuration = dayDuration;
       
        
        String initialParametersFile = "src\\assets\\initialParametersRM.txt";
        DriveObject[] driveParts = FunctionsTXT.loadStudioInitialParameters(initialParametersFile);
        this.producers = new Producer[15];
        int count = 0;
        int[] producersQty= new int[6];
        int producerCount = 0;
        for (DriveObject initialDriveInfo : driveParts){
            for (int i = 0; i<initialDriveInfo.getInitialProducerQty(); i++) {
                producers[count] = new Producer( (initialDriveInfo.getPartName().equals(PTypes.chapter) ? PTypes.assembler : initialDriveInfo.getPartName()), count);
                count++;
            }
            
            producersQty[producerCount] = initialDriveInfo.getInitialProducerQty();
            producerCount++;
            
        }
        producersController.setProducersQtys(producersQty);
        producersController.setInit(false);
        producersController.setAvailableProducers();
        
        
        while (count < 15){
            producers[count] = new Producer(PTypes.noType, count);
            count++;
        }
        
        this.startProduction();
        
        
        this.drive = new Drive(driveParts);
        getDrive().showDriveParts();
        plotTwistChapterCounter = 0;
        
    }
        public JLabel getUtilityLabel() {
        return utilityLabel;
    }
    
    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }
    
        public int getPlotTwistChapterCounter() {
        return plotTwistChapterCounter;
    }

    public void setPlotTwistChapterCounter(int plotTwistChapterCounter) {
        this.plotTwistChapterCounter = plotTwistChapterCounter;
    }
    
     public Drive getDrive() {
        return drive;
    }

    @Override
    public void run() {
              while(this.active){
            try {
                getDrive().showDriveParts();
                getUtilityLabel().setText(getUtilityAsString());
//                this.printAllSalariesPayed();
//                for (Producer producer : producers) {
//                    producer.printProducerProduction();
//                    
//                }
//                System.out.println("\n\n");
                FunctionsUI.updateMainDashBoardUI("$"+Integer.toString(this.getAllSalariesPayed()));
                Thread.sleep(getDayDuration());
            } catch (InterruptedException ex){
                System.out.println("error");
            }
        }
    }
    
    
    
    public void startProduction(){
        startAllEmployees();
    }
         /**
     * Starts Thread of all employees
     */
    public void startAllEmployees(){
        for(int i = 0; i<15;i++){
            getProducer(i).start();
        }
    }
    
    public Producer getProducer(int i){
        return this.producers[i];
    }
    
         /**
     * Calculates all salaries payed by the studio so far
     * @return totalpayed (int)
     */
    public int getAllSalariesPayed(){
        int total = 0;
        for(int i = 0; i<15;i++){
            total += getProducer(i).getTotalPay();
        }
        return (total/1000);
    }
    
    public void printAllSalariesPayed(){
        System.out.println("R&M has payed so far $"+this.getAllSalariesPayed()+" in salaries");
    }
    
    
     /**
     * reAssings the roles of all producers
     * @param spinners
     */
    public void reAssingProducerRoles(JSpinner[] spinners){
        int outerCounter = 0;
        int innerCounter = 0;
        for (JSpinner spinner : spinners) {
            int typeAmount = Integer.parseInt(spinner.getValue().toString());
            for (int i = 0; i < typeAmount; i++) {
                
                getProducer(innerCounter).setProducerType(getProducerTypeByOrder(outerCounter));
                innerCounter += 1;
            }
            outerCounter+=1;
        }
        
        while (innerCounter <=14){
            getProducer(innerCounter).setProducerType(PTypes.noType);
            innerCounter += 1;
        }
    }
    
    public String getProducerTypeByOrder(int position){
        switch (position) {
            case 0:
                return PTypes.intro;
            case 1:
                return PTypes.start;
            case 2:
                return PTypes.credit;
            case 3:
                return PTypes.twist;
            case 4:
                return PTypes.end;
            case 5:
                return PTypes.assembler;
            default:
                return PTypes.noType;
        }
    }
    
    public boolean isNextChapterAPlotTwist(){
        return (getPlotTwistChapterCounter() >= 5);
    }
    
    public void newChapterCreated(){
        setPlotTwistChapterCounter(getPlotTwistChapterCounter()+1);
    }
    
    public double getTotalUtility(){
        return ((getDrive().getTotalAmountOfChapters()*666.666)-getAllSalariesPayed());
    }
    
    public String getUtilityAsString(){
        double num  = (getTotalUtility() < 1000 ) ? (Math.round((Math.abs(getTotalUtility()))*100)/100) : (Math.round((Math.abs(getTotalUtility()))*100)/100)/100;
        String sufix = (getTotalUtility() >= 1000 )? "M" : "K";
        String prefix = (getTotalUtility() < 0) ? "-$" : "$";
        
        return (prefix + num + sufix);
     
    }
}
