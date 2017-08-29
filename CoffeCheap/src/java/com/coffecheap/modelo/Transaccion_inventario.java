package com.coffecheap.modelo;

import java.util.Date;

public class Transaccion_inventario 
{
    int id_transaccion = 0;
    Date fecha = null;
    Producto producto = new Producto();
    Tipo_transacciones Ttransaccion = new Tipo_transacciones();

    public Transaccion_inventario() {
    }

    public Transaccion_inventario(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Transaccion_inventario(Date fecha) {
        this.fecha = fecha;
    }

    public Transaccion_inventario(Producto producto) {
        this.producto = producto;
    }

    public Transaccion_inventario(Tipo_transacciones Ttransaccion) {
        this.Ttransaccion = Ttransaccion;
    }

    public Transaccion_inventario(int id_transaccion, Date fecha, Producto producto, Tipo_transacciones Ttransaccion) {
        this.id_transaccion = id_transaccion;
        this.fecha = fecha;
        this.producto = producto;
        this.Ttransaccion = Ttransaccion;
    }
    
    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Tipo_transacciones getTtransaccion() {
        return Ttransaccion;
    }

    public void setTtransaccion(Tipo_transacciones Ttransaccion) {
        this.Ttransaccion = Ttransaccion;
    }

    @Override
    public String toString() {
        return "Transaccion_inventario{" + "id_transaccion=" + id_transaccion + ", fecha=" + fecha + ", producto=" + producto + ", Ttransaccion=" + Ttransaccion + '}';
    }
}
