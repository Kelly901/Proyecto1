/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Kelly
 */
public class VentanaRegistrarse extends JFrame {

    JPanel panel3;
   public JTextField usuario1;
    JTextField nombre;
    JTextField contraseña;
    JTextField confirmarContraseña;
    JButton registar;
   public String nombreIngresado;
   public String usuarioIngresado;
   public String contraseñaIngresada;
   public String confimacionIngresada;
   JButton regresar1;
   UsuarioExistente usuEx= new UsuarioExistente();
    RegistroDeUsuarios registroUsuario= new RegistroDeUsuarios();
    public VentanaRegistrarse() {
        this.setSize(500, 450);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        Panel3();

    }

    public void Panel3() {
        panel3 = new JPanel();
        panel3.setSize(500, 450);
        panel3.setLayout(null);
        panel3.setBackground(Color.BLACK);
        this.add(panel3);

        agregarBotones2();

    }

    public void agregarBotones2() {
        
        panel3.add(Componentes.Utiles.agregarImagenes(360, 315, "creaTuUsuario.jpg"));
        //
        panel3.add(Componentes.Utiles.crearEtiquetas(80, 80, "USUARIO",Color.BLUE));
        usuario1 = new JTextField();
        usuario1.setBounds(230, 80, 140, 40);
        usuario1.setFont(new Font("arial", Font.CENTER_BASELINE, 16));
        panel3.add(usuario1);
        usuarioIngresado= new String();
        usuarioIngresado=usuario1.getText();
        //NOMBRE
        panel3.add(Componentes.Utiles.crearEtiquetas(80,135,"NOMBRE",Color.BLUE));
        nombre = new JTextField();
        nombre.setBounds(230, 130, 145, 40);
        nombre.setFont(new Font("arial", Font.CENTER_BASELINE, 16));
        panel3.add(nombre);
        nombreIngresado= new String();
        nombreIngresado=nombre.getText();
        //Contraseña
        panel3.add(Componentes.Utiles.crearEtiquetas(80,185,"CONTRASEÑA",Color.BLUE));
        contraseña = new JTextField();
        contraseña.setBounds(230, 185, 145, 40);
        contraseña.setFont(new Font("arial", Font.CENTER_BASELINE, 16));
        panel3.add(contraseña);
        contraseñaIngresada= new String();
        contraseñaIngresada=contraseña.getText();
        //Confirmar Contraseña
        panel3.add(Componentes.Utiles.crearEtiquetas(80,235,"CONFIRMAR",Color.BLUE));
        panel3.add(Componentes.Utiles.crearEtiquetas(80,270,"CONTRASEÑA",Color.BLUE));
        confirmarContraseña = new JTextField();
        confirmarContraseña.setBounds(230, 240, 140, 40);
        confirmarContraseña.setFont(new Font("arial", Font.CENTER_BASELINE, 16));
        panel3.add(confirmarContraseña);
        confimacionIngresada= new String();
        confimacionIngresada=confirmarContraseña.getText();
        //Boton registrar
        registar= new JButton("Registrar");
        registar.setBounds(205,310 ,140, 40);
        registar.setFont(new Font("arial",Font.BOLD,15));
        panel3.add(registar);
        
        //
        regresar1= new JButton("regresar");
        regresar1.setBounds(205, 355,85,40);
        panel3.add(regresar1);
        
        
        botonRegistrar();
        
        botonRegresar();
        
    }
    
    public void botonRegistrar(){
        registar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) { 
               
                registroUsuario.guardarUsuario(usuario1.getText(),nombre.getText(), contraseña.getText(), confirmarContraseña.getText());
                usuEx.compararContraseña(confirmarContraseña.getText());
//                usuEx.compararUsuarios(usuario1.getText());
              
            }
        });
        
        
        
    }
    public void botonRegresar(){
       regresar1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               VentanaPrincipal venP= new VentanaPrincipal();
               venP.show();
               dispose();
           }
       }
       
      );
    }
}
