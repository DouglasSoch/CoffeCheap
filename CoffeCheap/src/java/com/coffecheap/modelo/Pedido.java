package com.coffecheap.modelo;

import java.sql.Time;
import java.sql.Date;
import java.util.Objects;

public class Pedido {

  int id_pedido = 0;
  Mesa mesa = new Mesa();
  Time hora = null;
  Usuario usuario = new Usuario();
  int cancelado = 0;
  Date fecha = null;
  String temp_fecha = null;
  String cancelar;

    public String getCancelar() {
        return cancelar;
    }

    public void setCancelar(String cancelar) {
        this.cancelar = cancelar;
    }
  
  public String getTemp_fecha() {
    return temp_fecha;
  }

  public void setTemp_fecha(String temp_fecha) {
    this.temp_fecha = temp_fecha;
  }

  public Pedido() {
  }

  public Pedido(int id_pedido, Mesa mesa, Time hora, Usuario usuario, int cancelado, Date fecha) {
    this.id_pedido = id_pedido;
    this.mesa = mesa;
    this.hora = hora;
    this.usuario = usuario;
    this.cancelado = cancelado;
    this.fecha = fecha;
  }

  public Pedido(Date fecha) {
    this.fecha = fecha;
  }

  public Pedido(Usuario usuario) {
    this.usuario = usuario;
  }

  public Pedido(Time hora) {
    this.hora = hora;
  }

  public Pedido(int id_pedido) {
    this.id_pedido = id_pedido;
  }

  public Pedido(Mesa mesa) {
    this.mesa = mesa;
  }

  public int getId_pedido() {
    return id_pedido;
  }

  public void setId_pedido(int id_pedido) {
    this.id_pedido = id_pedido;
  }

  public Mesa getMesa() {
    return mesa;
  }

  public void setMesa(Mesa mesa) {
    this.mesa = mesa;
  }

  public Time getHora() {
    return hora;
  }

  public void setHora(Time hora) {
    this.hora = hora;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public int getCancelado() {
    return cancelado;
  }

  public void setCancelado(int cancelado) {
    this.cancelado = cancelado;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 47 * hash + this.id_pedido;
    hash = 47 * hash + Objects.hashCode(this.mesa);
    hash = 47 * hash + Objects.hashCode(this.hora);
    hash = 47 * hash + Objects.hashCode(this.usuario);
    hash = 47 * hash + this.cancelado;
    hash = 47 * hash + Objects.hashCode(this.fecha);
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
    final Pedido other = (Pedido) obj;
    if (this.id_pedido != other.id_pedido) {
      return false;
    }
    if (this.cancelado != other.cancelado) {
      return false;
    }
    if (!Objects.equals(this.mesa, other.mesa)) {
      return false;
    }
    if (!Objects.equals(this.hora, other.hora)) {
      return false;
    }
    if (!Objects.equals(this.usuario, other.usuario)) {
      return false;
    }
    return Objects.equals(this.fecha, other.fecha);
  }

  @Override
  public String toString() {
    return "Pedido{" + "id_pedido=" + id_pedido + ", mesa=" + mesa + ", hora=" + hora + ", usuario=" + usuario + ", cancelado=" + cancelado + ", fecha=" + fecha + '}';
  }

  

}
