/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Administrador
 */
public class Pedidos {
    
    private int mesa;
    private String plato_entrada;
    private String plato_principal;
    private String bebida;
    private String postre;
    private String estado;

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getPlato_entrada() {
        return plato_entrada;
    }

    public void setPlato_entrada(String plato_entrada) {
        this.plato_entrada = plato_entrada;
    }

    public String getPlato_principal() {
        return plato_principal;
    }

    public void setPlato_principal(String plato_principal) {
        this.plato_principal = plato_principal;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getPostre() {
        return postre;
    }

    public void setPostre(String postre) {
        this.postre = postre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedidos{" + "mesa=" + mesa + ", plato_entrada=" + plato_entrada + ", plato_principal=" + plato_principal + ", bebida=" + bebida + ", postre=" + postre + ", estado=" + estado + '}';
    }
    
}
