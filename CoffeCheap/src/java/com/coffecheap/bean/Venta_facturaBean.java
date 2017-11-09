package com.coffecheap.bean;

/**
 *
 * @marhor acier
 */
import com.coffecheap.dao.Control_mesaDao;
import com.coffecheap.modelo.Venta_factura;
import com.coffecheap.dao.Venta_facturaDao;
import com.coffecheap.modelo.Control_mesa;
import com.coffecheap.modelo.Proveedor_productos;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Venta_facturaBean {

  private Venta_factura venta_factura = new Venta_factura();
  private List<Venta_factura> lstVenta_factura;
  List<Proveedor_productos> lstProveedor_productos;

  public List<Proveedor_productos> getLstProveedor_productos() {
    return lstProveedor_productos;
  }

  public void setLstProveedor_productos(List<Proveedor_productos> lstProveedor_productos) {
    this.lstProveedor_productos = lstProveedor_productos;
  }

  public Venta_factura getVenta_factura() {
    return venta_factura;
  }

  public void setVenta_factura(Venta_factura venta_factura) {
    this.venta_factura = venta_factura;
  }

  public List<Venta_factura> getLstVenta_factura() {
    return lstVenta_factura;
  }

  public void setLstVenta_factura(List<Venta_factura> lstVenta_factura) {
    this.lstVenta_factura = lstVenta_factura;
  }

  public void registrar() {

    System.out.println("*******************************************************registrar");

    Venta_facturaDao dao;

    try {

      String formateador = new SimpleDateFormat("yyyy-MM-dd").format(venta_factura.getFecha_emision());

      venta_factura.setTemp_fecha_emision(formateador);

      dao = new Venta_facturaDao();
      dao.registrar(venta_factura);

    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void Mostrar() throws Exception {
    Venta_facturaDao dao;

    try {
      dao = new Venta_facturaDao();
      lstVenta_factura = dao.listar();
    } catch (Exception e) {
      throw e;
    }
  }

  public void modificar(Venta_factura mar) throws Exception {
    System.out.println("*******************************************************Modificar");
    Venta_facturaDao dao;

    try {
      dao = new Venta_facturaDao();
      dao.modificar(mar);

    } catch (Exception e) {
      throw e;
    }
  }

  public void eliminar(Venta_factura mar) throws Exception {
    System.out.println("*******************************************************eliminar");
    Venta_facturaDao dao;

    try {
      dao = new Venta_facturaDao();
      dao.eliminar(mar);

    } catch (Exception e) {
      throw e;
    }
  }

  public void registrar_venta(int mesa) {

    venta_factura.setEstadoFactura(true);
    
    System.out.println("*******************************************************registrar");

    Venta_facturaDao dao;
    Control_mesaDao dao2;

    try {

      dao = new Venta_facturaDao();
      dao.registrar_venta(venta_factura, mesa);

    } catch (Exception e) {
      System.out.println(e);
    }

  }
  
    public boolean controlGenerarFactura(int mesa) {

    boolean estado=false;
    
    System.out.println("*******************************************************registrar");
    Venta_facturaDao dao;
    

    try {

      dao = new Venta_facturaDao();
      estado=dao.controlGenerarFactura(venta_factura, mesa);

    } catch (Exception e) {
      System.out.println(e);
    }
    return estado;
  }

}
