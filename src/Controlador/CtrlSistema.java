/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionListener;
import Modelo.Productos;
import Modelo.Pedidos;
import Modelo.Usuarios;
import Vistas.CRUDProductos;
import Vistas.Inventario;
import Vistas.MantenedorPedidos;
import Vistas.Sesion_CRUD;
import Vistas.Sesion_Pedidos;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class CtrlSistema implements ActionListener {
    
    private Productos mod;
    private Consultas modC;
    private Pedidos modP;
    private CRUDProductos agre;
    private Inventario inv;
    private MantenedorPedidos ped;
    private Sesion_Pedidos sesionPed;
    private Sesion_CRUD sesionCrud;
    private Usuarios usu;
    
    public CtrlSistema (Productos mod,Consultas modC,CRUDProductos agre, Inventario inv,
            MantenedorPedidos ped,Sesion_CRUD sesionCrud, Sesion_Pedidos sesionPed, Pedidos modP, Usuarios usu)
    {
        //Para acceder a las secciones
        this.mod = mod;
        this.modC = modC;
        this.modP = modP;
        this.agre = agre;
        this.inv = inv;
        this.ped = ped;
        this.usu = usu;
        this.sesionCrud = sesionCrud;
        this.sesionPed = sesionPed;
        
        //Listeners de los botones del CRUD de productos
        this.agre.jbAgregarProducto.addActionListener(this);
        this.agre.jbModificar.addActionListener(this);
        this.agre.jbSalir.addActionListener(this);
        
        //Listeners de los botones de MantenedorPedidos
        this.ped.jbCompletado.addActionListener(this);
        this.ped.jbEnProceso.addActionListener(this);
        this.ped.jbLimpiarCompletados.addActionListener(this);
        this.ped.jbSalir.addActionListener(this);
        
        //Listeners de los botones del menu inicial
        this.inv.jbInventario.addActionListener(this);
        this.inv.jbPedidos.addActionListener(this);
        
        //Listeners de los botones de inicios de sesion del CRUD
        this.sesionCrud.jbIngresarInv.addActionListener(this);
        this.sesionCrud.jbCancelarInv.addActionListener(this);
        
        //Listeners de los botones de inicios de sesion de pedidos
        this.sesionPed.jbIngresarPed.addActionListener(this);
        this.sesionPed.jbCancelarPed.addActionListener(this);
    }
    
    // Aqui se establece que dependiendo del boton que se pulse se realizara una accion en concreto 
    @Override
    
    public void actionPerformed(ActionEvent e)
    
    {
        //Acceso a inicios de sesion de pedidos y CRUD respectivamente, boton de salir.
        if(e.getSource() == inv.jbPedidos)
        {
            inv.setVisible(false);
            sesionPed.setVisible(true);
        }
        
        else if(e.getSource() == inv.jbInventario)
        {
            inv.setVisible(false);
            sesionCrud.setVisible(true);
        }
        
        else if(e.getSource() == inv.jbSalir)
        {
            this.inv.dispose();
        }
        
        //Inicio de sesion de Inventario
        if(e.getSource() == sesionCrud.jbIngresarInv)
        {
            if(!sesionCrud.jTextCodigoAccesoInv.getText().equals("") && !sesionCrud.cboxTipoUserInv.getSelectedItem().equals(""));
            {
                usu.setContrasena(Integer.parseInt(sesionCrud.jTextCodigoAccesoInv.getText()));
                usu.setTipo_usuario(sesionCrud.cboxTipoUserInv.getSelectedItem().toString());
            
                if(modC.login(usu))
                {
                    agre.setVisible(true);
                    this.sesionCrud.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Ingrese un codigo correspondiente al Usuario");
                } 
            }
        }
        //Cancelar y volver al menu inicial
        else if(e.getSource() == sesionCrud.jbCancelarInv)
        {
            inv.setVisible(true);
            this.sesionCrud.dispose();
        }
        
        //Inicio de sesion de Pedidos
        if(e.getSource() == sesionPed.jbIngresarPed)
        {
            if(!sesionPed.jTextCodigoAccesoPed.getText().equals("") && !sesionPed.cboxTipoUserPed.getSelectedItem().equals(""));
            {
                usu.setContrasena(Integer.parseInt(sesionPed.jTextCodigoAccesoPed.getText()));
                usu.setTipo_usuario(sesionPed.cboxTipoUserPed.getSelectedItem().toString());
            
                if(modC.login(usu))
                {
                    ped.setVisible(true);
                    this.sesionPed.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Ingrese un codigo correspondiente al Usuario");
                }
            }
        }
        //Cancelar y volver al menu inicial
        
        else if(e.getSource() == sesionPed.jbCancelarPed)
        {
            inv.setVisible(true);
            this.sesionPed.dispose();
        }
        
           
        //Action listeners de los botones del CRUD
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
                limpiarProductos();
                actualizarProductos();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error al Agregar");
            }
        }
        
        else if(e.getSource() == agre.jbModificar)
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
                limpiarProductos();
                actualizarProductos();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error al Modificar");
            }
        }
        
        else if(e.getSource() == agre.jbSalir)
        {
            inv.setVisible(true);
            this.agre.dispose();
        }
        
        
        //Action Listeners de los botones de pedidos
        
        if (e.getSource() == ped.jbEnProceso)
        {
            modP.setMesa(Integer.parseInt(ped.txtMesa.getText()));
            
            if(modC.enProceso(modP))
            {
                JOptionPane.showMessageDialog(null,"Estado Cambiado a En Proceso");
                actualizarPedidos();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error al Cambiar Estado a En Proceso");
            }
        }
        else if (e.getSource() == ped.jbCompletado)
        {
            modP.setMesa(Integer.parseInt(ped.txtMesa.getText()));
            
            if(modC.Completado(modP))
            {
                JOptionPane.showMessageDialog(null,"Estado Cambiado a Completado");
                actualizarPedidos();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error al Cambiar Estado a Completado");
            }
        }
        else if (e.getSource() == ped.jbLimpiarCompletados)
        {
            modP.setMesa(Integer.parseInt(ped.txtMesa.getText()));
            
            if(modC.limpiarCompletados(modP))
            {
                JOptionPane.showMessageDialog(null,"Se han limpiado los pedidos Completados");
                actualizarPedidos();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error al limpiar los pedidos Completados");
            }
        }
        else if (e.getSource() == ped.jbSalir)
        {
            inv.setVisible(true);
            this.ped.dispose();
        }
        
        
        
    }
    
    public void limpiarProductos()
    {
        agre.txtId.setText(null);
        agre.cboxProducto.setSelectedItem("Seleccionar");
        agre.cboxTipo.setSelectedItem(null);
        agre.txtNombre.setText(null);
        agre.txtPrecio.setText(null);
        agre.txtCantidad.setText(null);
        agre.txtCompra.setText(null);
    }
    public void actualizarProductos()
    {
      try{
            DefaultTableModel modelo = new DefaultTableModel();
            PreparedStatement ps = null;
            ResultSet rs = null;
            agre.TablaDeDatos.setModel(modelo);
            
            Connection cn;
            Conexion con=new Conexion();
            cn = con.getConexion();
        
            String sql = "SELECT id, producto, tipo, nombre, precio, cantidad, fecha_compra FROM productos";  
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("Id");
            modelo.addColumn("Producto");
            modelo.addColumn("Tipo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Precio");
            modelo.addColumn("Cantidad");
            modelo.addColumn("Fecha de Compra");
            
            
            while(rs.next()){
                
                Object[] filas = new Object[cantidadColumnas];
                
                for(int i = 0; i< cantidadColumnas; i++ )
                {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            
            
            }
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
            
        }  
        
                
    }
    
    public void actualizarPedidos()
    {
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            PreparedStatement ps = null;
            ResultSet rs = null;
            ped.TablaDePedidos.setModel(modelo);
            
            Connection cn;
            Conexion con=new Conexion();
            cn = con.getConexion();
        
            String sql = "SELECT mesa, plato_entrada, plato_principal, bebida, postre, estado FROM pedidos";  
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("Mesa");
            modelo.addColumn("Platillos de entrada");
            modelo.addColumn("Platillos Principales");
            modelo.addColumn("Bebidas");
            modelo.addColumn("Postres");
            modelo.addColumn("Estado del pedido");
            
            
            
            while(rs.next()){
                
                Object[] filas = new Object[cantidadColumnas];
                
                for(int i = 0; i< cantidadColumnas; i++ )
                {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            
            
            }
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
            
        }
    }
}
