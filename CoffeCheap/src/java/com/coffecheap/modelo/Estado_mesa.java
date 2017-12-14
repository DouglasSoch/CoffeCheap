package com.coffecheap.modelo;

import java.util.Objects;

/**
 * Clase estado mesa
 *
 * @author bryan
 */
public class Estado_mesa {

    int id_estado = 0;
    String nombre = null;

    /**
     * constructor vacio
     */
    public Estado_mesa() {
    }

    /**
     * constructor para int
     *
     * @param id_estado atributo
     */
    public Estado_mesa(int id_estado) {
        this.id_estado = id_estado;
    }

    /**
     * Constructor para String
     *
     * @param nombre atributo
     */
    public Estado_mesa(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor con todos los atributos
     *
     * @param id_estado atributo
     * @param nombre atributoF
     */
    public Estado_mesa(int id_estado, String nombre) {
        this.id_estado = id_estado;
        this.nombre = nombre;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id_estado;
        hash = 29 * hash + Objects.hashCode(this.nombre);
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
        final Estado_mesa other = (Estado_mesa) obj;
        if (this.id_estado != other.id_estado) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Estado_mesa{" + "id_estado=" + id_estado + ", nombre=" + nombre + '}';
    }

}
