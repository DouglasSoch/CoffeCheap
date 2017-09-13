package com.coffecheap.bean;

/**
 *
 * @marhor acier
 */

import com.coffecheap.modelo.Unidad_medida;
import com.coffecheap.dao.Unidad_medidaDao;

import java.util.List;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Unidad_medidaBean {

  private Unidad_medida unidad_medida = new Unidad_medida();
  private List<Unidad_medida> lstUnidad_medida;

  public Unidad_medida getUnidad_medida() {
    return unidad_medida;
  }

  public void setUnidad_medida(Unidad_medida unidad_medida) {
    this.unidad_medida = unidad_medida;
  }

  public List<Unidad_medida> getLstUnidad_medida() {
    return lstUnidad_medida;
  }

  public void setLstUnidad_medida(List<Unidad_medida> lstUnidad_medida) {
    this.lstUnidad_medida = lstUnidad_medida;
  }

  public void registrar() {

    System.out.println("*******************************************************registrar");

    Unidad_medidaDao dao;

    try {
      dao = new Unidad_medidaDao();
      dao.registrar(unidad_medida);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void listar() throws Exception {
    Unidad_medidaDao dao;

    try {
      dao = new Unidad_medidaDao();
      lstUnidad_medida = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }

  public void modificar(Unidad_medida mar) throws Exception {
    System.out.println("*******************************************************Modificar");
    Unidad_medidaDao dao;

    try {
      dao = new Unidad_medidaDao();
      dao.modificar(mar);

    } catch (Exception e) {
      throw e;
    }

  }

  public void eliminar(Unidad_medida mar) throws Exception {
    System.out.println("*******************************************************eliminar");
    Unidad_medidaDao dao;

    try {
      dao = new Unidad_medidaDao();
      dao.eliminar(mar);

    } catch (Exception e) {
      throw e;
    }

  }

}
