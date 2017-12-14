package com.coffecheap.modelo;

import java.util.Objects;

/**
 * Clase Mesa
 *
 * @author bryan
 */
public class Mesa {

    int id_mesa = 0;
    int cantidad_comensales = 0;
    String ubicacion = null;
    Estado_mesa EstMesa = new Estado_mesa();

    /**
     * Constructor vacio
     */
    public Mesa() {
    }

    /**
     * constructor para int
     *
     * @param id_mesa atributo
     */
    public Mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    /**
     * constructor para String
     *
     * @param ubicacion atributo
     */
    public Mesa(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * constructor para ojeto estado mesa
     *
     * @param EstMesa atributo
     */
    public Mesa(Estado_mesa EstMesa) {
        this.EstMesa = EstMesa;
    }

    /**
     * constructor con todos los atributos
     *
     * @param id_mesa atributo
     * @param cantidad_comensales atributo
     * @param ubicacion atributo
     * @param EstMesa atributo
     * @param reserva atributo
     */
    public Mesa(int id_mesa, int cantidad_comensales, String ubicacion, Estado_mesa EstMesa, Reserva reserva) {
        this.id_mesa = id_mesa;
        this.cantidad_comensales = cantidad_comensales;
        this.ubicacion = ubicacion;
        this.EstMesa = EstMesa;

    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public int getCantidad_comensales() {
        return cantidad_comensales;
    }

    public void setCantidad_comensales(int cantidad_comensales) {
        this.cantidad_comensales = cantidad_comensales;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Estado_mesa getEstMesa() {
        return EstMesa;
    }

    public void setEstMesa(Estado_mesa EstMesa) {
        this.EstMesa = EstMesa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id_mesa;
        hash = 71 * hash + this.cantidad_comensales;
        hash = 71 * hash + Objects.hashCode(this.ubicacion);
        hash = 71 * hash + Objects.hashCode(this.EstMesa);

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
        final Mesa other = (Mesa) obj;
        if (this.id_mesa != other.id_mesa) {
            return false;
        }
        if (this.cantidad_comensales != other.cantidad_comensales) {
            return false;
        }
        if (!Objects.equals(this.ubicacion, other.ubicacion)) {
            return false;
        }
        if (!Objects.equals(this.EstMesa, other.EstMesa)) {
            return false;
        }
        return false;

    }

    @Override
    public String toString() {
        return "Mesa{" + "id_mesa=" + id_mesa + ", cantidad_comensales=" + cantidad_comensales + ", ubicacion=" + ubicacion + ", EstMesa=" + EstMesa + '}';
    }

}
