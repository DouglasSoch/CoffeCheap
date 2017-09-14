/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class PedidoDao extends Dao {

  public void registrar(Pedido Tt) throws Exception {

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into pedido values(?,?);");

      st.setInt(1, Tt.getId_pedido());
      st.setInt(2, Tt.getMesa().getId_mesa());
      st.setTime(3, Tt.getHora());
      st.setInt(4, Tt.getUsuario().getId());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public List<Pedido> listar() throws Exception {
    List<Pedido> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM pedido");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Pedido tt = new Pedido();

        tt.setId_pedido(rs.getInt(1));
        tt.getMesa().setId_mesa(rs.getInt(2));
        tt.setHora(rs.getTime(3));
        tt.getUsuario().setId(rs.getInt(4));

        lista.add(tt);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }

  public void modificar(Pedido Tt) throws Exception {
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE  pedido SET id_pedido=?, id_mesa=?, hora=?, id_personal=? WHERE id_pedido=?;");

      st.setInt(1, Tt.getId_pedido());
      st.setInt(2, Tt.getMesa().getId_mesa());
      st.setTime(3, Tt.getHora());
      st.setInt(4, Tt.getUsuario().getId());
      st.setInt(5, Tt.getId_pedido());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public void eliminar(Pedido pac) throws Exception {
    System.out.println("*******************************************************eliminar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM pedido WHERE id_pedido=?;");
      st.setInt(1, pac.getId_pedido());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

}
