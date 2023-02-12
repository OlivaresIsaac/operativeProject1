/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.RM.Producer;

/**
 *
 * @author isaac
 */
public class Main {
    
    public static PTypes ptypes = new PTypes();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Producer pepe = new Producer(ptypes.intro);
        pepe.start();
    }
    //fdfdf
}
