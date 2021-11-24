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
import javafx.stage.FileChooser;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Kelly
 */
public class MenuPrincipal extends JFrame {
    JPanel panel4;
    JButton clientes;
    JButton productos;
    JButton ventas;
    JButton reportes;
    JButton cerrarSesion;
    JButton subirClientes;
    JButton subirProducto;
    JButton subirVenta;
    public MenuPrincipal(){
        super();
        this.setSize(550, 450);
        this.setTitle("Menu Principal");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        Panel4();
    }
    
    public void Panel4(){
        
        panel4= new JPanel();
        panel4.setSize(550,450);
        panel4.setLayout(null);
        panel4.setBackground(Color.BLACK);
        this.add(panel4);
        agregaBotones4();
    }
    public void agregaBotones4(){
        
        JLabel label= new JLabel("Menu Principal");
        label.setBounds(150, 10,260,45);
        label.setFont(new Font("arial", Font.CENTER_BASELINE, 19));
        label.setForeground(Color.WHITE);
        panel4.add(label);
        //Clientes
        clientes= new JButton("Administración de Clientes");
        clientes.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        clientes.setBackground(Color.BLACK);
        clientes.setForeground(Color.cyan);
        clientes.setBounds(45, 80, 260, 45);
        panel4.add(clientes);
        //Subir archivo de ventas
        subirClientes= new JButton("CargarClientes");
        subirClientes.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
       subirClientes.setBackground(Color.BLACK);
       subirClientes.setForeground(Color.WHITE);
        subirClientes.setBounds(320, 80, 190, 45);
        panel4.add(subirClientes);
        //Administración de productos
        productos= new JButton("Administración de Productos");
        productos.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        productos.setBackground(Color.BLACK);
        productos.setForeground(Color.GREEN);
        productos.setBounds(45,135, 270, 45);
        panel4.add(productos);
        //SUBIR PRODUCTO
        subirProducto= new JButton("Cargar productos");
        subirProducto.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
       subirProducto.setBackground(Color.BLACK);
       subirProducto.setForeground(Color.WHITE);
        subirProducto.setBounds(320, 135, 190, 45);
        panel4.add(subirProducto);
        //Administracion de ventas
        ventas= new JButton("Administración de Ventas");
        ventas.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        ventas.setBackground(Color.BLACK);
        ventas.setForeground(Color.BLUE);
        ventas.setBounds(45,185, 270, 45);
        panel4.add(ventas);
        //Cargar ventas
        subirVenta= new JButton("Cargar Ventas");
        subirVenta.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        subirVenta.setBackground(Color.BLACK);
        subirVenta.setForeground(Color.WHITE);
        subirVenta.setBounds(320, 185, 190, 45);
        panel4.add(subirVenta);
        //Administración de Reportes
        reportes= new JButton("Administración de Reportes");
        reportes.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        reportes.setBackground(Color.BLACK);
        reportes.setForeground(Color.LIGHT_GRAY);
        reportes.setBounds(45,235, 270, 45);
        panel4.add(reportes);
        //CERRAR SESION
        cerrarSesion = new JButton("Cerrar Sesion");
        cerrarSesion.setBounds(0,350, 150, 60);
        cerrarSesion.setBackground(Color.BLACK);
        cerrarSesion.setForeground(Color.BLUE);
        cerrarSesion.setFont(new Font("arial", Font.CENTER_BASELINE, 15));
        panel4.add(cerrarSesion);
        
        botonClientes();
    }
    
