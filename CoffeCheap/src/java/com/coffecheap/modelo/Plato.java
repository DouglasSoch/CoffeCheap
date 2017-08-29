package com.coffecheap.modelo;

import java.util.Objects;

public class Plato 
{
    int id_plato = 0;
    String nombre = null;
    Double precio = 0.0;
    int porciones  = 0;
    String descripcion = null;

    public Plato() {
    }
    
    public Plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public Plato(String nombre) {
        this.nombre = nombre;
    }

    public Plato(Double precio) {
        this.precio = precio;
    }

    public Plato(int id_plato, String nombre, Double precio, int porciones, String descripcion) {
        this.id_plato = id_plato;
        this.nombre = nombre;
        this.precio = precio;
        this.porciones = porciones;
        this.descripcion = descripcion;
    }
    
    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getPorciones() {
        return porciones;
    }

    public void setPorciones(int porciones) {
        this.porciones = porciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id_plato;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.precio);
        hash = 53 * hash + this.porciones;
        hash = 53 * hash + Objects.hashCode(this.descripcion);
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
        final Plato other = (Plato) obj;
        if (this.id_plato != other.id_plato) {
            return false;
        }
        if (this.porciones != other.porciones) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return Objects.equals(this.precio, other.precio);
    }

    @Override
    public String toString() {
        return "Plato{" + "id_plato=" + id_plato + ", nombre=" + nombre + ", precio=" + precio + ", porciones=" + porciones + ", descripcion=" + descripcion + '}';
    }
}
