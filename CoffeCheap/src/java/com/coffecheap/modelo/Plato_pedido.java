package com.coffecheap.modelo;

import java.util.Objects;

/**
 * Clase plato pedido
 *
 * @author bryan
 */
public class Plato_pedido {

    int id_plato_pedido = 0;
    Plato plato = new Plato();
    int cantidad = 0;
    Usuario usuario = new Usuario();
    Pedido pedido = new Pedido();
    Double precio = 0.0;

    /**
     * constructor vacio
     */
    public Plato_pedido() {
    }

    /**
     * constructor para int
     *
     * @param id_plato_pedido atributo
     */
    public Plato_pedido(int id_plato_pedido) {
        this.id_plato_pedido = id_plato_pedido;
    }

    /**
     * Constructor para objeto plato
     *
     * @param plato atributo
     */
    public Plato_pedido(Plato plato) {
        this.plato = plato;
    }

    /**
     * constructor para objeto usuario
     *
     * @param usuario atributo
     */
    public Plato_pedido(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * constructor para objeto pedido
     *
     * @param pedido atributo
     */
    public Plato_pedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * Constructor para double
     *
     * @param precio atributo
     */
    public Plato_pedido(Double precio) {
        this.precio = precio;
    }

    /**
     * constructor con todos los atributos
     *
     * @param id_plato_pedido atributo
     * @param plato atributo
     * @param cantidad atributo
     * @param usuario atributo
     * @param pedido atributo
     * @param precio atributo
     */
    public Plato_pedido(int id_plato_pedido, Plato plato, int cantidad, Usuario usuario, Pedido pedido, Double precio) {
        this.id_plato_pedido = id_plato_pedido;
        this.plato = plato;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.pedido = pedido;
        this.precio = precio;
    }

    public int getId_plato_pedido() {
        return id_plato_pedido;
    }

    public void setId_plato_pedido(int id_plato_pedido) {
        this.id_plato_pedido = id_plato_pedido;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id_plato_pedido;
        hash = 89 * hash + Objects.hashCode(this.plato);
        hash = 89 * hash + this.cantidad;
        hash = 89 * hash + Objects.hashCode(this.usuario);
        hash = 89 * hash + Objects.hashCode(this.pedido);
        hash = 89 * hash + Objects.hashCode(this.precio);
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
        final Plato_pedido other = (Plato_pedido) obj;
        if (this.id_plato_pedido != other.id_plato_pedido) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (!Objects.equals(this.plato, other.plato)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        return Objects.equals(this.precio, other.precio);
    }

    @Override
    public String toString() {
        return "Plato_pedido{" + "id_plato_pedido=" + id_plato_pedido + ", plato=" + plato + ", cantidad=" + cantidad + ", usuario=" + usuario + ", pedido=" + pedido + ", precio=" + precio + '}';
    }

}
