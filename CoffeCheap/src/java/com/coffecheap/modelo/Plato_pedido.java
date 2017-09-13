package com.coffecheap.modelo;

import java.util.Objects;

public class Plato_pedido 
{
    int id_plato_pedido= 0;
    Plato plato = new Plato();
    int cantidad =0 ;
    Usuario usuario= new Usuario();

    public Plato_pedido() {
    }

    public Plato_pedido(int id_plato_pedido) {
        this.id_plato_pedido = id_plato_pedido;
    }

    public Plato_pedido(Plato plato) {
        this.plato = plato;
    }

    public Plato_pedido(Usuario usuario) {
        this.usuario = usuario;
    }

    public Plato_pedido(int id_plato_pedido, Plato plato, int cantidad, Usuario usuario) {
        this.id_plato_pedido = id_plato_pedido;
        this.plato = plato;
        this.cantidad = cantidad;
        this.usuario = usuario;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id_plato_pedido;
        hash = 89 * hash + Objects.hashCode(this.plato);
        hash = 89 * hash + this.cantidad;
        hash = 89 * hash + Objects.hashCode(this.usuario);
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
        return Objects.equals(this.usuario, other.usuario);
    }

    @Override
    public String toString() {
        return "Plato_pedido{" + "id_plato_pedido=" + id_plato_pedido + ", plato=" + plato + ", cantidad=" + cantidad + ", usuario=" + usuario + '}';
    }
    
}
