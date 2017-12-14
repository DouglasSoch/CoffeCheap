package com.coffecheap.modelo;

/**
 * Clase fac
 *
 * @author Lezanaman
 */
public class Fac {

    String fecha_emision;
    String nombre_cliente;
    int nit_cliente;
    String direccion;
    String nombre_platillo;
    int cantidad;
    int precio;
    int tot;
    int subtotal;
    int iva;
    int propina;
    int total;
    int id_mesa;
    int cantidad_comensales;
    String nombre;

    public String getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(String fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public int getNit_cliente() {
        return nit_cliente;
    }

    public void setNit_cliente(int nit_cliente) {
        this.nit_cliente = nit_cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre_platillo() {
        return nombre_platillo;
    }

    public void setNombre_platillo(String nombre_platillo) {
        this.nombre_platillo = nombre_platillo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = tot;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getPropina() {
        return propina;
    }

    public void setPropina(int propina) {
        this.propina = propina;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public int getCantidad_comensales() {
        return cantidad_comensales;
    }

    public void setCantidad_comensales(int cantidad_comensales) {
        this.cantidad_comensales = cantidad_comensales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
