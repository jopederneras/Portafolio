/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QRFoodInventory;
import Controlador.CtrlProducto;
import Modelo.Consultas;
import Modelo.Productos;
import Vistas.CRUDProductos;
import Vistas.Inventario;

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
        
        CtrlProducto ctrl = new CtrlProducto(mod, modC , agre);
        ctrl.iniciar();
        agre.setVisible(true);
        
        
    }
    
}
