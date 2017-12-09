/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;


import com.coffecheap.dao.PlatoDao;
import com.coffecheap.modelo.Plato;
import com.coffecheap.modelo.Tipo_plato;
import java.util.List;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;



/**
 *
 * @author medev
 */
@Named(value = "platoBean")
@ManagedBean
@ViewScoped
public class PlatoBean 
{
    static public void addMessage(String summary) {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
    FacesContext.getCurrentInstance().addMessage(null, message);
  }
private Plato plato = new Plato();
private List<Plato>lstPlato;
List<Tipo_plato> lstTPlato = new ArrayList();

    public List<Tipo_plato> getLstTPlato() {
        return lstTPlato;
    }

    public void setLstTPlato(List<Tipo_plato> lstTPlato) {
        this.lstTPlato = lstTPlato;
    }

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

    public void listarTPlatp() throws Exception {
    PlatoDao dao;

    try {
      dao = new PlatoDao();
      lstTPlato = dao.listarTipoPlato();
    } catch (Exception e) {
      throw e;
    }

  }
  
  public void modificar(Plato plat) throws Exception {
    System.out.println("*******************************************************Modificar");
    PlatoDao dao;

    try {
      dao = new PlatoDao();
      dao.modificar(plat);

    } catch (Exception e) {
      throw e;
    }

  }


  public void eliminar(Plato plat) throws Exception {
    System.out.println("*******************************************************eliminar");
    PlatoDao dao;

    try {
      dao = new PlatoDao();
      dao.eliminar(plat);

    } catch (Exception e) {
      throw e;
    }

  }
    
    
}
