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
public class Ventas {
    
    private String codigo;
    private int nit;
    private String nombre;
    private int cantidad;

    public Ventas(String codigo, int nit, String nombre, int cantidad) {
        this.codigo = codigo;
        this.nit = nit;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nit
     */
    public int getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(int nit) {
        this.nit = nit;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
   
    public void imprimir(){
        System.out.println("codigo "+this.getCodigo());
        System.out.println("NIT "+this.getNit());
        System.out.println("NOMBRE "+this.getNombre());
        System.out.println("cantidad "+this.getCantidad());
    }
    
}
