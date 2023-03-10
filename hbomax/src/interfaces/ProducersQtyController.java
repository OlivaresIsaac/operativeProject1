/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.FunctionsUI;
import javax.swing.JCheckBox;
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
    private final boolean isDrive;
    private final boolean doesUpdate;
    private boolean init;


    
        public ProducersQtyController(){
        initComponents();
        maxProducerQty = 1;
        studio = "dummy";
        spinners = new JSpinner[6];
        this.isDrive = false;
        this.doesUpdate = false;
        
    }
    
    public ProducersQtyController(int max, String studio, String Label, boolean isDrive, boolean doesUpdate) {
        initComponents();
        this.jPanel1.setOpaque(false);
        this.setOpaque(false);
        this.maxProducerQty = max;
        this.spinners = new JSpinner[6];
        this.studio = studio;
        this.titleLabel.setText(Label);
        this.isDrive = isDrive;
        this.doesUpdate = doesUpdate;
        if (isDrive){
        this.chaptersLabel.setText("Capítulos");
        this.availableProducerQty.setVisible(false);
        }
        else {
        hideCheckbox();
        }
        
        this.init = doesUpdate;
        

        fillSpinners();
        if (!doesUpdate) {
             setAvailableProducers();
        }
        
    }
    
        public void setInit(boolean init) {
        this.init = init;
    }
    
    public void hideCheckbox(){
        this.introInfinite.setVisible(false);
        this.startInfinite.setVisible(false);
        this.endInfinite.setVisible(false);
        this.twistInfinite.setVisible(false);
        this.creditInfinite.setVisible(false);
        this.chapterInfinite.setVisible(false);
        
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
        chaptersLabel = new javax.swing.JLabel();
        introSpinner = new javax.swing.JSpinner();
        startSpinner = new javax.swing.JSpinner();
        creditSpinner = new javax.swing.JSpinner();
        twistSpinner = new javax.swing.JSpinner();
        endSpinner = new javax.swing.JSpinner();
        availableProducerQty = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        chapterInfinite = new javax.swing.JCheckBox();
        introInfinite = new javax.swing.JCheckBox();
        startInfinite = new javax.swing.JCheckBox();
        creditInfinite = new javax.swing.JCheckBox();
        twistInfinite = new javax.swing.JCheckBox();
        endInfinite = new javax.swing.JCheckBox();

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

        chaptersLabel.setBackground(new java.awt.Color(255, 255, 255));
        chaptersLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        chaptersLabel.setForeground(new java.awt.Color(255, 255, 255));
        chaptersLabel.setText("Ensambladores");
        jPanel1.add(chaptersLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

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

        titleLabel.setBackground(new java.awt.Color(255, 255, 255));
        titleLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Productores Disponibles: ");
        jPanel1.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        chapterInfinite.setText("Infinito");
        jPanel1.add(chapterInfinite, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        introInfinite.setText("Infinito");
        jPanel1.add(introInfinite, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        startInfinite.setText("Infinito");
        jPanel1.add(startInfinite, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        creditInfinite.setText("Infinito");
        jPanel1.add(creditInfinite, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

        twistInfinite.setText("Infinito");
        jPanel1.add(twistInfinite, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        endInfinite.setText("Infinito");
        jPanel1.add(endInfinite, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 150));
    }// </editor-fold>//GEN-END:initComponents

    private void endSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_endSpinnerStateChanged
        if (!this.isDrive && !this.init){
             this.endSpinner.setValue(FunctionsUI.validateNumberSpinnerRM(this.maxProducerQty, getSpinners(), endSpinner.getValue().toString(), studio, this.doesUpdate));
        setAvailableProducers();
        }
       
    }//GEN-LAST:event_endSpinnerStateChanged

    private void twistSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_twistSpinnerStateChanged
        if (!this.isDrive && !this.init){
        this.twistSpinner.setValue(FunctionsUI.validateNumberSpinnerRM(this.maxProducerQty, getSpinners(), twistSpinner.getValue().toString(), studio, this.doesUpdate));
        setAvailableProducers();
        }
    }//GEN-LAST:event_twistSpinnerStateChanged

    private void creditSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_creditSpinnerStateChanged
       if (!this.isDrive && !this.init){ 
        this.creditSpinner.setValue(FunctionsUI.validateNumberSpinnerRM(this.maxProducerQty, getSpinners(), creditSpinner.getValue().toString(), studio, this.doesUpdate));
       setAvailableProducers();
       }
    }//GEN-LAST:event_creditSpinnerStateChanged

    private void startSpinnerrStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_startSpinnerrStateChanged
        if (!this.isDrive && !this.init){
        this.startSpinner.setValue(FunctionsUI.validateNumberSpinnerRM(this.maxProducerQty, getSpinners(), startSpinner.getValue().toString(), studio, this.doesUpdate));
        setAvailableProducers();
        }
    }//GEN-LAST:event_startSpinnerrStateChanged

    private void introSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_introSpinnerStateChanged
        if (!this.isDrive && !this.init) {
        this.introSpinner.setValue(FunctionsUI.validateNumberSpinnerRM(this.maxProducerQty, getSpinners(), introSpinner.getValue().toString(), studio, this.doesUpdate));
        setAvailableProducers();
        }
    }//GEN-LAST:event_introSpinnerStateChanged

    private void assemblerSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_assemblerSpinnerStateChanged
    if (!this.isDrive && !this.init){
        this.assemblerSpinner.setValue(FunctionsUI.validateNumberSpinnerRM(this.maxProducerQty, getSpinners(), assemblerSpinner.getValue().toString(), studio, this.doesUpdate));
    setAvailableProducers();
    }
    }//GEN-LAST:event_assemblerSpinnerStateChanged
   
    public int[] getDriveQtys(){ 
        int[] driveQtys = new int[6];
        driveQtys[0] = this.introInfinite.isSelected() ? -1 : Integer.parseInt(this.introSpinner.getValue().toString());
        driveQtys[1] = this.startInfinite.isSelected() ? -1 : Integer.parseInt(this.startSpinner.getValue().toString());
        driveQtys[2] = this.creditInfinite.isSelected() ? -1 : Integer.parseInt(this.creditSpinner.getValue().toString());
        driveQtys[3] = this.twistInfinite.isSelected() ? -1 : Integer.parseInt(this.twistSpinner.getValue().toString());
        driveQtys[4] = this.endInfinite.isSelected() ? -1 : Integer.parseInt(this.endSpinner.getValue().toString());
        driveQtys[5] = this.chapterInfinite.isSelected() ? -1 : Integer.parseInt(this.assemblerSpinner.getValue().toString());
       
        return driveQtys;
    }
    
    public int[] getProducersQtys(){ 
        int[] producersQty = new int[6];
        producersQty[0] = Integer.parseInt(this.introSpinner.getValue().toString());
        producersQty[1] = Integer.parseInt(this.startSpinner.getValue().toString());
        producersQty[2] = Integer.parseInt(this.creditSpinner.getValue().toString());
        producersQty[3] = Integer.parseInt(this.twistSpinner.getValue().toString());
        producersQty[4] = Integer.parseInt(this.endSpinner.getValue().toString());
        producersQty[5] = Integer.parseInt(this.assemblerSpinner.getValue().toString());
       
        return producersQty;
    }
        
    public void setSpinnersQtys(int [] spinnerQty){ 
        this.introSpinner.setValue(spinnerQty[0]);
        this.startSpinner.setValue(spinnerQty[1]);
        this.creditSpinner.setValue(spinnerQty[2]);
        this.twistSpinner.setValue(spinnerQty[3]);
        this.endSpinner.setValue(spinnerQty[4]);
        this.assemblerSpinner.setValue(spinnerQty[5]);
        setAvailableProducers();
        
   
    }
        
     public void updateQtysInSpinners(int[] producersQty){
        setInit(true);
        setSpinnersQtys(producersQty);
        setInit(false);
        setAvailableProducers();
    }
     
     public JCheckBox returnCheckBoxByOrder(int position){
              
        switch (position) {
            case 0:
                return this.introInfinite;
            case 1:
                return this.startInfinite;
            case 2:
                return this.creditInfinite;
            case 3:
                return this.twistInfinite;
            case 4:
                return this.endInfinite;
            case 5:
                return this.chapterInfinite;
            default:
                return null;
        
        }
     }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner assemblerSpinner;
    private javax.swing.JLabel availableProducerQty;
    private javax.swing.JCheckBox chapterInfinite;
    private javax.swing.JLabel chaptersLabel;
    private javax.swing.JCheckBox creditInfinite;
    private javax.swing.JSpinner creditSpinner;
    private javax.swing.JCheckBox endInfinite;
    private javax.swing.JSpinner endSpinner;
    private javax.swing.JCheckBox introInfinite;
    private javax.swing.JSpinner introSpinner;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox startInfinite;
    private javax.swing.JSpinner startSpinner;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JCheckBox twistInfinite;
    private javax.swing.JSpinner twistSpinner;
    // End of variables declaration//GEN-END:variables
}

 
