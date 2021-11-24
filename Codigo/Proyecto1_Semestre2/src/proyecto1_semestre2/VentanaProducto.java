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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Kelly
 */
public class VentanaProducto extends JFrame {
    JPanel panelProducto;
    JTextField nombreProducto;
    JTextField precioProducto;
    JTextField cantidad;
    JButton imagen;
    JButton regresar;
    JButton verificarNombre;
    ProductoExistente pr= new ProductoExistente();
    public VentanaProducto(){
        this.setSize(500, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        agregarPanelProducto();
    }
    public void agregarPanelProducto(){
       panelProducto= new JPanel();
       panelProducto.setSize(500,400);
       panelProducto.setLayout(null);
       panelProducto.setBackground(Color.black);
       this.add(panelProducto);
       agregarCompontes3();
    }
    
    public void agregarCompontes3(){
        JLabel etiqueta=  new JLabel("");
        etiqueta.setBounds(80, 0, 305, 45);
        etiqueta.setFont(new Font("arial", Font.CENTER_BASELINE, 18));
        etiqueta.setForeground(Color.GREEN);
        panelProducto.add(etiqueta);
        agregarBotonones3();
    }
    public void agregarBotonones3(){
      //Etique de Nombre
         panelProducto.add(Componentes.Utiles.crearEtiquetas(80, 80, "Nombre", Color.RED));
         //Nombre DEL PRODUCTO
        nombreProducto = new JTextField();
        nombreProducto.setBounds(165, 80, 140, 40);
        nombreProducto.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        nombreProducto.setEditable(false);
        panelProducto.add(nombreProducto);
        //ETIQUETA Precio
        panelProducto.add(Componentes.Utiles.crearEtiquetas(80, 125, "Precio", Color.RED));
        //PrecioProducto
        precioProducto= new JTextField();
        precioProducto.setBounds(165, 125, 140, 40);
        precioProducto.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
      
        panelProducto.add(precioProducto);
        //Etiqueta sexo
        panelProducto.add(Componentes.Utiles.crearEtiquetas(80, 170, "Cantidad", Color.RED));
        cantidad= new JTextField();
        cantidad.setBounds(165,170,140,40);
        cantidad.setFont(new Font("arial",Font.CENTER_BASELINE,17));
       
        panelProducto.add(cantidad);
       
        panelProducto.add(Componentes.Utiles.crearEtiquetas(165, 260, "AVATAR", Color.RED));
//        avatarN = new JTextField();
//        avatarN.setBounds(165, 260, 140, 40);
//        avatarN.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
//        panel6.add(avatarN);
//        
        //Seleccionar
        imagen=new JButton("Seleccionar");
        imagen.setBounds(165,305,110,50);
        
        panelProducto.add(imagen);
        //
 
        //Regresar
        regresar=new JButton("Regresar");
        regresar.setBounds(10,305,100,50);
        panelProducto.add(regresar);
        
        verificarNombre = new JButton("Verificar Nit");
        verificarNombre.setBounds(0, 0,500, 30);
        verificarNombre.setFont(new Font("arial",Font.CENTER_BASELINE, 17));
        
        panelProducto.add(verificarNombre);
        iniciarBotonesP();
    }
    
    public void iniciarBotonesP(){
       regresar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               AdministracionProducto admin= new AdministracionProducto();
               admin.show();
               dispose();
           }
       });
       
       verificarNombre.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
              String d= JOptionPane.showInputDialog("Escriba el nombre para verficarlo");
             pr.productoExistente(d,nombreProducto);
              
               System.out.println(d);
               
           }
       });
       //IMAGEN
       imagen.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
            String ruta=abrirImagenP();
            float preci=Float.parseFloat(precioProducto.getText());
            pr.productoNuevo(nombreProducto.getText(), preci,Integer.parseInt(cantidad.getText()), ruta);
           }
       });
    }
    
    public String abrirImagenP(){
        String cadena="";
        String texto="";
        
        try{
         JFileChooser fileChooser= new JFileChooser();  
         fileChooser.showOpenDialog(this);
         File abrir= fileChooser.getSelectedFile();
            if (abrir!=null) {
                FileReader archivo= new FileReader(abrir);
                BufferedReader leer = new BufferedReader(archivo);
                texto=String.valueOf(abrir);
                 
                leer.close();
                
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e+" "+"\n No se encontro el archivo");
        }
        System.out.println(texto);
       return texto ;
       
    }
    
    
}
