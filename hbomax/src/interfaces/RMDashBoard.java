/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import classes.FunctionsUI;
import javax.swing.JLabel;
import javax.swing.JSpinner;

/**
 *
 * @author isaac
 */
public class RMDashBoard extends javax.swing.JPanel {

    /** Creates new form RMDashBoard */
    public RMDashBoard() {
        initComponents();
   
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        RMLogo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        RMLogo1 = new javax.swing.JLabel();
        daysToLaunchLabel = new javax.swing.JLabel();
        totalChapterQty = new javax.swing.JLabel();
        totalUtility = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pmFaultsLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        twistChapterQty = new javax.swing.JLabel();
        directorStateLabel = new javax.swing.JLabel();
        pmStateLabel = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        producersQtyController1 = new interfaces.ProducersQtyController(15, "RM","Productores disponibles", false, true);
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        normalChapterQty = new javax.swing.JLabel();
        introDriveMax = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        introDriveQty = new javax.swing.JLabel();
        startDriveQty = new javax.swing.JLabel();
        creditDriveQty = new javax.swing.JLabel();
        twistDriveQty = new javax.swing.JLabel();
        endDriveQty = new javax.swing.JLabel();
        endDriveMax = new javax.swing.JLabel();
        twistDriveMax = new javax.swing.JLabel();
        creditDriveMax = new javax.swing.JLabel();
        startDriveMax = new javax.swing.JLabel();
        monthlySalariesLabel = new javax.swing.JLabel();
        launchIncomeLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        pmSalaryLabel = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        regularChapterLaunchLabel = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        twistChapterLaunchLabel = new javax.swing.JLabel();
        rmWallpaper = new javax.swing.JLabel();

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("HBO DASHBOARD");

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RMLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/RMLogo.png"))); // NOI18N
        jPanel2.add(RMLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, 80));

        jPanel3.setBackground(new java.awt.Color(153, 102, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RMLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/RMLogo.png"))); // NOI18N
        jPanel3.add(RMLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, 80));

        daysToLaunchLabel.setBackground(new java.awt.Color(255, 255, 255));
        daysToLaunchLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        daysToLaunchLabel.setForeground(new java.awt.Color(255, 255, 255));
        daysToLaunchLabel.setText("5 días");
        jPanel3.add(daysToLaunchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 120, -1));

