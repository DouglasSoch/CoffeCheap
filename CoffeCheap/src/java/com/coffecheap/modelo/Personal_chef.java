
package com.coffecheap.modelo;

import java.util.Objects;

public class Personal_chef 
{
    int id_personal = 0;
    String nombre = null;
    int telefono = 0;
    Turno turno = new Turno();

    public Personal_chef() {
    }

    public Personal_chef(int id_personal) {
        this.id_personal = id_personal;
    }

    public Personal_chef(String nombre) {
        this.nombre = nombre;
    }

    public Personal_chef(Turno turno) {
        this.turno = turno;
    }

    public Personal_chef(int id_personal, String nombre, int telefono, Turno turno) {
        this.id_personal = id_personal;
        this.nombre = nombre;
        this.telefono = telefono;
        this.turno = turno;
    }
    
    public int getId_personal() {
        return id_personal;
    }

    public void setId_personal(int id_personal) {
        this.id_personal = id_personal;
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

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id_personal;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + this.telefono;
        hash = 67 * hash + Objects.hashCode(this.turno);
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
        final Personal_chef other = (Personal_chef) obj;
        if (this.id_personal != other.id_personal) {
            return false;
        }
        if (this.telefono != other.telefono) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.turno, other.turno)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Personal_chef{" + "id_personal=" + id_personal + ", nombre=" + nombre + ", telefono=" + telefono + ", turno=" + turno + '}';
    }
    
}
