/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import interfaces.MainPage;

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
    
    public static void works(){
        System.out.println("works");
    }
    
    public static void updateMainDashBoardUI(String text){
       updateTotalPayedText(text);
    }
    
    public static void updateTotalPayedText(String text){
        mainPage.getMainDashBoard1().setTotalPayedLabel(text);
    }


}
