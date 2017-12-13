package com.coffecheap.bean;



import com.coffecheap.modelo.Tipo_producto;
import com.coffecheap.dao.Tipo_productoDao;

import java.util.List;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
/**
 * 
 * @author Santi
 */
@ManagedBean
@ViewScoped
public class Tipo_productoBean {

  private Tipo_producto tipo_producto = new Tipo_producto();
  private List<Tipo_producto> lstTipo_producto;

  public Tipo_producto getTipo_producto() {
    return tipo_producto;
  }

  public void setTipo_producto(Tipo_producto tipo_producto) {
    this.tipo_producto = tipo_producto;
  }

  public List<Tipo_producto> getLstTipo_producto() {
    return lstTipo_producto;
  }

  public void setLstTipo_producto(List<Tipo_producto> lstTipo_producto) {
    this.lstTipo_producto = lstTipo_producto;
  }

  /**
   * Metodo para registrar
   */
  public void registrar() 
  {
    Tipo_productoDao dao;

    try {
      dao = new Tipo_productoDao();
      dao.registrar(tipo_producto);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  /**
   * Metodo para listar
   * @throws Exception 
   */
  public void listar() throws Exception {
    Tipo_productoDao dao;

    try {
      dao = new Tipo_productoDao();
      lstTipo_producto = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }

  /**
   * Metodo para modificar
   * @param mar
   * @throws Exception 
   */
  public void modificar(Tipo_producto mar) throws Exception {
    System.out.println("*******************************************************Modificar");
    Tipo_productoDao dao;

    try {
      dao = new Tipo_productoDao();
      dao.modificar(mar);

    } catch (Exception e) {
      throw e;
    }

  }

  /**
   * Metodo para eliminar
   * @param mar
   * @throws Exception 
   */
  public void eliminar(Tipo_producto mar) throws Exception {
    System.out.println("*******************************************************eliminar");
    Tipo_productoDao dao;

    try {
      dao = new Tipo_productoDao();
      dao.eliminar(mar);

    } catch (Exception e) {
      throw e;
    }

  }

}
