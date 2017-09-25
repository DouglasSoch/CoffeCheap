package com.coffecheap.bean;

/**
 *
 * @marhor acier
 */

import com.coffecheap.modelo.Control_mesa;
import com.coffecheap.dao.Control_mesaDao;

import java.util.List;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Control_mesaBean {

  private Control_mesa control_mesa = new Control_mesa();
  private List<Control_mesa> lstControl_mesa;

  public Control_mesa getControl_mesa() {
    return control_mesa;
  }

  public void setControl_mesa(Control_mesa control_mesa) {
    this.control_mesa = control_mesa;
  }

  public List<Control_mesa> getLstControl_mesa() {
    return lstControl_mesa;
  }

  public void setLstControl_mesa(List<Control_mesa> lstControl_mesa) {
    this.lstControl_mesa = lstControl_mesa;
  }

  public void registrar() {

    System.out.println("*******************************************************registrar");

    Control_mesaDao dao;

    try {
      dao = new Control_mesaDao();
      dao.registrar(control_mesa);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void listar() throws Exception {
    Control_mesaDao dao;

    try {
      dao = new Control_mesaDao();
      lstControl_mesa = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }

  public void modificar(Control_mesa mar) throws Exception {
    System.out.println("*******************************************************Modificar");
    Control_mesaDao dao;

    try {
      dao = new Control_mesaDao();
      dao.modificar(mar);

    } catch (Exception e) {
      throw e;
    }

  }

  public void eliminar(Control_mesa mar) throws Exception {
    System.out.println("*******************************************************eliminar");
    Control_mesaDao dao;

    try {
      dao = new Control_mesaDao();
      dao.eliminar(mar);

    } catch (Exception e) {
      throw e;
    }

  }

}
