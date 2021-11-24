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
public class CargaProducto {
    public static proyecto1_semestre2.Producto productos[]= new proyecto1_semestre2.Producto[100];
    
    public void guardarProductos(String nombre,float precio,int cantidad,String imagen){
        for (int fila = 0; fila < productos.length; fila++) {
            if (productos[fila]==null) {
                productos[fila]=new proyecto1_semestre2.Producto(nombre,precio,cantidad, imagen);
                
                break;
            }
        }
      
    }
    //Imprimir
    public void imprimir3(){
        for (int i = 0; i <productos.length; i++) {
            if (productos[i]!=null) {
                productos[i].imprimir2();
            }
        }
        System.out.println("---------------------------------------");
    }
    
}
