package com.coffecheap.modelo;

import java.util.Objects;

public class Plato_pedido 
{
    int id_plato_pedido = 0;
    Plato plato = new Plato();
    int cantidad = 0;
    Personal_chef Pchef = new Personal_chef();

    public Plato_pedido() {
    }

    public Plato_pedido(int id_plato_pedido) {
        this.id_plato_pedido = id_plato_pedido;
    }

    public Plato_pedido(Plato plato) {
        this.plato = plato;
    }

    public Plato_pedido(Personal_chef Pchef) {
        this.Pchef = Pchef;
    }

    public Plato_pedido(int id_plato_pedido, Plato plato, int cantidad, Personal_chef Pchef) {
        this.id_plato_pedido = id_plato_pedido;
        this.plato = plato;
        this.cantidad = cantidad;
        this.Pchef = Pchef;
    }
    
    

    public int getId_plato_pedido() {
        return id_plato_pedido;
    }

    public void setId_plato_pedido(int id_plato_pedido) {
        this.id_plato_pedido = id_plato_pedido;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Personal_chef getPchef() {
        return Pchef;
    }

    public void setPchef(Personal_chef Pchef) {
        this.Pchef = Pchef;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_plato_pedido;
        hash = 29 * hash + Objects.hashCode(this.plato);
        hash = 29 * hash + this.cantidad;
        hash = 29 * hash + Objects.hashCode(this.Pchef);
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
        final Plato_pedido other = (Plato_pedido) obj;
        if (this.id_plato_pedido != other.id_plato_pedido) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (!Objects.equals(this.plato, other.plato)) {
            return false;
        }
        return Objects.equals(this.Pchef, other.Pchef);
    }

    @Override
    public String toString() {
        return "Plato_pedido{" + "id_plato_pedido=" + id_plato_pedido + ", plato=" + plato + ", cantidad=" + cantidad + ", Pchef=" + Pchef + '}';
    }
}
