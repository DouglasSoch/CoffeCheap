package com.coffecheap.modelo;

import java.util.Objects;

/**
 * Clase tem mesero
 *
 * @author bryan
 */
public class Tem_mesero {

    int id_chef = 0;
    Pedido pedido = new Pedido();
    Plato plato = new Plato();
    int cantidad = 0;
    String descripcion = null;
    Estado_plato estadoPlato = new Estado_plato();
    Tipo_plato tipoPlato = new Tipo_plato();

    /**
     * constructor vacio
     */
    public Tem_mesero() {
    }

    /**
     * constructor para int
     *
     * @param id_chef atributo
     */
    public Tem_mesero(int id_chef) {
        this.id_chef = id_chef;
    }

    /**
     * constructor para objeto pedido
     *
     * @param pedido atributo
     */
    public Tem_mesero(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * constructor para objeto plato
     *
     * @param plato atributo
     */
    public Tem_mesero(Plato plato) {
        this.plato = plato;
    }

    /**
     * constructor para string
     *
     * @param descripcion atributo
     */
    public Tem_mesero(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * constructor para objeto estado plato
     *
     * @param estadoPlato atributo
     */
    public Tem_mesero(Estado_plato estadoPlato) {
        this.estadoPlato = estadoPlato;
    }

    /**
     * constructor para objeto tipo plato
     *
     * @param tipoPlato atributo
     */
    public Tem_mesero(Tipo_plato tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    /**
     * constructor con todos los atributos
     *
     * @param id_chef atributo
     * @param pedido atributo
     * @param plato atributo
     * @param cantidad atributo
     * @param descripcion atributo
     * @param estadoPlato atributo
     * @param tipoPlato atributo
     */
    public Tem_mesero(int id_chef, Pedido pedido, Plato plato, int cantidad, String descripcion, Estado_plato estadoPlato, Tipo_plato tipoPlato) {
        this.id_chef = id_chef;
        this.pedido = pedido;
        this.plato = plato;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.estadoPlato = estadoPlato;
        this.tipoPlato = tipoPlato;
    }

    public int getId_chef() {
        return id_chef;
    }

    public void setId_chef(int id_chef) {
        this.id_chef = id_chef;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado_plato getEstadoPlato() {
        return estadoPlato;
    }

    public void setEstadoPlato(Estado_plato estadoPlato) {
        this.estadoPlato = estadoPlato;
    }

    public Tipo_plato getTipoPlato() {
        return tipoPlato;
    }

    public void setTipoPlato(Tipo_plato tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id_chef;
        hash = 17 * hash + Objects.hashCode(this.pedido);
        hash = 17 * hash + Objects.hashCode(this.plato);
        hash = 17 * hash + this.cantidad;
        hash = 17 * hash + Objects.hashCode(this.descripcion);
        hash = 17 * hash + Objects.hashCode(this.estadoPlato);
        hash = 17 * hash + Objects.hashCode(this.tipoPlato);
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
        final Tem_mesero other = (Tem_mesero) obj;
        if (this.id_chef != other.id_chef) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        if (!Objects.equals(this.plato, other.plato)) {
            return false;
        }
        if (!Objects.equals(this.estadoPlato, other.estadoPlato)) {
            return false;
        }
        return Objects.equals(this.tipoPlato, other.tipoPlato);
    }

    @Override
    public String toString() {
        return "Tem_chef{" + "id_chef=" + id_chef + ", pedido=" + pedido + ", plato=" + plato + ", cantidad=" + cantidad + ", descripcion=" + descripcion + ", estadoPlato=" + estadoPlato + ", tipoPlato=" + tipoPlato + '}';
    }

}
