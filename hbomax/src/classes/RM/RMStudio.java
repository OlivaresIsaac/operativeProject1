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
import classes.TLOU.TLOUStudio;
import interfaces.PieChart;
import interfaces.ProducersQtyController;
import interfaces.XYChart;
import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;
import javax.swing.JLabel;
import javax.swing.JSpinner;

/**
 *
 * @author isaac
 */
public final class RMStudio extends Thread {
   
    private Producer[] producers;
    final private boolean active = true;
    final private  Drive drive;
    private int plotTwistChapterCounter;
    private int dayDuration;
    private final int daysUntilLaunch;
    private final JLabel utilityLabel;
    private final ProducersQtyController producersController;
    private final ProducersQtyController dashboardProducerController;
    private final Semaphore counterMutex = new Semaphore(1);
//    private final Semaphore synchPmAndDirector = new Semaphore(1);
    private final PM pm;
    private final Director director;
    private final double[] utilityOverTime = new double [200];


    int totalDayCounter = 0;



    public RMStudio(int dayDuration, int daysUntilLaunch){
        
        this.utilityLabel = GlobalUI.getMainPage().getRMDashBoard1().getTotalUtility();
        this.producersController = GlobalUI.getMainPage().getRMDashBoard1().getProducersQtyController1();
        this.dashboardProducerController = GlobalUI.getMainPage().getMainDashBoard1().getRmController();
        this.dayDuration = dayDuration;
        this.daysUntilLaunch = daysUntilLaunch;
        this.pm = new PM(this.daysUntilLaunch);
        this.director = new Director(this.daysUntilLaunch);
       
        String initialParametersFile = "src\\assets\\initialParametersRM.txt";
        DriveObject[] driveParts = FunctionsTXT.loadStudioInitialParameters(initialParametersFile);

       int [] producersQty = this.initializeProducers(driveParts);
       GlobalUI.getMainPage().getRMDashBoard1().getProducerPie().setChart(PieChart.createChart(PieChart.createDataset(producersQty), "Productores"));
        
       this.updateSpinnerAndProducersType(producersQty);
       this.updateDashboardSpinner(producersQty);
       this.startProduction();
       
        this.drive = new Drive(driveParts);
        this.plotTwistChapterCounter = 0;
        
    }
    
     /**
     * Updates the value of the producers spinners in RmDashcboard
     * @param producersQty
     */
    public void updateSpinnerAndProducersType(int [] producersQty){
    producersController.updateQtysInSpinners(producersQty);
        reAssingProducerRoles(getProducersController().getSpinners());
    }
    
    
         /**
     * Updates the value of the producers spinners in MainDashboard
     * @param producersQty
     */
    public void updateDashboardSpinner(int [] producersQty){
    dashboardProducerController.updateQtysInSpinners(producersQty);
        reAssingProducerRoles(getProducersController().getSpinners());
    }
    
    
         /**
     * Initizalizes all producers in the studio, returns the producers 
     * count of each category
     * @param driveParts
     * @return producersQty
     */
    public int [] initializeProducers( DriveObject[] driveParts){
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

        
        
        while (count < 15){
            producers[count] = new Producer(PTypes.noType, count);
            count++;
        }
        return producersQty;
    }
    
    public double[] getUtilityOverTime() {
        return utilityOverTime;
    }

    
    public JLabel getUtilityLabel() {
        return utilityLabel;
    }
    
    public int getDayDuration() {
        return dayDuration;
    }
    
