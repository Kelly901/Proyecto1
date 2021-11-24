/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import static Componentes.CargaDeDatos.clientes;
import proyecto1_semestre2.RegistroDeUsuarios;

/**
 *
 * @author Kelly
 */
public class CargarVentas {
    int obtenerPosicion;
    public static int codigo ;
    public static Ventas[] venta= new Ventas[500];
    public static int suma;
    public static String codigos[];
    public void guardarVentas(String codigo, int nit, String nombre, int cantidad){
        for (int fila = 0; fila < venta.length; fila++) {
        
            if (venta[fila]==null) {
                venta[fila]=new Ventas(codigo, nit, nombre, cantidad);
                 suma=suma+1;
                 
                break;
            }
        }
        

    }
    

       
      
    
    //Imprimir
    public void imprimirV(){
        for (int i = 0; i < venta.length; i++) {
            if (venta[i]!=null) {
                venta[i].imprimir();
                
            }
        }
        System.out.println(suma);
    }
    
}
