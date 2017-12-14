/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;

import com.coffecheap.dao.PlatoDao;
import com.coffecheap.modelo.Plato;
import com.coffecheap.modelo.Tipo_plato;
import java.util.List;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bryan
 */
@Named(value = "platoBean")
@ManagedBean
@ViewScoped
public class PlatoBean {

    /**
     * Metodo para mostrar mensaje emergente desde una instancia creada de
     * PlatoBean
     *
     * @param summary String
     */
    static public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    private Plato plato = new Plato();
    private List<Plato> lstPlato;
    List<Tipo_plato> lstTPlato = new ArrayList();

    public List<Tipo_plato> getLstTPlato() {
        return lstTPlato;
    }

    public void setLstTPlato(List<Tipo_plato> lstTPlato) {
        this.lstTPlato = lstTPlato;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public List<Plato> getLstPlato() {
        return lstPlato;
    }

    public void setLstPlato(List<Plato> lstPlato) {
        this.lstPlato = lstPlato;
    }

    /**
     * Metodo para registrar un plato
     */
    public void registrar() {
        PlatoDao dao;
        try {
            dao = new PlatoDao();
            dao.registrar(plato);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo para obtener una fila en un objeto de plato
     *
     * @param plato Objeto de la clase
     */
    public void fila(Plato plato) {
        PlatoDao dao;
        Plato temp;
        try {
            dao = new PlatoDao();
            temp = dao.leerFila(plato);
            if (temp != null) {
                this.plato = temp;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo para listar todos los registros de plato
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void listar() throws Exception {
        PlatoDao dao;
        try {
            dao = new PlatoDao();
            lstPlato = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * MEtodo para listar en una lista deplegable los tipos de plato
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void listarTPlatp() throws Exception {
        PlatoDao dao;
        try {
            dao = new PlatoDao();
            lstTPlato = dao.listarTipoPlato();
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para modificar un plato
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar() throws Exception {
        PlatoDao dao;
        try {
            dao = new PlatoDao();
            dao.modificar(plato);

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para Eliminar un plato
     *
     * @param plat Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Plato plat) throws Exception {
        PlatoDao dao;
        try {
            dao = new PlatoDao();
            dao.eliminar(plat);

        } catch (Exception e) {
            throw e;
        }
    }
}
