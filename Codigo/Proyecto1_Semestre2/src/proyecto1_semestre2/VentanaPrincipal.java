/*s
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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kelly
 */
public class VentanaPrincipal extends JFrame {

    JPanel panel1;
    JButton botonUsuario;
    JButton salir;
    JButton botonRegistrarse;

    public VentanaPrincipal() {
        super();

        this.setSize(500, 450);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        Panel();
        
    
    }

    public void Panel() {

        panel1 = new JPanel();
        panel1.setSize(500, 450);
        panel1.setLayout(null);
        panel1.setBackground(Color.BLACK);
        this.add(panel1);
        agregarBotones();
    }

    public void agregarBotones() {
        JLabel label= new JLabel();
        label.setText("AUTENTICACIÓN");
        label.setBounds(120,10, 170, 40);
        label.setFont(new Font("arial", Font.CENTER_BASELINE, 21));
        label.setForeground(Color.white);
        panel1.add(label);
        //Boton de usuario 
        botonUsuario = new JButton();
        botonUsuario.setText("Usuario");
        botonUsuario.setFont(new Font("arial", Font.CENTER_BASELINE, 20));
        botonUsuario.setBackground(Color.BLACK);
        botonUsuario.setForeground(Color.GREEN);
        botonUsuario.setBounds(160, 80, 135, 55);
        panel1.add(botonUsuario);

        //Boton para registrarse
        botonRegistrarse = new JButton();
        botonRegistrarse.setText("Registrarse");
        botonRegistrarse.setFont(new Font("arial", Font.CENTER_BASELINE, 20));
        botonRegistrarse.setBackground(Color.BLACK);
        botonRegistrarse.setForeground(Color.GREEN);
        botonRegistrarse.setBounds(160, 175, 145, 55);
        panel1.add(botonRegistrarse);
        
        //boton salir
        salir = new JButton();
        salir.setText("Salir");
        salir.setFont(new Font("arial", Font.CENTER_BASELINE, 20));
        salir.setBackground(Color.BLACK);
        salir.setForeground(Color.GREEN);
        salir.setBounds(160, 235, 145, 55);
        panel1.add(salir);
        
        
            usuario();
        
        
    }

    public void usuario() {
        botonUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaUsuario venUsuario = new VentanaUsuario();
                venUsuario.show();
                dispose();

            }
        });
        botonRegistrarse.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent ae) {
             VentanaRegistrarse venRegis= new VentanaRegistrarse();
             venRegis.show();
             dispose();
          }
      });
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }

   
}
