/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.modelo.Tipo_transacciones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acier
 */
public class Tipo_transaccionesDao extends Dao {

  public void registrar(Tipo_transacciones Tt) throws Exception {

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into tipo_transacciones values(?,?);");

      st.setInt(1, Tt.getId_tipo_transacciones());
      st.setString(2, Tt.getNombre());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public List<Tipo_transacciones> listar() throws Exception {
    List<Tipo_transacciones> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM tipo_transacciones");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Tipo_transacciones tt = new Tipo_transacciones();

        tt.setId_tipo_transacciones(rs.getInt(1));
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

  public void modificar(Tipo_transacciones tt) throws Exception {
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE  tipo_transacciones SET id_tipo_transacciones=?, nombre_trasaccion=? WHERE id_tipo_transacciones=?;");

      st.setInt(1, tt.getId_tipo_transacciones());
      st.setString(2, tt.getNombre());
      st.setInt(3, tt.getId_tipo_transacciones());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public void eliminar(Tipo_transacciones pac) throws Exception {
    System.out.println("*******************************************************eliminar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM tipo_transacciones WHERE id_tipo_transacciones=?;");
      st.setInt(1, pac.getId_tipo_transacciones());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

}
