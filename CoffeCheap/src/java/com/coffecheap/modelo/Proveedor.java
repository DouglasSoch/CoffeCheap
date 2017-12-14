package com.coffecheap.modelo;

import java.util.Objects;

/**
 * Clase proveedor
 *
 * @author bryan
 */
public class Proveedor {

    int id_proveedor = 0;
    String nombre = null;
    String nit = null;
    int telefono = 0;
    String mail = null;
    String direccion = null;

    /**
     * constructo vacio
     */
    public Proveedor() {
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * constructor para int
     *
     * @param id_provedor atributo
     */
    public Proveedor(int id_provedor) {
        this.id_proveedor = id_provedor;
    }

    /**
     * constructor para String
     *
     * @param nombre atributo
     */
    public Proveedor(String nombre) {
        this.nombre = nombre;
    }

    /**
     * constructor con todos los atributos
     *
     * @param id_provedor atributo
     * @param nombre atributo
     * @param telefono atributo
     * @param mail atributo
     * @param direccion atributo
     */
    public Proveedor(int id_provedor, String nombre, int telefono, String mail, String direccion) {
        this.id_proveedor = id_provedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.direccion = direccion;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id_proveedor;
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + this.telefono;
        hash = 71 * hash + Objects.hashCode(this.mail);
        hash = 71 * hash + Objects.hashCode(this.direccion);
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
        final Proveedor other = (Proveedor) obj;
        if (this.id_proveedor != other.id_proveedor) {
            return false;
        }
        if (this.telefono != other.telefono) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        return Objects.equals(this.direccion, other.direccion);
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id_provedor=" + id_proveedor + ", nombre=" + nombre + ", telefono=" + telefono + ", mail=" + mail + ", direccion=" + direccion + '}';
    }
}
