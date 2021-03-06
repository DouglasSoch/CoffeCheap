package com.coffecheap.modelo;

import java.util.Date;
import java.util.Objects;

/**
 * Clase orden compras
 *
 * @author bryan
 */
public class Orden_compras {

    String temp_fecha_orden;
    String temp_fecha_entrega;
    int id_orden_compras = 0;
    Date fecha_orden = null;
    Date fecha_entrega = null;
    int cantidad = 0;
    Proveedor_productos Pproductos = new Proveedor_productos();
    Double precio = 0.0;

    public String getTemp_fecha_orden() {
        return temp_fecha_orden;
    }

    public void setTemp_fecha_orden(String temp_fecha_orden) {
        this.temp_fecha_orden = temp_fecha_orden;
    }

    public String getTemp_fecha_entrega() {
        return temp_fecha_entrega;
    }

    public void setTemp_fecha_entrega(String temp_fecha_entrega) {
        this.temp_fecha_entrega = temp_fecha_entrega;
    }

    public Orden_compras() {
    }

    public Orden_compras(int id_orden_compras) {
        this.id_orden_compras = id_orden_compras;
    }

    public Orden_compras(Date fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public Orden_compras(Proveedor_productos Pproductos) {
        this.Pproductos = Pproductos;
    }

    public Orden_compras(Double precio) {
        this.precio = precio;
    }

    /**
     * constructor con todos los atributos
     *
     * @param id_orden_compras atributo
     * @param fecha_orden atributo
     * @param fecha_entrega atributo
     * @param cantidad atributo
     * @param Pproductos atributo
     * @param precio atributo
     */
    public Orden_compras(int id_orden_compras, Date fecha_orden, Date fecha_entrega, int cantidad, Proveedor_productos Pproductos, Double precio) {
        this.id_orden_compras = id_orden_compras;
        this.fecha_orden = fecha_orden;
        this.fecha_entrega = fecha_entrega;
        this.cantidad = cantidad;
        this.Pproductos = Pproductos;
        this.precio = precio;
    }

    public int getId_orden_compras() {
        return id_orden_compras;
    }

    public void setId_orden_compras(int id_orden_compras) {
        this.id_orden_compras = id_orden_compras;
    }

    public Date getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(Date fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Proveedor_productos getPproductos() {
        return Pproductos;
    }

    public void setPproductos(Proveedor_productos Pproductos) {
        this.Pproductos = Pproductos;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id_orden_compras;
        hash = 79 * hash + Objects.hashCode(this.fecha_orden);
        hash = 79 * hash + Objects.hashCode(this.fecha_entrega);
        hash = 79 * hash + this.cantidad;
        hash = 79 * hash + Objects.hashCode(this.Pproductos);
        hash = 79 * hash + Objects.hashCode(this.precio);
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
        final Orden_compras other = (Orden_compras) obj;
        if (this.id_orden_compras != other.id_orden_compras) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (!Objects.equals(this.fecha_orden, other.fecha_orden)) {
            return false;
        }
        if (!Objects.equals(this.fecha_entrega, other.fecha_entrega)) {
            return false;
        }
        if (!Objects.equals(this.Pproductos, other.Pproductos)) {
            return false;
        }
        return Objects.equals(this.precio, other.precio);
    }

    @Override
    public String toString() {
        return "Orden_compras{" + "id_orden_compras=" + id_orden_compras + ", fecha_orden=" + fecha_orden + ", fecha_entrega=" + fecha_entrega + ", cantidad=" + cantidad + ", Pproductos=" + Pproductos + ", precio=" + precio + '}';
    }

}
