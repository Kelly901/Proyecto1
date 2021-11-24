/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import javax.swing.JOptionPane;

/**
 *
 * @author Kelly
 */
public class RegistroDeUsuarios {
    public static Usuario[] datos= new Usuario[10];
    
    public  void guardarUsuario(String usuario,String nombre,String contraseña,String confirmar){
        //Guarda los usuarios
         for (int fila = 0; fila < datos.length; fila++) {
             if (datos[fila]==null) {
                
                 datos[fila]= new Usuario(usuario, nombre, contraseña, confirmar);
                 break;
             }
        }
         
        impresion();
    }
    
    
    
    public void impresion(){
        //Imprime los usuarios
        for(int i = 0; i < datos.length; i++) {
            if (datos[i]!=null) {
                datos[i].imprimir();
            }
        }
    }
}
