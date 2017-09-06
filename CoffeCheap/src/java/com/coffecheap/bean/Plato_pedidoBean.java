/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;

import com.coffecheap.dao.Plato_pedidoDao;
import com.coffecheap.modelo.Plato_pedido;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@Named(value = "plato_pedidoBean")
@ManagedBean
@ViewScoped
public class Plato_pedidoBean {
    private Plato_pedido plapedido = new Plato_pedido();
    private List<Plato_pedido>lstPlapedido;

    public Plato_pedido getPlapedido() {
        return plapedido;
    }

    public void setPlapedido(Plato_pedido plapedido) {
        this.plapedido = plapedido;
    }

    public List<Plato_pedido> getLstPlapedido() {
        return lstPlapedido;
    }

    public void setLstPlapedido(List<Plato_pedido> lstPlapedido) {
        this.lstPlapedido = lstPlapedido;
    }
    
    public void registrar() {

    System.out.println("*******************************************************registrar");

    Plato_pedidoDao dao;

    try {
      dao = new Plato_pedidoDao();
      dao.registrar(plapedido);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void listar() throws Exception {
    Plato_pedidoDao dao;

    try {
      dao = new Plato_pedidoDao();
      lstPlapedido = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }

  public void modificar(Plato_pedido plapedido) throws Exception {
    System.out.println("*******************************************************Modificar");
    Plato_pedidoDao dao;

    try {
      dao = new Plato_pedidoDao();
      dao.modificar(plapedido);

    } catch (Exception e) {
      throw e;
    }

  }


  public void eliminar(Plato_pedido plapedido) throws Exception {
    System.out.println("*******************************************************eliminar");
    Plato_pedidoDao dao;

    try {
      dao = new Plato_pedidoDao();
      dao.eliminar(plapedido);

    } catch (Exception e) {
      throw e;
    }

  }
    
}
