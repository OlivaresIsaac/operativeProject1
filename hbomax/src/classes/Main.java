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
    public static int[] generalParameters = FunctionsTXT.loadGeneralInitialParameters();
    public static RMStudio rm = new RMStudio(generalParameters[0], generalParameters[1]);
    static TLOUStudio tlou = new TLOUStudio(4, 100, 1, 1, 1, 1, 1, 1);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        GlobalUI.openMainPage();
        rm.run();
        tlou.run();
    }
}
