/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.RM.Producer;
import classes.RM.RMStudio;

/**
 *
 * @author isaac
 */
public class Main {
   
     static RMStudio rm = new RMStudio();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FunctionsUI.openMainPage();
        rm.run();
//        Producer pepe = new Producer(PTypes.intro, 1);
//        pepe.start();
    }
    //fdfdf
}
