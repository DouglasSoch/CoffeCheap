/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acier
 */
public class UsuarioDao extends Dao {

  public void registrar(Usuario Tt) throws Exception {

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into usuario values(?,?,?,?,?,?,?,?);");

      st.setInt(1, Tt.getId());
      st.setString(2, Tt.getUsuario());
      st.setString(3, Tt.getPass());
      st.setInt(4, Tt.getTipo().getId());
      st.setString(5, Tt.getNombre());
      st.setString(6, Tt.getApellido());
      st.setInt(7, Tt.getCodigo());
      st.setInt(8, Tt.getTurno().getId_turno());
      
      
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public List<Usuario> listar() throws Exception {
    List<Usuario> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM usuario");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Usuario tt = new Usuario();

        tt.setId(rs.getInt(1));
        tt.setNit(rs.getString(2));
        tt.setPass(rs.getString(3));
        tt.getTipo().setId(rs.getInt(4));
        tt.setNombre(rs.getString(5));
        tt.setApellido(rs.getString(6));
        tt.setCodigo(rs.getInt(7));
        tt.getTurno().setId_turno(rs.getInt(8));   

        lista.add(tt);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }
  
   public List<Usuario> listarMe() throws Exception {
    List<Usuario> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM usuario WHERE tipouser=3");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Usuario tt = new Usuario();

        tt.setId(rs.getInt(1));
        tt.setNit(rs.getString(2));
        tt.setPass(rs.getString(3));
        tt.getTipo().setId(rs.getInt(4));
        tt.setNombre(rs.getString(5));
        tt.setApellido(rs.getString(6));
        tt.setCodigo(rs.getInt(7));
        tt.getTurno().setId_turno(rs.getInt(8));   

        lista.add(tt);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }
  
  public List<Usuario> listarChef() throws Exception {
    List<Usuario> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM usuario WHERE tipouser=4");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Usuario tt = new Usuario();

        tt.setId(rs.getInt(1));
        tt.setNit(rs.getString(2));
        tt.setPass(rs.getString(3));
        tt.getTipo().setId(rs.getInt(4));
        tt.setNombre(rs.getString(5));
        tt.setApellido(rs.getString(6));
        tt.setCodigo(rs.getInt(7));
        tt.getTurno().setId_turno(rs.getInt(8));   

        lista.add(tt);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }
  

  public void modificar(Usuario Tt) throws Exception {
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE usuario SET iduser=?, user=?, pass=?, tipouser=?, nombre=?, apellido=?, codigo=?, idturno=?, telefono=?, direccion=?, dpi=?, nit=?, correo=? WHERE iduser=?;");

      st.setInt(1, Tt.getId());
      st.setString(2, Tt.getUsuario());
      st.setString(3, Tt.getPass());
      st.setInt(4, Tt.getTipo().getId());
      st.setString(5, Tt.getNombre());
      st.setString(6, Tt.getApellido());
      st.setInt(7, Tt.getCodigo());
      st.setInt(8, Tt.getTurno().getId_turno());
      st.setInt(9, Tt.getId());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public void eliminar(Usuario pac) throws Exception {
    System.out.println("*******************************************************eliminar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM usuario WHERE iduser=?;");
      st.setInt(1, pac.getId());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

}
