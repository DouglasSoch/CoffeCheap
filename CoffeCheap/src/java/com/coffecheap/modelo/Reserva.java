package com.coffecheap.modelo;


import java.sql.Time;
import java.util.Date;

import java.util.Objects;

public class Reserva 
{
    int id_reserva =0 ; 
    Date fecha = null;
    Time hora_inicio = null ;
    Time hora_final= null;
    int cantidad_personas = 0;
    String hora_entrada = null;
    String hora_salida = null;
    String fechaSus = null;
    Cliente cliente = new Cliente();
    Mesa mesa = new Mesa();

    public Reserva() {
    }

    public Reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Reserva(Date fecha) {
        this.fecha = fecha;
    }

    public Reserva(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Reserva(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public Reserva(Cliente cliente) {
        this.cliente = cliente;
    }

    public Reserva(Mesa mesa) {
        this.mesa = mesa;
    }

    public Reserva(int id_reserva, Date fecha, Time hora_inicio, Time hora_final, int cantidad_personas, String hora_entrada, String hora_salida, String fechaSus, Cliente cliente, Mesa mesa) {
        this.id_reserva = id_reserva;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
        this.cantidad_personas = cantidad_personas;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.fechaSus = fechaSus;
        this.cliente = cliente;
        this.mesa = mesa;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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

    public int getCantidad_personas() {
        return cantidad_personas;
    }

    public void setCantidad_personas(int cantidad_personas) {
        this.cantidad_personas = cantidad_personas;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getFechaSus() {
        return fechaSus;
    }

    public void setFechaSus(String fechaSus) {
        this.fechaSus = fechaSus;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id_reserva;
        hash = 37 * hash + Objects.hashCode(this.fecha);
        hash = 37 * hash + Objects.hashCode(this.hora_inicio);
        hash = 37 * hash + Objects.hashCode(this.hora_final);
        hash = 37 * hash + this.cantidad_personas;
        hash = 37 * hash + Objects.hashCode(this.hora_entrada);
        hash = 37 * hash + Objects.hashCode(this.hora_salida);
        hash = 37 * hash + Objects.hashCode(this.fechaSus);
        hash = 37 * hash + Objects.hashCode(this.cliente);
        hash = 37 * hash + Objects.hashCode(this.mesa);
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
        if (this.cantidad_personas != other.cantidad_personas) {
            return false;
        }
        if (!Objects.equals(this.hora_entrada, other.hora_entrada)) {
            return false;
        }
        if (!Objects.equals(this.hora_salida, other.hora_salida)) {
            return false;
        }
        if (!Objects.equals(this.fechaSus, other.fechaSus)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.hora_inicio, other.hora_inicio)) {
            return false;
        }
        if (!Objects.equals(this.hora_final, other.hora_final)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return Objects.equals(this.mesa, other.mesa);
    }

    @Override
    public String toString() {
        return "Reserva{" + "id_reserva=" + id_reserva + ", fecha=" + fecha + ", hora_inicio=" + hora_inicio + ", hora_final=" + hora_final + ", cantidad_personas=" + cantidad_personas + ", hora_entrada=" + hora_entrada + ", hora_salida=" + hora_salida + ", fechaSus=" + fechaSus + ", cliente=" + cliente + ", mesa=" + mesa + '}';
    }

    
    
}
