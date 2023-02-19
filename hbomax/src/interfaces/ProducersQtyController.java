/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.FunctionsUI;
import javax.swing.JSpinner;

/**
 *
 * @author isaac
 */
public final class ProducersQtyController extends javax.swing.JPanel {

    /**
     * Creates new form ProducersQtyController
     */
    private final int maxProducerQty;
    private final String studio;
    private final JSpinner[] spinners;
    
        public ProducersQtyController(){
        initComponents();
        maxProducerQty = 1;
        studio = "dummy";
        spinners = new JSpinner[6];
    }
    
    public ProducersQtyController(int max, String studio) {
        initComponents();
        this.jPanel1.setOpaque(false);
        this.setOpaque(false);
        this.maxProducerQty = max;
        this.spinners = new JSpinner[6];
        this.studio = studio;
        fillSpinners();
        setAvailableProducers();
    }
    
    public void setAvailableProducers(){
        this.availableProducerQty.setText(FunctionsUI.getAvailableProducersQty(this.maxProducerQty, this.spinners));
    }

    public JSpinner[] getSpinners() {
        return spinners;
    }
    
    public void fillSpinners(){
        this.spinners[0] = this.introSpinner;
        this.spinners[1] = this.startSpinner;
        this.spinners[2] = this.creditSpinner;
        this.spinners[3] = this.twistSpinner;
        this.spinners[4] = this.endSpinner;
        this.spinners[5] = this.assemblerSpinner;
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
        assemblerSpinner = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        introSpinner = new javax.swing.JSpinner();
        startSpinner = new javax.swing.JSpinner();
        creditSpinner = new javax.swing.JSpinner();
        twistSpinner = new javax.swing.JSpinner();
        endSpinner = new javax.swing.JSpinner();
        availableProducerQty = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assemblerSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        assemblerSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                assemblerSpinnerStateChanged(evt);
            }
        });
        jPanel1.add(assemblerSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 50, -1));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Intro");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Inicio");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Créditos");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Plot Twist");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Cierre");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Ensambladores");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        introSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        introSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                introSpinnerStateChanged(evt);
            }
        });
        jPanel1.add(introSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 50, -1));

        startSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        startSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                startSpinnerrStateChanged(evt);
            }
        });
        jPanel1.add(startSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 50, -1));

        creditSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        creditSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                creditSpinnerStateChanged(evt);
            }
        });
        jPanel1.add(creditSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 50, -1));

        twistSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        twistSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                twistSpinnerStateChanged(evt);
            }
        });
        jPanel1.add(twistSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 50, -1));

        endSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        endSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                endSpinnerStateChanged(evt);
            }
        });
        jPanel1.add(endSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 50, -1));

        availableProducerQty.setBackground(new java.awt.Color(255, 255, 255));
        availableProducerQty.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        availableProducerQty.setForeground(new java.awt.Color(255, 255, 255));
        availableProducerQty.setText("n");
        jPanel1.add(availableProducerQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Productores Disponibles: ");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 150));
    }// </editor-fold>//GEN-END:initComponents

    private void endSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_endSpinnerStateChanged
        this.endSpinner.setValue(FunctionsUI.validateNumberSpinnerRM(this.maxProducerQty, getSpinners(), endSpinner.getValue().toString(), studio));
        setAvailableProducers();
    }//GEN-LAST:event_endSpinnerStateChanged

    private void twistSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_twistSpinnerStateChanged
        this.twistSpinner.setValue(FunctionsUI.validateNumberSpinnerRM(this.maxProducerQty, getSpinners(), twistSpinner.getValue().toString(), studio));
        setAvailableProducers();
    }//GEN-LAST:event_twistSpinnerStateChanged

    private void creditSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_creditSpinnerStateChanged
       this.creditSpinner.setValue(FunctionsUI.validateNumberSpinnerRM(this.maxProducerQty, getSpinners(), creditSpinner.getValue().toString(), studio));
       setAvailableProducers();
    }//GEN-LAST:event_creditSpinnerStateChanged

    private void startSpinnerrStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_startSpinnerrStateChanged
        this.startSpinner.setValue(FunctionsUI.validateNumberSpinnerRM(this.maxProducerQty, getSpinners(), startSpinner.getValue().toString(), studio));
        setAvailableProducers();
    }//GEN-LAST:event_startSpinnerrStateChanged

    private void introSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_introSpinnerStateChanged
        this.introSpinner.setValue(FunctionsUI.validateNumberSpinnerRM(this.maxProducerQty, getSpinners(), introSpinner.getValue().toString(), studio));
        setAvailableProducers();
    }//GEN-LAST:event_introSpinnerStateChanged

    private void assemblerSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_assemblerSpinnerStateChanged
    this.assemblerSpinner.setValue(FunctionsUI.validateNumberSpinnerRM(this.maxProducerQty, getSpinners(), assemblerSpinner.getValue().toString(), studio));
    setAvailableProducers();
    }//GEN-LAST:event_assemblerSpinnerStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner assemblerSpinner;
    private javax.swing.JLabel availableProducerQty;
    private javax.swing.JSpinner creditSpinner;
    private javax.swing.JSpinner endSpinner;
    private javax.swing.JSpinner introSpinner;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner startSpinner;
    private javax.swing.JSpinner twistSpinner;
    // End of variables declaration//GEN-END:variables
}