package com.coffecheap.modelo;

import java.util.Date;
import java.util.Objects;

public class Venta_factura 
{
    int id_venta_factura = 0;
    String nit_empresa = null; 
     Double subtotal = 0.0;
     Double iva = 0.0;
     Double propina = 0.0;
    Double total = 0.0;
    Date fecha_emision = null;
    Pedido pedido =new Pedido();

    public Venta_factura() {
    }
    
    public Venta_factura(int id_venta_factura) {
        this.id_venta_factura = id_venta_factura;
    }

    public Venta_factura(String nit_empresa) {
        this.nit_empresa = nit_empresa;
    }

    public Venta_factura(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Venta_factura(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Venta_factura(Pedido pedido) {
        this.pedido = pedido;
    }

    public Venta_factura(int id_venta_factura, String nit_empresa, Double subtotal, Double iva, Double propina, Double total, Date fecha_emision, Pedido pedido) {
        this.id_venta_factura = id_venta_factura;
        this.nit_empresa = nit_empresa;
        this.subtotal = subtotal;
        this.iva = iva;
        this.propina = propina;
        this.total = total;
        this.fecha_emision = fecha_emision;
        this.pedido = pedido;
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

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id_venta_factura;
        hash = 61 * hash + Objects.hashCode(this.nit_empresa);
        hash = 61 * hash + Objects.hashCode(this.subtotal);
        hash = 61 * hash + Objects.hashCode(this.iva);
        hash = 61 * hash + Objects.hashCode(this.propina);
        hash = 61 * hash + Objects.hashCode(this.total);
        hash = 61 * hash + Objects.hashCode(this.fecha_emision);
        hash = 61 * hash + Objects.hashCode(this.pedido);
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
        if (this.id_venta_factura != other.id_venta_factura) {
            return false;
        }
        if (!Objects.equals(this.nit_empresa, other.nit_empresa)) {
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
        if (!Objects.equals(this.fecha_emision, other.fecha_emision)) {
            return false;
        }
        return Objects.equals(this.pedido, other.pedido);
    }

    @Override
    public String toString() {
        return "Venta_factura{" + "id_venta_factura=" + id_venta_factura + ", nit_empresa=" + nit_empresa + ", subtotal=" + subtotal + ", iva=" + iva + ", propina=" + propina + ", total=" + total + ", fecha_emision=" + fecha_emision + ", pedido=" + pedido + '}';
    }

    
    
    
    
}
