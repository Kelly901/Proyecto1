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
public class Usuario {

    private String usuario;
    private String nombre;
    private String contraseña;
    private String confirmarContraseña;
    int contador=1;
    
    public Usuario(){
        
    }
    public Usuario(String usuario, String nombre, String contraseña, String confirmarContraseña) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.confirmarContraseña = confirmarContraseña;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the confirmarContraseña
     */
    public String getConfirmarContraseña() {
        return confirmarContraseña;
    }

    /**
     * @param confirmarContraseña the confirmarContraseña to set
     */
    public void setConfirmarContraseña(String confirmarContraseña) {
        this.confirmarContraseña = confirmarContraseña;
    }
    
    public void imprimir(){
        
        System.out.println("Usuario "+this.getUsuario());
        System.out.println("Nombre "+this.getNombre());
        System.out.println("contra "+this.getContraseña());
        System.out.println("confirmacion "+this.getConfirmarContraseña());
        
    }

}
