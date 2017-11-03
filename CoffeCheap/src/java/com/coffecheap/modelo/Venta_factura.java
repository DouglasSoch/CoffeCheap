package com.coffecheap.modelo;
//import java.sql.Date;
//import java.sql.Time;
import java.sql.Timestamp;

import java.util.Objects;

public class Venta_factura {

  String temp_fecha_emision= null;
  boolean opc_propina= false;
  Double tem_total=0.0;
  int id_venta_factura=0;
  String nit_empresa = null;
  Double subtotal=0.0 ;
  Double iva =0.0;
  Double propina= 0.0;
  Double total = 0.0;
  Pedido pedido= new Pedido();
  Cliente cliente= new Cliente();
  Timestamp fecha_emision= null;

  public Venta_factura() {
  }
  

  public Venta_factura(String temp_fecha_emision) {
    this.temp_fecha_emision = temp_fecha_emision;
  }

  public Venta_factura(boolean opc_propina) {
    this.opc_propina = opc_propina;
  }

  public Venta_factura(Double tem_total) {
    this.tem_total = tem_total;
  }

  public Venta_factura(int id_venta_factura) {
    this.id_venta_factura = id_venta_factura;
  }

  public Venta_factura(Pedido pedido) {
    this.pedido = pedido;
  }

  public Venta_factura(Cliente cliente) {
    this.cliente = cliente;
  }

  public Venta_factura(Timestamp fecha_emision) {
    this.fecha_emision = fecha_emision;
  }

  public Venta_factura(String temp_fecha_emision, boolean opc_propina, Double tem_total, int id_venta_factura, String nit_empresa, Double subtotal, Double iva, Double propina, Double total, Pedido pedido, Cliente cliente, Timestamp fecha_emision) {
    this.temp_fecha_emision = temp_fecha_emision;
    this.opc_propina = opc_propina;
    this.tem_total = tem_total;
    this.id_venta_factura = id_venta_factura;
    this.nit_empresa = nit_empresa;
    this.subtotal = subtotal;
    this.iva = iva;
    this.propina = propina;
    this.total = total;
    this.pedido = pedido;
    this.cliente = cliente;
    this.fecha_emision = fecha_emision;
  }

  public String getTemp_fecha_emision() {
    return temp_fecha_emision;
  }

  public void setTemp_fecha_emision(String temp_fecha_emision) {
    this.temp_fecha_emision = temp_fecha_emision;
  }

  public boolean isOpc_propina() {
    return opc_propina;
  }

  public void setOpc_propina(boolean opc_propina) {
    this.opc_propina = opc_propina;
  }

  public Double getTem_total() {
    return tem_total;
  }

  public void setTem_total(Double tem_total) {
    this.tem_total = tem_total;
  }

  public int getId_venta_factura() {
    return id_venta_factura;
  }

  public void setId_venta_factura(int id_venta_factura) {
    this.id_venta_factura = id_venta_factura;
  }

  public String getNit_empresa() {
    return nit_empresa;
  }

  public void setNit_empresa(String nit_empresa) {
    this.nit_empresa = nit_empresa;
  }

  public Double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(Double subtotal) {
    this.subtotal = subtotal;
  }

  public Double getIva() {
    return iva;
  }

  public void setIva(Double iva) {
    this.iva = iva;
  }

  public Double getPropina() {
    return propina;
  }

  public void setPropina(Double propina) {
    this.propina = propina;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Timestamp getFecha_emision() {
    return fecha_emision;
  }

  public void setFecha_emision(Timestamp fecha_emision) {
    this.fecha_emision = fecha_emision;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 * hash + Objects.hashCode(this.temp_fecha_emision);
    hash = 67 * hash + (this.opc_propina ? 1 : 0);
    hash = 67 * hash + Objects.hashCode(this.tem_total);
    hash = 67 * hash + this.id_venta_factura;
    hash = 67 * hash + Objects.hashCode(this.nit_empresa);
    hash = 67 * hash + Objects.hashCode(this.subtotal);
    hash = 67 * hash + Objects.hashCode(this.iva);
    hash = 67 * hash + Objects.hashCode(this.propina);
    hash = 67 * hash + Objects.hashCode(this.total);
    hash = 67 * hash + Objects.hashCode(this.pedido);
    hash = 67 * hash + Objects.hashCode(this.cliente);
    hash = 67 * hash + Objects.hashCode(this.fecha_emision);
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
    final Venta_factura other = (Venta_factura) obj;
    if (this.opc_propina != other.opc_propina) {
      return false;
    }
    if (this.id_venta_factura != other.id_venta_factura) {
      return false;
    }
    if (!Objects.equals(this.temp_fecha_emision, other.temp_fecha_emision)) {
      return false;
    }
    if (!Objects.equals(this.nit_empresa, other.nit_empresa)) {
      return false;
    }
    if (!Objects.equals(this.tem_total, other.tem_total)) {
      return false;
    }
    if (!Objects.equals(this.subtotal, other.subtotal)) {
      return false;
    }
    if (!Objects.equals(this.iva, other.iva)) {
      return false;
    }
    if (!Objects.equals(this.propina, other.propina)) {
      return false;
    }
    if (!Objects.equals(this.total, other.total)) {
      return false;
    }
    if (!Objects.equals(this.pedido, other.pedido)) {
      return false;
    }
    if (!Objects.equals(this.cliente, other.cliente)) {
      return false;
    }
    return Objects.equals(this.fecha_emision, other.fecha_emision);
  }

  @Override
  public String toString() {
    return "Venta_factura{" + "temp_fecha_emision=" + temp_fecha_emision + ", opc_propina=" + opc_propina + ", tem_total=" + tem_total + ", id_venta_factura=" + id_venta_factura + ", nit_empresa=" + nit_empresa + ", subtotal=" + subtotal + ", iva=" + iva + ", propina=" + propina + ", total=" + total + ", pedido=" + pedido + ", cliente=" + cliente + ", fecha_emision=" + fecha_emision + '}';
  }

  
  
}
