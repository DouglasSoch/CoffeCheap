package com.coffecheap.modelo;

/**
 * Clase menu
 *
 * @author bryan
 */
public class Menu {

    int codigo;
    int codigosubmenu;
    int cantidadprimerciclo;
    int cantidadsegundociclo;
    String llamadopagina;
    String paginaprincipal;
    String subpagina;

    public String getLlamadopagina() {
        return llamadopagina;
    }

    public void setLlamadopagina(String llamadopagina) {
        this.llamadopagina = llamadopagina;
    }

    public int getCodigosubmenu() {
        return codigosubmenu;
    }

    public void setCodigosubmenu(int codigosubmenu) {
        this.codigosubmenu = codigosubmenu;
    }

    public int getCantidadprimerciclo() {
        return cantidadprimerciclo;
    }

    public void setCantidadprimerciclo(int cantidadprimerciclo) {
        this.cantidadprimerciclo = cantidadprimerciclo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPaginaprincipal() {
        return paginaprincipal;
    }

    public void setPaginaprincipal(String paginaprincipal) {
        this.paginaprincipal = paginaprincipal;
    }

    public int getCantidadsegundociclo() {
        return cantidadsegundociclo;
    }

    public void setCantidadsegundociclo(int cantidadsegundociclo) {
        this.cantidadsegundociclo = cantidadsegundociclo;
    }

    public String getSubpagina() {
        return subpagina;
    }

    public void setSubpagina(String subpagina) {
        this.subpagina = subpagina;
    }

}
