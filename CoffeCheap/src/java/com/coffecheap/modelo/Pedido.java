package com.coffecheap.modelo;

import java.sql.Time;
import java.util.Objects;

public class Pedido 
{
    int id_pedido = 0;
    Mesa mesa = new Mesa(); 
    Time hora = null;
    Usuario usuario= new Usuario();

    public Pedido() {
    }

    
    
    public Pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Pedido(Mesa mesa) {
        this.mesa = mesa;
    }

    public Pedido(Time hora) {
        this.hora = hora;
    }

    public Pedido(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pedido(int id_pedido, Mesa mesa, Time hora, Usuario usuario) {
        this.id_pedido = id_pedido;
        this.mesa = mesa;
        this.hora = hora;
        this.usuario = usuario;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id_pedido;
        hash = 89 * hash + Objects.hashCode(this.mesa);
        hash = 89 * hash + Objects.hashCode(this.hora);
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
        final Pedido other = (Pedido) obj;
        if (this.id_pedido != other.id_pedido) {
            return false;
        }
        if (!Objects.equals(this.mesa, other.mesa)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        return Objects.equals(this.usuario, other.usuario);
    }

    @Override
    public String toString() {
        return "Pedido{" + "id_pedido=" + id_pedido + ", mesa=" + mesa + ", hora=" + hora + ", usuario=" + usuario + '}';
    }

    
}
