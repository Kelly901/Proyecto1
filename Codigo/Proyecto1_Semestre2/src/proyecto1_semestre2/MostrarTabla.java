/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_semestre2;

import Componentes.CargarVentas;
import static Componentes.CargarVentas.suma;
import static Componentes.CargarVentas.venta;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kelly
 */
public class MostrarTabla extends JFrame {

    JPanel panelMostrar;
    JPanel tablaMo;
    String codigos;
    String nombre;
    float cantidad2;
    float cantidad3;
    float iva;
    float precio2;
    float cantidad;

    public MostrarTabla() {
        this.setSize(700, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Nueva venta");
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        PanelMostrarTabla();
    }

    public void PanelMostrarTabla() {
        panelMostrar = new JPanel();
        panelMostrar.setSize(700, 600);
        panelMostrar.setLayout(null);
        panelMostrar.setBackground(Color.black);
        this.add(panelMostrar);
//        ObtenerPosicion();
        agregarTabla();
    }

    public void agregarTabla() {
        Componentes.Ventas[] venta = Componentes.CargarVentas.venta;
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable();
        JPanel panel = new JPanel();
        panel.setVisible(true);
        panel.add(table);

        panel.setBounds(10, 0, 470,600);
        model.addColumn("Codigo");
        model.addColumn("Cliente");
        model.addColumn("Total");

        Object arreglo[] = new Object[100];

        for (int i = 0; i < arreglo.length; i++) {
            if (venta != null) {
                if (venta[i].getCodigo().equals(CargarVentas.codigos[i])) {
                    obetenerClietne(venta[i].getNit());
                    ObtenerCantidad(venta[i].getNombre());
                    arreglo[0] =CargarVentas.codigos[i];
                    arreglo[1] = nombre;
                    arreglo[2] = cantidad3;
                    model.addRow(arreglo);

                }
            }
        }
        JScrollPane pane = new JScrollPane(table);
        panel.add(pane, BorderLayout.CENTER);
        table.setModel(model);
        panelMostrar.add(panel);

    }

    public void obetenerClietne(int nit) {
        Componentes.Cliente[] client = Componentes.CargaDeDatos.clientes;

        for (int i = 0; i < client.length; i++) {
            if (client[i] != null) {
                if (client[i].getNit() == nit) {
                    this.nombre = client[i].getNombre();
                }
            }
        }
    }

    //
    public void ObtenerCantidad(String producto) {
        Componentes.Ventas[] datos = Componentes.CargarVentas.venta;
        proyecto1_semestre2.Producto[] datos3 = Componentes.CargaProducto.productos;
        precio2 = 0;
        for (int i = 0; i < datos3.length; i++) {
            if (datos3[i] != null) {
                if (datos3[i].getNombre().equals(producto)) {
                    System.out.println(datos3[i].getNombre() + "-->>>" + producto + "-->" + datos3[i].getPrecio());
                    precio2 = datos3[i].getPrecio();
                    cantidad2 = precio2 * cantidad;
                    cantidad3 += cantidad2;
                    iva = (float) (cantidad3 * 0.12);
                }
            }
        }

    }

    //
    public void ObtenerPosicion() {
        for (int i = 0; i < suma - 1; i++) {
            if (venta != null) {
                if (venta[i].getCodigo().equals(venta[i + 1].getCodigo())) {
                    System.out.println("codigos " + i + " " + venta[i].getCodigo());
                    codigos = venta[i].getCodigo();
                    break;

                }
                {

                }
            }
        }

    }
}
