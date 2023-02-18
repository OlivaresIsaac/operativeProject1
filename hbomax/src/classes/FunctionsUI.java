/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.MainPage;
import javax.swing.JSpinner;

/**
 *
 * @author isaac
 */
public class FunctionsUI {
    private static final MainPage mainPage = new MainPage();

    public static MainPage getMainPage() {
        return mainPage;
    }
    
        /**
     * Opens project MainPage
     */
    public static void openMainPage() {
        getMainPage().setVisible(true);
        
    }
    
    
    public static void updateMainDashBoardUI(String text){
       updateTotalPayedText(text);
    }
    
    public static void updateTotalPayedText(String text){
        mainPage.getMainDashBoard1().setTotalPayedLabel(text);
    }
    
      /**
     * Validates all spinners numbers for RM studio
     * makes sure the sum of all producers and assemblers are not greater
     * than the max
     * @param maxProducersQty
     * @param spinners
     * @param originalValue
     * @param studio
     * @return spinnerValue
     */
    public static int validateNumberSpinnerRM(int maxProducersQty, JSpinner[] spinners, String originalValue, String studio) {
        int acc = calculateCurrentProducersQty(spinners);
        int newValue = Integer.parseInt(originalValue);
        
        if (acc <= maxProducersQty){
            if (studio.equals("RM")) {
                System.out.println("REASIGNANDO PRODUCTORES RM");
                Main.rm.reAssingProducerRoles(spinners);
            } else {
                //TODO poner reasignacción productores TLOU
            }
            
            return newValue;
        } else {
            return newValue-1;
        }
        
        
    }
    
          /**
     * Calculates the current the sum of producers in all spinners
     * than the max
     * @param spinner
     * @return spinnerValue
     */
    public static int calculateCurrentProducersQty(JSpinner[] spinners) {
          int acc = 0;
        for(int i = 0; i< spinners.length; i++){
            acc += Integer.parseInt(spinners[i].getValue().toString());
        }
        return acc;
    }
      /**
     * Gets the number of availableProducers
     * @param maxProducersQty, spinners
     * @param spinners
     * @return String
     */
     public static String getAvailableProducersQty(int maxProducersQty, JSpinner[] spinners){
        int acc = calculateCurrentProducersQty(spinners);
        String result = String.valueOf((maxProducersQty-acc));
        return result;
     }


}
