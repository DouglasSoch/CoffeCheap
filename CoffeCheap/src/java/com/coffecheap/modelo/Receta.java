package com.coffecheap.modelo;

import java.util.Objects;

public class Receta 
{
    Plato plato = new Plato();
    Producto producto = new Producto();
    int cantidad = 0;
    Unidad_medida Umedida = new Unidad_medida();

    public Receta() {
    }

    public Receta(Plato plato) {
        this.plato = plato;
    }

    public Receta(Producto producto) {
        this.producto = producto;
    }

    public Receta(int cantidad) {
        this.cantidad = cantidad;
    }

    public Receta(Unidad_medida Umedida) {
        this.Umedida = Umedida;
    }

    public Receta(Plato plato, Producto producto, int cantidad, Unidad_medida Umedida) {
        this.plato = plato;
        this.producto = producto;
        this.cantidad = cantidad;
        this.Umedida = Umedida;
    }
    
    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Unidad_medida getUmedida() {
        return Umedida;
    }

    public void setUmedida(Unidad_medida Umedida) {
        this.Umedida = Umedida;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.plato);
        hash = 83 * hash + Objects.hashCode(this.producto);
        hash = 83 * hash + this.cantidad;
        hash = 83 * hash + Objects.hashCode(this.Umedida);
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
        final Receta other = (Receta) obj;
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (!Objects.equals(this.plato, other.plato)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return Objects.equals(this.Umedida, other.Umedida);
    }

    @Override
    public String toString() {
        return "Receta{" + "plato=" + plato + ", producto=" + producto + ", cantidad=" + cantidad + ", Umedida=" + Umedida + '}';
    }
}
