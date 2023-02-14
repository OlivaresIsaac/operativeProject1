/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.RM;

import classes.FunctionsUI;
import classes.PTypes;

/**
 *
 * @author isaac
 */
public final class RMStudio extends Thread{
   
    final private Producer[] producers;
    final private boolean active = true;
    
    public RMStudio(){
        this.producers = new Producer[15];
        for (int i=0;i<15;i++){
            producers[i] = new Producer(PTypes.intro, i);
        }
        this.startProduction();
    }

    @Override
    public void run() {
              while(this.active){
            try {
                this.printAllSalariesPayed();
                FunctionsUI.updateMainDashBoardUI("$"+Integer.toString(this.getAllSalariesPayed()));
                Thread.sleep(1000);
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
        System.out.println("R&M has payed so far $"+this.getAllSalariesPayed()+"in salaries");
    }
}
