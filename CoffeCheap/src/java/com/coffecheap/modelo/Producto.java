package com.coffecheap.modelo;

import java.util.Date;
import java.util.Objects;

public class Producto 
{
    int id_producto =0;
    int id_producto_eliminar;
    int cantidad;
    int cantidad_eliminar;
    String nombre =null;
    int existencia =0;
    Unidad_medida Umedida = new Unidad_medida();
    Tipo_producto Tproducto = new Tipo_producto();
    //no tocar la variable Date es especial
    Date fecha=null;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    

    public Producto() {
    }

    public int getCantidad_eliminar() {
        return cantidad_eliminar;
    }

    public void setCantidad_eliminar(int cantidad_eliminar) {
        this.cantidad_eliminar = cantidad_eliminar;
    }

    
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
    public int getId_producto_eliminar() {
        return id_producto_eliminar;
    }

    public void setId_producto_eliminar(int id_producto_eliminar) {
        this.id_producto_eliminar = id_producto_eliminar;
    }
    
    public Producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto(Unidad_medida Umedida) {
        this.Umedida = Umedida;
    }

    public Producto(Tipo_producto Tproducto) {
        this.Tproducto = Tproducto;
    }

    public Producto(int id_producto, String nombre, int existencia, Unidad_medida Umedida, Tipo_producto Tproducto) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.existencia = existencia;
        this.Umedida = Umedida;
        this.Tproducto = Tproducto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public Unidad_medida getUmedida() {
        return Umedida;
    }

    public void setUmedida(Unidad_medida Umedida) {
        this.Umedida = Umedida;
    }

    public Tipo_producto getTproducto() {
        return Tproducto;
    }

    public void setTproducto(Tipo_producto Tproducto) {
        this.Tproducto = Tproducto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id_producto;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + this.existencia;
        hash = 89 * hash + Objects.hashCode(this.Umedida);
        hash = 89 * hash + Objects.hashCode(this.Tproducto);
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
        final Producto other = (Producto) obj;
        if (this.id_producto != other.id_producto) {
            return false;
        }
        if (this.existencia != other.existencia) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.Umedida, other.Umedida)) {
            return false;
        }
        return Objects.equals(this.Tproducto, other.Tproducto);
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", nombre=" + nombre + ", existencia=" + existencia + ", Umedida=" + Umedida + ", Tproducto=" + Tproducto + '}';
    }
}
