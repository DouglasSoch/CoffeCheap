package com.coffecheap.modelo;

import java.util.Objects;

public class Mesa 
{
    int id_mesa = 0;
    int cantidad_comensales = 0;
    String ubicacion = null;
    Estado_mesa eMesa = new Estado_mesa();
    Reserva reserva = new Reserva();
    Cliente cliente = new Cliente();

    public Mesa() {
    }

    public Mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public Mesa(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Mesa(Estado_mesa eMesa) {
        this.eMesa = eMesa;
    }

    public Mesa(Reserva reserva) {
        this.reserva = reserva;
    }

    public Mesa(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa(int id_mesa, int cantidad_comensales, String ubicacion, Estado_mesa eMesa, Reserva reserva, Cliente cliente) {
        this.id_mesa = id_mesa;
        this.cantidad_comensales = cantidad_comensales;
        this.ubicacion = ubicacion;
        this.eMesa = eMesa;
        this.reserva = reserva;
        this.cliente = cliente;
    }
    
    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public int getCantidad_comensales() {
        return cantidad_comensales;
    }

    public void setCantidad_comensales(int cantidad_comensales) {
        this.cantidad_comensales = cantidad_comensales;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Estado_mesa geteMesa() {
        return eMesa;
    }

    public void seteMesa(Estado_mesa eMesa) {
        this.eMesa = eMesa;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id_mesa;
        hash = 83 * hash + this.cantidad_comensales;
        hash = 83 * hash + Objects.hashCode(this.ubicacion);
        hash = 83 * hash + Objects.hashCode(this.eMesa);
        hash = 83 * hash + Objects.hashCode(this.reserva);
        hash = 83 * hash + Objects.hashCode(this.cliente);
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
        final Mesa other = (Mesa) obj;
        if (this.id_mesa != other.id_mesa) {
            return false;
        }
        if (this.cantidad_comensales != other.cantidad_comensales) {
            return false;
        }
        if (!Objects.equals(this.ubicacion, other.ubicacion)) {
            return false;
        }
        if (!Objects.equals(this.eMesa, other.eMesa)) {
            return false;
        }
        if (!Objects.equals(this.reserva, other.reserva)) {
            return false;
        }
        return Objects.equals(this.cliente, other.cliente);
    }

    @Override
    public String toString() {
        return "Mesa{" + "id_mesa=" + id_mesa + ", cantidad_comensales=" + cantidad_comensales + ", ubicacion=" + ubicacion + ", eMesa=" + eMesa + ", reserva=" + reserva + ", cliente=" + cliente + '}';
    }
    
}
