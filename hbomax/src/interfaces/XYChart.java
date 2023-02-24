/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Main;
import classes.PTypes;
import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.Rotation;

/**
 *
 * @author isaac
 */
public class XYChart {
        public static ChartPanel createUtilityXYChart(String chartTitle, double[] utilityOverTime) {
//        double [] utilityOverTime = Main.rm.getUtilityOverTime();
        XYDataset dataset = createDataset(utilityOverTime);
        JFreeChart xyChart = createChart(dataset, chartTitle);
        ChartPanel chartPanel = new ChartPanel( xyChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      final XYPlot plot = xyChart.getXYPlot( );
      
      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
      renderer.setSeriesPaint( 0 , Color.RED );
      renderer.setSeriesPaint( 1 , Color.BLUE );
 
      renderer.setSeriesStroke( 0 , new BasicStroke( 8.0f ) );
      renderer.setSeriesStroke( 1 , new BasicStroke( 8.0f ) );
      plot.setRenderer( renderer ); 
     
        return chartPanel;
    }

    public static XYDataset createDataset(double[] utilityOverTime) {
     
        final XYSeries serie1 = new XYSeries( "Utilidad" );    
        
        for (int i = 0; i<utilityOverTime.length;i++){
            if (i!=0 && utilityOverTime[i] == 0) {
                break;
            }
            
            serie1.add(i, utilityOverTime[i]);
        }
             
      final XYSeriesCollection dataset = new XYSeriesCollection();          
      dataset.addSeries( serie1 ); 
      
      
        return dataset;

    }
    
        public static XYDataset createDoubleDataset(double[] utilityOverTimeRM, double[] utilityOverTimeTLOU) {
     
        final XYSeries serie1 = new XYSeries( "Studio RM" );    
        
        for (int i = 0; i<utilityOverTimeRM.length;i++){
            if (i!=0 &&  utilityOverTimeRM[i] == 0) {
                break;
            }
            
            serie1.add(i, utilityOverTimeRM[i]);
        }
        
        final XYSeries serie2 = new XYSeries( "Studio TLOU" );    
        
        for (int i = 0; i<utilityOverTimeTLOU.length;i++){
            if ( i!=0 && utilityOverTimeTLOU[i] == 0) {
                break;
            }
            
            serie2.add(i, utilityOverTimeTLOU[i]);
        }

             
      final XYSeriesCollection dataset = new XYSeriesCollection();          
      dataset.addSeries( serie1 ); 
      dataset.addSeries( serie2 );
      
      
        return dataset;

    }

    public static JFreeChart createChart(XYDataset dataset, String title) {
      
        JFreeChart chart = ChartFactory.createXYLineChart(title, "Tiempo (Dias)", "Utilidad (Millones $)", dataset, PlotOrientation.VERTICAL ,true , true , false);
        
    
        return chart;

    }
}
