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
public class Cliente {

    private String nombre;
    private int edad;
    private char sexo;
    private int nit;

    public Cliente(String nombre, int edad, char sexo, int nit, String avatar) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.nit = nit;
        this.avatar = avatar;
    }
    private String avatar;

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
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
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
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void imprimir2() {
        System.out.println("nombre: " + this.getNombre());
        System.out.println("edad: " + this.getEdad());
        System.out.println("genero: " + this.getSexo());
        System.out.println("NIT: " + this.getNit());
        System.out.println("AVATAR: " + this.getAvatar());
    }

}
