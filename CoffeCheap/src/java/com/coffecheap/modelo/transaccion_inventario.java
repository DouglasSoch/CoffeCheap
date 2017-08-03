package com.coffecheap.modelo;

public class transaccion_inventario {
  int id_trasaccion;
  String fecha;
  int id_producto;
  int id_tipo_transaccion;

  public int getId_trasaccion() {
    return id_trasaccion;
  }

  public void setId_trasaccion(int id_trasaccion) {
    this.id_trasaccion = id_trasaccion;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public int getId_producto() {
    return id_producto;
  }

  public void setId_producto(int id_producto) {
    this.id_producto = id_producto;
  }

  public int getId_tipo_transaccion() {
    return id_tipo_transaccion;
  }

  public void setId_tipo_transaccion(int id_tipo_transaccion) {
    this.id_tipo_transaccion = id_tipo_transaccion;
  }
  
  
}
