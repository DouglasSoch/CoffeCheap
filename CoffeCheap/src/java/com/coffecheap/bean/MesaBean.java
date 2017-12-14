package com.coffecheap.bean;

/**
 *
 * @marhor acier
 */
import com.coffecheap.modelo.Mesa;
import com.coffecheap.dao.MesaDao;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author bryan
 */
@ManagedBean
@ViewScoped
public class MesaBean {

     static public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    private Mesa mesa = new Mesa();
    private List<Mesa> lstMesa;

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Mesa> getLstMesa() {
        return lstMesa;
    }

    public void setLstMesa(List<Mesa> lstMesa) {
        this.lstMesa = lstMesa;
    }

    /**
     * Metodo para registrar una mesa
     */
    public void registrar() {


        MesaDao dao;

        try {
             if(mesa.getCantidad_comensales()==0)
                                 {
                                     addMessage("Ingrese la Catidad de Comensales");
                                 }
                                 else
                                 { if(mesa.getUbicacion().equals(""))
                                 {
                                     addMessage("Ingrese La Ubicacion de la Mesa");
                                 }
                                 else
                                 {
            dao = new MesaDao();
            dao.registrar(mesa);
                                 }}
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Metodo para listar todos los registros de mesa
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void listar() throws Exception {
        MesaDao dao;

        try {
            dao = new MesaDao();
            lstMesa = dao.listar();
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para modificar una mesa
     *
     * @param mar Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar(Mesa mar) throws Exception {
        MesaDao dao;

        try {
            dao = new MesaDao();
            dao.modificar(mar);

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para eliminar un registro de mesa
     *
     * @param mar Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Mesa mar) throws Exception {
        MesaDao dao;
        try {
            dao = new MesaDao();
            dao.eliminar(mar);

        } catch (Exception e) {
            throw e;
        }

    }

}
