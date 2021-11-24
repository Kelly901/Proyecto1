/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Kelly
 */
public class AdministracionDeVenta extends JFrame{
    JPanel panelVenta;
    JButton VentaNuevo;
    JButton tabla;
    JButton informacionVenta;
    JButton retornar;
    JButton dashboard;
    public static String codigo;

    public AdministracionDeVenta() {

        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        agregarPanelProducto1();
    }

    //Agrega un panel a la ventana
    public void agregarPanelProducto1() {
        //Panel
        panelVenta = new JPanel();
        panelVenta.setSize(500, 500);
        panelVenta.setLayout(null);
        panelVenta.setBackground(Color.black);
        this.add(panelVenta);
        agregarBotones3();
    }

    //Agrega botones al panel y etiquetas
    public void agregarBotones3() {
        //Etiqueta con el titulo Administracion de productos
        JLabel label = new JLabel("ADMINISTRACION DE VENTAS");
        label.setBounds(80, 0, 330, 45);
        label.setFont(new Font("arial", Font.CENTER_BASELINE, 18));
        label.setForeground(Color.WHITE);
        panelVenta.add(label);
        //Boton Producto nuevo
       VentaNuevo = new JButton("Venta nueva");
        VentaNuevo.setBounds(80, 80, 170, 40);
        VentaNuevo.setBackground(Color.BLACK);
        VentaNuevo.setForeground(Color.BLUE);
       VentaNuevo.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
         panelVenta.add(VentaNuevo);

        //Tabla de Productos
        tabla = new JButton("Tabla");
        tabla.setBounds(80, 125, 150, 40);
        tabla.setBackground(Color.BLACK);
        tabla.setForeground(Color.CYAN);
        tabla.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panelVenta.add(tabla);

        //Boton de la informacion de clientes
        informacionVenta = new JButton("Información de Ventas");
        informacionVenta.setBounds(80, 170, 150, 60);
        informacionVenta.setBackground(Color.BLACK);
        informacionVenta.setForeground(Color.WHITE);
        informacionVenta.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panelVenta.add(informacionVenta);
        
        //Dashbaord
        dashboard = new JButton("Información de Ventas");
        dashboard.setBounds(80, 235, 150, 60);
        dashboard.setBackground(Color.BLACK);
        dashboard.setForeground(Color.WHITE);
        dashboard.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panelVenta.add(dashboard);
        //Regresara al menu Principal
        retornar = new JButton("Menu Principal");
        retornar.setBounds(80, 300, 150, 60);
        retornar.setBackground(Color.BLACK);
        retornar.setForeground(Color.CYAN);
        retornar.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panelVenta.add(retornar);
        iniciarBotones();
    }

    public void iniciarBotones() {
        //Producto Nuevo llama a la ventanProducto
        VentaNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
             VentanaVenta venVenta= new VentanaVenta();
             venVenta.show();
             dispose();
                     
            }
        });

        //Informacion del producto
        informacionVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
           
            String code;
            code=JOptionPane.showInputDialog("Ingrese el código");
            
                Componentes.Ventas []dato= Componentes.CargarVentas.venta;
              
               
               
             for (int i = 0; i < dato.length; i++) {
                    if (dato[i]!=null) {
                        if (dato[i].getCodigo().equals(code)) {
                             codigo=code;
                            JOptionPane.showMessageDialog(null,"El código esta registrado.");
                             InformacionDeVenta inV= new InformacionDeVenta();
                            inV.show();
                            dispose();
                         return;   
                        }
                 }
                }
             
               JOptionPane.showMessageDialog(null, "El codigo no esta registrado.");
                                          
            }
        });
        //Tabla
        tabla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              TablaVenta venta= new TablaVenta();
              venta.show();
                dispose();
             
            }
        });
        //Dashboard
        dashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MostrarTabla m= new MostrarTabla();
                m.show();
                dispose();
            }
        });
        //Retornar
        retornar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               MenuPrincipal men=new MenuPrincipal();
               men.show();
                dispose();
            }
        });
    }
}
