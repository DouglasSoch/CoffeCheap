package com.coffecheap.modelo;

import java.util.Objects;

public class Compras 
{
    int id_compras = 0;
    Orden_compras Ocompras = new Orden_compras();
    Proveedor proveedor = new Proveedor();
    Producto producto = new Producto();

    public Compras() {
    }

    public Compras(int id_compras) {
        this.id_compras = id_compras;
    }

    public Compras(Orden_compras Ocompras) {
        this.Ocompras = Ocompras;
    }

    public Compras(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Compras(Producto producto) {
        this.producto = producto;
    }

    public Compras(int id_compras, Orden_compras Ocompras, Proveedor proveedor, Producto producto) {
        this.id_compras = id_compras;
        this.Ocompras = Ocompras;
        this.proveedor = proveedor;
        this.producto = producto;
    }
    
    public int getId_compras() {
        return id_compras;
    }

    public void setId_compras(int id_compras) {
        this.id_compras = id_compras;
    }

    public Orden_compras getOcompras() {
        return Ocompras;
    }

    public void setOcompras(Orden_compras Ocompras) {
        this.Ocompras = Ocompras;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id_compras;
        hash = 31 * hash + Objects.hashCode(this.Ocompras);
        hash = 31 * hash + Objects.hashCode(this.proveedor);
        hash = 31 * hash + Objects.hashCode(this.producto);
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
        final Compras other = (Compras) obj;
        if (this.id_compras != other.id_compras) {
            return false;
        }
        if (!Objects.equals(this.Ocompras, other.Ocompras)) {
            return false;
        }
        if (!Objects.equals(this.proveedor, other.proveedor)) {
            return false;
        }
        return Objects.equals(this.producto, other.producto);
    }

    @Override
    public String toString() {
        return "Compras{" + "id_compras=" + id_compras + ", Ocompras=" + Ocompras + ", proveedor=" + proveedor + ", producto=" + producto + '}';
    }
}
