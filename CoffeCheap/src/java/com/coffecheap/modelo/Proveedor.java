package com.coffecheap.modelo;

import java.util.Objects;

public class Proveedor 
{
    int id_provedor = 0; 
    String nombre = null;
    int telefono = 0;
    String mail = null;
    String direccion = null;

    public Proveedor() {
    }

    public Proveedor(int id_provedor) {
        this.id_provedor = id_provedor;
    }

    public Proveedor(String nombre) {
        this.nombre = nombre;
    }

    public Proveedor(int id_provedor, String nombre, int telefono, String mail, String direccion) {
        this.id_provedor = id_provedor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.mail = mail;
        this.direccion = direccion;
    }
    
    public int getId_provedor() {
        return id_provedor;
    }

    public void setId_provedor(int id_provedor) {
        this.id_provedor = id_provedor;
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
        hash = 71 * hash + this.id_provedor;
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
        if (this.id_provedor != other.id_provedor) {
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
        return "Proveedor{" + "id_provedor=" + id_provedor + ", nombre=" + nombre + ", telefono=" + telefono + ", mail=" + mail + ", direccion=" + direccion + '}';
    }
}
