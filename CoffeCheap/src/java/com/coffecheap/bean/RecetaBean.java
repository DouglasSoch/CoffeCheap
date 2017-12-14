/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;

import com.coffecheap.dao.RecetaDao;
import com.coffecheap.modelo.Receta;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bryan
 */
@ManagedBean
@ViewScoped
public class RecetaBean {

    /**
     * Metodo para mostrar mensaje emergente desde una instancia creada
     * RecetaBean
     *
     * @param summary String
     */
    static public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private Receta receta = new Receta();
    private List<Receta> lstReceta;

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public List<Receta> getLstReceta() {
        return lstReceta;
    }

    public void setLstReceta(List<Receta> lstReceta) {
        this.lstReceta = lstReceta;
    }

    /**
     * Metodo para registrar una Receta
     */
    public void registrar() {

        System.out.println("*******************************************************registrar");

        RecetaDao dao;

        try {
            dao = new RecetaDao();
            dao.registrar(receta);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Metodo para listar las recetas
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void listar() throws Exception {
        RecetaDao dao;

        try {
            dao = new RecetaDao();
            lstReceta = dao.listar();
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * MEtodo para modificar una receta
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar() throws Exception {
        RecetaDao dao;

        try {
            dao = new RecetaDao();
            dao.modificar(receta);

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para eliminar una receta
     *
     * @param receta Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Receta receta) throws Exception {
        System.out.println("*******************************************************eliminar");
        RecetaDao dao;

        try {
            dao = new RecetaDao();
            dao.eliminar(receta);

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para obtener una fila en un objeto Receta
     *
     * @param recet Objeto de la clase
     */
    public void fila(Receta recet) {
        RecetaDao dao;
        Receta temp;
        try {
            dao = new RecetaDao();
            temp = dao.leerFila(recet);
            if (temp != null) {
                this.receta = temp;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
