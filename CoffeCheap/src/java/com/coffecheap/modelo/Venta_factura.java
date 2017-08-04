package com.coffecheap.modelo;

import java.util.Date;
import java.util.Objects;

public class Venta_factura 
{
    int id_venta_factura = 0;
    int dpi_empresa = 0; 
    int subtotal = 0;
    int iva = 0;
    int propina = 0;
    int total = 0;
    Date fecha_emision = null;
    Pedido pedido = new Pedido();

    public Venta_factura() {
    }
    
    public Venta_factura(int id_venta_factura) {
        this.id_venta_factura = id_venta_factura;
    }

    public Venta_factura(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Venta_factura(Pedido pedido) {
        this.pedido = pedido;
    }

    public Venta_factura(int id_venta_factura, int dpi_empresa, int subtotal, int iva, int propina, int total, Date fecha_emision, Pedido pedido) {
        this.id_venta_factura = id_venta_factura;
        this.dpi_empresa = dpi_empresa;
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

    public int getDpi_empresa() {
        return dpi_empresa;
    }

    public void setDpi_empresa(int dpi_empresa) {
        this.dpi_empresa = dpi_empresa;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getPropina() {
        return propina;
    }

    public void setPropina(int propina) {
        this.propina = propina;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
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
        hash = 83 * hash + this.id_venta_factura;
        hash = 83 * hash + this.dpi_empresa;
        hash = 83 * hash + this.subtotal;
        hash = 83 * hash + this.iva;
        hash = 83 * hash + this.propina;
        hash = 83 * hash + this.total;
        hash = 83 * hash + Objects.hashCode(this.fecha_emision);
        hash = 83 * hash + Objects.hashCode(this.pedido);
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
        if (this.dpi_empresa != other.dpi_empresa) {
            return false;
        }
        if (this.subtotal != other.subtotal) {
            return false;
        }
        if (this.iva != other.iva) {
            return false;
        }
        if (this.propina != other.propina) {
            return false;
        }
        if (this.total != other.total) {
            return false;
        }
        if (!Objects.equals(this.fecha_emision, other.fecha_emision)) {
            return false;
        }
        return Objects.equals(this.pedido, other.pedido);
    }

    @Override
    public String toString() {
        return "Venta_factura{" + "id_venta_factura=" + id_venta_factura + ", dpi_empresa=" + dpi_empresa + ", subtotal=" + subtotal + ", iva=" + iva + ", propina=" + propina + ", total=" + total + ", fecha_emision=" + fecha_emision + ", pedido=" + pedido + '}';
    }
}
