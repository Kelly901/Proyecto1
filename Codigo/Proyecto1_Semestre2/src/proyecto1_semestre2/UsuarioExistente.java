/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Kelly
 */
public class UsuarioExistente {

    MenuPrincipal mp = new MenuPrincipal();

    //Comparar Contraseñas
    public void compararContraseña(String confirmarContra) {
        Usuario[] datos = RegistroDeUsuarios.datos;
        for (int fila = 0; fila < datos.length; fila++) {
            if (datos[fila] != null) {
                try {
                    if (!datos[fila].getContraseña().equals(datos[fila].getConfirmarContraseña())) {
                        datos[fila] = null;
                        JOptionPane.showMessageDialog(null, "La contraseña no coincide vuelva a escribirla.");
                        System.out.println("--------------");
                        return;
                    } else if (datos[fila].getUsuario().equals(datos[fila + 1].getUsuario())) {
                        datos[fila + 1] = null;
                        JOptionPane.showMessageDialog(null, "El usuario ya existe");
                        System.out.println("----------------------");
                        return;
                    }
                } catch (Exception e) {

                }

            }
        }
        JOptionPane.showMessageDialog(null, "El Usuario a sido registrado");

    }

    //Los Usuarios tienen que ser distintos
    public void compararUsuarios(String usuario) {
        Usuario[] datos = RegistroDeUsuarios.datos;
        for (int fila = 0; fila < datos.length; fila++) {
            if (datos[fila] != null) {

            }
        }

    }

    //Nombres de usuarios existen o no
    public void elUsuarioExite(String usuario, String contraseña, String bandera) {
        VentanaUsuario v = new VentanaUsuario();
        Usuario[] datos = RegistroDeUsuarios.datos;
        String contraseñaNueva;
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] != null) {
                //Compara si el usuario y la contraseña coinciden
                if (datos[i].getUsuario().equals(usuario) && datos[i].getContraseña().equals(contraseña)) {
                  
                    JOptionPane.showMessageDialog(null, ">>Bienvenid@<<\n" + ">>>>>" + datos[i].getUsuario() + "<<<<<");
                    bandera = "si";
                    mp.show();
//                    v.dispose();
//                } else if (usuario.equalsIgnoreCase("ADMIN")) {
//
//                    JOptionPane.showMessageDialog(null, ">>BIENVENID@ ADMINISTRADOR<<.");
                
                    
                    //Compara si el usuario esta correcto pero la contraseña no es la correcta
                    return;
                } else if (usuario.equalsIgnoreCase("ADMIN")) {

                    JOptionPane.showMessageDialog(null, ">>BIENVENID@ ADMINISTRADOR<<.");
                    mp.show();
                    bandera = "si";
//                    v.dispose();
                    return;
                } else if (datos[i].getUsuario().equals(usuario) && !(datos[i].getContraseña().equals(contraseña))) {

                    JOptionPane.showMessageDialog(null, " \n Su contraseña es incorrecta");

//                    datos[i].setContraseña(JOptionPane.showInputDialog("Escriba su nueva contraseña"));
//                    datos[i].setConfirmarContraseña(JOptionPane.showInputDialog("Confirme su contraseña"));
//   
//                    JOptionPane.showMessageDialog(null, "Su nueva contraseña es: \n" + datos[i].getContraseña());
                    bandera = "si";
                    return;
                }

            }
        }
        bandera = "no";
        JOptionPane.showMessageDialog(null, "No existe el usuario");

    }

    public void recuperarContraseña(String usuario, String contraseña) {
        Usuario[] datos = RegistroDeUsuarios.datos;
        String contraseñaNueva;
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] != null) {
                if (datos[i].getUsuario().equals(usuario) && !(datos[i].getContraseña().equals(contraseña))) {

//                    JOptionPane.showMessageDialog(null, " \n Su contraseña es incorrecta");

                    datos[i].setContraseña(JOptionPane.showInputDialog("Escriba su nueva contraseña"));
                    datos[i].setConfirmarContraseña(JOptionPane.showInputDialog("Confirme su contraseña"));

                    JOptionPane.showMessageDialog(null, "Su nueva contraseña es: \n" + datos[i].getContraseña());
                    return;

                }
            }
        }
    }

    public void limpiarUsuario(JTextField usuario, JTextField contraseña) {
        usuario.setText(null);
        contraseña.setText(null);
    }
}
