package com.coffecheap.modelo;

import java.util.Date;
import java.util.Objects;

public class Transaccion_inventario {

    int id_transaccion = 0;
    Date fecha = null;
    Producto producto = new Producto();
    Tipo_transacciones Ttransaccion = new Tipo_transacciones();
    String fechaUno = null;
    String fechaDos = null;
    int cantidad = 0;
    Detalle_devolucion detalle = new Detalle_devolucion();

    public Transaccion_inventario() {
    }

    public Transaccion_inventario(int id_transaccion, Date fecha, Producto producto, Tipo_transacciones Ttransaccion, String fechaUno, String fechaDos, int cantidad, Detalle_devolucion detalle) {
        this.id_transaccion = id_transaccion;
        this.fecha = fecha;
        this.producto = producto;
        this.Ttransaccion = Ttransaccion;
        this.fechaUno = fechaUno;
        this.fechaDos = fechaDos;
        this.cantidad = cantidad;
        this.detalle = detalle;
    }

    public Transaccion_inventario(Detalle_devolucion detalle) {
        this.detalle = detalle;
    }

    public Transaccion_inventario(String fechaUno) {
        this.fechaUno = fechaUno;
    }

    public Transaccion_inventario(Tipo_transacciones Ttransaccion) {
        this.Ttransaccion = Ttransaccion;
    }

    public Transaccion_inventario(Producto producto) {
        this.producto = producto;
    }

    public Transaccion_inventario(Date fecha) {
        this.fecha = fecha;
    }

    public Transaccion_inventario(int id_transaccion) {
        this.id_transaccion = id_transaccion;
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

    public String getFechaUno() {
        return fechaUno;
    }

    public void setFechaUno(String fechaUno) {
        this.fechaUno = fechaUno;
    }

    public String getFechaDos() {
        return fechaDos;
    }

    public void setFechaDos(String fechaDos) {
        this.fechaDos = fechaDos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Detalle_devolucion getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle_devolucion detalle) {
        this.detalle = detalle;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id_transaccion;
        hash = 83 * hash + Objects.hashCode(this.fecha);
        hash = 83 * hash + Objects.hashCode(this.producto);
        hash = 83 * hash + Objects.hashCode(this.Ttransaccion);
        hash = 83 * hash + Objects.hashCode(this.fechaUno);
        hash = 83 * hash + Objects.hashCode(this.fechaDos);
        hash = 83 * hash + this.cantidad;
        hash = 83 * hash + Objects.hashCode(this.detalle);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transaccion_inventario other = (Transaccion_inventario) obj;
        if (this.id_transaccion != other.id_transaccion) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (!Objects.equals(this.fechaUno, other.fechaUno)) {
            return false;
        }
        if (!Objects.equals(this.fechaDos, other.fechaDos)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        if (!Objects.equals(this.Ttransaccion, other.Ttransaccion)) {
            return false;
        }
        return Objects.equals(this.detalle, other.detalle);
    }

    @Override
    public String toString() {
        return "Transaccion_inventario{" + "id_transaccion=" + id_transaccion + ", fecha=" + fecha + ", producto=" + producto + ", Ttransaccion=" + Ttransaccion + ", fechaUno=" + fechaUno + ", fechaDos=" + fechaDos + ", cantidad=" + cantidad + ", detalle=" + detalle + '}';
    }

}
