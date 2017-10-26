/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this ttiplate file, choose Tools | Ttiplates
 * and open the ttiplate in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.modelo.Pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acier
 */
public class Pedido_MostrarDao extends Dao {

  public List<Pedido> listar() throws Exception {
    List<Pedido> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT * FROM pedido;");

      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Pedido Emp = new Pedido();
        //Emp.setCodigo(rs.getInt(1));
        //Emp.setNombre(rs.getString(2));

        lista.add(Emp);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }

}
