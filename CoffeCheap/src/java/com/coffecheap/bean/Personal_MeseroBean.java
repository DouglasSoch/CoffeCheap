/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;

import com.coffecheap.dao.Personal_MeseroDao;
import com.coffecheap.modelo.Usuario;
import java.util.List;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author medev
 */
@Named(value = "personal_MeseroBean")
@ManagedBean
@ViewScoped
public class Personal_MeseroBean {
    private Usuario permes = new Usuario();
    private List<Usuario>lstPermes;

    public Usuario getPermes() {
        return permes;
    }

    public void setPermes(Usuario permes) {
        this.permes = permes;
    }

    public List<Usuario> getLstPermes() {
        return lstPermes;
    }

    public void setLstPermes(List<Usuario> lstPermes) {
        this.lstPermes = lstPermes;
    }
 
    public void registrar() {

    System.out.println("*******************************************************registrar");

    Personal_MeseroDao dao;

    try {
      dao = new Personal_MeseroDao();
      dao.registrar(permes);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public void listar() throws Exception {
    Personal_MeseroDao dao;

    try {
      dao = new Personal_MeseroDao();
      lstPermes = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }

  public void modificar(Usuario permes) throws Exception {
    System.out.println("*******************************************************Modificar");
    Personal_MeseroDao dao;

    try {
      dao = new Personal_MeseroDao();
      dao.modificar(permes);

    } catch (Exception e) {
      throw e;
    }

  }


  public void eliminar(Usuario permes) throws Exception {
    System.out.println("*******************************************************eliminar");
    Personal_MeseroDao dao;

    try {
      dao = new Personal_MeseroDao();
      dao.eliminar(permes);

    } catch (Exception e) {
      throw e;
    }

  }
    
}
