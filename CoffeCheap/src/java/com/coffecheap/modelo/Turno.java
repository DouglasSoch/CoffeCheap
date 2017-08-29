
package com.coffecheap.modelo;

import java.util.Objects;

public class Turno 
{
    int id_turno = 0;
    String horario_turno = null;
    String observaciones = null;

    public Turno() {
    }

    public Turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public Turno(String horario_turno) {
        this.horario_turno = horario_turno;
    }

    public Turno(int id_turno, String horario_turno, String observaciones) {
        this.id_turno = id_turno;
        this.horario_turno = horario_turno;
        this.observaciones = observaciones;
    }
    
    public int getId_turno() {
        return id_turno;
    }

    public void setId_turno(int id_turno) {
        this.id_turno = id_turno;
    }

    public String getHorario_turno() {
        return horario_turno;
    }

    public void setHorario_turno(String horario_turno) {
        this.horario_turno = horario_turno;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id_turno;
        hash = 47 * hash + Objects.hashCode(this.horario_turno);
        hash = 47 * hash + Objects.hashCode(this.observaciones);
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
        final Turno other = (Turno) obj;
        if (this.id_turno != other.id_turno) {
            return false;
        }
        if (!Objects.equals(this.horario_turno, other.horario_turno)) {
            return false;
        }
        return Objects.equals(this.observaciones, other.observaciones);
    }

    @Override
    public String toString() {
        return "Turno{" + "id_turno=" + id_turno + ", horario_turno=" + horario_turno + ", observaciones=" + observaciones + '}';
    }
    
}
