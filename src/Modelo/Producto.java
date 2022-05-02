/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ACER
 */
public class Producto {
      private String producto;
        private String tipo;
        private String nombre;
        private int precio;
        private int cantidad;
        private String fecha_compra;
        private String fecha_caducidad;

        public Producto(String producto, String tipo, String nombre, int precio, int cantidad, String fecha_compra, String fecha_caducidad) {
            this.producto = producto;
            this.tipo = tipo;
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
            this.fecha_compra = fecha_compra;
            this.fecha_caducidad = fecha_caducidad;
        }

        public String getProducto() {
            return producto;
        }

        public void setProducto(String producto) {
            this.producto = producto;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getPrecio() {
            return precio;
        }

        public void setPrecio(int precio) {
            this.precio = precio;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public String getFechaCompra() {
            return fecha_compra;
        }

        public void setFechaCompra(String fecha_compra) {
            this.fecha_compra = fecha_compra;
        }

        public String getFechaCaducidad() {
            return fecha_caducidad;
        }

        public void setCaducidad(String caducidad) {
            this.fecha_caducidad = caducidad;
        }

        @Override
        public String toString() {
            return "Producto{" + "producto=" + producto + ", tipo=" + tipo + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad + ", fecha_compra=" + fecha_compra + ", fecha_caducidad=" + fecha_caducidad + '}';
        }
    
}
