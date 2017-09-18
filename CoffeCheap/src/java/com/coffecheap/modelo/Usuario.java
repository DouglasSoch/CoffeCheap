package com.coffecheap.modelo;

import java.util.Objects;

public class Usuario {
          int id= 0;
          String usuario= null;
          String pass= null;
          Tipo tipo = new Tipo();
          String nombre= null;
          String apellido = null;
          int codigo= 0;
          Turno turno= new Turno();
          int telefono = 0;
          String direccion= null;
          int dpi= 0;
          String nit= null;
          String correo= null;

    public Usuario() {
    }

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(String usuario) {
        this.usuario = usuario;
    }

    public Usuario(Tipo tipo) {
        this.tipo = tipo;
    }

    public Usuario(Turno turno) {
        this.turno = turno;
    }

    public Usuario(int id, String usuario, String pass, Tipo tipo, String nombre, String apellido, int codigo, Turno turno, int telefono, String direccion, int dpi, String nit, String correo) {
        this.id = id;
        this.usuario = usuario;
        this.pass = pass;
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.turno = turno;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dpi = dpi;
        this.nit = nit;
        this.correo = correo;
    }

          
          
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.id;
        hash = 19 * hash + Objects.hashCode(this.usuario);
        hash = 19 * hash + Objects.hashCode(this.pass);
        hash = 19 * hash + Objects.hashCode(this.tipo);
        hash = 19 * hash + Objects.hashCode(this.nombre);
        hash = 19 * hash + Objects.hashCode(this.apellido);
        hash = 19 * hash + this.codigo;
        hash = 19 * hash + Objects.hashCode(this.turno);
        hash = 19 * hash + this.telefono;
        hash = 19 * hash + Objects.hashCode(this.direccion);
        hash = 19 * hash + this.dpi;
        hash = 19 * hash + Objects.hashCode(this.nit);
        hash = 19 * hash + Objects.hashCode(this.correo);
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
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.telefono != other.telefono) {
            return false;
        }
        if (this.dpi != other.dpi) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.pass, other.pass)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.nit, other.nit)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.turno, other.turno);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usuario=" + usuario + ", pass=" + pass + ", tipo=" + tipo + ", nombre=" + nombre + ", apellido=" + apellido + ", codigo=" + codigo + ", turno=" + turno + ", telefono=" + telefono + ", direccion=" + direccion + ", dpi=" + dpi + ", nit=" + nit + ", correo=" + correo + '}';
    }
}
