/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;

import com.coffecheap.dao.ProductoDao;
import com.coffecheap.modelo.Producto;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bryan
 */
@Named(value = "productoBean")
@ManagedBean
@ViewScoped
public class ProductoBean 
{
    /**
     * Metodo para mostrar un mensaje emergente desde una instancia de ProductoBean
     * @param summary 
     */
    static public void addMessage(String summary) {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
    FacesContext.getCurrentInstance().addMessage(null, message);
  }
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
    
    /**
     * Metodo para registrar  un producto
     */
    public void registrar() 
    {
    ProductoDao dao;
    try 
    {
      dao = new ProductoDao();
      dao.registrar(producto);
    }
    catch (Exception e) 
    {
      System.out.println(e);
    }

  }
/**
 * Metodo para listar todos los registros de producto
 * @throws Exception 
 */
  public void Mostrar() throws Exception {
    ProductoDao dao;

    try {
      dao = new ProductoDao();
      lstProducto = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }
  /**
   * Metodo para mostrar todos los registros de producto
   * @throws Exception 
   */
  public void listar() throws Exception {
    ProductoDao dao;

    try {
      dao = new ProductoDao();
      lstProducto = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }
  /**
   * Metodo para modificar un producto
   * @throws Exception 
   */
  public void modificar() throws Exception {
    
    ProductoDao dao;

    try {
      dao = new ProductoDao();
      dao.modificar(producto);

    } catch (Exception e) {
      throw e;
    }

  }

/**
 * Metodo para eliminar
 * @param prod
 * @throws Exception 
 */
  public void eliminar(Producto prod) throws Exception 
  {
    ProductoDao dao;

    try {
      dao = new ProductoDao();
      dao.eliminar(prod);

    } catch (Exception e) {
      throw e;
    }

  }
  /**
   * Metodo para obtener una fila en un objeto producto
   * @param pro 
   */
  public void fila(Producto pro) 
  {
    ProductoDao dao;
    Producto temp;
    try 
    {
      dao = new ProductoDao();
      temp = dao.leerFila(pro);
      if(temp !=null)
      {
          this.producto= temp;
      }
    } catch (Exception e) 
    {
      System.out.println(e);
    }
  }

}
