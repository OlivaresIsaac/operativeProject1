/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import javax.swing.JLabel;

/**
 *
 * @author isaac
 */
public class MainDashBoard extends javax.swing.JPanel {

    /**
     * Creates new form MainDashBoard
     */
    public MainDashBoard() {
        initComponents();
    }
    
    public void setTotalPayedLabel(String text){
        this.TotalPayedLabel.setText(text);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TotalPayedLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("DashBoard");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 20, -1, -1));

        jLabel2.setText("Dinero en sueldos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        TotalPayedLabel.setText("$0");
        jPanel1.add(TotalPayedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 110, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 480));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TotalPayedLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables


}