    public ProducersQtyController getDashboardProducerController() {
        return dashboardProducerController;
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
//                getDrive().showDriveParts();
                getUtilityLabel().setText(getUtilityAsString());
                registerTodayUility();
//                this.printAllSalariesPayed();
//                for (Producer producer : producers) {
//                    producer.printProducerProduction();
//                    
//                }
//                System.out.println("\n");
//                FunctionsUI.updateMainDashBoardUI("$"+Integer.toString(this.getAllSalariesPayed()));
                Thread.sleep(getDayDuration());
            } catch (InterruptedException ex){
                System.out.println("error");
            }
        }
    }
    
    
    
    public void startProduction(){
        startAllEmployees();
        getPm().start();
        getDirector().start();
        
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
        total += getPm().getTotalPay();
        total += getDirector().getTotalPay();
        return (total/1000);
    }
    
    public void printAllSalariesPayed(){
        System.out.println("R&M has payed so far $"+this.getAllSalariesPayed()+" in salaries");
    }
    
    
         /**
     * Returns the daily salaries of all employees 
     * in the studio
     * @return 
     */
    public float getAllDailySalaries(){
        int total = 0;
         for(int i = 0; i<15;i++){
            total += getProducer(i).getDolarPerHour()*24;
        }
        total += getPm().getDolarPerHour()*24;
        total += getDirector().getDailyPay();
        return total;
    }
    
    
     /**
     * reAssings the roles of all producers
     * @param spinners
     */
    public void reAssingProducerRoles(JSpinner[] spinners){
        int outerCounter = 0;
        int innerCounter = 0;
        int[] producersQty = new int[6];
        for (JSpinner spinner : spinners) {
           
            int typeAmount = Integer.parseInt(spinner.getValue().toString());
            for (int i = 0; i < typeAmount; i++) {
                
                getProducer(innerCounter).setProducerType(getProducerTypeByOrder(outerCounter));
                innerCounter += 1;
            }
            
            producersQty[outerCounter] = typeAmount;
            outerCounter+=1;
        }
        
        while (innerCounter <=14){
            getProducer(innerCounter).setProducerType(PTypes.noType);
            innerCounter += 1;
        }
        GlobalUI.getMainPage().getRMDashBoard1().getProducerPie().setChart(PieChart.createChart(PieChart.createDataset(producersQty), "Productores"));
        setMonthlySalaries();
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
        
        final DecimalFormat df = new DecimalFormat("0.00");
        double num  = (getTotalUtility() < 1000 ) ? (Math.abs(getTotalUtility())) : ((getTotalUtility()/1000));
//        double num  = (getTotalUtility() < 1000 ) ? (Math.round((Math.abs(getTotalUtility()))*100)/100) : (Math.round((getTotalUtility()/1000)));
        String sufix = (getTotalUtility() >= 1000 )? "M" : "K";
        String prefix = (getTotalUtility() < 0) ? "-$" : "$";
        
        return (prefix + df.format(num) + sufix);
     
    }
    
    public ProducersQtyController getProducersController() {
        return producersController;
    }
    
        public PM getPm() {
        return pm;
    }

    public Semaphore getCounterMutex() {
        return counterMutex;
    }
    
    public Producer[] getProducers() {
        return producers;
    }

    public void setProducers(Producer[] producers) {
        this.producers = producers;
    }
    public Director getDirector() {
        return director;
    }
    
    public void setMonthlySalaries(){
        float total = (this.getAllDailySalaries()*30)/1000;
        String label = ("$"+total+"K");
        GlobalUI.getMainPage().getRMDashBoard1().getMonthlySalariesLabel().setText(label);
    }
    
    public float getLaunchIncome(){
    int totalChapters = getDirector().getNormalChaptersAcc() + getDirector().getTwitChaptersAcc();
    return (float) (totalChapters*666.666);
    }
    
    public void registerTodayUility(){
        this.utilityOverTime[this.totalDayCounter] = getTotalUtility()/1000;
        this.totalDayCounter+=1;
        GlobalUI.getMainPage().getRMDashBoard1().getTotalDaysLabel().setText(String.valueOf(this.totalDayCounter)+" dias");
        GlobalUI.getMainPage().getRMDashBoard1().getUtilityChart().setChart(XYChart.createChart(XYChart.createDataset(this.utilityOverTime), "Utilidad vs Tiempo"));
        
       updateChartsInMainDashboard();
    }
    
    public void updateChartsInMainDashboard(){
    //TLOU
     GlobalUI.getMainPage().getMainDashBoard1().getUtilityChart().setChart(XYChart.createChart(XYChart.createDoubleDataset(this.utilityOverTime, TLOUStudio.utilityOverTime), "Utilidad vs Tiempo"));
    }



}
