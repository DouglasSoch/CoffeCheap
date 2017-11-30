package com.coffecheap.modelo;

public class TipoUsuario {
    
    int identificacion;
    int id_tipo;
    int id_crud;
    int id_html;
    String nombrecrud;
    String nombrepagina;
    String nombretipo;
    String descripcion;

    public TipoUsuario(int identificacion, int id_crud, int id_html) {
        this.identificacion = identificacion;
        this.id_crud = id_crud;
        this.id_html = id_html;
    }

    public TipoUsuario(int identificacion, String nombretipo, String descripcion) {
        this.identificacion = identificacion;
        this.nombretipo = nombretipo;
        this.descripcion = descripcion;
    }

    

    public TipoUsuario() {
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public int getId_crud() {
        return id_crud;
    }

    public void setId_crud(int id_crud) {
        this.id_crud = id_crud;
    }

    public int getId_html() {
        return id_html;
    }

    public void setId_html(int id_html) {
        this.id_html = id_html;
    }

   
    public String getNombrecrud() {
        return nombrecrud;
    }

    public void setNombrecrud(String nombrecrud) {
        this.nombrecrud = nombrecrud;
    }

    public String getNombrepagina() {
        return nombrepagina;
    }

    public void setNombrepagina(String nombrepagina) {
        this.nombrepagina = nombrepagina;
    }

    public String getNombretipo() {
        return nombretipo;
    }

    public void setNombretipo(String nombretipo) {
        this.nombretipo = nombretipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
