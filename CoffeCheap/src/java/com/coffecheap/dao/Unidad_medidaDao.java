/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.modelo.Unidad_medida;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acier
 */
public class Unidad_medidaDao extends Dao {

  public void registrar(Unidad_medida Tt) throws Exception {

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into unidad_medida values(?,?);");

      st.setInt(1, Tt.getId_unidad());
      st.setString(2, Tt.getNombre());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public List<Unidad_medida> listar() throws Exception {
    List<Unidad_medida> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM unidad_medida");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Unidad_medida tt = new Unidad_medida();

        tt.setId_unidad(rs.getInt(1));
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

  public void modificar(Unidad_medida tt) throws Exception {
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE  unidad_medida SET id_unidad_medida=?, nombre_trasaccion=? WHERE id_unidad_medida=?;");

      st.setInt(1, tt.getId_unidad());
      st.setString(2, tt.getNombre());
      st.setInt(3, tt.getId_unidad());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public void eliminar(Unidad_medida pac) throws Exception {
    System.out.println("*******************************************************eliminar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM unidad_medida WHERE id_unidad_medida=?;");
      st.setInt(1, pac.getId_unidad());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

}
