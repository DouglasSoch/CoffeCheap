/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.bean.MesaBean;
import com.coffecheap.modelo.Control_mesa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acier
 */
public class Control_mesaDao extends Dao {

  public void registrar(Control_mesa Tt) throws Exception {

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into control_mesa values(?,?);");

      //st.setInt(1, Tt.getId_tipo());
      //st.setString(2, Tt.getNombre());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public List<Control_mesa> listarMesaOcupadas() throws Exception {
    List<Control_mesa> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM control_mesa");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Control_mesa tt = new Control_mesa();

        //  tt.setId_tipo(rs.getInt(1));
        //  tt.setNombre(rs.getString(2));
        lista.add(tt);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }

  public int tamaño() throws Exception {
    int numero = 0;
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("select count(*)from mesa");
      ResultSet n = st.executeQuery();

      if (n.next()) {
        numero = n.getInt(1);
      }
    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return numero;
  }

  public void eliminar(Control_mesa pac) throws Exception {
    System.out.println("*******************************************************eliminar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM control_mesa WHERE id_control_mesa=?;");
      //st.setInt(1, pac.getId_tipo());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public void CamBioEstado(int bus) throws Exception {

    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE  mesa SET id_estado=? WHERE id_mesa=?;");

      st.setInt(1, 3);
      st.setInt(2, bus);

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public boolean pago(int mesa) throws Exception {
    int pago;
    boolean estado = false;
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("SELECT mesa.id_mesa, pedido.cancelado from mesa inner join pedido on (mesa.id_mesa=pedido.id_mesa) WHERE mesa.id_mesa=? and pedido.id_pedido=3;");
      st.setInt(1, mesa);
      ResultSet n = st.executeQuery();
      if (n.next()) {
        pago = n.getInt(1);

        if (pago == 1) {
          estado = true;
        } 
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }
    return estado;
  }

}