        totalChapterQty.setBackground(new java.awt.Color(255, 255, 255));
        totalChapterQty.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        totalChapterQty.setForeground(new java.awt.Color(255, 255, 255));
        totalChapterQty.setText("0");
        jPanel3.add(totalChapterQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 100, 30));

        totalUtility.setBackground(new java.awt.Color(255, 255, 255));
        totalUtility.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        totalUtility.setForeground(new java.awt.Color(255, 255, 255));
        totalUtility.setText("$1.200.350");
        jPanel3.add(totalUtility, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 130, 30));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Capítulos: ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Utilidad:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 120, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Próximo corte en");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 210, -1));
        jPanel3.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 270, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 90));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 90));

        jPanel4.setBackground(new java.awt.Color(153, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Gráfico de producción");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 390, 270));

        pmFaultsLabel.setBackground(new java.awt.Color(255, 255, 255));
        pmFaultsLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        pmFaultsLabel.setForeground(new java.awt.Color(255, 255, 255));
        pmFaultsLabel.setText("0 faltas");
        jPanel1.add(pmFaultsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Estadísticas Por Mes");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, -1, -1));

        twistChapterQty.setBackground(new java.awt.Color(255, 255, 255));
        twistChapterQty.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        twistChapterQty.setForeground(new java.awt.Color(255, 255, 255));
        twistChapterQty.setText("0");
        jPanel1.add(twistChapterQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, -1, 20));

        directorStateLabel.setBackground(new java.awt.Color(255, 255, 255));
        directorStateLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        directorStateLabel.setForeground(new java.awt.Color(255, 255, 255));
        directorStateLabel.setText("Trabajando");
        jPanel1.add(directorStateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        pmStateLabel.setBackground(new java.awt.Color(255, 255, 255));
        pmStateLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        pmStateLabel.setForeground(new java.awt.Color(255, 255, 255));
        pmStateLabel.setText("Viendo Series");
        jPanel1.add(pmStateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("PM:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));
        jPanel1.add(producersQtyController1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gestionar empleados");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Director:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Cierre");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        normalChapterQty.setBackground(new java.awt.Color(255, 255, 255));
        normalChapterQty.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        normalChapterQty.setForeground(new java.awt.Color(255, 255, 255));
        normalChapterQty.setText("0");
        jPanel1.add(normalChapterQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        introDriveMax.setBackground(new java.awt.Color(255, 255, 255));
        introDriveMax.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        introDriveMax.setForeground(new java.awt.Color(255, 255, 255));
        introDriveMax.setText("0");
        jPanel1.add(introDriveMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 100, -1));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Máximo");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, -1, -1));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Inicio");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Créditos");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, -1, -1));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Plot Twist");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, -1));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Intro");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, -1, -1));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Disponible");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, -1, -1));

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Partes");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 50, -1));

        introDriveQty.setBackground(new java.awt.Color(255, 255, 255));
        introDriveQty.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        introDriveQty.setForeground(new java.awt.Color(255, 255, 255));
        introDriveQty.setText("0");
        jPanel1.add(introDriveQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 30, -1));

        startDriveQty.setBackground(new java.awt.Color(255, 255, 255));
        startDriveQty.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        startDriveQty.setForeground(new java.awt.Color(255, 255, 255));
        startDriveQty.setText("0");
        jPanel1.add(startDriveQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 30, -1));

        creditDriveQty.setBackground(new java.awt.Color(255, 255, 255));
        creditDriveQty.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        creditDriveQty.setForeground(new java.awt.Color(255, 255, 255));
        creditDriveQty.setText("0");
        jPanel1.add(creditDriveQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 30, -1));

        twistDriveQty.setBackground(new java.awt.Color(255, 255, 255));
        twistDriveQty.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        twistDriveQty.setForeground(new java.awt.Color(255, 255, 255));
        twistDriveQty.setText("0");
        jPanel1.add(twistDriveQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 30, -1));

        endDriveQty.setBackground(new java.awt.Color(255, 255, 255));
        endDriveQty.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        endDriveQty.setForeground(new java.awt.Color(255, 255, 255));
        endDriveQty.setText("0");
        jPanel1.add(endDriveQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 30, -1));

        endDriveMax.setBackground(new java.awt.Color(255, 255, 255));
        endDriveMax.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        endDriveMax.setForeground(new java.awt.Color(255, 255, 255));
        endDriveMax.setText("0");
        jPanel1.add(endDriveMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 120, -1));

        twistDriveMax.setBackground(new java.awt.Color(255, 255, 255));
        twistDriveMax.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        twistDriveMax.setForeground(new java.awt.Color(255, 255, 255));
        twistDriveMax.setText("0");
        jPanel1.add(twistDriveMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 100, -1));

        creditDriveMax.setBackground(new java.awt.Color(255, 255, 255));
        creditDriveMax.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        creditDriveMax.setForeground(new java.awt.Color(255, 255, 255));
        creditDriveMax.setText("0");
        jPanel1.add(creditDriveMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 100, -1));

        startDriveMax.setBackground(new java.awt.Color(255, 255, 255));
        startDriveMax.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        startDriveMax.setForeground(new java.awt.Color(255, 255, 255));
        startDriveMax.setText("0");
        jPanel1.add(startDriveMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 100, -1));

        monthlySalariesLabel.setBackground(new java.awt.Color(255, 255, 255));
        monthlySalariesLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        monthlySalariesLabel.setForeground(new java.awt.Color(255, 255, 255));
        monthlySalariesLabel.setText("$0");
        jPanel1.add(monthlySalariesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 280, 120, -1));

        launchIncomeLabel.setBackground(new java.awt.Color(255, 255, 255));
        launchIncomeLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        launchIncomeLabel.setForeground(new java.awt.Color(255, 255, 255));
        launchIncomeLabel.setText("$0");
        jPanel1.add(launchIncomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, 90, 20));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Visualizar Recursos");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        pmSalaryLabel.setBackground(new java.awt.Color(255, 255, 255));
        pmSalaryLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        pmSalaryLabel.setForeground(new java.awt.Color(255, 255, 255));
        pmSalaryLabel.setText("$0");
        jPanel1.add(pmSalaryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Capitulos regulares");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Capitulos con twist");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, 20));

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Salarios Mensuales");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, -1, 20));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Capitulos regulares");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, -1, -1));

        regularChapterLaunchLabel.setBackground(new java.awt.Color(255, 255, 255));
        regularChapterLaunchLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        regularChapterLaunchLabel.setForeground(new java.awt.Color(255, 255, 255));
        regularChapterLaunchLabel.setText("0");
        jPanel1.add(regularChapterLaunchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, 70, -1));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Ganancias del Lote");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, -1, 20));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Estadísticas del último lote");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Capitulos con twist");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, -1, 20));

        twistChapterLaunchLabel.setBackground(new java.awt.Color(255, 255, 255));
        twistChapterLaunchLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        twistChapterLaunchLabel.setForeground(new java.awt.Color(255, 255, 255));
        twistChapterLaunchLabel.setText("0");
        jPanel1.add(twistChapterLaunchLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 160, 90, -1));

        rmWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/rmWallpaper.png"))); // NOI18N
        jPanel1.add(rmWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RMLogo;
    private javax.swing.JLabel RMLogo1;
    private javax.swing.JLabel creditDriveMax;
    private javax.swing.JLabel creditDriveQty;
    private javax.swing.JLabel daysToLaunchLabel;
    private javax.swing.JLabel directorStateLabel;
    private javax.swing.JLabel endDriveMax;
    private javax.swing.JLabel endDriveQty;
    private javax.swing.JLabel introDriveMax;
    private javax.swing.JLabel introDriveQty;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel launchIncomeLabel;
    private javax.swing.JLabel monthlySalariesLabel;
    private javax.swing.JLabel normalChapterQty;
    private javax.swing.JLabel pmFaultsLabel;
    private javax.swing.JLabel pmSalaryLabel;
    private javax.swing.JLabel pmStateLabel;
    private interfaces.ProducersQtyController producersQtyController1;
    private javax.swing.JLabel regularChapterLaunchLabel;
    private javax.swing.JLabel rmWallpaper;
    private javax.swing.JLabel startDriveMax;
    private javax.swing.JLabel startDriveQty;
    private javax.swing.JLabel totalChapterQty;
    private javax.swing.JLabel totalUtility;
    private javax.swing.JLabel twistChapterLaunchLabel;
    private javax.swing.JLabel twistChapterQty;
    private javax.swing.JLabel twistDriveMax;
    private javax.swing.JLabel twistDriveQty;
    // End of variables declaration//GEN-END:variables

    public JLabel getCreditDriveMax() {
        return creditDriveMax;
    }



    public JLabel getCreditDriveQty() {
        return creditDriveQty;
    }

    public JLabel getEndDriveMax() {
        return endDriveMax;
    }

  

    public JLabel getEndDriveQty() {
        return endDriveQty;
    }



    public JLabel getIntroDriveMax() {
        return introDriveMax;
    }


    public JLabel getIntroDriveQty() {
        return introDriveQty;
    }



    public JLabel getNormalChapterQty() {
        return normalChapterQty;
    }

 

    public ProducersQtyController getProducersQtyController1() {
        return producersQtyController1;
    }


    public JLabel getStartDriveMax() {
        return startDriveMax;
    }

 

    public JLabel getStartDriveQty() {
        return startDriveQty;
    }

  

    public JLabel getTwistChapterQty() {
        return twistChapterQty;
    }


    public JLabel getTwistDriveMax() {
        return twistDriveMax;
    }



    public JLabel getTwistDriveQty() {
        return twistDriveQty;
    }
    
    public JLabel getTotalChapterQty(){
        return totalChapterQty;
    }
    public JLabel getTotalUtility(){
        return totalUtility;
    }
    
    public JLabel getDaysToLaunchLabel()
    {
        return daysToLaunchLabel;
    }
    
    public JLabel getPmStateLabel(){
        return pmStateLabel;
    }
    
    public JLabel getDirectorStateLabel(){
        return directorStateLabel;
    }
    
    public JLabel getPmFaultsLabel(){
        return pmFaultsLabel;
    }
    public JLabel getPmSalaryLabel(){
        return pmSalaryLabel;
    }
    public JLabel getMonthlySalariesLabel(){
        return monthlySalariesLabel;
    }
    
    public JLabel getLaunchIncomeLabel(){
        return launchIncomeLabel;
    }
    
    public JLabel getRegularChapterLaunchLabel(){
        return regularChapterLaunchLabel;
    }
    
    public JLabel getTwistChapterLaunchLabel(){
        return twistChapterLaunchLabel;
    }



}
