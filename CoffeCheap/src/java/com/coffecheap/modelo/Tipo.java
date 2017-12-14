/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.modelo;

import java.util.Objects;

/**
 * Clase tipo
 *
 * @author bryan
 */
public class Tipo {

    int id = 0;
    String nombre = null;
    String desc = null;

    /**
     * Constructor vacio
     */
    public Tipo() {
    }

    /**
     * constructor para int
     *
     * @param id atributo
     */
    public Tipo(int id) {
        this.id = id;
    }

    /**
     * Cosntructor para string
     *
     * @param nombre atributo
     */
    public Tipo(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor con todos los atributos
     *
     * @param id atributo
     * @param nombre atributo
     * @param desc atributo
     */
    public Tipo(int id, String nombre, String desc) {
        this.id = id;
        this.nombre = nombre;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.desc);
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
        final Tipo other = (Tipo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.desc, other.desc);
    }

    @Override
    public String toString() {
        return "Tipo{" + "id=" + id + ", nombre=" + nombre + ", desc=" + desc + '}';
    }

}
