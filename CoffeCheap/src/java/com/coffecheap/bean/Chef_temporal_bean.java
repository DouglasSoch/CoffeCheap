/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;

import com.coffecheap.dao.Chef_temporal_Dao;
import com.coffecheap.modelo.Tem_chef;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Bryan
 */
@ManagedBean
@ViewScoped
public class Chef_temporal_bean {

    ArrayList<Tem_chef> listchef = new ArrayList();
    Tem_chef chef = new Tem_chef();

    public ArrayList<Tem_chef> getListchef() {
        return listchef;
    }

    public void setListchef(ArrayList<Tem_chef> listchef) {
        this.listchef = listchef;
    }

    public Tem_chef getChef() {
        return chef;
    }

    public void setChef(Tem_chef chef) {
        this.chef = chef;
    }

    public void listar() {
        Chef_temporal_Dao dao = new Chef_temporal_Dao();
        try {
            listchef = dao.listar();

        } catch (Exception e) {

        }
    }

    /**
     *
     * @param valor Objeto de la clase
     * @return String
     * @throws Exception por si resulta un error de SQL
     */
    public String ControlColor(int valor) throws Exception {
        //System.out.println("********************************Pago de mesa");
        Chef_temporal_Dao dao;
        String estado = null;
        try {
            dao = new Chef_temporal_Dao();
            estado = dao.ControlColor(valor);
        } catch (Exception e) {
            throw e;
        }

        // System.out.println("" + valor + "* " + estado + "");
        return estado;
    }

    /**
     *
     * @param codigo Objeto de la clase
     * @param codigo2 Objeto de la clase
     * @return String
     * @throws Exception por si resulta un error de SQL
     */
    public String Eliminar(int codigo, int codigo2) throws Exception {

        String respuesta = null;
        Chef_temporal_Dao dao;
        try {
            dao = new Chef_temporal_Dao();
            if (codigo2 == 2) {
                dao.Eliminar(codigo);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminado Correctamente", ""));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Tiene que preparar el platillo para eliminar el registro"));
            }

        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

    public void info() {

    }

    /**
     *
     * @param codigoenvio Objeto de la clase
     * @return int
     * @throws Exception por si resulta un error de SQL
     */
    public int beliminar(int codigoenvio) throws Exception {

        int respuesta;
        Chef_temporal_Dao dao;
        try {
            dao = new Chef_temporal_Dao();
            respuesta = dao.BotonEliminar(codigoenvio);
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

    /**
     *
     * @param codigo Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void estado(int codigo) throws Exception {

        Chef_temporal_Dao dao;
        try {
            dao = new Chef_temporal_Dao();
            dao.cierre(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @param codigo Objeto de la clase
     * @return String
     * @throws Exception por si resulta un error de SQL
     */
    public String Boton(int codigo) throws Exception {
        String respuesta = null;
        Chef_temporal_Dao dao;
        try {
            dao = new Chef_temporal_Dao();
            respuesta = dao.NombreBoton(codigo);
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }

}
