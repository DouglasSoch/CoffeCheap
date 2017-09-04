/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;


import com.coffecheap.dao.PlatoDao;
import com.coffecheap.modelo.Plato;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author medev
 */
@Named(value = "platoBean")
@RequestScoped
public class PlatoBean {
private Plato plato = new Plato();
private List<Plato>lstPlato;

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public List<Plato> getLstPlato() {
        return lstPlato;
    }

    public void setLstPlato(List<Plato> lstPlato) {
        this.lstPlato = lstPlato;
    }




    public void registrar() {

    System.out.println("*******************************************************registrar");

    PlatoDao dao;

    try {
      dao = new PlatoDao();
      dao.registrar(plato);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void listar() throws Exception {
    PlatoDao dao;

    try {
      dao = new PlatoDao();
      lstPlato = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }

  public void modificar(Plato plato) throws Exception {
    System.out.println("*******************************************************Modificar");
    PlatoDao dao;

    try {
      dao = new PlatoDao();
      dao.modificar(plato);

    } catch (Exception e) {
      throw e;
    }

  }


  public void eliminar(Plato plato) throws Exception {
    System.out.println("*******************************************************eliminar");
    PlatoDao dao;

    try {
      dao = new PlatoDao();
      dao.eliminar(plato);

    } catch (Exception e) {
      throw e;
    }

  }
    
    
}