    public void botonClientes(){
        clientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                AdministraciónDeClientes admin= new AdministraciónDeClientes();
                admin.show();
//              VentanaClientes venClientes= new VentanaClientes();
//              venClientes.show();
              dispose();
            }
        });
        //Cargar Clienes
        subirClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               quitarLaComa(abrirTexto());
            }
        });
        productos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                AdministracionProducto ad= new AdministracionProducto();
                ad.show();
                dispose();
            }
        });
        //Subir productos
        subirProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               quitarLaComa2(abrirTextoProducto()); 
            }
        });
        //
        ventas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               AdministracionDeVenta adVen= new AdministracionDeVenta();
               adVen.show();
               dispose();
            }
        });
        //Cargar venta
        subirVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                quitarLaComaVenta(abrirTextoVenta());
               
            }
        });
        
        
        cerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              VentanaUsuario us= new VentanaUsuario();
              us.show();
              dispose();
            }
        });
    }
    //Este metodo quita la coma y asigna el valor seguna la posicion que le corresponde en el constructor de cliente nuevo
    public void quitarLaComa(String cadena){
        Componentes.CargaDeDatos cd= new Componentes.CargaDeDatos();
        String fila[]= cadena.split("\n");
        for (int i = 0; i < fila.length; i++) {
            String [] palabras= fila[i].split(",");
            String name=palabras[0];
            int edad= Integer.parseInt(palabras[1]);
            char sexo= palabras[2].charAt(0);
            int nit= Integer.parseInt(palabras[3]);
            String avatar=palabras[4];
            cd.guardarCargDeDatos(name, edad, sexo, nit, avatar);
        }
    }
    //Abre el archivo de texto para cliente nuevo
    public String abrirTexto(){
        String cadena="";
        String texto="";
        
       try{
           JFileChooser fileChooser= new JFileChooser();
       
        fileChooser.showOpenDialog(this);
        
        File abrir= fileChooser.getSelectedFile();
        if (abrir!=null) {
            FileReader archivo= new FileReader(abrir);
            BufferedReader leer= new BufferedReader(archivo);
            while((cadena=leer.readLine())!=null){
                texto+=cadena+"\n";
                System.out.println(abrir);
            }
            leer.close();
            
        }
    }catch(IOException e){
           JOptionPane.showMessageDialog(null, e+" "+"\n No se encontro el archivo" ,
                   "Adevertencia",JOptionPane.WARNING_MESSAGE);
    }
        return texto;
    }
    //Quitar la coma de producto
    public void quitarLaComa2(String cadena){
        Componentes.CargaProducto p= new Componentes.CargaProducto();
        String fila[]= cadena.split("\n");
        for (int i = 0; i < fila.length; i++) {
            String [] palabras= fila[i].split(",");
            String name=palabras[0];
            float precio=Float.parseFloat(palabras[1]);
            int cantidad= Integer.parseInt(palabras[2]);
            String avatar=palabras[3];
            p.guardarProductos(name, precio,cantidad, avatar);
        }
    }
    //Abri Texot Producto
    public String abrirTextoProducto(){
        String cadena2="";
        String texto="";
        
        try{
            JFileChooser file= new JFileChooser();
            file.showOpenDialog(this);
            File abrir=file.getSelectedFile();
            if (abrir!=null) {
                FileReader archivo= new FileReader(abrir);
                BufferedReader leer= new BufferedReader(archivo);
                while((cadena2=leer.readLine())!=null){
                    texto+=cadena2+"\n";
                }
                leer.close();
                
            }
        }catch(IOException b){
             JOptionPane.showMessageDialog(null, b+" "+"\n No se encontro el archivo" ,
                   "Adevertencia",JOptionPane.WARNING_MESSAGE);
            
        }
        return texto;
    }
    //Quitar coma de venta
    public void quitarLaComaVenta(String cadena){
         Componentes.CargarVentas cv= new Componentes.CargarVentas();
         VentaExistente ven=new VentaExistente();
        String fila[]= cadena.split("\n");
        for (int i = 0; i < fila.length; i++) {
            String [] palabras= fila[i].split(",");
            String codigo=palabras[0];
            int nit= Integer.parseInt(palabras[1]);
            String name= palabras[2];
            int cantidad=Integer.parseInt(palabras[3]);
            cv.guardarVentas(codigo, nit, name,cantidad);
            ven.restarleProducto(name, cantidad);
        }
       
    }
    //Abrir archivo de venta
    public String abrirTextoVenta(){
        String cadena2="";
        String texto="";
        
        try{
            JFileChooser file= new JFileChooser();
            file.showOpenDialog(this);
            File abrir=file.getSelectedFile();
            if (abrir!=null) {
                FileReader archivo= new FileReader(abrir);
                BufferedReader leer= new BufferedReader(archivo);
                while((cadena2=leer.readLine())!=null){
                    texto+=cadena2+"\n";
                }
                leer.close();
                
            }
        }catch(IOException b){
             JOptionPane.showMessageDialog(null, b+" "+"\n No se encontro el archivo" ,
                   "Adevertencia",JOptionPane.WARNING_MESSAGE);
            
        }
        return texto;
    }
}
