/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Kelly
 */
public class Utiles {
    
  public static JLabel crearEtiquetas(int x,int y,String nombreEitiqueta,Color color){
     
      JLabel etiqueta= new JLabel();
      etiqueta.setText(nombreEitiqueta);
      etiqueta.setFont(new Font("arial",Font.CENTER_BASELINE,15 ));
      etiqueta.setForeground(color);
      etiqueta.setBounds(x, y, 130, 40);
         
      
      return etiqueta;
      
  } 
   public static JLabel agregarImagenes(int x,int y,String icono){
     
      JLabel etiqueta= new JLabel();
      
      etiqueta.setFont(new Font("arial",Font.CENTER_BASELINE,15 ));
      etiqueta.setForeground(Color.BLUE);
      etiqueta.setBounds(x, y, 130, 103);
         etiqueta.setIcon(new ImageIcon(icono));
      
      return etiqueta;
      
  } 
  
  public static JButton crearBotones(int x,int y, String nombre){
      JButton boton= new JButton();
      boton.setText(nombre);
      boton.setFont(new Font("arial",Font.CENTER_BASELINE, 15));
      boton.setBackground(Color.BLACK);
      boton.setForeground(Color.GREEN);
      boton.setBounds(x, y, 130, 55);
      return boton;
  }
}
