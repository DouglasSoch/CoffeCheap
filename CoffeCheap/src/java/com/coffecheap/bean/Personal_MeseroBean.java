/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.bean;

import com.coffecheap.dao.Personal_MeseroDao;
import com.coffecheap.modelo.Personal_mesero;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author medev
 */
@Named(value = "personal_MeseroBean")
@RequestScoped
public class Personal_MeseroBean {
    private Personal_mesero permes = new Personal_mesero();
    private List<Personal_mesero>lstPermes;

    public Personal_mesero getPermes() {
        return permes;
    }

    public void setPermes(Personal_mesero permes) {
        this.permes = permes;
    }

    public List<Personal_mesero> getLstPermes() {
        return lstPermes;
    }

    public void setLstPermes(List<Personal_mesero> lstPermes) {
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

  public void modificar(Personal_mesero permes) throws Exception {
    System.out.println("*******************************************************Modificar");
    Personal_MeseroDao dao;

    try {
      dao = new Personal_MeseroDao();
      dao.modificar(permes);

    } catch (Exception e) {
      throw e;
    }

  }


  public void eliminar(Personal_mesero permes) throws Exception {
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
