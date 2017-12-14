/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.modelo;

import java.util.Objects;

/**
 * Clase html
 *
 * @author bryan
 */
public class Html {

    int id = 0;
    String nombre = null;

    /**
     * constructor vacio
     */
    public Html() {
    }

    /**
     * constructor para int
     *
     * @param id atributo
     */
    public Html(int id) {
        this.id = id;
    }

    /**
     * Constructor para Sring
     *
     * @param nombre atributo
     */
    public Html(String nombre) {
        this.nombre = nombre;
    }

    /**
     * constructor con todos los parametros
     *
     * @param id atributo
     * @param nombre atributo
     */
    public Html(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.nombre);
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
        final Html other = (Html) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Html{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
