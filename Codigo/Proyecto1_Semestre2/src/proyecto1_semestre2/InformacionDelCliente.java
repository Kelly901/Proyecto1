/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
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
public class InformacionDelCliente extends JFrame {

    JPanel panel8;
    JButton botonNitI;
    JButton botonR;
    JTextField nombreI;
    JTextField edadI;
    JTextField sexoI;
    JComboBox  sexoC;
    JTextField nitI;
    JButton modificar;
    JButton aceptarModificacion;
    JButton eliminar;
    JLabel avatarI;
    public int nit2;
    public InformacionDelCliente() {
        this.setSize(480, 440);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        Panel8();
    }

    public void Panel8() {
        panel8 = new JPanel();
        panel8.setSize(480, 430);
        panel8.setLayout(null);
        panel8.setBackground(Color.BLACK);
        this.add(panel8);
        agregarComponentes8();
    }

    public void agregarComponentes8() {
        panel8.add(Componentes.Utiles.crearEtiquetas(70, 85, "NOMBRE:", Color.ORANGE));
        panel8.add(Componentes.Utiles.crearEtiquetas(70, 130, "EDAD::", Color.LIGHT_GRAY));
        panel8.add(Componentes.Utiles.crearEtiquetas(70, 175, "SEXO:", Color.MAGENTA));
        panel8.add(Componentes.Utiles.crearEtiquetas(70, 210, "NIT:", Color.cyan));
        //
        nombreI = new JTextField();
        nombreI.setBounds(150, 85, 180, 40);
        nombreI.setFont(new Font("arial", Font.CENTER_BASELINE, 17));

        nombreI.setEditable(false);
        panel8.add(nombreI);
        //
        edadI = new JTextField();
        edadI.setBounds(150, 130, 180, 40);
        edadI.setFont(new Font("arial", Font.CENTER_BASELINE, 17));

        edadI.setEditable(false);
        panel8.add(edadI);
        //
        sexoI = new JTextField();
        sexoI.setBounds(150, 175, 180, 40);
        sexoI.setFont(new Font("arial", Font.CENTER_BASELINE, 17));

        sexoI.setEditable(false);
        panel8.add(sexoI);
        //Combox
         sexoC = new JComboBox();
        sexoC.setBounds(150, 175, 180, 40);
        sexoC.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        sexoC.addItem("F");
        sexoC.addItem("M");
        sexoC.setEditable(false);
        sexoC.setVisible(false);
        panel8.add(sexoC);
        
        //
        nitI = new JTextField();
        nitI.setBounds(150, 220, 180, 40);
        nitI.setFont(new Font("arial", Font.CENTER_BASELINE, 17));

        nitI.setEditable(false);
        panel8.add(nitI);
        //
        avatarI = new JLabel();
        avatarI.setBounds(150, 265, 100, 100);
        avatarI.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        avatarI.setForeground(Color.WHITE);
//        avatarI.setIcon(agregarDimensionesDeImagen(180,180,));

        panel8.add(avatarI);

        //Boton
        botonNitI = new JButton("Verificacion de NIT");
        botonNitI.setBounds(0, 0, 500, 30);
        botonNitI.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panel8.add(botonNitI);
        //Regresar
        botonR = new JButton("Regresar");
        botonR.setBounds(305, 370, 95, 30);
        botonR.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
        panel8.add(botonR);

        //Modificar
        modificar = new JButton();
        modificar.setBounds(20, 370, 95, 30);
        modificar.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
        modificar.setText("Modificar");
        panel8.add(modificar);
        //Aceptar Modificacion
        aceptarModificacion = new JButton();
        aceptarModificacion.setBounds(120, 370, 95, 30);
        aceptarModificacion.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
        aceptarModificacion.setText("<html><p>Aceptar</p><p>Modificación</p></html>");
        panel8.add(aceptarModificacion);
        //Boton Eliminar
        eliminar = new JButton();
        eliminar.setBounds(220, 370, 80, 30);
        eliminar.setFont(new Font("arial", Font.CENTER_BASELINE, 12));
        eliminar.setText("Eliminar");
        panel8.add(eliminar);
        iniciar();

    }

    public void iniciar() {
        botonNitI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                InfoCliente info = new InfoCliente();
                
                nit2=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el NIT a buscar"));
                info.informacioSobreCliente(nit2, nombreI, edadI, sexoI, nitI, avatarI);
//             nombreI.setEditable(false);
//            //
//            edadI.setEditable(false);
//            //
//            sexoI.setEditable(false);
//            //
//            nitI.setEditable(false);
//            //
//            
            }
        });
        //Regresar
        botonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AdministraciónDeClientes admin = new AdministraciónDeClientes();
                admin.show();
                dispose();
            }
        });
        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                InfoCliente inf = new InfoCliente();
                String bandera ="si";               
                
                nitI.setEditable(true);
                nombreI.setEditable(true);
                edadI.setEditable(true);
                sexoI.setVisible(false);
                sexoC.setVisible(true);
                sexoC.setEditable(true);

            }
        });

        aceptarModificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                InfoCliente inf = new InfoCliente();
                String ruta=abrirImagen2();
                String dato=sexoC.getSelectedItem().toString();
                char dato1=dato.charAt(0);
                String bandera ="si";
                
                 inf.compararNitRepetido(Integer.parseInt(nitI.getText()),bandera);
                 
                if (bandera.equals(InfoCliente.bandera2)) {
                    
                   
                }else{
                    inf.guardarDatos(nit2,Integer.parseInt(nitI.getText()),nombreI.getText(),Integer.parseInt(edadI.getText()), dato1, ruta,bandera);
                System.out.println("guardado");
                
                }
                nombreI.setEditable(false);
                //
                edadI.setEditable(false);
                //
                sexoI.setEditable(false);
                sexoC.setEditable(false);
                //
                nitI.setEditable(false);
                //
            }
        });
        //Elimina un usuario
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               InfoCliente inf = new InfoCliente();
              inf.eliminarUsuario(Integer.parseInt(nitI.getText()));
            }
        });
    }

    //Funcion que retorna una cadena con la ruta de un archivo
    public String abrirImagen2() {
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
