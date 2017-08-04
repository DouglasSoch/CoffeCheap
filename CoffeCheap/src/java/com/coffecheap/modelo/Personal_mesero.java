package com.coffecheap.modelo;

import java.util.Objects;

public class Personal_mesero 
{
    int id_personal_servicio = 0;
    String nombre = null;
    String telefono = null;
    Turno turno = new Turno();

    public Personal_mesero() {
    }

    public Personal_mesero(int id_personal_servicio) {
        this.id_personal_servicio = id_personal_servicio;
    }

    public Personal_mesero(String nombre) {
        this.nombre = nombre;
    }

    public Personal_mesero(Turno turno) {
        this.turno = turno;
    }

    public Personal_mesero(int id_personal_servicio, String nombre, String telefono, Turno turno) {
        this.id_personal_servicio = id_personal_servicio;
        this.nombre = nombre;
        this.telefono = telefono;
        this.turno = turno;
    }
    
    public int getId_personal_servicio() {
        return id_personal_servicio;
    }

    public void setId_personal_servicio(int id_personal_servicio) {
        this.id_personal_servicio = id_personal_servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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
        int hash = 7;
        hash = 47 * hash + this.id_personal_servicio;
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.telefono);
        hash = 47 * hash + Objects.hashCode(this.turno);
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
        final Personal_mesero other = (Personal_mesero) obj;
        if (this.id_personal_servicio != other.id_personal_servicio) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return Objects.equals(this.turno, other.turno);
    }

    @Override
    public String toString() {
        return "Personal_mesero{" + "id_personal_servicio=" + id_personal_servicio + ", nombre=" + nombre + ", telefono=" + telefono + ", turno=" + turno + '}';
    }
  
}
