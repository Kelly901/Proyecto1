/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Kelly
 */
public class DashboardClientes {
   
    
    
    public DashboardClientes(){
         DefaultPieDataset pie=new DefaultPieDataset();
        
        Componentes.Cliente[] datos1 = Componentes.CargaDeDatos.clientes;
        System.out.println("hola");
        int sumaF=0;
        int sumaM=0;
        for (int i = 0; i < datos1.length; i++) {
            if (datos1[i]!=null) {
                 
                if (datos1[i].getSexo()=='F') {
                      sumaF+=i;
                    System.out.println("hola1");
                    return;
                } else {
                 
                    sumaM+=i;
                }
                    
                
            }
        }
        pie.setValue("Hombres",30);
       pie.setValue("Mujeres", 70);
         
        
        JFreeChart chart= ChartFactory.createPieChart("Clasificación de clientes por sexo", pie,true,true,false);
        
        ChartFrame frames= new ChartFrame("Dashboard", chart);
        System.out.println("adios");
        frames.pack();
        frames.setVisible(true);
        
    }
}
