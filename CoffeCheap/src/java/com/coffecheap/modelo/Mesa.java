package com.coffecheap.modelo;

import java.util.Objects;

public class Mesa 
{
    int id_mesa = 0;
    int cantidad_comensales = 0 ;
    String ubicacion = null;
    Estado_mesa EstMesa = new Estado_mesa();
    Reserva reserva = new Reserva();

  public Mesa() {
  }

  public Mesa(int id_mesa) {
    this.id_mesa = id_mesa;
  }

  public Mesa(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public Mesa(Estado_mesa EstMesa) {
    this.EstMesa = EstMesa;
  }

  public Mesa(Reserva reserva) {
    this.reserva = reserva;
  }

  public Mesa(int id_mesa, int cantidad_comensales, String ubicacion, Estado_mesa EstMesa, Reserva reserva) {
    this.id_mesa = id_mesa;
    this.cantidad_comensales = cantidad_comensales;
    this.ubicacion = ubicacion;
    this.EstMesa = EstMesa;
    this.reserva = reserva;
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

  public Estado_mesa getEstMesa() {
    return EstMesa;
  }

  public void setEstMesa(Estado_mesa EstMesa) {
    this.EstMesa = EstMesa;
  }

  public Reserva getReserva() {
    return reserva;
  }

  public void setReserva(Reserva reserva) {
    this.reserva = reserva;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + this.id_mesa;
    hash = 71 * hash + this.cantidad_comensales;
    hash = 71 * hash + Objects.hashCode(this.ubicacion);
    hash = 71 * hash + Objects.hashCode(this.EstMesa);
    hash = 71 * hash + Objects.hashCode(this.reserva);
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
    if (!Objects.equals(this.EstMesa, other.EstMesa)) {
      return false;
    }
    return Objects.equals(this.reserva, other.reserva);
  }

  @Override
  public String toString() {
    return "Mesa{" + "id_mesa=" + id_mesa + ", cantidad_comensales=" + cantidad_comensales + ", ubicacion=" + ubicacion + ", EstMesa=" + EstMesa + ", reserva=" + reserva + '}';
  }
        
}
