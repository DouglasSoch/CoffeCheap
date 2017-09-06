package com.coffecheap.bean;

import com.coffecheap.dao.Personal_chefDao;
import com.coffecheap.modelo.Personal_chef;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Douglas Soch
 */
@ManagedBean
@ViewScoped
public class Personal_chefBean {

    Personal_chef personal = new Personal_chef();
    List<Personal_chef> lstChef;

    public Personal_chef getPersonal() {
        return personal;
    }

    public void setPersonal(Personal_chef personal) {
        this.personal = personal;
    }

    public List<Personal_chef> getLstChef() {
        return lstChef;
    }

    public void setLstChef(List<Personal_chef> lstChef) {
        this.lstChef = lstChef;
    }

    public Personal_chefBean() {
    }

    public void Guardar() throws Exception {

        Personal_chefDao dao;

        try {
            dao = new Personal_chefDao();
            dao.Ingresar(personal);
        } catch (Exception e) {
            throw e;
        }
    }

    public void Modificar() throws Exception {

        Personal_chefDao dao;

        try {
            dao = new Personal_chefDao();
            dao.Modificar(personal);
        } catch (Exception e) {
            throw e;
        }
    }

    public void Eliminar() throws Exception {

        Personal_chefDao dao;

        try {
            dao = new Personal_chefDao();
            dao.Borrar(personal);
        } catch (Exception e) {
            throw e;
        }
    }

    public void Mostrar() throws Exception {

        Personal_chefDao dao;

        try {
            dao = new Personal_chefDao();
            lstChef = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

}
