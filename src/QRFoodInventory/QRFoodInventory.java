/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QRFoodInventory;
import Controlador.CtrlSistema;
import Controlador.Consultas;
import Modelo.Pedidos;
import Modelo.Productos;
import Modelo.Usuarios;
import Vistas.CRUDProductos;
import Vistas.Inventario;
import Vistas.MantenedorPedidos;
import Vistas.Sesion_CRUD;
import Vistas.Sesion_Pedidos;

/**
 *
 * @author Administrador
 */
public class QRFoodInventory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Productos mod = new Productos();
        Consultas modC = new Consultas();
        CRUDProductos agre = new CRUDProductos();
        Inventario inv = new Inventario();
        MantenedorPedidos ped = new MantenedorPedidos();
        Sesion_Pedidos sesionPed = new Sesion_Pedidos();
        Sesion_CRUD sesionCrud = new Sesion_CRUD();
        Pedidos modP = new Pedidos();
        Usuarios usu = new Usuarios();
        
        CtrlSistema ctrlPro = new CtrlSistema(mod, modC , agre, inv, ped, sesionCrud, sesionPed, modP,usu);
        inv.setVisible(true);
    }
    
}
