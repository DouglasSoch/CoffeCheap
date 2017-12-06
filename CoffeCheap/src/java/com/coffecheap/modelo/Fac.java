package com.coffecheap.modelo;

import java.util.Objects;

/**
 *
 * @author Lezanaman
 */
public class Fac 
{
    Venta_factura ventaFac= new Venta_factura();
    Cliente cliente= new Cliente();
    Pedido pedido= new Pedido();
    Mesa mesa = new Mesa();
    Usuario usuario = new Usuario();
    Plato_pedido platoPedido = new Plato_pedido();

    public Fac() {
    }

    public Fac(Venta_factura ventaFac) {
        this.ventaFac = ventaFac;
    }

    public Fac(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fac(Pedido pedido) {
        this.pedido = pedido;
    }

    public Fac(Mesa mesa) {
        this.mesa = mesa;
    }

    public Fac(Usuario usuario) {
        this.usuario = usuario;
    }

    public Fac(Plato_pedido platoPedido) {
        this.platoPedido = platoPedido;
    }

    
    public Venta_factura getVentaFac() {
        return ventaFac;
    }

    public void setVentaFac(Venta_factura ventaFac) {
        this.ventaFac = ventaFac;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Plato_pedido getPlatoPedido() {
        return platoPedido;
    }

    public void setPlatoPedido(Plato_pedido platoPedido) {
        this.platoPedido = platoPedido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.ventaFac);
        hash = 67 * hash + Objects.hashCode(this.cliente);
        hash = 67 * hash + Objects.hashCode(this.pedido);
        hash = 67 * hash + Objects.hashCode(this.mesa);
        hash = 67 * hash + Objects.hashCode(this.usuario);
        hash = 67 * hash + Objects.hashCode(this.platoPedido);
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
        final Fac other = (Fac) obj;
        if (!Objects.equals(this.ventaFac, other.ventaFac)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        if (!Objects.equals(this.mesa, other.mesa)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return Objects.equals(this.platoPedido, other.platoPedido);
    }

    @Override
    public String toString() {
        return "Fac{" + "ventaFac=" + ventaFac + ", cliente=" + cliente + ", pedido=" + pedido + ", mesa=" + mesa + ", usuario=" + usuario + ", platoPedido=" + platoPedido + '}';
    }
    
    
    
}
