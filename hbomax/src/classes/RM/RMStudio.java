/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.RM;

import classes.FunctionsTXT;
import classes.FunctionsUI;
import classes.PTypes;
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



   
    
    public RMStudio(){
        this.producers = new Producer[15];
        for (int i=0;i<15;i++){
            producers[i] = new Producer(PTypes.noType, i);
        }
        this.startProduction();
        
        String initialParametersFile = "src\\assets\\initialParametersRM.txt";
        DriveObject[] driveParts = FunctionsTXT.loadInitialParameters(initialParametersFile);
        this.drive = new Drive(driveParts);
        getDrive().showDriveParts();
        plotTwistChapterCounter = 0;
        
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
//                this.printAllSalariesPayed();
//                for (Producer producer : producers) {
//                    producer.printProducerProduction();
//                    
//                }
//                System.out.println("\n\n");
                FunctionsUI.updateMainDashBoardUI("$"+Integer.toString(this.getAllSalariesPayed()));
                Thread.sleep(3000);
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
        return total;
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
}
