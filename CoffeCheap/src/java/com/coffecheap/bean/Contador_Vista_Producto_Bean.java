/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;


import com.coffecheap.dao.Contador_Vista_Producto_Dao;
import com.coffecheap.dao.Dao;
import java.util.List;

import com.coffecheap.modelo.Producto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Contador_Vista_Producto_Bean extends Dao {
    Producto producto = new Producto();
    List<Producto> lista;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> lista) {
        this.lista = lista;
    }
    
    
    public void Mostrar() throws Exception {

    Contador_Vista_Producto_Dao dao;
    try {
      dao = new Contador_Vista_Producto_Dao();
      lista = dao.Listar();      
    } catch (Exception e) {
      throw e;
    }
  }
}
