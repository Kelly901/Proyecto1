/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import Componentes.Cliente;
import com.sun.org.apache.xml.internal.utils.StringVector;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Kelly
 */
public class InfoCliente {
    //Compara el nit del cliente y muestra la informacion del cliente si e NiT existe
    public static String bandera2;
    int posicion2;
    public void informacioSobreCliente(int nit2,JTextField nombre,JTextField edad,JTextField sexo,JTextField nit,JLabel avatar) {
        Componentes.Cliente[] datos1 = Componentes.CargaDeDatos.clientes;
        for (int fila = 0; fila < datos1.length; fila++) {
            if (datos1[fila]!=null) {
                if (datos1[fila].getNit()==nit2) {
                    JOptionPane.showMessageDialog(null,"NIT encontrado");
                    
                    nombre.setText(datos1[fila].getNombre());
                    edad.setText(String.valueOf(datos1[fila].getEdad()));
                    sexo.setText(String.valueOf(datos1[fila].getSexo()));
                    nit.setText(String.valueOf(datos1[fila].getNit()));
                    avatar.setIcon(agregarDimensionesDeImagen(100,100, datos1[fila].getAvatar()));
//                    avatar.setText(datos1[fila].getAvatar());
                    return;
                }
            }
        }
        //Si el nit no existe muestra este mensaje  y los JTextField quedan vacios
        JOptionPane.showMessageDialog(null,"NIT no encontrado");
        nombre.setText(null);
        edad.setText(null);
        sexo.setText(null);
        nit.setText(null);
        avatar.setIcon(agregarDimensionesDeImagen(100,100,""));
    }
    //Comparar si no hay un nit repetddio
    public void compararNitRepetido(int nit,String bandera){
         Componentes.Cliente[] datos1 = Componentes.CargaDeDatos.clientes;
         for (int fila = 0; fila < datos1.length; fila++) {
             if (datos1[fila]!=null) {
                 if (datos1[fila].getNit()==nit   ) {
                     JOptionPane.showMessageDialog(null,"El NIT ya existe");

                     bandera2="si";
                   return;                 
//                     }
                 }
                    
                 
   
                     
                 }
             }
        bandera2="no";
            

        }
                         
                         
        public void guardarDatos(int nit,int nit2,String nombre,int edad,char sexo,String ruta,String bandera){
            
            Componentes.Cliente[] datos1 = Componentes.CargaDeDatos.clientes;
            
            
         for (int fila = 0; fila < datos1.length; fila++) {
             if (datos1[fila]!=null) {
            if (datos1[fila].getNit()==nit) {
                 
                          datos1[fila].setNombre(nombre);
                     datos1[fila].setEdad(edad);
                     datos1[fila].setNit(nit2);
                     datos1[fila].setSexo(sexo);
                     datos1[fila].setAvatar(ruta);
                     JOptionPane.showMessageDialog(null,"Modificación exitosa");
//                     bandera=false;
                     return;
                             }
             }
         }
         
        }
        //
        public void eliminarUsuario(int nit){
               Componentes.Cliente[] datos1 = Componentes.CargaDeDatos.clientes;
               
               int contador=0;
               
         for (int fila = 0; fila < datos1.length; fila++) {
             
             if (datos1[fila]!=null) {
              
                if (datos1[fila].getNit()==nit) {
                     
                     posicion2=fila;
                
             }
              
             
             }
            
        }
          System.out.println("--------");
             System.out.println(posicion2);
          rellenarTabla1();
         imprimirU();
        }
        public void rellenarTabla1(){
           Componentes.Cliente[] datos1 = Componentes.CargaDeDatos.clientes; 
           Object datos2[]=Componentes.CargaDeDatos.clientes;
           
            for (int i = posicion2; i <datos1.length-1; i++) {
                if (datos1[i]!=null) {
                    datos1[i]=datos1[i+1];
                }
                   
            }
        }
                
        
       
     //
        public void imprimirU(){
           Componentes.Cliente[] datos1 = Componentes.CargaDeDatos.clientes;
            for (int i = 0; i < datos1.length; i++) {
                if (datos1[i]!=null) {
                    datos1[i].imprimir2();
                }
            }
        }
    //AGREGA una imagen al Label
    public ImageIcon agregarDimensionesDeImagen(int ancho,int alto,String direccion){
        ImageIcon x= new ImageIcon(direccion);
        ImageIcon y= new ImageIcon(x.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return y;
        
    }
}
