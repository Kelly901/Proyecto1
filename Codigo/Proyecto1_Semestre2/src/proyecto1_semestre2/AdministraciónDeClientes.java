/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Kelly
 */
public class AdministraciónDeClientes extends JFrame {

    JButton clienteN;
    JButton mostrarTabla;
    JButton infoClientes;
     DefaultPieDataset pie=new DefaultPieDataset();
    JPanel panel7;
    JButton menuPrincipal;
   JButton dashboard; 
    public AdministraciónDeClientes() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        Panel7();
    }

    public void Panel7() {

        panel7 = new JPanel();
        panel7.setSize(500, 500);
        panel7.setLayout(null);
        panel7.setBackground(Color.black);
        this.add(panel7);
        agregarComponentes2();
    }

    public void agregarComponentes2() {
        //Labeñ
        JLabel label = new JLabel("ADMINISTRACION DE CLIENTES");
        label.setBounds(80, 0, 335, 45);
        label.setFont(new Font("arial", Font.CENTER_BASELINE, 18));
        label.setForeground(Color.WHITE);
        panel7.add(label);
        //Cliente
        clienteN = new JButton("Cliente Nuevo");
        clienteN.setBounds(80, 80, 170, 40);
        clienteN.setBackground(Color.BLACK);
        clienteN.setForeground(Color.CYAN);
        clienteN.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panel7.add(clienteN);
        //Boton mostrar Tabla
        mostrarTabla = new JButton("Tabla");
        mostrarTabla.setBounds(80, 125, 150, 40);
        mostrarTabla.setBackground(Color.BLACK);
        mostrarTabla.setForeground(Color.BLUE);
        mostrarTabla.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panel7.add(mostrarTabla);

        //Boton para acceder a la informacion de los clientes
        infoClientes = new JButton("Información de \n clientes");
        infoClientes.setBounds(80, 170, 150, 60);
        infoClientes.setBackground(Color.BLACK);
        infoClientes.setForeground(Color.WHITE);
        infoClientes.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panel7.add(infoClientes);
        //Dashboard
        dashboard = new JButton("Dashboard");
        dashboard.setBounds(80, 240, 150, 60);
        dashboard.setBackground(Color.BLACK);
        dashboard.setForeground(Color.GREEN);
        dashboard.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panel7.add(dashboard);
        //Menu Principal
         menuPrincipal = new JButton("Menu Principal");
        menuPrincipal.setBounds(80, 305, 150, 60);
        menuPrincipal.setBackground(Color.BLACK);
        menuPrincipal.setForeground(Color.CYAN);
        menuPrincipal.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panel7.add(menuPrincipal);
        //Boton cerrar sesicon
        
        
        
        inciarClienteN();

    }

    public void inciarClienteN() {

        //Este boton abre la clase VentanaClienteNuevo
        clienteN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                VentanaClienteNuevo venNuevo = new VentanaClienteNuevo();
                venNuevo.show();
                dispose();
            }
        });

        //LLLA,A la ventanaCLIENTES
        mostrarTabla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaClientes venClientes = new VentanaClientes();
                venClientes.show();
                dispose();
            }
        });
        infoClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                InformacionDelCliente info = new InformacionDelCliente();
                info.show();
                dispose();
            }
        });
        //Ir al dashboard de clientes
        dashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//             DashboardClientes dash= new DashboardClientes();
             JFreeChart grafico=null;
              DefaultPieDataset datosPie= new DefaultPieDataset();
              float suma1=0;
              float suma2=0;
              float porcentaje=0;
              float porcentaje2=0;
              float sumaTotal=0;
              Componentes.Cliente[] datos1 = Componentes.CargaDeDatos.clientes;
                for (int i = 0; i < datos1.length; i++) {
                    if (datos1[i]!=null) {
                        if (datos1[i].getSexo()=='F') {
                           
                            suma1++;
                            
                        }else {
                            
                            suma2++;
                            
                         
                        }
                    }
                }
               
                sumaTotal=suma1+suma2;
               
                porcentaje=(suma1*100)/sumaTotal;
                porcentaje2=(suma2*100)/sumaTotal;
                
              datosPie.setValue("HOMBRE",porcentaje2);
              datosPie.setValue("Mujer",porcentaje);
              grafico=ChartFactory.createPieChart("Gráfica del sexo de clietes", datosPie, true, true, false);
              //Grafica de barras
              JFreeChart grafica2= null;
              int contEdad1=0;
              int contEdad2=0;
              int contEdad3=0;
              int contEdad4=0;
              int contEdad5=0;
              int contEdad6=0;
              int contEdad7=0;
              
              
               DefaultCategoryDataset datos= new DefaultCategoryDataset();
                for (int i = 0; i < datos1.length; i++) {
                    if (datos1[i]!=null) {
                        if (datos1[i].getEdad()>0  && datos1[i].getEdad()<=15) {
                            contEdad1++;
                        }else if (datos1[i].getEdad()>15  && datos1[i].getEdad()<=30) {
                            contEdad2++;
                        }else if (datos1[i].getEdad()>30  && datos1[i].getEdad()<=45) {
                            contEdad3++;
                        }else if (datos1[i].getEdad()>45  && datos1[i].getEdad()<=60) {
                            contEdad4++;
                        }else if (datos1[i].getEdad()>60  && datos1[i].getEdad()<=75) {
                            contEdad5++;
                        }else if (datos1[i].getEdad()>75  && datos1[i].getEdad()<=90) {
                            contEdad6++;
                        }else if (datos1[i].getEdad()>90  && datos1[i].getEdad()<=105) {
                            contEdad7++;
                        }
                    }
                }
                
               datos.addValue(contEdad1,"Grafica","0-15");
               datos.addValue(contEdad2,"Grafica","15-30");
               datos.addValue(contEdad3,"Grafica","30-45");
               datos.addValue(contEdad4,"Grafica","45-60");
               datos.addValue(contEdad5,"Grafica","60-75");
               datos.addValue(contEdad6,"Grafica","75-90");
               datos.addValue(contEdad7,"Grafica","90-105");
               grafica2= ChartFactory.createBarChart("Gráfica de rango de edades de Clientes","Eje x","Eje y", datos,PlotOrientation.VERTICAL,true,true,false);
            //Tabla
                DefaultTableModel model= new DefaultTableModel();
                JTable table1= new JTable();
                JPanel panelTabla= new JPanel();
                
                panelTabla.setLayout(new BorderLayout());
                panelTabla.setSize(300,500);
                panelTabla.add(table1);
                panelTabla.setVisible(true);
                model.addColumn("nombre");
                model.addColumn("Edad");
                model.addColumn("Sexi");
                model.addColumn("Nit");
                Object arreglo[]= new Object[100];
                for (int i = 0; i < arreglo.length; i++) {
                    if (datos1[i]!=null) {
                        arreglo[0]=datos1[i].getNombre();
                        arreglo[1]=datos1[i].getEdad();
                        arreglo[2]=datos1[i].getSexo();
                        arreglo[3]=datos1[i].getNit();
                          model.addRow(arreglo);
                    }
                }
                
               
                  
                
                JScrollPane pane = new JScrollPane(table1);
               
                panelTabla.add(pane);
                table1.setModel(model);
            //paneles
                ChartPanel piePanel = new ChartPanel(grafico);
                ChartPanel barraPable=new ChartPanel(grafica2);
                JPanel panelEtiqueta= new JPanel();
                
                //JFrame
                JFrame info= new JFrame("Grafica");
                info.setLayout(new GridLayout(2,1));
               
                info.getContentPane().add(piePanel);
                info.getContentPane().add(panelTabla);
                info.getContentPane().add(barraPable);
                info.pack();
                info.setVisible(true);
                
            }
        });
        
       //Regresar al menu Principal
       menuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuPrincipal menu= new MenuPrincipal();
                menu.show();
                dispose();
            }
        });
        
    }
    
   
    
     

}
