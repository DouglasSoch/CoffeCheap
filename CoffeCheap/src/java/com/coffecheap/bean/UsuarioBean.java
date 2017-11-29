package com.coffecheap.bean;

/**
 *
 * @marhor acier
 */

import com.coffecheap.modelo.Usuario;
import com.coffecheap.dao.UsuarioDao;
import com.coffecheap.modelo.Tipo;
import com.coffecheap.modelo.Turno;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UsuarioBean {

  private Usuario usuario = new Usuario();
  private List<Usuario> lstUsuario;
   private List<Tipo> lstTipo;
     private List<Turno> lstTurno;

    public List<Tipo> getLstTipo() {
        return lstTipo;
    }

    public void setLstTipo(List<Tipo> lstTipo) {
        this.lstTipo = lstTipo;
    }

    public List<Turno> getLstTurno() {
        return lstTurno;
    }

    public void setLstTurno(List<Turno> lstTurno) {
        this.lstTurno = lstTurno;
    }

     
     
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
  
    public void listarTipo() throws Exception 
  {
    UsuarioDao dao;

    try {
      dao = new UsuarioDao();
      lstTipo = dao.listarTipo();
    } catch (Exception e) {
      throw e;
    }

  }
    
      public void listarTurno() throws Exception 
  {
    UsuarioDao dao;

    try {
      dao = new UsuarioDao();
      lstTurno = dao.listarTurno();
    } catch (Exception e) {
      throw e;
    }

  }
  
  public void buscarr() throws Exception 
  {
       
    UsuarioDao dao;
    Usuario temp;
        
    try {
      dao = new UsuarioDao();
      temp = dao.leerParaModificar(usuario);

      if (usuario != null) {
        this. usuario= temp;
      }

    } catch (Exception e) {
      throw e;
      
    }
  }

  public void modificar() throws Exception 
  {
    UsuarioDao dao;

    try {
      dao = new UsuarioDao();
      dao.modificar(usuario);

    } catch (Exception e) {
      throw e;
    }

  }

  public void eliminar() throws Exception 
  {
    UsuarioDao dao;

    try {
      dao = new UsuarioDao();
      dao.eliminar(usuario);

    } catch (Exception e) {
      throw e;
    }

  }

}
