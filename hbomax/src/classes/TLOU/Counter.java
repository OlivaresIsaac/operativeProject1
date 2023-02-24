/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.TLOU;

import classes.GlobalUI;
import java.util.concurrent.Semaphore;

/**
 *
 * @author dsre1
 */
public class Counter {

    private int countdown;
    private int originalCountdown;

    public void setOriginalCountdown(int originalCountdown) {
        this.originalCountdown = originalCountdown;
    }
    
    private double total;
    private double totalPaid;
    private double totalGain;
    private double salaryPerMonth;
    
    private int chaptersThisBatch;
    private double totalThisBatch;
    private int normalChaptersThisBatch;
    private int twistChaptersThisBatch;

    private int totalChapters;
    private int totalNormalChapters;
    private int totalTwistChapters;

    private Semaphore semaphore;

    public Counter(int countdown) {
        this.countdown = countdown;
        this.originalCountdown = countdown;
        
        this.total = 0;
        this.totalPaid = 0;
        this.totalGain = 0;
        this.salaryPerMonth = 0;
        
        this.totalThisBatch = 0;
        this.chaptersThisBatch = 0;
        this.normalChaptersThisBatch = 0;
        this.twistChaptersThisBatch = 0;

        this.totalChapters = 0;

        this.semaphore = new Semaphore(1);
    }

    public void resetCountdown() {
        this.countdown = this.originalCountdown;
    }

    public void dayPassed() {
        this.countdown -= 1;
        GlobalUI.getMainPage().getTLOUDashBoard().getDaysToLaunchLabel().setText(String.valueOf(this.countdown) + " días");
    }
    
    public String getStringToTotal(){
        double aux = this.total / 1000;
        double num  = (aux < 1000 ) ? (Math.round((Math.abs(aux))*100)/100) : (Math.round((aux/1000)));
        String sufix = (aux >= 1000 )? "M" : "K";
        String prefix = (aux < 0) ? "-$" : "$";
        
        return (prefix + num + sufix);
     
    }
    
    private void updateTotal() {
        this.total = this.totalGain - this.totalPaid;
        System.out.print("TOTAL: " + this.total + "\n");
        GlobalUI.getMainPage().getTLOUDashBoard().getTotalUtilityLabel().setText(this.getStringToTotal());
    }
    
    public void updateTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
        this.updateTotal();
    }
    
    public void updateTotalGain() {
        this.totalThisBatch = this.profitPerAudience(110) * 10000 * this.chaptersThisBatch;
        this.totalGain += this.totalThisBatch;
        this.updateTotal();
        
        this.chaptersThisBatch = 0;
        
        GlobalUI.getMainPage().getTLOUDashBoard().getLaunchIncomeLabel().setText(String.valueOf(this.totalThisBatch));
        this.totalThisBatch = 0;
        
        GlobalUI.getMainPage().getTLOUDashBoard().getRegularChapterLaunchLabel().setText(String.valueOf(this.normalChaptersThisBatch));
        this.normalChaptersThisBatch = 0;
        
        this.twistChaptersThisBatch = 0;
        GlobalUI.getMainPage().getTLOUDashBoard().getTwistChapterLaunchLabel().setText(String.valueOf(this.twistChaptersThisBatch));
        
    }
    
    public void updateTotalChapter(int deliverables) {
        this.totalChapters += deliverables;
        this.chaptersThisBatch += deliverables;
        
        GlobalUI.getMainPage().getTLOUDashBoard().getTotalChapterQtyLabel().setText(String.valueOf(this.totalChapters));

        if (totalChapters % 5 == 0) {
            this.addNewTwistChapter();
        } else {
            this.addNewNormalChapter();
        }
    }

    private void addNewTwistChapter() {
        this.totalTwistChapters += 1;
        this.twistChaptersThisBatch += 1;
        GlobalUI.getMainPage().getTLOUDashBoard().getTwistChapterQtyLabel().setText(String.valueOf(this.totalTwistChapters));
    }

    private void addNewNormalChapter() {
        this.totalNormalChapters += 1;
        this.normalChaptersThisBatch += 1;
        GlobalUI.getMainPage().getTLOUDashBoard().getNormalChapterQtyLabel().setText(String.valueOf(this.totalNormalChapters));
    }
    
    public int getCountdown() {
        return countdown;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }
    
    private int profitPerAudience(int audience) {
        return (int) (audience * 10) / 15;
    }
    
    public void setSalaryPerMonth(double setSalaryPerMonth) {
        this.salaryPerMonth = setSalaryPerMonth * 30;
        GlobalUI.getMainPage().getTLOUDashBoard().getMonthlySalariesLabel().setText("$" + String.valueOf(this.salaryPerMonth));
    }

    public double getTotal() {
        return total;
    }
    
    
    
}
