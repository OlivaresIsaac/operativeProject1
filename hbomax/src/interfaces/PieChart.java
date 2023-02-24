/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.PTypes;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.util.Rotation;

/**
 *
 * @author isaac
 */
public class PieChart {
   
    public static ChartPanel createProducersPieChart(String chartTitle, int producersQty[]) {
        PieDataset dataset = createDataset(producersQty);
        JFreeChart chart = createChart(dataset, chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
    }

    public static PieDataset createDataset(int producersQty[]) {
     
        DefaultPieDataset result = new DefaultPieDataset();
        for (int i = 0; i<producersQty.length; i++) {
            String type = PTypes.getChartProducerLabels(i);
            int value = producersQty[i];
            result.setValue(type, value);
        }
//        result.setValue("Linux", 29);
//        result.setValue("Mac", 20);
//        result.setValue("Windows", 51);
//        result.setValue("hola", 50);
        return result;

    }

    public static JFreeChart createChart(PieDataset dataset, String title) {
      
        JFreeChart chart = ChartFactory.createPieChart3D(
            title, dataset, true, true, false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setCircular(true);
    
        return chart;

    }
   
   
}
