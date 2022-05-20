/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.Conexion;
import Modelo.Pedidos;
import Modelo.Productos;
import Modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Administrador
 */
public class Consultas extends Conexion{
    
    public boolean agregar (Productos pro)
    {
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "INSERT INTO productos (producto,tipo,nombre,precio,cantidad,fecha_compra) VALUES (?,?,?,?,?,?)";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getProducto());
            ps.setString(2, pro.getTipo());
            ps.setString(3, pro.getNombre());
            ps.setInt(4, pro.getPrecio());
            ps.setInt(5, pro.getCantidad());
            ps.setString(6, pro.getFecha_compra());
            ps.execute();
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally {
            try
            {
                con.close();
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificar (Productos pro)
    {
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "UPDATE productos SET producto=?, tipo=?, nombre=?, precio=?, cantidad=?, fecha_compra=? WHERE id=?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getProducto());
            ps.setString(2, pro.getTipo());
            ps.setString(3, pro.getNombre());
            ps.setInt(4, pro.getPrecio());
            ps.setInt(5, pro.getCantidad());
            ps.setString(6, pro.getFecha_compra());
            ps.setInt(7, pro.getId());
            ps.execute();
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally {
            try
            {
                con.close();
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminar (Pedidos ped)
    {
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "DELETE FROM pedidos WHERE mesa=?";
        try
        {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ped.getMesa());
            ps.execute();
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally {
            try
            {
                con.close();
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
    
    public boolean enProceso(Pedidos ped)
    {
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "UPDATE pedidos SET estado = 'En Proceso' WHERE mesa=?";
        
        try
        {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ped.getMesa());
            ps.execute();
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally {
            try
            {
                con.close();
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
   
    public boolean Completado (Pedidos ped)
    {
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "UPDATE pedidos SET estado = 'Completado' WHERE mesa=?";
        
        try
        {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ped.getMesa());
            ps.execute();
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally {
            try
            {
                con.close();
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
    
    public boolean limpiarCompletados(Pedidos ped)
    {
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "UPDATE pedidos SET plato_entrada = '', plato_principal = '', bebida = '', postre = '', estado = '' WHERE estado = 'Completado'";
        
        try
        {
            ps = con.prepareStatement(sql);
            ps.execute();
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally {
            try
            {
                con.close();
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }
    
    public boolean login (Usuarios usu){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) getConexion();
        
        String sql = " SELECT contrasena, tipo_usuario FROM usu_escritorio WHERE contrasena =?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, usu.getContrasena());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                if(usu.getTipo_usuario().equals(rs.getString(2))){
                    return true;
                }else{
                    return false;
                }
                
            }
        } catch(SQLException e)
            {
                System.err.println(e);
            
        }
        return false;
    }
    
    
    /*public boolean filtrar (Productos pro)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) getConexion();
        
        String sql = "SELECT * FROM productos WHERE producto=?, tipo=?";
        try
       {
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getProducto());
            ps.setString(2, pro.getTipo());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setProducto(rs.getString("producto"));
                pro.setTipo(rs.getString("tipo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(Integer.parseInt(rs.getString("precio")));
               pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                pro.setFecha_compra(rs.getString("fecha_compra"));
                return true;
            }
            
            return false;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally {
            try
            {
                con.close();
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }
        }
    }*/
}
