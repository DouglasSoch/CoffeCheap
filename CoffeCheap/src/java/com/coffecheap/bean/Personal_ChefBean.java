package com.coffecheap.bean;

import com.coffecheap.dao.Personal_chefDao;
import com.coffecheap.modelo.Personal_chef;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Douglas Soch
 */
@Named(value = "personal_ChefBean")
@RequestScoped
public class Personal_ChefBean {

  Personal_chef personal = new Personal_chef();
  List<Personal_chef> lista = new ArrayList();

  public Personal_chef getPersonal() {
    return personal;
  }

  public void setPersonal(Personal_chef personal) {
    this.personal = personal;
  }

  public List<Personal_chef> getLista() {
    return lista;
  }

  public void setLista(List<Personal_chef> lista) {
    this.lista = lista;
  }

  public Personal_ChefBean() {
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
      lista = dao.Mostrar();
    } catch (Exception e) {
      throw e;
    }
  }

}
