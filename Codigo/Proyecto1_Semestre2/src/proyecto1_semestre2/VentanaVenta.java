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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kelly
 */
public class VentanaVenta extends JFrame  {
    JComboBox nit;
    JComboBox producto;
    JTextField cantidad;
    JButton agregar;
    JPanel panelVenta;
    JLabel codigoL;
    JLabel nitL;
    JLabel cantidadaL;
    JLabel productoL;
     String ban;
    JButton regresar;
    JButton detallesDeVenta;
    JButton verificarVenta;
     
    public VentanaVenta(){
        this.setSize(500,550);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Nueva venta");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        PanelVenta();
    }
    public void PanelVenta(){
        panelVenta= new JPanel();
        panelVenta.setSize(500,550);
        panelVenta.setLayout(null);
        panelVenta.setBackground(Color.black);
        this.add(panelVenta);
        agregarComponentesV();
    }
    
    public void agregarComponentesV(){
        panelVenta.add(Componentes.Utiles.crearEtiquetas(60,80,"NIT del Cliente", Color.WHITE));
         nit= new JComboBox();
      
     
//         panelVenta.add(Componentes.Utiles.crearEtiquetas(30,130,"Agregar Productos", Color.WHITE));
         JLabel label= new JLabel("Agregar Productos:");
         label.setBounds(30,130,180,45);
         label.setForeground(Color.WHITE);
         label.setFont(new Font("arial", Font.CENTER_BASELINE,17));
         panelVenta.add(label);
         //Etiqueta de producto
         panelVenta.add(Componentes.Utiles.crearEtiquetas(60,185, "Productos", Color.WHITE));
         //ComboBox de producto
         producto = new JComboBox();
       
         //Etiqueta
         panelVenta.add(Componentes.Utiles.crearEtiquetas(60,230,"Cantidad", Color.WHITE));
          //CANTIDAD
          cantidad = new JTextField();
          cantidad.setBounds(170,230,150,40);
          cantidad.setFont(new Font("arial",Font.CENTER_BASELINE,15));
          panelVenta.add(cantidad);
          
         //Agregar
         agregar= new JButton("Agregar");
         agregar.setBounds(250,275,100,45);
         agregar.setVisible(false);
         panelVenta.add(agregar);
         //Verificar venta
         verificarVenta= new JButton("Verificar venta");
         verificarVenta.setBounds(250,325,100,45);
         panelVenta.add(verificarVenta);
//         //Etiqueta de codigo
//         JLabel cod= new JLabel("codigo:");
//         cod.setBounds(60,320,100,45);
//         cod.setForeground(Color.WHITE);
//         cod.setFont(new Font("arial", Font.CENTER_BASELINE,17));
//         panelVenta.add(cod);
//         //
         detallesDeVenta= new JButton("Detalles de venta");
         detallesDeVenta.setBounds(250,380,100,45);
         panelVenta.add(detallesDeVenta);
         
        
         //Boton para regresar
         regresar=new JButton("Regresar");
         regresar.setBounds(300,469 ,70, 45);
         panelVenta.add(regresar);
         //verificar Venta
         
         agregarAlComboBox();
     
         iniciarBotonesV();
    }
    //Iniciar botones
    public void iniciarBotonesV(){
        verificarVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Componentes.Ventas venta[]=  Componentes.CargarVentas.venta;
           
                VentaExistente venE= new VentaExistente();
                venE.compararPrecios((String) producto.getSelectedItem(),Integer.parseInt( cantidad.getText()), ban);
                System.out.println(ban);
                if (VentaExistente.band.equals("no")) {
                    agregar.setVisible(false);
                    
                }else{
                    agregar.setVisible(true);
                }
                
//              
            }
        });
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

               VentaExistente venE= new VentaExistente();
                  venE.obtenerCodigo(Integer.parseInt((String) nit.getSelectedItem()));
                //Verifica las ventas y si aun es posibel agregar ventas
                 if (Componentes.CargarVentas.suma==10) {
                     JOptionPane.showMessageDialog(null,"<html><p>Ya ha sobrepasado</p><p>la cantidad de ventas disponibles</p></html>");
                     agregar.setVisible(false);
                }else{
                      venE.ventaExiste(Integer.parseInt((String) nit.getSelectedItem()),String.valueOf(producto.getSelectedItem()),Integer.parseInt(cantidad.getText()),ban,agregar); 
                 }
                 venE.mostrarDatos(Integer.parseInt(String.valueOf( nit.getSelectedItem())), (String) producto.getSelectedItem(),Integer.parseInt(cantidad.getText()));
                      agregar.setVisible(false);
                  
                  
             
            }
        });
        detallesDeVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
             crearTabla();
            }
        });
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AdministracionDeVenta ad= new AdministracionDeVenta();
                ad.show();
                dispose();
            }
        });
    }
    public void crearTabla(){
              
       Componentes.Ventas venta[]=  Componentes.CargarVentas.venta;
        
                JPanel panelT = new JPanel();
                
               DefaultTableModel model= new DefaultTableModel();
              JTable table= new JTable();
             
             System.out.println("Este soy yo "+VentaExistente.cod);
             
              
       
//         panelT= new JPanel();
//         
//        panelT.setLayout(new GridLayout(4,1));
//        
//  
//         panelT.setVisible(true);
       
       
        model.addColumn("Código");
        model.addColumn("NIT");
        model.addColumn("Nombre del producto");
        model.addColumn("Cantidad");
      
         Object arreglo[]=new Object[500];
         System.out.println("Soy el codigo"+VentaExistente.cod);
         for (int i = 0; i < arreglo.length; i++) {

            if (venta[i]!=null) {
                
                if (venta[i].getCodigo().equals(VentaExistente.cod)) {
                    
                    arreglo[0]=venta[i].getCodigo();
                    arreglo[1]=venta[i].getNit();
                    arreglo[2]=venta[i].getNombre();
                    arreglo[3]=venta[i].getCantidad();
                    
                    model.addRow(arreglo);
               
                
            }
            
                 }
        }
//         JScrollPane pane= new JScrollPane(table,BorderLayout.CENTER);
//         panelT.add(pane);
         table.setModel(model);
         table.repaint();
         JFrame fram= new JFrame("Detalles de la venta");
//         fram.setLayout(new GridLayout(2,1));
         fram.getContentPane().add(new JScrollPane(table),BorderLayout.CENTER);
         fram.setBounds(500, 300,400, 150);
          
         fram.setVisible(true);
      
        
    }
    //Este metodo es para agregar al comboBox
    public void agregarAlComboBox(){
        //Agregar nit del cliente
        Componentes.Cliente [] datos = Componentes.CargaDeDatos.clientes;
      
        for(int i = 0; i < datos.length; i++) {
            if (datos[i]!=null) {
                 nit.addItem(String.valueOf(datos[i].getNit()));
            }
        }
            nit.setBounds(170,80,170, 40);
         panelVenta.add(nit);
        //Agregar produtcto
         proyecto1_semestre2.Producto [] datos3= Componentes.CargaProducto.productos;
         for (int j = 0; j < datos3.length; j++) {
             if (datos3[j]!=null) {
                 producto.addItem(datos3[j].getNombre());
             }
        }
          producto.setBounds(170,185,170, 40);
           panelVenta.add(producto);
    }
    
    
}
