/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.modelo;

import java.util.Objects;

/**
 * Clase crud
 *
 * @author bryan
 */
public class Crud {

    int id = 0;
    String nombre = null;

    /**
     * constructor vacio
     */
    public Crud() {
    }

    /**
     * constructor para int
     *
     * @param id atributo
     */
    public Crud(int id) {
        this.id = id;
    }

    /**
     * constructor para String
     *
     * @param nombre atributo
     */
    public Crud(String nombre) {
        this.nombre = nombre;
    }

    /**
     * constructor con todos los atributos
     *
     * @param id atributo
     * @param nombre atributo
     */
    public Crud(int id, String nombre) {
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
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.nombre);
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
        final Crud other = (Crud) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Crud{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
