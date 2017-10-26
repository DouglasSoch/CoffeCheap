package com.coffecheap.modelo;

import java.util.Objects;

public class Compra {

  int identificacion;
  int id_compras;
  Orden_compras Ocompras = new Orden_compras();
  Producto producto = new Producto();
  int cantidad;
  int costo;
  int no_fac;
  String serie;
  String fechaEntrega;

  public Compra() {
  }

  public Compra(int identifi, int orden, int producto,int cantidad, int costo, int no_fac, String serie, String fechaEntrega) {    
    this.identificacion = identifi;
    this.Ocompras.id_orden_compras=orden;
    this.producto.id_producto = producto;
    this.cantidad = cantidad;
    this.costo = costo;
    this.no_fac = no_fac;
    this.serie = serie;
    this.fechaEntrega = fechaEntrega;
  }

  public int getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(int identificacion) {
    this.identificacion = identificacion;
  }
 
  
  public Compra(int id_compras) {
    this.id_compras = id_compras;
  }

  public Compra(String serie) {
    this.serie = serie;
  }
  
  public int getId_compras() {
    return id_compras;
  }

  public void setId_compras(int id_compras) {
    this.id_compras = id_compras;
  }

  public Orden_compras getOcompras() {
    return Ocompras;
  }

  public void setOcompras(Orden_compras Ocompras) {
    this.Ocompras = Ocompras;
  }

  public Producto getProducto() {
    return producto;
  }

  public void setProducto(Producto producto) {
    this.producto = producto;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public int getCosto() {
    return costo;
  }

  public void setCosto(int costo) {
    this.costo = costo;
  }

  public int getNo_fac() {
    return no_fac;
  }

  public void setNo_fac(int no_fac) {
    this.no_fac = no_fac;
  }

  public String getSerie() {
    return serie;
  }

  public void setSerie(String serie) {
    this.serie = serie;
  }

  public String getFechaEntrega() {
    return fechaEntrega;
  }

  public void setFechaEntrega(String fechaEntrega) {
    this.fechaEntrega = fechaEntrega;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 79 * hash + this.id_compras;
    hash = 79 * hash + Objects.hashCode(this.Ocompras);
    hash = 79 * hash + Objects.hashCode(this.producto);
    hash = 79 * hash + this.cantidad;
    hash = 79 * hash + this.costo;
    hash = 79 * hash + this.no_fac;
    hash = 79 * hash + Objects.hashCode(this.serie);
    hash = 79 * hash + Objects.hashCode(this.fechaEntrega);
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
    final Compra other = (Compra) obj;
    if (this.id_compras != other.id_compras) {
      return false;
    }
    if (this.cantidad != other.cantidad) {
      return false;
    }
    if (this.costo != other.costo) {
      return false;
    }
    if (this.no_fac != other.no_fac) {
      return false;
    }
    if (!Objects.equals(this.serie, other.serie)) {
      return false;
    }
    if (!Objects.equals(this.fechaEntrega, other.fechaEntrega)) {
      return false;
    }
    if (!Objects.equals(this.Ocompras, other.Ocompras)) {
      return false;
    }
    return Objects.equals(this.producto, other.producto);
  }

  
  
  @Override
  public String toString() {
    return "Compra{" + "id_compras=" + id_compras + ", Ocompras=" + Ocompras + ", producto=" + producto + ", cantidad=" + cantidad + ", costo=" + costo + ", no_fac=" + no_fac + ", serie=" + serie + ", fechaEntrega=" + fechaEntrega + '}';
  }

  

}
