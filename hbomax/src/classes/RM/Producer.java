/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.RM;
import classes.PTypes;
/**
 *
 * @author isaac
 */
public class Producer extends Thread{
    private double totalPay;
    
    private double dolarPerHour;
    private double dailyProduction;
    // ver como se llevara el registro de lo producido 
    // tomar en cuenta que se puede despachar si es >=1
//    private double currentProduced;
    private String producedPart;
    
    final private PTypes type = new PTypes();
    final private boolean active = true;
    
    
     /**
     * Producer constructor
     * types could be [intro, credit, start, end, twist]
     * @param type (String)
     */
    public Producer(String type){
        this.producedPart = type;
        this.totalPay = 0;
        this.initializeProducerByType();
    }
    
        @Override
    public void run(){
        while(this.active){
            try {
                // diminuir el semafoto acquire (wait)
                // aumentar el seamforo release (signal)
                // revisar esto
                this.payProducerADay();
                this.showTotalPay();
                Thread.sleep(1000);
            } catch (InterruptedException ex){
                System.out.println("ferror");
            }
        }
    }
    
      /**
     * Initializes all important parameters of producer
     * is trigger when created or when the producer type changes
     */
    private void initializeProducerByType(){
        if (this.producedPart.equals(type.intro)) {
            this.dolarPerHour = 5;
            this.dailyProduction = 2;
        } else if (this.producedPart.equals(type.credit)) {
            this.dolarPerHour = 3;
            this.dailyProduction = 2;
        }
        else if (this.producedPart.equals(type.start)) {
            this.dolarPerHour = 7;
            this.dailyProduction = (1/3);
        } else if (this.producedPart.equals(type.end)) {
             this.dolarPerHour = 7.5;
             this.dailyProduction = 0.5;
        } else if (this.producedPart.equals(type.twist)) {
             this.dolarPerHour = 10;
             this.dailyProduction = (1/3);
        } else {
             System.out.println("INVALID PRODUCER TYPE");
        }
        
        
    }
    
    public void setProducerType(String type){
        this.producedPart = type;
        this.initializeProducerByType();
    }
    
    public String getProducerType(){
        return this.producedPart;
    }
    
    public double getTotalPay(){
        return this.totalPay;
    }
    
    public double getDolarPerHour(){
        return this.dolarPerHour;
    }
    
    public void payProducerADay(){
        this.totalPay += (getDolarPerHour()*24);
    }
    
    public void addTodaysProduct(){
        
    }
    
    public void showTotalPay(){
        System.out.println("$"+this.getTotalPay());
    }
}
