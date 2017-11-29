package com.coffecheap.bean;

/**
 *
 * @marhor acier
 */

import com.coffecheap.modelo.Usuario;
import com.coffecheap.dao.UsuarioDao;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UsuarioBean {

  private Usuario usuario = new Usuario();
  private List<Usuario> lstUsuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLstUsuario() {
        return lstUsuario;
    }

    public void setLstUsuario(List<Usuario> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }
 
  public void registrar() 
  {
    UsuarioDao dao;

    try {
      dao = new UsuarioDao();
      dao.registrar(usuario);
    } catch (Exception e) {
      System.out.println(e);
    }

  }

         public void mostarPorParametro() throws Exception 
  {
    UsuarioDao dao;

    try {
      dao = new UsuarioDao();
      lstUsuario = dao.listarPorParametro(usuario);
    } catch (Exception e) {
      throw e;
    }

  }
  public void listar() throws Exception 
  {
    UsuarioDao dao;

    try {
      dao = new UsuarioDao();
      lstUsuario = dao.listar();
    } catch (Exception e) {
      throw e;
    }

  }
  

  public void modificar(Usuario mar) throws Exception 
  {
    UsuarioDao dao;

    try {
      dao = new UsuarioDao();
      dao.modificar(mar);

    } catch (Exception e) {
      throw e;
    }

  }

  public void eliminar(Usuario mar) throws Exception {
    System.out.println("*******************************************************eliminar");
    UsuarioDao dao;

    try {
      dao = new UsuarioDao();
      dao.eliminar(mar);

    } catch (Exception e) {
      throw e;
    }

  }

}
