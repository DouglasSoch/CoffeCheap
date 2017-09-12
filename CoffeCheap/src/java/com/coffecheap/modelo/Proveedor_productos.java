package com.coffecheap.modelo;

import java.util.Objects;

public class Proveedor_productos 
{
    Proveedor proveedor= new Proveedor();
    Producto producto= new Producto();
    int precio = 0;

    public Proveedor_productos() {
    }

    public Proveedor_productos(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Proveedor_productos(Producto producto) {
        this.producto = producto;
    }

    public Proveedor_productos(int precio) {
        this.precio = precio;
    }

    public Proveedor_productos(Proveedor proveedor, Producto producto, int precio) {
        this.proveedor = proveedor;
        this.producto = producto;
        this.precio = precio;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.proveedor);
        hash = 53 * hash + Objects.hashCode(this.producto);
        hash = 53 * hash + this.precio;
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
        if (this.precio != other.precio) {
            return false;
        }
        if (!Objects.equals(this.proveedor, other.proveedor)) {
            return false;
        }
        return Objects.equals(this.producto, other.producto);
    }

    @Override
    public String toString() {
        return "Proveedor_productos{" + "proveedor=" + proveedor + ", producto=" + producto + ", precio=" + precio + '}';
    }
}
