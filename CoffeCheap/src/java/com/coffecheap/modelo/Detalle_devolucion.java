package com.coffecheap.modelo;

import java.util.Objects;

/**
 *
 * @author Lezanaman
 */
public class Detalle_devolucion 
{
   int id=0;
   Compra compra = new Compra();

    public Detalle_devolucion() {
    }

    public Detalle_devolucion(int id, Compra compra) {
        this.id = id;
        this.compra = compra;
    }

    public Detalle_devolucion(Compra compra) {
        this.compra = compra;
    }

    public Detalle_devolucion(int id) {
        this.id = id;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.compra);
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
        final Detalle_devolucion other = (Detalle_devolucion) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.compra, other.compra);
    }

    @Override
    public String toString() {
        return "Detalle_devolucion{" + "id=" + id + ", compra=" + compra + '}';
    }
   
   
}
