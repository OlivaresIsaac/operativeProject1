/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.TLOU;

/**
 *
 * @author dsre1
 */
public class Assembler {

    private final double salaryPerHour;
    private final int daysToCap;

    public Assembler() {
        this.salaryPerHour = 8;
        this.daysToCap = 2;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public int getDaysToCap() {
        return daysToCap;
    }

}
