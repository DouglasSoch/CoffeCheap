/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;

import com.coffecheap.dao.ProductoDao;
import com.coffecheap.modelo.Producto;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author medev
 */
@Named(value = "productoBean")
@ManagedBean
@ViewScoped
public class ProductoBean {
    private Producto producto = new Producto();
    private List<Producto>lstProducto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }
    
    public void registrar() {

    System.out.println("*******************************************************registrar");

    ProductoDao dao;

    try {
      dao = new ProductoDao();
      dao.registrar(producto);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void Mostrar() throws Exception {
    ProductoDao dao;

    try {
      dao = new ProductoDao();
      lstProducto = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }
  public void listar() throws Exception {
    ProductoDao dao;

    try {
      dao = new ProductoDao();
      lstProducto = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }
  public void modificar(Producto prod) throws Exception {
    System.out.println("*******************************************************Modificar");
    ProductoDao dao;

    try {
      dao = new ProductoDao();
      dao.modificar(prod);

    } catch (Exception e) {
      throw e;
    }

  }


  public void eliminar(Producto prod) throws Exception {
    System.out.println("*******************************************************eliminar");
    ProductoDao dao;

    try {
      dao = new ProductoDao();
      dao.eliminar(prod);

    } catch (Exception e) {
      throw e;
    }

  }
}
