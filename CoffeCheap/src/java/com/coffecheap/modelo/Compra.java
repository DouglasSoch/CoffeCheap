package com.coffecheap.modelo;

import java.util.Objects;

public class Compra 
{
    int id_compras  = 0;
    Orden_compras Ocompras = new Orden_compras();
    int cantidad =0;
    int costo =0;
    int no_fac=0;
    String serie = null;

    public Compra() {
    }

    public Compra(int id_compras) {
        this.id_compras = id_compras;
    }

    public Compra(Orden_compras Ocompras) {
        this.Ocompras = Ocompras;
    }

    public Compra(String serie) {
        this.serie = serie;
    }

    public Compra(int id_compras, Orden_compras Ocompras, int cantidad, int costo, int no_fac, String serie) {
        this.id_compras = id_compras;
        this.Ocompras = Ocompras;
        this.cantidad = cantidad;
        this.costo = costo;
        this.no_fac = no_fac;
        this.serie = serie;
    }

    public int getId_compras() {
        return id_compras;
    }

    public void setId_compras(int id_compras) {
        this.id_compras = id_compras;
    }

    public Orden_compras getOcompras() {
        return Ocompras;
    }

    public void setOcompras(Orden_compras Ocompras) {
        this.Ocompras = Ocompras;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getNo_fac() {
        return no_fac;
    }

    public void setNo_fac(int no_fac) {
        this.no_fac = no_fac;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id_compras;
        hash = 83 * hash + Objects.hashCode(this.Ocompras);
        hash = 83 * hash + this.cantidad;
        hash = 83 * hash + this.costo;
        hash = 83 * hash + this.no_fac;
        hash = 83 * hash + Objects.hashCode(this.serie);
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
        final Compra other = (Compra) obj;
        if (this.id_compras != other.id_compras) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (this.costo != other.costo) {
            return false;
        }
        if (this.no_fac != other.no_fac) {
            return false;
        }
        if (!Objects.equals(this.serie, other.serie)) {
            return false;
        }
        return Objects.equals(this.Ocompras, other.Ocompras);
    }

    @Override
    public String toString() {
        return "Compra{" + "id_compras=" + id_compras + ", Ocompras=" + Ocompras + ", cantidad=" + cantidad + ", costo=" + costo + ", no_fac=" + no_fac + ", serie=" + serie + '}';
    }
    
}