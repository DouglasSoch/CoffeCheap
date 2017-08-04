package com.coffecheap.modelo;

import java.util.Objects;

public class Proveedor_productos 
{
    int id_proveedor = 0;
    Producto producto = new Producto();
    int precio;

    public Proveedor_productos() {
    }

    public Proveedor_productos(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Proveedor_productos(Producto producto) {
        this.producto = producto;
    }

    public Proveedor_productos(int id_proveedor, Producto producto, int precio) {
        this.id_proveedor = id_proveedor;
        this.producto = producto;
        this.precio = precio;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.id_proveedor;
        hash = 11 * hash + Objects.hashCode(this.producto);
        hash = 11 * hash + this.precio;
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
        final Proveedor_productos other = (Proveedor_productos) obj;
        if (this.id_proveedor != other.id_proveedor) {
            return false;
        }
        if (this.precio != other.precio) {
            return false;
        }
        return Objects.equals(this.producto, other.producto);
    }

    @Override
    public String toString() {
        return "Proveedor_productos{" + "id_proveedor=" + id_proveedor + ", producto=" + producto + ", precio=" + precio + '}';
    }
}
