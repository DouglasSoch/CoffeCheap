package com.coffecheap.bean;

/**
 *
 * @marhor acier
 */

import com.coffecheap.modelo.Proveedor_productos;
import com.coffecheap.dao.Proveedor_productosDao;

import java.util.List;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Proveedor_productosBean {

  private Proveedor_productos proveedor_productos = new Proveedor_productos();
  private List<Proveedor_productos> lstProveedor_productos;

  public Proveedor_productos getProveedor_productos() {
    return proveedor_productos;
  }

  public void setProveedor_productos(Proveedor_productos proveedor_productos) {
    this.proveedor_productos = proveedor_productos;
  }

  public List<Proveedor_productos> getLstProveedor_productos() {
    return lstProveedor_productos;
  }

  public void setLstProveedor_productos(List<Proveedor_productos> lstProveedor_productos) {
    this.lstProveedor_productos = lstProveedor_productos;
  }

  public void registrar() {

    System.out.println("*******************************************************registrar");

    Proveedor_productosDao dao;

    try {
      dao = new Proveedor_productosDao();
      dao.registrar(proveedor_productos);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void listar() throws Exception {
    Proveedor_productosDao dao;

    try {
      dao = new Proveedor_productosDao();
      lstProveedor_productos = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }

  public void modificar(Proveedor_productos mar) throws Exception {
    System.out.println("*******************************************************Modificar");
    Proveedor_productosDao dao;

    try {
      dao = new Proveedor_productosDao();
      dao.modificar(mar);

    } catch (Exception e) {
      throw e;
    }

  }

  public void eliminar(Proveedor_productos mar) throws Exception {
    System.out.println("*******************************************************eliminar");
    Proveedor_productosDao dao;

    try {
      dao = new Proveedor_productosDao();
      dao.eliminar(mar);

    } catch (Exception e) {
      throw e;
    }

  }

}
