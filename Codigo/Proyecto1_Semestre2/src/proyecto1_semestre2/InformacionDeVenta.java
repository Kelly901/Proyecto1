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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kelly
 */
public class InformacionDeVenta extends JFrame {

    JLabel coddigo;

    JButton agregar;
    JPanel panelVenta;
    JLabel codigoL;
    JLabel totalV2;

   
    JLabel totalVenta;
    JLabel producto5;
    JButton regresar;
    JButton mostrarDatos;
    String precio;
    float precio2;
    float cantidad2;
    float cantidad3;
    float iva;
    JLabel ivaLabel;
    public static String co;

    public InformacionDeVenta() {
        this.setSize(500, 550);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Nueva venta");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        PanelVenta();
    }

    public void PanelVenta() {
        panelVenta = new JPanel();
        panelVenta.setSize(500, 550);
        panelVenta.setLayout(null);
        panelVenta.setBackground(Color.black);
        this.add(panelVenta);
        agregarComponentesV();

    }

    public void agregarComponentesV() {
        panelVenta.add(Componentes.Utiles.crearEtiquetas(60, 80, "Codigo: ", Color.WHITE));
        coddigo = new JLabel("Codigo");
        coddigo.setBounds(170, 80, 170, 40);
        coddigo.setForeground(Color.WHITE);
        coddigo.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        
        panelVenta.add(coddigo);


            //Etiqueta de label
        JLabel pro= new JLabel("Productos en la venta:");
          pro.setBounds(60,130,300,45);
          pro.setForeground(Color.WHITE);
         pro.setFont(new Font("arial", Font.CENTER_BASELINE,17));
         panelVenta.add(pro);
//        //primer producto
         
          //Etiqueta de total de venta
         totalVenta= new JLabel("Total de la venta:");
          totalVenta.setBounds(60,315,200,45);
          totalVenta.setForeground(Color.WHITE);
          totalVenta.setFont(new Font("arial", Font.CENTER_BASELINE,15));
         panelVenta.add(totalVenta);
         
         //
         totalV2= new JLabel();
          totalV2.setBounds(235,315,100,45);
          totalV2.setForeground(Color.WHITE);
          totalV2.setFont(new Font("arial", Font.CENTER_BASELINE,17));
         panelVenta.add(totalV2);
         
         //
        JLabel ivaL= new JLabel("IVA:");
          ivaL.setBounds(60,365,90,45);
          ivaL.setForeground(Color.WHITE);
          ivaL.setFont(new Font("arial", Font.CENTER_BASELINE,17));
         panelVenta.add(ivaL);
         //
          ivaLabel= new JLabel();
          ivaLabel.setBounds(165,365,100,45);
          ivaLabel.setForeground(Color.WHITE);
          ivaLabel.setFont(new Font("arial", Font.CENTER_BASELINE,17));
         panelVenta.add(ivaLabel);
//         //producto3
//          producto3= new JLabel();
//          producto3.setBounds(60,280,100,45);
//         producto3.setForeground(Color.WHITE);
//         producto3.setFont(new Font("arial", Font.CENTER_BASELINE,17));
//         panelVenta.add(producto3);
//         //Producto4
//          producto4= new JLabel();
//          producto4.setBounds(60,325,100,45);
//         producto4.setForeground(Color.WHITE);
//         producto4.setFont(new Font("arial", Font.CENTER_BASELINE,17));
//         panelVenta.add(producto4);
//         //prodcuto5
//          producto5= new JLabel();
//          producto5.setBounds(60,375,100,45);
//         producto5.setForeground(Color.WHITE);
//         producto5.setFont(new Font("arial", Font.CENTER_BASELINE,17));
//         panelVenta.add(producto5);
//          
//          
////       
////        
//         mostrarDatos= new JButton("Verificar venta");
//         mostrarDatos.setBounds(250,325,100,45);
//         panelVenta.add(mostrarDatos);
//         //Etiqueta de codigo
//         JLabel cod= new JLabel("codigo:");
//         cod.setBounds(60,320,100,45);
//         cod.setForeground(Color.WHITE);
//         cod.setFont(new Font("arial", Font.CENTER_BASELINE,17));
//         panelVenta.add(cod);
//         //

        //Boton para regresar
        regresar = new JButton("Regresar");
        regresar.setBounds(300, 469, 70, 45);
        panelVenta.add(regresar);
        //verificar Venta

        iniciarB();
        crearTabla(AdministracionDeVenta.codigo);
        coddigo.setText(AdministracionDeVenta.codigo);
    }//

