package com.coffecheap.bean;

/**
 *
 * @marhor acier
 */

import com.coffecheap.modelo.Estado_mesa;
import com.coffecheap.dao.Estado_mesaDao;

import java.util.List;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Estado_mesaBean {

  private Estado_mesa estado_mesa = new Estado_mesa();
  private List<Estado_mesa> lstEstado_mesa;

  public Estado_mesa getEstado_mesa() {
    return estado_mesa;
  }

  public void setEstado_mesa(Estado_mesa estado_mesa) {
    this.estado_mesa = estado_mesa;
  }

  public List<Estado_mesa> getLstEstado_mesa() {
    return lstEstado_mesa;
  }

  public void setLstEstado_mesa(List<Estado_mesa> lstEstado_mesa) {
    this.lstEstado_mesa = lstEstado_mesa;
  }

  public void registrar() {

    System.out.println("*******************************************************registrar");

    Estado_mesaDao dao;

    try {
      dao = new Estado_mesaDao();
      dao.registrar(estado_mesa);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void listar() throws Exception {
    Estado_mesaDao dao;

    try {
      dao = new Estado_mesaDao();
      lstEstado_mesa = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }

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

  public void eliminar(Estado_mesa mar) throws Exception {
    System.out.println("*******************************************************eliminar");
    Estado_mesaDao dao;

    try {
      dao = new Estado_mesaDao();
      dao.eliminar(mar);

    } catch (Exception e) {
      throw e;
    }

  }

}
