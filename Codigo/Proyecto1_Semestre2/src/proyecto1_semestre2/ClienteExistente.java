/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import Componentes.Cliente;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Kelly
 */
public class ClienteExistente {
     
     //Este metodo compara el nit guardado con el nit que el usuario desea registrar
     public void clienteExiste(int nit,JTextField texgtN){
         Componentes.Cliente [] datos1 = Componentes.CargaDeDatos.clientes;
       for (int fila = 0; fila < datos1.length; fila++) {
             if (datos1[fila]!=null) {
                 if (datos1[fila].getNit()==nit) {
                     System.out.println(datos1[fila].getNit());
                     JOptionPane.showMessageDialog(null,"Denegado");
                   texgtN.setEditable(false);
                 return;
//                   break;
                 
                 }
                    
                     
                 
                
//                 }
                
             }
           
       }
       texgtN.setText(String.valueOf(nit));
        JOptionPane.showMessageDialog(null,"NIT Aceptado");
     }
     
     //Este metodo agrega un cliente nuevo despues de comparar si el nit existe o no
     public void NitCoincide(String nombre,int edad,char sexo,int nit,String avatar){
         Componentes.Cliente [] datos1 = Componentes.CargaDeDatos.clientes;
         for (int fila = 0; fila < datos1.length; fila++) {
             if (datos1[fila]!=null) {
                     JOptionPane.showMessageDialog(null,"El Cliente Ha sido registrado");
                     
                         System.out.println(datos1.length);
                         for (int i = 0; i < datos1.length; i++) {
                          if (datos1[i]==null) {
                        datos1[i]=new Cliente(nombre, edad, sexo, nit, avatar); 
                     break;
                     }
                         
////                          
                        
                          }
                    

                  break;
                
             }
             
         }
         imprimir();
     }
     
     //IMPRIME LOS CLIENTES AGREGADOS Y GUARDADOS
     public void imprimir(){
         Componentes.Cliente [] datos1 = Componentes.CargaDeDatos.clientes;
         for (int i = 0; i <datos1.length; i++) {
             if (datos1[i]!=null) {
                 datos1[i].imprimir2();
             }
         }
     }
     
     
}