    //Iniciar botones
    public void iniciarB() {
        System.out.println("soy yo" + AdministracionDeVenta.codigo);
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AdministracionDeVenta ven = new AdministracionDeVenta();
                ven.show();
                precio = "";
                dispose();
            }
        });
    }

    //CrearTabla
    public void crearTabla(String codigo) {
        System.out.println("verificacion" + codigo);
        Componentes.Ventas[] venta = Componentes.CargarVentas.venta;
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable();
        JPanel panel = new JPanel();
        panel.setVisible(true);
        panel.add(table);

        panel.setBounds(10, 180, 470, 130);
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Prodctos adquiridos");

        Object arreglo[] = new Object[500];
        proyecto1_semestre2.Producto[] datos3 = Componentes.CargaProducto.productos;
        Object arrCodigo[] = new Object[5];
        int c = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (venta[i] != null) {
                if (venta[i].getCodigo().equals(codigo)) {
                    productosEnVenta(venta[i].getNombre());
                    
                    totalDeVent(venta[i].getNombre(),venta[i].getCantidad());
                    arreglo[0] = venta[i].getNombre();
                    System.out.println("--->" + venta[i].getNombre());
                    arreglo[1] = precio;

                    arreglo[2] = venta[i].getCantidad();
                    model.addRow(arreglo);

                }

            }
        }
        for (int i = 0; i < datos3.length; i++) {
            if (datos3[i] != null) {

            }
        }
        for (int i = 0; i < arrCodigo.length; i++) {

            System.out.println("...." + arrCodigo[i]);

        }

        JScrollPane pane = new JScrollPane(table);
        panel.add(pane, BorderLayout.CENTER);
        table.setModel(model);

        panelVenta.add(panel);

    }
    //Agregar al comboBox

    public void totalDeVent(String producto,int cantidad) {
        
        Componentes.Ventas[] datos = Componentes.CargarVentas.venta;
        proyecto1_semestre2.Producto[] datos3 = Componentes.CargaProducto.productos;
        precio2 = 0;
        for (int i = 0; i < datos3.length; i++) {
            if (datos3[i] != null) {
                if (datos3[i].getNombre().equals(producto)) {
                    System.out.println(datos3[i].getNombre() + "-->>>" + producto + "-->" + datos3[i].getPrecio());
                    precio2 = datos3[i].getPrecio();
                    cantidad2=precio2*cantidad;
                    cantidad3+=cantidad2;
                      iva =(float) (cantidad3*0.12);
                }
            }
        }
        totalV2.setText(String.valueOf(cantidad3));
        ivaLabel.setText(String.valueOf(iva));
    }

    public void productosEnVenta(String producto) {
        Componentes.Ventas[] datos = Componentes.CargarVentas.venta;
        proyecto1_semestre2.Producto[] datos3 = Componentes.CargaProducto.productos;
        precio = "";
        for (int i = 0; i < datos3.length; i++) {
            if (datos3[i] != null) {
                if (datos3[i].getNombre().equals(producto)) {
                    System.out.println(datos3[i].getNombre() + "-->>>" + producto + "-->" + datos3[i].getPrecio());
                    precio = String.valueOf(datos3[i].getPrecio());
                  
                }
            }
        }

    }
}
