package com.coffecheap.bean;

/**
 *
 * @tiphor acier
 */

import com.coffecheap.modelo.Pedido;
import com.coffecheap.dao.Pedido_MostrarDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Pedido_Mostrar_Bean {

  private Pedido pedido = new Pedido();
  private static List<Pedido> lstPedido;

  public List<Pedido> getLstPedido() {
    return lstPedido;
  }

  public void setLstPedido(List<Pedido> lstPedido) {
    this.lstPedido = lstPedido;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

   
  /*public void listar() throws Exception {
    Pedido_MostrarDao dao;

    try {
      dao = new Pedido_MostrarDao();
      lstPedido = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }*/



 
}
