package com.coffecheap.bean;

/**
 *
 * @marhor acier
 */
import com.coffecheap.modelo.Estado_mesa;
import com.coffecheap.dao.Estado_mesaDao;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class Estado_mesaBean {
static public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    private Estado_mesa estado_mes = new Estado_mesa();

    public Estado_mesa getEstado_mes() {
        return estado_mes;
    }

    public void setEstado_mes(Estado_mesa estado_mes) {
        this.estado_mes = estado_mes;
    }
    private List<Estado_mesa> lstEstado_mesa;

   

    public List<Estado_mesa> getLstEstado_mesa() {
        return lstEstado_mesa;
    }

    public void setLstEstado_mesa(List<Estado_mesa> lstEstado_mesa) {
        this.lstEstado_mesa = lstEstado_mesa;
    }

    /**
     * Metodo para ingresar registros en estado mesa
     */
    public void registrar() throws Exception {

        Estado_mesaDao dao;

        try {
           
 if(estado_mes.getNombre().equals(""))
                                 {
                                     addMessage("Ingrese El Nombre");
                                 }
                                 else
                                 {
            dao = new Estado_mesaDao();
            dao.registrar(estado_mes);
                                 }
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo para listar todos los registros de estado mesa
     *
     * @throws Exception por si resulta un error de SQL
     */
    public void listar() throws Exception {
        Estado_mesaDao dao;

        try {
            dao = new Estado_mesaDao();
            lstEstado_mesa = dao.listar();
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     *
     * @param mar Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar(Estado_mesa mar) throws Exception {
        System.out.println("*******************************************************Modificar");
        Estado_mesaDao dao;

        try {
            dao = new Estado_mesaDao();
            dao.modificar(mar);

        } catch (Exception e) {
            throw e;
        }

    }

    /**
     *
     * @param mar Objeto de la clase
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Estado_mesa mar) throws Exception {
        Estado_mesaDao dao;

        try {
            dao = new Estado_mesaDao();
            dao.eliminar(mar);

        } catch (Exception e) {
            throw e;
        }

    }

}
