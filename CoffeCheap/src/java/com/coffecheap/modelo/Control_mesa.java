/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.modelo;

import java.util.Objects;

/**
 *
 * @author bryan
 */
public class Control_mesa {
    
    Mesa mesa= new Mesa();
    Boolean pago= false;
    Boolean vaciar= false;

    public Control_mesa() {
    }

    public Control_mesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Control_mesa(Boolean pago) {
        this.pago = pago;
    }

    public Control_mesa(Mesa mesa, Boolean pago, Boolean vaciar) {
        this.mesa = mesa;
        this.pago = pago;
        this.vaciar = vaciar;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Boolean getVaciar() {
        return vaciar;
    }

    public void setVaciar(Boolean vaciar) {
        this.vaciar = vaciar;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.mesa);
        hash = 97 * hash + Objects.hashCode(this.pago);
        hash = 97 * hash + Objects.hashCode(this.vaciar);
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
        final Control_mesa other = (Control_mesa) obj;
        if (!Objects.equals(this.mesa, other.mesa)) {
            return false;
        }
        if (!Objects.equals(this.pago, other.pago)) {
            return false;
        }
        return Objects.equals(this.vaciar, other.vaciar);
    }

    @Override
    public String toString() {
        return "Control_mesa{" + "mesa=" + mesa + ", pago=" + pago + ", vaciar=" + vaciar + '}';
    }
    
    
}
