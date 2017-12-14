/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.modelo;

import java.util.Objects;

/**
 * Clase
 *
 * @author bryan
 */
public class Permiso {

    Tipo tipo = new Tipo();
    Html html = new Html();
    Crud crud = new Crud();

    /**
     * constructor vacio
     */
    public Permiso() {
    }

    /**
     * constructor para objeto tipo
     *
     * @param tipo atributo
     */
    public Permiso(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * constructor para objeto html
     *
     * @param html atributo
     */
    public Permiso(Html html) {
        this.html = html;
    }

    /**
     * constructor para objeto crud
     *
     * @param crud atributo
     */
    public Permiso(Crud crud) {
        this.crud = crud;
    }

    /**
     * constructor con todos los atributos
     *
     * @param tipo atributo
     * @param html atributo
     * @param crud atributo
     */
    public Permiso(Tipo tipo, Html html, Crud crud) {
        this.tipo = tipo;
        this.html = html;
        this.crud = crud;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Html getHtml() {
        return html;
    }

    public void setHtml(Html html) {
        this.html = html;
    }

    public Crud getCrud() {
        return crud;
    }

    public void setCrud(Crud crud) {
        this.crud = crud;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.tipo);
        hash = 13 * hash + Objects.hashCode(this.html);
        hash = 13 * hash + Objects.hashCode(this.crud);
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
        final Permiso other = (Permiso) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.html, other.html)) {
            return false;
        }
        return Objects.equals(this.crud, other.crud);
    }

    @Override
    public String toString() {
        return "Permiso{" + "tipo=" + tipo + ", html=" + html + ", crud=" + crud + '}';
    }

}
