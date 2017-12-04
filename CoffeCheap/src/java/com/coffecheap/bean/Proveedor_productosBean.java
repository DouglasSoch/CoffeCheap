package com.coffecheap.bean;

/**
 *
 * @marhor acier
 */

import com.coffecheap.modelo.Proveedor_productos;
import com.coffecheap.dao.Proveedor_productosDao;
import com.coffecheap.modelo.Producto;
import com.coffecheap.modelo.Proveedor;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class Proveedor_productosBean 
{

     static public void addMessage(String summary) {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
    FacesContext.getCurrentInstance().addMessage(null, message);
  }
     
  private Proveedor_productos proveedor_productos = new Proveedor_productos();
  private List<Proveedor_productos> lstProveedor_productos = new ArrayList();
  private List<Producto> lstProducto = new ArrayList();
  private List<Proveedor> lstProveedor= new ArrayList();

    public List<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

    public List<Proveedor> getLstProveedor() {
        return lstProveedor;
    }

    public void setLstProveedor(List<Proveedor> lstProveedor) {
        this.lstProveedor = lstProveedor;
    }

  
  
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

  public void registrar() 
  {
    Proveedor_productosDao dao;
    try 
    {
      dao = new Proveedor_productosDao();
      dao.registrar(proveedor_productos);
    } catch (Exception e) {
      System.out.println(e);
    }

  }
  
   public void fila(Proveedor_productos prod) 
  {
    Proveedor_productosDao dao;
    Proveedor_productos temp;
    System.out.println("el id del proveedor "+prod.getProveedor().getId_proveedor());
      System.out.println("el proveedor "+prod.getProveedor().getNombre());
      System.out.println("el id del producto "+prod.getProducto().getId_producto());
      System.out.println("el producto "+prod.getProducto().getNombre());
      System.out.println("el precio "+prod.getPrecio());
      
    try 
    {
      dao = new Proveedor_productosDao();
      temp = dao.leerFila(prod);
      if(temp !=null)
      {
          this.proveedor_productos= temp;
      }
      
    } catch (Exception e) 
    {
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

  public void listarProducto() throws Exception {
    Proveedor_productosDao dao;

    try {
      dao = new Proveedor_productosDao();
      lstProducto = dao.listarProducto();
    } catch (Exception e) {
      throw e;
    }

  }
  
  
  public void listarProveedor() throws Exception {
    Proveedor_productosDao dao;

    try {
      dao = new Proveedor_productosDao();
      lstProveedor = dao.listarProveedor();
    } catch (Exception e) {
      throw e;
    }

  }
  
 
  
  public void modificar() throws Exception 
  {
    Proveedor_productosDao dao;
    try 
    {
      dao = new Proveedor_productosDao();
      dao.modificar(proveedor_productos);
    } catch (Exception e) 
    {
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
