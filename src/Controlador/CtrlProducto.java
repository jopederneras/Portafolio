/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionListener;
import Modelo.Productos;
import Modelo.Consultas;
import Vistas.CRUDProductos;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class CtrlProducto implements ActionListener {
    
    private Productos mod;
    private Consultas modC;
    private CRUDProductos agre;
    
    public CtrlProducto (Productos mod,Consultas modC,CRUDProductos agre)
    {
        this.mod = mod;
        this.modC = modC;
        this.agre = agre;
        this.agre.jbAgregarProducto.addActionListener(this);
        this.agre.jbEliminar.addActionListener(this);
        this.agre.jbModificar.addActionListener(this);
    }
    
    public void iniciar ()
    {
        agre.setTitle("Agregar");
        agre.setLocationRelativeTo(null);
        agre.txtId.setVisible(false);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource() == agre.jbAgregarProducto)
        {
            mod.setProducto(agre.cboxProducto.getSelectedItem().toString());
            mod.setTipo(agre.cboxTipo.getSelectedItem().toString());
            mod.setNombre(agre.txtNombre.getText());
            mod.setPrecio(Integer.parseInt(agre.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(agre.txtCantidad.getText()));
            mod.setFecha_compra(agre.txtCompra.getText());
            
            if(modC.agregar(mod))
            {
                JOptionPane.showMessageDialog(null,"Producto Agregado");
                limpiar();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error al Agregar");
            }
        }
        
        if(e.getSource() == agre.jbModificar)
        {
            mod.setId(Integer.parseInt(agre.txtId.getText()));
            mod.setProducto(agre.cboxProducto.getSelectedItem().toString());
            mod.setTipo(agre.cboxTipo.getSelectedItem().toString());
            mod.setNombre(agre.txtNombre.getText());
            mod.setPrecio(Integer.parseInt(agre.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(agre.txtCantidad.getText()));
            mod.setFecha_compra(agre.txtCompra.getText());
            
            if(modC.modificar(mod))
            {
                JOptionPane.showMessageDialog(null,"Producto Modificado");
                limpiar();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error al Modificar");
            }
        }
        
        if(e.getSource() == agre.jbEliminar)
        {
            mod.setId(Integer.parseInt(agre.txtId.getText()));
            
            
            if(modC.eliminar(mod))
            {
                JOptionPane.showMessageDialog(null,"Producto Eliminado");
                limpiar();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error al Eliminar");
            }
        }
    }
    
    public void limpiar()
    {
        agre.txtId.setText(null);
        agre.cboxProducto.setSelectedItem(null);
        agre.cboxTipo.setSelectedItem(null);
        agre.txtNombre.setText(null);
        agre.txtPrecio.setText(null);
        agre.txtCantidad.setText(null);
        agre.txtCompra.setText(null);
    }
}
