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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Kelly
 */
public class VentanaUsuario extends JFrame{
    JPanel panel2;
    JTextField textUsuario;
    JPasswordField textContraseña;
    JButton ingresar;
    JButton regresarU;
    JButton recuperar;
    UsuarioExistente usuarioExistente= new UsuarioExistente();
    String bandera;
    
    public VentanaUsuario(){
        this.setSize(500, 400);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        Panel2();
    }
    
    public void Panel2(){
       panel2= new JPanel();
       panel2.setSize(500,400);
       panel2.setLayout(null);
       panel2.setBackground(Color.BLACK);
       this.add(panel2);
       agregarLabels();
    }
    
    public void agregarLabels(){
     //login
     panel2.add(Componentes.Utiles.crearEtiquetas(10, 10,"LOGIN",Color.BLUE));
    //USUARIO
    panel2.add(Componentes.Utiles.crearEtiquetas(50, 80,"USUARIO:",Color.BLUE));
    textUsuario= new JTextField();
    textUsuario.setBounds(183,80,135,40);
    textUsuario.setFont(new Font("arial",Font.CENTER_BASELINE, 15));
    panel2.add(textUsuario);
    //CONTRASEÑA
    panel2.add(Componentes.Utiles.crearEtiquetas(50, 160,"CONTRASEÑA:",Color.BLUE));
    textContraseña= new JPasswordField();
    textContraseña.setBounds(183, 160, 135, 40);
    textContraseña.setFont(new Font("arial",Font.CENTER_BASELINE, 15));
    panel2.add(textContraseña);
    //Imagen usuario
     panel2.add(Componentes.Utiles.agregarImagenes(368, 255,"usaurioImge2.jpg"));
    //Ingresar
    ingresar=new JButton("INGRESAR");
    ingresar.setBounds(178,210,100,40);
    panel2.add(ingresar);
    //Boton para regresar
     regresarU= new JButton("Regresar");
    regresarU.setBounds(5,300,100,40);
    panel2.add(regresarU);
    //Boton recuperar
    recuperar=new JButton("<html><p>Olvide</p><p>Mi contraseña</p></html>");
    recuperar.setBounds(178,300,100,65);
    panel2.add(recuperar);
    botonIngresar();
    }
    
    public void botonIngresar(){
        
        ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                VentanaUsuario v= new VentanaUsuario();
//                usuarioExistente.denegarUsuario(textUsuario.getText());
//                usuarioExistente.ingresarAmin(textUsuario.getText(), v);
                bandera=" ";
                 usuarioExistente.elUsuarioExite(textUsuario.getText(),textContraseña.getText(),bandera);
                if (bandera=="si") {
                  
               usuarioExistente.limpiarUsuario(textUsuario, textContraseña);
                 MenuPrincipal menu= new MenuPrincipal();
                    dispose();
               
                return;
                }
               
            }
        });
        recuperar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                bandera=false;
                if (bandera=="si") {
                    
                }else{
                    usuarioExistente.recuperarContraseña(textUsuario.getText(), textContraseña.getText());
                    usuarioExistente.limpiarUsuario(textUsuario, textContraseña);
                }
            }
        });
        regresarU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaPrincipal venP = new VentanaPrincipal();
                venP.show();
                dispose();
            }
        });
    }
}
