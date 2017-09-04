/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.modelo.Estado_mesa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acier
 */
public class Estado_mesaDao extends Dao {

  public void registrar(Estado_mesa Tt) throws Exception {

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into estado_mesa values(?,?);");

      st.setInt(1, Tt.getId_estado());
      st.setString(2, Tt.getNombre());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public List<Estado_mesa> listar() throws Exception {
    List<Estado_mesa> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM estado_mesa");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Estado_mesa tt = new Estado_mesa();

        tt.setId_estado(rs.getInt(1));
        tt.setNombre(rs.getString(2));

        lista.add(tt);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }

  public void modificar(Estado_mesa tt) throws Exception {
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE  estado_mesa SET id_estado_mesa=?, nombre=? WHERE id_estado=?;");

      st.setInt(1, tt.getId_estado());
      st.setString(2, tt.getNombre());
      st.setInt(3, tt.getId_estado());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public void eliminar(Estado_mesa pac) throws Exception {
    System.out.println("*******************************************************eliminar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM estado_mesa WHERE id_estado=?;");
      st.setInt(1, pac.getId_estado());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

}
