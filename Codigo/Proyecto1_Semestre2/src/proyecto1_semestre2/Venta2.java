/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

/**
 *
 * @author Kelly
 */
public class Venta2 {
    private int codigo;
    private int costoTotal;
    private int cantidaProductos;

    public Venta2(int codigo, int costoTotal, int cantidaProductos) {
        this.codigo = codigo;
        this.costoTotal = costoTotal;
        this.cantidaProductos = cantidaProductos;
    }
    
    
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the costoTotal
     */
    public int getCostoTotal() {
        return costoTotal;
    }

    /**
     * @param costoTotal the costoTotal to set
     */
    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }

    /**
     * @return the cantidaProductos
     */
    public int getCantidaProductos() {
        return cantidaProductos;
    }

    /**
     * @param cantidaProductos the cantidaProductos to set
     */
    public void setCantidaProductos(int cantidaProductos) {
        this.cantidaProductos = cantidaProductos;
    }
    
}
