/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.FunctionsTXT;
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
        hboLogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        TotalPayedLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        driveController = new interfaces.ProducersQtyController(1000, "RM", "Espacio de Drive", true, false);
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tlouController = new interfaces.ProducersQtyController(16, "TLOU", "Productores disponibles", false, false);
        rmController = new interfaces.ProducersQtyController(15, "RM", "Productores disponibles", false, false);
        daysToLaunchSpinner = new javax.swing.JSpinner();
        dayDurationSpinner = new javax.swing.JSpinner();
        loadFileButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hboLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/hboLogo.png"))); // NOI18N
        jPanel1.add(hboLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 300, 90));

        jPanel2.setBackground(new java.awt.Color(102, 0, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TotalPayedLabel.setBackground(new java.awt.Color(255, 255, 255));
        TotalPayedLabel.setForeground(new java.awt.Color(255, 255, 255));
        TotalPayedLabel.setText("$0");
        jPanel2.add(TotalPayedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 110, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("HBO DASHBOARD");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 90));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("HBO DASHBOARD");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("HBO DASHBOARD");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel3.setBackground(new java.awt.Color(51, 0, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Dias Entre lanzamientos");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));
        jPanel3.add(driveController, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Configurar parámetros iniciales");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Studio TLOU");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Studio RM");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("General");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Duración del día (segundos)");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));
        jPanel3.add(tlouController, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, -1, -1));
        jPanel3.add(rmController, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, -1, -1));

        daysToLaunchSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jPanel3.add(daysToLaunchSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, -1, -1));

        dayDurationSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jPanel3.add(dayDurationSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        loadFileButton.setText("Guardar");
        loadFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileButtonActionPerformed(evt);
            }
        });
        jPanel3.add(loadFileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 90, 1060, 530));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void loadFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileButtonActionPerformed
       int durationDayInSec = Integer.parseInt(this.dayDurationSpinner.getValue().toString());
       int daysToLaunch = Integer.parseInt(this.daysToLaunchSpinner.getValue().toString());
        
        FunctionsTXT.saveInitialParameters(durationDayInSec, daysToLaunch, driveController.getDriveQtys(), rmController.getProducersQtys(), tlouController.getProducersQtys() );
    }//GEN-LAST:event_loadFileButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TotalPayedLabel;
    private javax.swing.JSpinner dayDurationSpinner;
    private javax.swing.JSpinner daysToLaunchSpinner;
    private interfaces.ProducersQtyController driveController;
    private javax.swing.JLabel hboLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton loadFileButton;
    private interfaces.ProducersQtyController rmController;
    private interfaces.ProducersQtyController tlouController;
    // End of variables declaration//GEN-END:variables


}
