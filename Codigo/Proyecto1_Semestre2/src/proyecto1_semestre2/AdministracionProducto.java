/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Kelly
 */
public class AdministracionProducto extends JFrame {

    JPanel panelProducto1;
    JButton productoNuevo;
    JButton tabla;
    JButton informacionProducto;
    JButton graficaPie;
    JButton graficaBarras;
    JButton menuPrincipal;
    JButton dashboardProducto;

    public AdministracionProducto() {

        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        agregarPanelProducto1();
    }

    //Agrega un panel a la ventana
    public void agregarPanelProducto1() {
        //Panel
        panelProducto1 = new JPanel();
        panelProducto1.setSize(500, 500);
        panelProducto1.setLayout(null);
        panelProducto1.setBackground(Color.black);
        this.add(panelProducto1);
        agregarBotones3();
    }

    //Agrega botones al panel y etiquetas
    public void agregarBotones3() {
        //Etiqueta con el titulo Administracion de productos
        JLabel label = new JLabel("ADMINISTRACION DE PRODUCTOS");
        label.setBounds(80, 0, 335, 45);
        label.setFont(new Font("arial", Font.CENTER_BASELINE, 18));
        label.setForeground(Color.WHITE);
        panelProducto1.add(label);
        //Boton Producto nuevo
        productoNuevo = new JButton("Producto Nuevo");
        productoNuevo.setBounds(80, 80, 170, 40);
        productoNuevo.setBackground(Color.BLACK);
        productoNuevo.setForeground(Color.green);
        productoNuevo.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panelProducto1.add(productoNuevo);

        //Tabla de Productos
        tabla = new JButton("Tabla");
        tabla.setBounds(80, 125, 150, 40);
        tabla.setBackground(Color.BLACK);
        tabla.setForeground(Color.BLUE);
        tabla.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panelProducto1.add(tabla);

        //Boton de la informacion de clientes
        informacionProducto = new JButton("Información de \n clientes");
        informacionProducto.setBounds(80, 170, 150, 60);
        informacionProducto.setBackground(Color.BLACK);
        informacionProducto.setForeground(Color.CYAN);
        informacionProducto.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panelProducto1.add(informacionProducto);

        //Regresar al menu principal
        dashboardProducto = new JButton("Dashboard de ventas");
        dashboardProducto.setBounds(80, 235, 150, 60);
        dashboardProducto.setBackground(Color.BLACK);
        dashboardProducto.setForeground(Color.white);
        dashboardProducto.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panelProducto1.add(dashboardProducto);
        //
        menuPrincipal = new JButton("Menu principal");
        menuPrincipal.setBounds(80, 300, 150, 60);
        menuPrincipal.setBackground(Color.BLACK);
        menuPrincipal.setForeground(Color.CYAN);
        menuPrincipal.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panelProducto1.add(menuPrincipal);
        iniciarBotones();
    }

    public void iniciarBotones() {
        //Producto Nuevo llama a la ventanProducto
        productoNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaProducto venP = new VentanaProducto();
                venP.show();
                dispose();
            }
        });

        //Informacion del producto
        informacionProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                InformacionProducto inf = new InformacionProducto();
                inf.show();
                dispose();
            }
        });
        //Tabla
        tabla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                TablaProductos tab = new TablaProductos();
                tab.show();
                dispose();
            }
        });
        //Dashboard
        dashboardProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Grafica de barra
                JFreeChart graficaB = null;
                DefaultCategoryDataset data = new DefaultCategoryDataset();
                proyecto1_semestre2.Producto[] datos3 = Componentes.CargaProducto.productos;
                int precio1 = 0;
                int precio2 = 0;
                int precio3 = 0;
                int precio4 = 0;
                int precio5 = 0;
                int precio6 = 0;
                int precio7 = 0;
                int precio8 = 0;
                int precio9 = 0;
                for (int i = 0; i < datos3.length; i++) {
                    if (datos3[i] != null) {

                        if (datos3[i].getPrecio() > 0 && datos3[i].getPrecio() <= 100) {

                            precio1++;
                        } else if (datos3[i].getPrecio()>100 && datos3[i].getPrecio() <= 200) {
                            precio2++;
                        } else if (datos3[i].getPrecio()> 200 && datos3[i].getPrecio() <= 300) {
                            precio3++;
                        }else if (datos3[i].getPrecio()>300 && datos3[i].getPrecio()<=400 ) {
                            precio4++;
                        }else if (datos3[i].getPrecio()>500 && datos3[i].getPrecio()<=600 ) {
                            precio5++;
                        }else if (datos3[i].getPrecio()>700 && datos3[i].getPrecio()<=800 ) {
                            precio6++;
                        }else if (datos3[i].getPrecio()>800 && datos3[i].getPrecio()<=900 ) {
                            precio7++;
                        }else if (datos3[i].getPrecio()>900 && datos3[i].getPrecio()<=1000 ) {
                            precio8++;
                        }else if (datos3[i].getPrecio()>1000 && datos3[i].getPrecio()<=1100 ) {
                            precio9++;
                        }
                    }
                }
                 data.addValue(precio1,"Grafica","0-100");
               data.addValue(precio2,"Grafica","100-200");
               data.addValue(precio3,"Grafica","200-300");
               data.addValue(precio4,"Grafica","300-400");
               data.addValue(precio5,"Grafica","400-500");
               data.addValue(precio6,"Grafica","600-700");
               data.addValue(precio7,"Grafica","800-900");
               data.addValue(precio8,"Grafica","900-1000");
               data.addValue(precio9,"Grafica","1000-1100");
               graficaB= ChartFactory.createBarChart("Rango de precios","Eje x", "Eje y", data,PlotOrientation.VERTICAL,true,true,false);
               
               //TABLA
                DefaultTableModel model= new DefaultTableModel();
                JTable table1= new JTable();
                JPanel panelTabla= new JPanel();
                  panelTabla.setLayout(new GridLayout(2,1));
                panelTabla.setSize(500,400);
                panelTabla.add(table1);
                panelTabla.setVisible(true);
                model.addColumn("Nombre");
                model.addColumn("Precio");
                model.addColumn("Cantidad");
               
                Object arreglo[]= new Object[100];
                for (int i = 0; i < arreglo.length; i++) {
                    if (datos3[i]!=null) {
                        arreglo[0]=datos3[i].getNombre();
                        arreglo[1]=datos3[i].getPrecio();
                        arreglo[2]=datos3[i].getCantidad();
                       
                          model.addRow(arreglo);
                    }
                }
                
               
                  
                
                JScrollPane pane = new JScrollPane(table1);
                
                panelTabla.add(pane,BorderLayout.CENTER);
                table1.setModel(model);
                //Paneles
                ChartPanel panelBarra = new ChartPanel(graficaB);
                
                //JFrame
                
                JFrame frame2= new JFrame("Dashboard de Productos");
                frame2.setLayout(new GridLayout(2,1));
                frame2.getContentPane().add(panelBarra);
                frame2.getContentPane().add(panelTabla);
                frame2.pack();
                frame2.setVisible(true);

            }
        });
        //Regresar al menu principal.
        menuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MenuPrincipal menu = new MenuPrincipal();
                menu.show();
                dispose();
            }
        });
    }
}
