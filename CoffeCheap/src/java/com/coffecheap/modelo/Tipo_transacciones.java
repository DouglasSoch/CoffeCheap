package com.coffecheap.modelo;

import java.util.Objects;

public class Tipo_transacciones 
{
    int id_tipo_transacciones = 0;
    String nombre = null;

    public Tipo_transacciones() {
    }

    public Tipo_transacciones(int id_tipo_transacciones) {
        this.id_tipo_transacciones = id_tipo_transacciones;
    }

    public Tipo_transacciones(String nombre) {
        this.nombre = nombre;
    }

    public Tipo_transacciones(int id_tipo_transacciones, String nombre) {
        this.id_tipo_transacciones = id_tipo_transacciones;
        this.nombre = nombre;
    }

    public int getId_tipo_transacciones() {
        return id_tipo_transacciones;
    }

    public void setId_tipo_transacciones(int id_tipo_transacciones) {
        this.id_tipo_transacciones = id_tipo_transacciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id_tipo_transacciones;
        hash = 47 * hash + Objects.hashCode(this.nombre);
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
        final Tipo_transacciones other = (Tipo_transacciones) obj;
        if (this.id_tipo_transacciones != other.id_tipo_transacciones) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Tipo_transacciones{" + "id_tipo_transacciones=" + id_tipo_transacciones + ", nombre=" + nombre + '}';
    }
}
