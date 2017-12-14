package com.coffecheap.modelo;

import java.util.Objects;

/**
 * Clase plato
 *
 * @author bryan
 */
public class Plato {

    int id_plato = 0;
    String nombre = null;
    Double precio = 0.0;
    int porciones = 0;
    String descripcion = null;
    Tipo_plato tipoPlato = new Tipo_plato();

    /**
     * constructor plato
     */
    public Plato() {
    }

    /**
     * constructor para nit
     *
     * @param id_plato atributo
     */
    public Plato(int id_plato) {
        this.id_plato = id_plato;
    }

    /**
     * constructor para String
     *
     * @param nombre atributo
     */
    public Plato(String nombre) {
        this.nombre = nombre;
    }

    /**
     * constructor para double
     *
     * @param precio atributo
     */
    public Plato(Double precio) {
        this.precio = precio;
    }

    /**
     * constructor para objeto tipo plato
     *
     * @param tipoPlato atributo
     */
    public Plato(Tipo_plato tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    /**
     * constructor con todos los atributos
     *
     * @param id_plato atributo
     * @param nombre atributo
     * @param precio atributo
     * @param porciones atributo
     * @param descripcion atributo
     * @param tipoPlato atributo
     */
    public Plato(int id_plato, String nombre, Double precio, int porciones, String descripcion, Tipo_plato tipoPlato) {
        this.id_plato = id_plato;
        this.nombre = nombre;
        this.precio = precio;
        this.porciones = porciones;
        this.descripcion = descripcion;
        this.tipoPlato = tipoPlato;
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

    public Tipo_plato getTipoPlato() {
        return tipoPlato;
    }

    public void setTipoPlato(Tipo_plato tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id_plato;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.precio);
        hash = 67 * hash + this.porciones;
        hash = 67 * hash + Objects.hashCode(this.descripcion);
        hash = 67 * hash + Objects.hashCode(this.tipoPlato);
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
        if (!Objects.equals(this.precio, other.precio)) {
            return false;
        }
        return Objects.equals(this.tipoPlato, other.tipoPlato);
    }

    @Override
    public String toString() {
        return "Plato{" + "id_plato=" + id_plato + ", nombre=" + nombre + ", precio=" + precio + ", porciones=" + porciones + ", descripcion=" + descripcion + ", tipoPlato=" + tipoPlato + '}';
    }

}
