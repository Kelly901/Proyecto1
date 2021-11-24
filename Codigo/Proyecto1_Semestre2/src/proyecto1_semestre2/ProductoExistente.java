/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Kelly
 */
public class ProductoExistente {
   Producto datoP[]=Componentes.CargaProducto.productos;
   
   public void productoExistente(String nombre,JTextField textN){
       for (int fila = 0; fila < datoP.length; fila++) {
           if (datoP[fila]!=null) {
               if (datoP[fila].getNombre().equals(nombre)) {
                   JOptionPane.showMessageDialog(null,"Denegado");
                   textN.setText(" ");
                   textN.setEditable(false);
                   return;
               }else{
                   textN.setText(nombre);
       
               }
           }
       }
       JOptionPane.showMessageDialog(null,"Nombre Acepatdo");
   }
   
   public void productoNuevo(String nombre,float precio,int cantidad,String avatar){
       
       for (int fila = 0; fila < datoP.length; fila++) {
           if (datoP[fila]!=null) {
               JOptionPane.showMessageDialog(null,"El Producto a sido registrado");
               for (int i = 0; i < datoP.length; i++) {
                   if (datoP[i]==null) {
                       datoP[i]=new Producto(nombre, precio, cantidad, avatar);
                   break;
                   }
               }
               break;
           }
       }
       imprimir();
   }
   //imprimir
   public void imprimir(){
         
         for (int i = 0; i <datoP.length; i++) {
             if (datoP[i]!=null) {
                 datoP[i].imprimir2();
             }
         }
     }
}
