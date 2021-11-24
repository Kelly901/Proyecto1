/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import javafx.scene.control.ButtonBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Kelly
 */
public class VentaExistente {
    String codigo;
    int codigo2;
    String codigo3;
    public static  String band;
    public static String cod;
    Componentes.Ventas cVenta[]=Componentes.CargarVentas.venta;
    public static Venta2 ventaTo[]=new Venta2[100];
    
    //Resta de la cantidad de prodcutos
     public void restarleProducto(String producto,int cantidad){
         proyecto1_semestre2.Producto [] datos3= Componentes.CargaProducto.productos;
     
         for (int i = 0; i < datos3.length; i++) {
             if (datos3[i]!=null) {
                 if (datos3[i].getNombre().equals(producto)) {
                     datos3[i].setCantidad(datos3[i].getCantidad()-cantidad);
                    
                 }
             }
         }
     }
     //Metodo para comparar precios
     public void compararPrecios(String producto,int cantidad,String ban){
         proyecto1_semestre2.Producto [] datos3= Componentes.CargaProducto.productos;
         for (int i = 0; i <datos3.length ; i++) {
             if (datos3[i]!=null) {
                 if (datos3[i].getNombre().equals(producto)&& datos3[i].getCantidad()<cantidad) {
//                     "Ingrese una cantidad menor a: "+cantidad +"La canidad disponible es de: "+datos3[i].getCantidad()
                     JOptionPane.showMessageDialog(null, "<html><p>La cantida "+cantidad+" sobrepasa la cantidad en existencia.</p><p>La cantidad de "+producto+" disponibles es de: "+datos3[i].getCantidad()+"</p></html>");
//                     restarleProducto(producto, cantidad);
                     band="no";
                     return;
                 }
                     
                     System.out.println("siiiiiii");
                     band="si";
                  
             }
         }
     }
     //Metodo para obtener el codigo
     public void obtenerCodigo(int nit){
         codigo3="0";
         for (int i = 0; i <cVenta.length; i++) {
             if (cVenta[i]!=null) {
                 if (cVenta[i].getNit()==nit) {
                     codigo3=cVenta[i].getCodigo();
                 }
             }
         }
         System.out.println("este es el codigo "+codigo3);
     }
    public void ventaExiste(int nit,String producto,int cantidad,String ba,JButton boton){
        
        System.out.println(nit);
          Componentes.Ventas cVenta2[]=Componentes.CargarVentas.venta;
          VentanaVenta v= new VentanaVenta();
          System.out.println("cantidad de: "+Componentes.CargarVentas.suma);
        for (int i = Componentes.CargarVentas.suma; i >= 0; i--) {
           
            if (cVenta2[i]!=null) {
//                if (cVenta2[i].getNit()==nit) {
//                    codigo3=cVenta2[i].getCodigo();
//                }
//                  System.out.println("codigo e: "+codigo3);
                   if (cVenta2[i].getCodigo().equals(codigo3) &&cVenta2[i].getNit()==nit && cVenta2[i].getNombre().equals(producto)) {
                JOptionPane.showMessageDialog(null, "nueva venta "+cVenta2[i].getNombre());
                numeroMayo();
                       restarleProducto(producto, cantidad);
                   crearVentaNitDiferente(nit, producto, cantidad);
                
                
                return;
             
                }
                   
                   
            }

   
                    
          
            
             
            
        }
        System.out.println("-------comparacion----------------");
        compararProductos(nit, producto, cantidad);
                  
                  boton.setVisible(true);    
       
    }
    public void compararProductos(int nit,String producto,int cantidad){
          Componentes.Ventas cVenta2[]=Componentes.CargarVentas.venta;
          for (int i = Componentes.CargarVentas.suma; i >= 0; i--) {
              if (cVenta2[i]!=null) {
                  if(cVenta[i].getNit()==nit && !cVenta[i].getNombre().equals(producto)){
//                   
                     codigo=cVenta[i].getCodigo();
                     creaVentaConCodigoIgual(nit, producto, cantidad);
                      restarleProducto(producto, cantidad);
                     System.out.println("adios");
                     JOptionPane.showMessageDialog(null, "Producto agregado");
                      
                       return;
                }
// 
              }
        }
                    numeroMayo();
                    crearVentaNitDiferente(nit, producto, cantidad);
                    restarleProducto(producto, cantidad);
                    System.out.println("hola");
                    
    }
    public void creaVentaConCodigoIgual(int nit,String producto,int cantidad){
        
        for (int i = 0; i < cVenta.length; i++) {
            if (cVenta[i]==null) {
                cVenta[i]=new Componentes.Ventas(codigo,nit,producto, cantidad);
              
                break;
            }
        }
        System.out.println("---------------");
        System.out.println("metodo1");
         imprimerV();
    }
    public void numeroMayo(){
        int mayor=0;
        
        for (int i = 0; i < cVenta.length; i++) {
            if (cVenta[i]!=null) {
                if (Integer.parseInt(cVenta[i].getCodigo())>mayor) {
                    mayor=Integer.parseInt(cVenta[i].getCodigo());
                   
                }
   
            }
        }
        codigo2=mayor;
        System.out.println("---> "+mayor);
    }
    //Vetodo para agrega la cantidad de productos comprado y la cantidad de productos vendidos
    
    //Metodo para agregar si el nit es diferente
    public void crearVentaNitDiferente(int nit,String producto,int cantidad){
        int codigo3=codigo2+1;
        for (int i = 0; i < cVenta.length; i++) {
            if (cVenta[i]==null) {
                cVenta[i]=new Componentes.Ventas(String.valueOf(codigo3), nit,producto,cantidad);
             
            break;
            }
        }
        System.out.println("---------------------");
        System.out.println("metod2");
        System.out.println(codigo3);
       
        imprimerV();
    }
    public void mostrarDatos(int nit,String producto,int cantidadd){
       cod="";
        for (int i = 0; i <cVenta.length; i++) {
            if (cVenta[i]!=null) {
                if (cVenta[i].getNit()==nit  && cVenta[i].getCantidad()==cantidadd && cVenta[i].getNombre().equals(producto)) {
                    cod=cVenta[i].getCodigo();
                }
            }
        }
       
    }
    public void imprimerV(){
        int suma2=0;
        for (int i = 0; i < cVenta.length; i++) {
            if (cVenta[i]!=null) {
                cVenta[i].imprimir();
               suma2=suma2+1; 
               
            }
        }
        
         Componentes.CargarVentas.suma=suma2;
        
         System.out.println("suma "+suma2); 
        System.out.println("suma "+Componentes.CargarVentas.suma);   
    }
}
