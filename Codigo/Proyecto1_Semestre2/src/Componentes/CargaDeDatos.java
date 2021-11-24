/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

/**
 *
 * @author Kelly
 */
public class CargaDeDatos {
    
    public static Cliente clientes []= new Cliente[100];
    public void guardarCargDeDatos(String nombre,int edad,char sexo,int nit,String avatar){
        
        for(int fila = 0; fila <clientes.length ; fila++) {
            if (clientes[fila]==null) {
                clientes[fila]= new Cliente(nombre, edad, sexo, nit, avatar);
                
                break;
            }
        }
        
       
    }
   
    
    public void impresion2(){
        
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i]!=null) {
                clientes[i].imprimir2();
            }
        }
        System.out.println("--------------------");
    }
    
}
