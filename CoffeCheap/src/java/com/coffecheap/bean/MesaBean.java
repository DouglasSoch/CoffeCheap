package com.coffecheap.bean;

/**
 *
 * @marhor acier
 */

import com.coffecheap.modelo.Mesa;
import com.coffecheap.dao.MesaDao;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class MesaBean {

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

  public void registrar() {

    System.out.println("********************************************registrar");

    MesaDao dao;

    try {
      dao = new MesaDao();
      dao.registrar(mesa);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void listar() throws Exception {
    MesaDao dao;

    try {
      dao = new MesaDao();
      lstMesa = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }

  public void modificar(Mesa mar) throws Exception {
    System.out.println("********************************************Modificar");
    MesaDao dao;

    try {
      dao = new MesaDao();
      dao.modificar(mar);

    } catch (Exception e) {
      throw e;
    }

  }
  
  

  public void eliminar(Mesa mar) throws Exception {
    System.out.println("*********************************************eliminar");
    MesaDao dao;

    try {
      dao = new MesaDao();
      dao.eliminar(mar);

    } catch (Exception e) {
      throw e;
    }

  }

}
