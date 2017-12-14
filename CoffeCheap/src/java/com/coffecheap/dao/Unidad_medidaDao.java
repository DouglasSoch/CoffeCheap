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
 * @author Bryan
 */
public class Unidad_medidaDao extends Dao {
/**
 * Metodo para registrar una medida de unidad
 * @param Tt
 * @throws Exception 
 */

  public void registrar(Unidad_medida Tt) throws Exception {

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("INSERT INTO coffechip.unidad_medida (id_unidad, nombre) VALUES (?, ?);");

      st.setInt(1, Tt.getId_unidad());
      st.setString(2, Tt.getNombre());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }
/**
 * Metodo para listar las unidades de medidas
 * @return
 * @throws Exception 
 */
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
/**
 * Metodo para modificar una unidad de medidia
 * @param tt
 * @throws Exception 
 */
  public void modificar(Unidad_medida tt) throws Exception 
  {
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE unidad_medida SET id_unidad=?, nombre=? WHERE id_unidad=?;");

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
/**
 * Metodo para eliminar un registro de unidad de medida
 * @param pac
 * @throws Exception 
 */
  public void eliminar(Unidad_medida pac) throws Exception 
  {
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM unidad_medida WHERE id_unidad=?;");
      st.setInt(1, pac.getId_unidad());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

}
