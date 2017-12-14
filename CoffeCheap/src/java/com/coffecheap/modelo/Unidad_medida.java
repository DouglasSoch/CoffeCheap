package com.coffecheap.modelo;

import java.util.Objects;

/**
 * Clase unidad medida
 *
 * @author bryan
 */
public class Unidad_medida {

    int id_unidad = 0;
    String nombre = null;

    /**
     * constructor vacio
     */
    public Unidad_medida() {
    }

    /**
     * Constructor para int
     *
     * @param id_unidad atributo
     */
    public Unidad_medida(int id_unidad) {
        this.id_unidad = id_unidad;
    }

    /**
     * Constructor para String
     *
     * @param nombre atributo
     */
    public Unidad_medida(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor con todos los atributos
     *
     * @param id_unidad atributo
     * @param nombre atributo
     */
    public Unidad_medida(int id_unidad, String nombre) {
        this.id_unidad = id_unidad;
        this.nombre = nombre;
    }

    public int getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(int id_unidad) {
        this.id_unidad = id_unidad;
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
        hash = 89 * hash + this.id_unidad;
        hash = 89 * hash + Objects.hashCode(this.nombre);
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
        final Unidad_medida other = (Unidad_medida) obj;
        if (this.id_unidad != other.id_unidad) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Unidad_medida{" + "id_unidad=" + id_unidad + ", nombre=" + nombre + '}';
    }
}
