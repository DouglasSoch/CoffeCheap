package com.coffecheap.modelo;

import java.util.Objects;

/**
 * Clase cliente
 *
 * @author bryan
 */
public class Cliente {

    int id_cliente = 0;
    String nombre = null;
    String direccion = null;
    String nit_cliente = null;

    /**
     * constructor para int
     *
     * @param id_cliente atributo
     */
    public Cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * constructor para String
     *
     * @param nombre atributo
     */
    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor con todos los atributos
     *
     * @param id_cliente atributo
     * @param nombre atributo
     * @param direccion atributo
     * @param nit_cliente atributo
     */
    public Cliente(int id_cliente, String nombre, String direccion, String nit_cliente) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit_cliente = nit_cliente;
    }

    public Cliente() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit_cliente() {
        return nit_cliente;
    }

    public void setNit_cliente(String nit_cliente) {
        this.nit_cliente = nit_cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id_cliente;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.direccion);
        hash = 59 * hash + Objects.hashCode(this.nit_cliente);
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
        final Cliente other = (Cliente) obj;
        if (this.id_cliente != other.id_cliente) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        return Objects.equals(this.nit_cliente, other.nit_cliente);
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", nombre=" + nombre + ", direccion=" + direccion + ", nit_cliente=" + nit_cliente + '}';
    }
}
