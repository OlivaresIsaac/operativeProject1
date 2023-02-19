/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.RM;
import classes.Main;
import classes.PTypes;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author isaac
 */
public class Producer extends Thread{
    private double totalPay;
    
    private double dolarPerHour;
    private double dailyProduction;

    private double accProduction;
    private final int id;
    // ver como se llevara el registro de lo producido 
    // tomar en cuenta que se puede despachar si es >=1
//    private double currentProduced;
    private String producedPart;
    
    final private boolean active = true;
    private boolean isAssembler;
    
  


    
   
     /**
     * Producer constructor
     * types could be [intro, credit, start, end, twist]
     * @param type (String)
     * @param id
     */
    public Producer(String type, int id){
        this.id = id;
        this.producedPart = type;
        this.totalPay = 0;
        this.accProduction = 0;
        this.initializeProducerByType();
    }
    
    
        @Override
    public void run(){
        while(this.active){
            try {
                // diminuir el semafoto acquire (wait)
                // aumentar el seamforo release (signal)
                // revisar esto
                this.produceChapterSection();    
                this.addTodaysProduct();
                this.payProducerADay();
//                this.showTotalPay();
                Thread.sleep(3000);
            } catch (InterruptedException ex){
                System.out.println("error");
            }
        }
    }
    
      /**
     * Initializes all important parameters of producer
     * is trigger when created or when the producer type changes
     */
        private void initializeProducerByType(){
        if (this.producedPart.equals(PTypes.intro)) {
            this.dolarPerHour = 5;
            this.dailyProduction = 2;
        } else if (this.producedPart.equals(PTypes.credit)) {
            this.dolarPerHour = 3;
            this.dailyProduction = 2;
        }
        else if (this.producedPart.equals(PTypes.start)) {
            this.dolarPerHour = 7;
            this.dailyProduction = 0.34;
        } else if (this.producedPart.equals(PTypes.end)) {
             this.dolarPerHour = 7.5;
             this.dailyProduction = 0.5;
        } else if (this.producedPart.equals(PTypes.twist)) {
             this.dolarPerHour = 10;
             this.dailyProduction = 0.34;
        
        }  else if (this.producedPart.equals(PTypes.assembler)) {
             this.dolarPerHour = 8;
             this.dailyProduction = (0.5);
             this.isAssembler = true;
             return;
        
        } else {
             this.dolarPerHour = 0;
             this.dailyProduction = 0;
             
        }
        
        this.isAssembler = false;
        
        
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
    
     /**
     * Pays the producer three 8 hours shift in a day
     */
    public void payProducerADay(){
        this.totalPay += (getDolarPerHour()*24);
    }
    
    public void produceChapterSection(){
        this.accProduction += getDailyProduction();
    }
    
    public void addTodaysProduct(){
        if (getAccProduction() >= 1) {
            int production = (int) Math.floor(getAccProduction());
            
            try {
                // assembler todavia no funciona
                String chapterSection = this.isAssembler ? PTypes.chapter : getProducerType();
                
                Main.rm.getDrive().getDriveSemaphore().acquire(); // sección entrada
                boolean completed = Main.rm.getDrive().addProduction(chapterSection, production); // sección crítica
                Main.rm.getDrive().getDriveSemaphore().release(); // sección salida
                if (completed) { // sección restante
                    setAccProduction(0);
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void showTotalPay(){
        System.out.println("id:"+this.getProducerId()+" has been pay $"+this.getTotalPay());
    }
    
    public int getProducerId(){
        return this.id;
    }
    
    
    public double getDailyProduction() {
        return dailyProduction;
    }

    public void setDailyProduction(double dailyProduction) {
        this.dailyProduction = dailyProduction;
    }

    public double getAccProduction() {
        return accProduction;
    }

    public void setAccProduction(double accProduction) {
        this.accProduction = accProduction;
    }

    public String getProducedPart() {
        return producedPart;
    }

    public void setProducedPart(String producedPart) {
        this.producedPart = producedPart;
    }

    public boolean isIsAssembler() {
        return isAssembler;
    }

    public void setIsAssembler(boolean isAssembler) {
        this.isAssembler = isAssembler;
    }
    
    public void printProducertype(){
        System.out.println("El productor ID: "+getId()+" es de tipo "+getProducedPart()+" y cobra $"+getDolarPerHour()*24+" diarios");
    }
}
