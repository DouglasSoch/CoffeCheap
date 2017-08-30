package com.coffecheap.bean;

/**
 *
 * @marhor acier
 */

import com.coffecheap.modelo.Orden_compras;
import com.coffecheap.dao.Orden_comprasDao;

import java.util.List;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Orden_comprasBean {

  private Orden_compras orden_compras = new Orden_compras();
  private List<Orden_compras> lstOrden_compras;

  public Orden_compras getOrden_compras() {
    return orden_compras;
  }

  public void setOrden_compras(Orden_compras orden_compras) {
    this.orden_compras = orden_compras;
  }

  public List<Orden_compras> getLstOrden_compras() {
    return lstOrden_compras;
  }

  public void setLstOrden_compras(List<Orden_compras> lstOrden_compras) {
    this.lstOrden_compras = lstOrden_compras;
  }

  public void registrar() {

    System.out.println("*******************************************************registrar");

    Orden_comprasDao dao;

    try {
      dao = new Orden_comprasDao();
      dao.registrar(orden_compras);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void listar() throws Exception {
    Orden_comprasDao dao;

    try {
      dao = new Orden_comprasDao();
      lstOrden_compras = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }

  public void modificar(Orden_compras mar) throws Exception {
    System.out.println("*******************************************************Modificar");
    Orden_comprasDao dao;

    try {
      dao = new Orden_comprasDao();
      dao.modificar(mar);

    } catch (Exception e) {
      throw e;
    }

  }


  public void eliminar(Orden_compras mar) throws Exception {
    System.out.println("*******************************************************eliminar");
    Orden_comprasDao dao;

    try {
      dao = new Orden_comprasDao();
      dao.eliminar(mar);

    } catch (Exception e) {
      throw e;
    }

  }

}
