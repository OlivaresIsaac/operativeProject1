/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.RM.Producer;
import classes.RM.RMStudio;
import classes.TLOU.TLOUStudio;

/**
 *
 * @author isaac
 */
public class Main {
   
//     static RMStudio rm = new RMStudio();
     static TLOUStudio tlou = new TLOUStudio(404, 2000, 1, 1, 1, 1, 1, 2);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        FunctionsUI.openMainPage();
//        rm.run();
        tlou.run();
//        Producer pepe = new Producer(PTypes.intro, 1);
//        pepe.start();
    }
    //fdfdf
}
