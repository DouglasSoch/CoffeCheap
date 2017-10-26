package com.coffecheap.bean;

import com.coffecheap.dao.CompraDao;
import com.coffecheap.dao.Dao;
import java.util.List;
import com.coffecheap.modelo.Compra;
import com.coffecheap.modelo.Producto;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CompraBean extends Dao {

  Compra compra = new Compra();
  List<Compra> lista;
  ArrayList<Compra> intermedio = new ArrayList<Compra>();
  int i;
  int producto;

  public ArrayList<Compra> getIntermedio() {
    return intermedio;
  }

  public void setIntermedio(ArrayList<Compra> intermedio) {
    this.intermedio = intermedio;
  }

  public List<Compra> getLista() {
    return lista;
  }

  public void setLista(List<Compra> lista) {
    this.lista = lista;
  }

  public Compra getCompra() {
    return compra;
  }

  public void setCompra(Compra compra) {
    this.compra = compra;
  }

  public CompraBean() {
  }

  public void Intermedio() throws Exception {

    i = i + 1;
    intermedio.add(new Compra(i, compra.getOcompras().getId_orden_compras(), compra.getProducto().getId_producto(),
        compra.getCantidad(), compra.getCosto(), compra.getNo_fac(), compra.getSerie(), compra.getFechaEntrega()));

    compra.getOcompras().setId_orden_compras(0);
    compra.getProducto().setId_producto(0);
    compra.setCantidad(0);
    compra.setCosto(0);
    compra.setFechaEntrega(null);
    compra.setNo_fac(0);
    compra.setSerie(null);

  }

  public void Ingresar() {
    CompraDao dao;
    try {
      dao = new CompraDao();
      for (int j = 0; j < intermedio.size(); j++) {

        int orden = intermedio.get(j).getOcompras().getId_orden_compras();
        int producto = intermedio.get(j).getProducto().getId_producto();
        int cantidad = intermedio.get(j).getCantidad();
        int costo = intermedio.get(j).getCosto();
        int factura = intermedio.get(j).getNo_fac();
        String serie = intermedio.get(j).getSerie();
        String dia = intermedio.get(j).getFechaEntrega().substring(0, 2);
        String mes = intermedio.get(j).getFechaEntrega().substring(3, 5);
        String anio = intermedio.get(j).getFechaEntrega().substring(6, 10);
        String fecha = anio + "-" + mes + "-" + dia;
        dao.Insertar(orden, producto, cantidad, costo, factura, serie, fecha);
        int productointer = dao.Operacion(intermedio.get(j).getProducto().getId_producto());
        int suma = productointer + cantidad;
        dao.ActualizacionProductos(intermedio.get(j).getProducto().getId_producto(), suma);

      }

      intermedio.clear();

    } catch (Exception e) {
      try {
        throw e;
      } catch (Exception ex) {
        Logger.getLogger(CompraBean.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  public void Eliminar() throws Exception {

    CompraDao dao;

    try {
      dao = new CompraDao();
      dao.Eliminar(compra);
    } catch (Exception e) {
      throw e;
    }
  }

  public void Modificar() throws Exception {

    CompraDao dao;
    producto = compra.getProducto().getId_producto();
    try {
      dao = new CompraDao();
      dao.Modificar(compra);
      List<String> listado = new ArrayList();
      listado = dao.CodigodeProducto();
      for (int j = 0; j < listado.size(); j++) {
        int cantidad = dao.Cantidad(Integer.parseInt(listado.get(j)));
        dao.ActualizarCantidad(cantidad, Integer.parseInt(listado.get(j)));
//        System.out.println("productos: " + listado.get(j));
      }

    } catch (Exception e) {
      throw e;
    }

  }

  public void Mostrar() throws Exception {

    CompraDao dao;
    try {
      dao = new CompraDao();
      lista = dao.Mostrar();

    } catch (Exception e) {
      throw e;
    }
  }
}
