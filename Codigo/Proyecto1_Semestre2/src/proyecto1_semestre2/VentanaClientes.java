/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Kelly
 */
public class VentanaClientes extends JFrame{
    JPanel panel5;
    JTable table;
    

    String nombre_columnas[]={"Nombre","Edad","Sexo","NIT"};
    Componentes.Cliente [] datos = Componentes.CargaDeDatos.clientes;
    Object [][] filas= new Object[100][4];
    
   public VentanaClientes(){
       
       setTitle("Tabla");
       setBounds(300,300,600,400);
       
       add(new panel5());
//       TableModel model= new Tabla();
       TableColumnModel colMod= table.getColumnModel();
       
       //Columna1
       colMod.getColumn(0).setPreferredWidth(150);
       colMod.getColumn(1).setPreferredWidth(150);
       colMod.getColumn(2).setPreferredWidth(150);
       colMod.getColumn(3).setPreferredWidth(150);
       
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

   }
  
    private class panel5 extends JPanel{
    
    public panel5(){
        setLayout(new BorderLayout());
      table= new JTable(filas,nombre_columnas);
      
      matriz();
      table.repaint();
     
      add(new JScrollPane(table),BorderLayout.CENTER);
      JPanel panel= new JPanel();
      panel.setLayout(new GridLayout(4,1));
      
       JButton boton = new JButton("regresar");
       boton.setBounds(500,300, 80, 80);
        panel.add(boton);
        add(panel,BorderLayout.EAST);
        
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
             AdministraciónDeClientes admin = new AdministraciónDeClientes();
             admin.show();
             dispose();
            }
        });
    }
    
}
     
     public void matriz(){
         
         for (int i = 0; i <filas.length; i++) {
             if (datos[i]!=null) {
                 filas[i][0]=datos[i].getNombre();
                 filas[i][1]=datos[i].getEdad();
                 filas[i][2]=datos[i].getSexo();
                 filas[i][3]=datos[i].getNit();
             }
         }
     }
     
     
   
}
   
    
   
//  public VentanaClientes(){
//      super();
//      this.setSize(500,450);
//      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//      this.setLayout(null);
//      this.setTitle("Clientes");
//      this.setLocationRelativeTo(null);
//      setResizable(false);
//      Panel5();
//  }
//  public void Panel5(){
//      panel5= new JPanel();
//      panel5.setSize(500,450);
//      panel5.setLayout(null);
//      panel5.setBackground(Color.BLACK);
//      
//     this.add(panel5);
//     panel5.add(new JScrollPane(table));
////     panel5.add(table.getTableHeader(),BorderLayout.NORTH);
////     panel5.add(table,BorderLayout.CENTER);
//      
//     
//   
//     tablaDeClientes();
//     
//     
//  }
//  
//  public void tablaDeClientes(){
//      Object[][] matriz=tabla.MatrizPrincipal();
//     Object[] encabezado={("Nombre"),("Edad"),("Sexo"),("NIT")};
////     table.setModel(new DefaultTableModel(matriz,encabezado));
//     model=(DefaultTableModel)table.getModel();
//     model.removeRow(table.getSelectedRow());
//    panel5.add(table);
//  }

