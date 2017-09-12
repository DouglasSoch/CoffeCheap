/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;

import com.coffecheap.dao.RecetaDao;
import com.coffecheap.modelo.Receta;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author medev
 */
@ManagedBean
@ViewScoped
public class RecetaBean {
private Receta receta = new Receta();
private List<Receta>lstReceta;

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public List<Receta> getLstReceta() {
        return lstReceta;
    }

    public void setLstReceta(List<Receta> lstReceta) {
        this.lstReceta = lstReceta;
    }
    
    public void registrar() {

    System.out.println("*******************************************************registrar");

    RecetaDao dao ;

    try {
      dao = new RecetaDao();
      dao.registrar(receta);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void listar() throws Exception {
    RecetaDao dao;

    try {
      dao = new RecetaDao();
      lstReceta = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }

  public void modificar(Receta receta) throws Exception {
    System.out.println("*******************************************************Modificar");
    RecetaDao dao;

    try {
      dao = new RecetaDao();
      dao.modificar(receta);

    } catch (Exception e) {
      throw e;
    }

  }


  public void eliminar(Receta receta) throws Exception {
    System.out.println("*******************************************************eliminar");
    RecetaDao dao;

    try {
      dao = new RecetaDao();
      dao.eliminar(receta);

    } catch (Exception e) {
      throw e;
    }

  }
}
