/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Kelly
 */
public class TablaProductos extends JFrame {
    JPanel panelTablarP;
    JTable tableP;
    String nombreColumnasP [] ={"Nombre","Precio","Cantidad"};
    proyecto1_semestre2.Producto [] datos3= Componentes.CargaProducto.productos;
    Object[][] filas= new Object[100][3];
    
    public TablaProductos(){
        setTitle("Tabla De productos");
        setBounds(300,300,550,400);
        add(new panelTableP());
        TableColumnModel columnaM= tableP.getColumnModel();
       
        //Columnas
        columnaM.getColumn(0).setPreferredWidth(180);
        columnaM.getColumn(1).setPreferredWidth(180);
        columnaM.getColumn(2).setPreferredWidth(180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private class panelTableP extends JPanel{
    public panelTableP(){
        setLayout(new BorderLayout());
        tableP= new JTable(filas,nombreColumnasP);
        matriz2();
        tableP.repaint();
        add(new JScrollPane(tableP),BorderLayout.CENTER);
        JPanel panelProducto= new JPanel();
        panelProducto.setLayout(new GridLayout(4,1));
        
        JButton regresar= new JButton("regresar");
        regresar.setBounds(450,300,80,80);
        panelProducto.add(regresar);
        add(panelProducto,BorderLayout.EAST);
        
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
             AdministracionProducto ap= new AdministracionProducto();
             ap.show();
             dispose();
            }
        });
       
    }
    
       public void matriz2(){
           for (int i = 0; i < filas.length; i++) {
               if (datos3[i]!=null) {
                   filas[i][0]=datos3[i].getNombre();
                   filas[i][1]=datos3[i].getPrecio();
                   filas[i][2]=datos3[i].getCantidad();
               }
           }
       } 
    }
}
