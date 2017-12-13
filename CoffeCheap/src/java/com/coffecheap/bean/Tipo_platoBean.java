package com.coffecheap.bean;

import com.coffecheap.dao.TipoUsuarioDao;
import com.coffecheap.dao.Tipo_platoDao;
import com.coffecheap.modelo.Tipo_plato;
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
public class Tipo_platoBean {

    /**
     * Metodo para mostrar mensaje emergente desde una instancia creada de este Bean
     * @param summary 
     */
    static public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    private Tipo_plato tipoPlato = new Tipo_plato();
    private List<Tipo_plato> lstTipo_plato;

    public Tipo_plato getTipo_plato() {
        return tipoPlato;
    }

    public void setTipo_plato(Tipo_plato tipoPlato) {
        this.tipoPlato = tipoPlato;
    }

    public List<Tipo_plato> getLstTipo_plato() {
        return lstTipo_plato;
    }

    public void setLstTipo_plato(List<Tipo_plato> lstTipo_plato) {
        this.lstTipo_plato = lstTipo_plato;
    }

    /**
     * Metodo para registrar un Tipo Plato
     */
    public void registrar() {
        Tipo_platoDao dao;
        try {
            dao = new Tipo_platoDao();
            dao.registrar(tipoPlato);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Metodo para obtener una fila en un objeto Tipo Plato
     * @param tipo 
     */
    public void fila(Tipo_plato tipo) {
        Tipo_platoDao dao;
        Tipo_plato temp;
        try {
            dao = new Tipo_platoDao();
            temp = dao.leerFila(tipo);
            if (temp != null) {
                this.tipoPlato = temp;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo para listar todos los registros de Tipo Plato
     * @throws Exception 
     */
    public void listar() throws Exception {
        Tipo_platoDao dao;
        try {
            dao = new Tipo_platoDao();
            lstTipo_plato = dao.listar();
        } catch (Exception e) {
            throw e;
        }

    }
/**
 * Metodo para Modificar Tipo Plato
 * @throws Exception 
 */
    public void modificar() throws Exception {
        Tipo_platoDao dao;
        try {
            dao = new Tipo_platoDao();
            dao.modificar(tipoPlato);

        } catch (Exception e) {
            throw e;
        }

    }
/**
 * Metodo para Eliminar un regitro de Tipo Plato
 * @param tipoPlato
 * @throws Exception 
 */
    public void eliminar(Tipo_plato tipoPlato) throws Exception {
        Tipo_platoDao dao;
        try {
            dao = new Tipo_platoDao();
            dao.eliminar(tipoPlato);

        } catch (Exception e) {
            throw e;
        }

    }
}
