/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.TLOU;

import java.util.concurrent.Semaphore;

/**
 *
 * @author dsre1
 */
public class Counter {

    private int originalCountdown;
    private int countdown;

    private Semaphore semaphore;

    public Counter(int countdown) {
        this.originalCountdown = countdown;
        this.countdown = countdown;
        this.semaphore = new Semaphore(1);
    }

    public void resetCountdown() {
        this.countdown = this.originalCountdown;
    }

    public void dayPassed() {
        this.countdown -= 1;
    }

    public int getCountdown() {
        return countdown;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

}
