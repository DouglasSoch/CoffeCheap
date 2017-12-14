package com.coffecheap.modelo;

import java.util.Objects;

/**
 * Constructor de tipo de producto
 *
 * @author bryan
 */
public class Tipo_producto {

    int id_tipo = 0;
    String nombre = null;

    /**
     * Cosntructor vacio
     */
    public Tipo_producto() {
    }

    /**
     * Constructor para int
     *
     * @param id_tipo atributo
     */
    public Tipo_producto(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    /**
     * Constructor para string
     *
     * @param nombre atributo
     */
    public Tipo_producto(String nombre) {
        this.nombre = nombre;
    }

    /**
     * constructor con todos los atributos
     *
     * @param id_tipo atributo
     * @param nombre atributo
     */
    public Tipo_producto(int id_tipo, String nombre) {
        this.id_tipo = id_tipo;
        this.nombre = nombre;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.id_tipo;
        hash = 31 * hash + Objects.hashCode(this.nombre);
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
        final Tipo_producto other = (Tipo_producto) obj;
        if (this.id_tipo != other.id_tipo) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Tipo_producto{" + "id_tipo=" + id_tipo + ", nombre=" + nombre + '}';
    }
}
