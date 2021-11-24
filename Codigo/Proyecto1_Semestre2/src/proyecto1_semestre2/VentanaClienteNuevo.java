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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Kelly
 */
public class VentanaClienteNuevo extends JFrame {

    JPanel panel6;
    JTextField nombreN;
    JTextField edadN;
    JComboBox sexoN;
    JTextField avatarN;
    JTextField nitN;
    JButton seleccionar;
    JButton reg;
     JButton verificarNit;
    ClienteExistente cliente= new ClienteExistente();
    public VentanaClienteNuevo() {

        this.setSize(500, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        Panel6();
    }

    //Se agrega el panel al JFrame
    public void Panel6() {

        panel6 = new JPanel();
        panel6.setSize(500, 400);
        panel6.setLayout(null);
        panel6.setBackground(Color.BLACK);
        this.add(panel6);
        agregarLabels6();

    }

    //Se agregan las etiqueetas ala panel
    public void agregarLabels6() {
        panel6.add(Componentes.Utiles.crearEtiquetas(80, 80, "Nombre", Color.RED));
        nombreN = new JTextField();
        nombreN.setBounds(165, 80, 140, 40);
        nombreN.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panel6.add(nombreN);
        //ETIQUETA EDAD
        panel6.add(Componentes.Utiles.crearEtiquetas(80, 125, "Edad", Color.RED));
        edadN = new JTextField();
        edadN.setBounds(165, 125, 140, 40);
        edadN.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        panel6.add(edadN);
        //Etiqueta sexo
        panel6.add(Componentes.Utiles.crearEtiquetas(80, 170, "Sexo", Color.RED));
        sexoN= new JComboBox();
        sexoN.addItem("F");
        sexoN.addItem("M");
        sexoN.setBounds(165,170,80,35);
        sexoN.setFont(new Font("arial",Font.CENTER_BASELINE,17));
        panel6.add(sexoN);
        //Etiqueta nit
        panel6.add(Componentes.Utiles.crearEtiquetas(80, 215, "NIT", Color.RED));
        nitN = new JTextField();
        nitN.setBounds(165, 215, 140, 40);
        nitN.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
        nitN.setEditable(false);
        panel6.add(nitN);
       //Etiqueta NIT
        panel6.add(Componentes.Utiles.crearEtiquetas(165, 260, "AVATAR", Color.RED));
//        avatarN = new JTextField();
//        avatarN.setBounds(165, 260, 140, 40);
//        avatarN.setFont(new Font("arial", Font.CENTER_BASELINE, 17));
//        panel6.add(avatarN);
//        
        //Seleccionar
        seleccionar=new JButton("Seleccionar");
        seleccionar.setBounds(165,305,110,50);
        panel6.add(seleccionar);
        
        //Regresar
        reg=new JButton("Regresar");
        reg.setBounds(10,305,100,50);
        panel6.add(reg);
        
        verificarNit = new JButton("Verificar Nit");
        verificarNit.setBounds(0, 0,500, 30);
        verificarNit.setFont(new Font("arial",Font.CENTER_BASELINE, 17));
        
        panel6.add(verificarNit);
        seleccionarBoton();

    }
    
    public void seleccionarBoton(){
        //Verifica el nit 
        verificarNit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                cliente.clienteExiste(Integer.parseInt(JOptionPane.showInputDialog("Escriba su NIT para verificarlo en la base de datos")),nitN);
                
            }
        });
        //Secciona la imagen y guarda los datos de los jtexfield
        seleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               String ruta= abrirImagen();
                String sexoElegido= sexoN.getSelectedItem().toString();
                
               char sexo=sexoElegido.charAt(0);
            cliente.NitCoincide(nombreN.getText(),Integer.parseInt(edadN.getText()),sexo,Integer.parseInt(nitN.getText()),ruta);
            nombreN.setText("");
            edadN.setText("");
            nitN.setText("");
//            avatarN.setText("");
            nitN.setEditable(false);
            }
        });
        //Este boton regresa al menu principal
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
             AdministraciónDeClientes admin= new AdministraciónDeClientes();
             admin.show();
             dispose();
            }
        });
    }
    
    //Funcion que devuelve una cadena de texto que guardo la ruta del archivo escogido
    public String abrirImagen(){
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
