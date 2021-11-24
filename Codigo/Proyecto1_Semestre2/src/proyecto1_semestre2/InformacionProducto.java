/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
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
public class InformacionProducto extends JFrame {
 JPanel panelProducto2;
    JTextField nombreProducto;
    JTextField precioProducto;
    JLabel imagenP;
    JTextField cantidad;
    JButton imagen;
    JButton regresar;
    JButton verificarNombre;
    JButton modificarP;
    JButton aceptarP;
    JButton eliminar;
    public String nombre2;
    public InformacionProducto() {
         this.setSize(480, 440);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        agregarPanelIp();
    }
    
    public void agregarPanelIp(){
        panelProducto2 = new JPanel();
        panelProducto2.setSize(480, 430);
        panelProducto2.setLayout(null);
        panelProducto2.setBackground(Color.BLACK);
        this.add(panelProducto2);
        agregarComponentes9();
    }
    
    public void agregarComponentes9(){
         panelProducto2.add(Componentes.Utiles.crearEtiquetas(70, 85, "NOMBRE:", Color.ORANGE));
        panelProducto2.add(Componentes.Utiles.crearEtiquetas(70, 130, "PRECIO::", Color.LIGHT_GRAY));
        panelProducto2.add(Componentes.Utiles.crearEtiquetas(70, 175, "CANTIDAD:", Color.MAGENTA));
        panelProducto2.add(Componentes.Utiles.crearEtiquetas(70, 210, "AVATAR:", Color.cyan));
        //
        nombreProducto= new JTextField();
        nombreProducto.setBounds(155, 85, 180, 40);
        nombreProducto.setFont(new Font("arial", Font.CENTER_BASELINE, 17));

        nombreProducto.setEditable(false);
        panelProducto2.add(nombreProducto);
        //
        precioProducto = new JTextField();
        precioProducto.setBounds(155, 130, 180, 40);
        precioProducto.setFont(new Font("arial", Font.CENTER_BASELINE, 17));

        precioProducto.setEditable(false);
        panelProducto2.add(precioProducto);
        //
        cantidad = new JTextField();
        cantidad.setBounds(155, 175, 180, 40);
        cantidad.setFont(new Font("arial", Font.CENTER_BASELINE, 17));

        cantidad.setEditable(false);
        panelProducto2.add(cantidad);
        //Combox
        
        //

        //
        imagenP = new JLabel();
        imagenP.setBounds(155, 240, 125, 130);
        imagenP.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        imagenP.setForeground(Color.WHITE);
//        avatarI.setIcon(agregarDimensionesDeImagen(180,180,));

        panelProducto2.add(imagenP);

        //Boton
        verificarNombre = new JButton("Verificacion de nombre");
        verificarNombre.setBounds(0, 0, 500, 30);
        verificarNombre.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panelProducto2.add(verificarNombre);
        //Regresar
        regresar = new JButton("Regresar");
        regresar.setBounds(305, 370, 95, 30);
        regresar.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
        panelProducto2.add(regresar);
        
        //Modificar
         modificarP = new JButton();
        modificarP.setBounds(20, 370, 95, 30);
        modificarP.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
        modificarP.setText("Modificar");
        panelProducto2.add(modificarP);
        //Aceptar Modificacion
        aceptarP= new JButton();
        aceptarP.setBounds(120, 370, 95, 30);
        aceptarP.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
        aceptarP.setText("<html><p>Aceptar</p><p>Modificación</p></html>");
        panelProducto2.add(aceptarP);
        //Eliminar un producto
        eliminar = new JButton();
        eliminar.setBounds(220, 370, 80, 30);
        eliminar.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
        eliminar.setText("Eliminar");
        panelProducto2.add(eliminar);
        iniciarBotonesPi();
        
    }
    //Iniciar los botones
    public void iniciarBotonesPi(){
        //VerificarNombre
        verificarNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              InfoProducto inf= new InfoProducto();
                nombre2=JOptionPane.showInputDialog("Ingrese Nombre");
                System.out.println(nombre2);
              inf.informacionSobreElPro(nombre2,nombreProducto,precioProducto,cantidad ,imagenP);
            }
        }
        );
        
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AdministracionProducto admi= new AdministracionProducto();
                admi.show();
                dispose();
            }
        });
        
        //Modificar evento
        modificarP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                InfoProducto inf= new InfoProducto();
                
                nombreProducto.setEditable(true);
                precioProducto.setEditable(true);
                cantidad.setEditable(true);
                
            }
        });
        
        aceptarP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                InfoProducto inf= new InfoProducto();
                String ruta=abrirImagenP();
                String bandera="si";
                float precio=Float.parseFloat(precioProducto.getText());
                
                inf.compararNombreProducto(nombreProducto.getText());
                if (bandera.equals(InfoProducto.banderaP)) {
                    nombreProducto.setEditable(true);
                }else{
                inf.guardarDatosProducto(nombre2, nombreProducto.getText(), precio,Integer.parseInt(cantidad.getText()), ruta);
                    System.out.println("guardado");
                    nombreProducto.setEditable(false);
                     precioProducto.setEditable(false);
                //
                cantidad.setEditable(false);
                    
                }


            }
        });

                //eliminar
                eliminar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        System.out.println("eliminar");
                        InfoProducto inpro= new InfoProducto();
                      inpro.eliminarProducto(nombreProducto.getText());
                      
                    }
                });
        
    }
    
    //OBTNER RUTA DE imagen de producto
     public String abrirImagenP() {
        String cadena = "";
        String texto = "";

        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(this);
            File abrir = fileChooser.getSelectedFile();
            if (abrir != null) {
                FileReader archivo = new FileReader(abrir);
                BufferedReader leer = new BufferedReader(archivo);
                texto = String.valueOf(abrir);

                leer.close();

            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e + " " + "\n No se encontro el archivo");
        }
        System.out.println(texto);
        return texto;

    }
}
