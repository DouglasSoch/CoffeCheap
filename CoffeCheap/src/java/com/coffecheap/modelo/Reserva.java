package com.coffecheap.modelo;

import java.sql.Time;
import java.util.Objects;

public class Reserva 
{
    int id_reserva = 0; 
    String fecha = null;
    Time hora_inicio = null;
    Time hora_final = null;
    String cantidad_personas = null;

    public Reserva() {
    }

    public Reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Reserva(String fecha) {
        this.fecha = fecha;
    }

    public Reserva(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Reserva(int id_reserva, String fecha, Time hora_inicio, Time hora_final, String cantidad_personas) {
        this.id_reserva = id_reserva;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.cantidad_personas = cantidad_personas;
    }
    
    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Time getHora_final() {
        return hora_final;
    }

    public void setHora_final(Time hora_final) {
        this.hora_final = hora_final;
    }

    public String getCantidad_personas() {
        return cantidad_personas;
    }

    public void setCantidad_personas(String cantidad_personas) {
        this.cantidad_personas = cantidad_personas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id_reserva;
        hash = 61 * hash + Objects.hashCode(this.fecha);
        hash = 61 * hash + Objects.hashCode(this.hora_inicio);
        hash = 61 * hash + Objects.hashCode(this.hora_final);
        hash = 61 * hash + Objects.hashCode(this.cantidad_personas);
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
        final Reserva other = (Reserva) obj;
        if (this.id_reserva != other.id_reserva) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.cantidad_personas, other.cantidad_personas)) {
            return false;
        }
        if (!Objects.equals(this.hora_inicio, other.hora_inicio)) {
            return false;
        }
        return Objects.equals(this.hora_final, other.hora_final);
    }

    @Override
    public String toString() {
        return "Reserva{" + "id_reserva=" + id_reserva + ", fecha=" + fecha + ", hora_inicio=" + hora_inicio + ", hora_final=" + hora_final + ", cantidad_personas=" + cantidad_personas + '}';
    }
}
