/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Kelly
 */
public class InfoProducto {
    public static String  banderaP;
    //Metodo para mostrar la información del producto segun el nombre
     int posicion;
    public void informacionSobreElPro(String nombre,JTextField name,JTextField precio,JTextField cantidad,JLabel avatar){
      proyecto1_semestre2.Producto [] datos3= Componentes.CargaProducto.productos;
        for (int fila = 0; fila < datos3.length; fila++) {
            if (datos3[fila]!=null) {
                if (datos3[fila].getNombre().equals(nombre)) {
                JOptionPane.showMessageDialog(null,"Producto Encontrado");
                    System.out.println(datos3[fila].getNombre());
                name.setText(datos3[fila].getNombre());
                precio.setText(String.valueOf(datos3[fila].getPrecio()));
                cantidad.setText(String.valueOf(datos3[fila].getCantidad()));
                avatar.setIcon(agregarDimensionesDeImagenP(125,135, datos3[fila].getImagen()));
                return;
                
            }
            }
        }
         JOptionPane.showMessageDialog(null,"Producto no encontrado");
        name.setText(null);
        precio.setText(null);
        cantidad.setText(null);
    
        avatar.setIcon( agregarDimensionesDeImagenP(100,100,""));
 
    }
    //Comparar nombre del producto
    public void compararNombreProducto(String nombre){
         proyecto1_semestre2.Producto [] datos3= Componentes.CargaProducto.productos;
        for (int fila = 0; fila < datos3.length; fila++) {
            if (datos3[fila]!=null) {
                if (datos3[fila].getNombre().equals(nombre)) {
                    JOptionPane.showMessageDialog(null,"El nombre del producto ya existe" );
                    banderaP="si";
                    return;
                    
                }
            }
   
        }
        banderaP="no";
    }
    public void guardarDatosProducto(String nombre,String nombre2,float precio,int cantidad,String avatar){
        
         proyecto1_semestre2.Producto [] datos3= Componentes.CargaProducto.productos;
         for (int fila = 0; fila <datos3.length; fila++) {
             if (datos3[fila].getNombre().equals(nombre)) {
                 datos3[fila].setNombre(nombre2);
                 datos3[fila].setPrecio(precio);
                 datos3[fila].setCantidad(cantidad);
                 datos3[fila].setImagen(avatar);
                 JOptionPane.showMessageDialog(null,"Modificación exitosa");
                 return;
             }
        }
    }
    
    //Metodo para eliminar un producto del arreglo 
      public void eliminarProducto(String nombre){
               proyecto1_semestre2.Producto [] datos3= Componentes.CargaProducto.productos;
               
            
               
         for (int fila = 0; fila < datos3.length; fila++) {
             
             if (datos3[fila]!=null) {
              
                 if (datos3[fila].getNombre().equals(nombre)) {
                     
                     posicion=fila;
                     
                     
                 
                 }
                 
//datos1[contador]=datos1[fila];
//                 contador++;
//                 
                
             }
              
             
             }
          System.out.println("----------------");
          System.out.println(posicion);
          rellenarTabla();
         imprimirP();
        }
        public void rellenarTabla(){
         proyecto1_semestre2.Producto [] datos3= Componentes.CargaProducto.productos;
          
          
            for (int i = posicion; i <datos3.length-1; i++) {
                if (datos3[i]!=null) {
                    datos3[i]=datos3[i+1];
                 
                }

            }
        }
        
        public void imprimirP(){
          proyecto1_semestre2.Producto [] datos3= Componentes.CargaProducto.productos;
            for (int i = 0; i < datos3.length; i++) {
                if (datos3[i]!=null) {
                    datos3[i].imprimir2();
                }
            }
        }
    //Metodo para agregarle Dimension a un imagen
    public ImageIcon agregarDimensionesDeImagenP(int ancho,int alto,String direccion){
        ImageIcon x= new ImageIcon(direccion);
        ImageIcon y= new ImageIcon(x.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return y;
        
    }
}
