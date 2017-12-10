/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;


import com.coffecheap.bean.Plato_pedidoBean;
import com.coffecheap.modelo.Plato_pedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author medev
 */
public class Plato_pedidoDao extends Dao{
    public void registrar(Plato_pedido ppedido) throws Exception {

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into plato_pedido(id_plato,cantidad,id_personal,id_pedido,precio) values(?,?,?,?,?)");
      st.setInt(1, ppedido.getPlato().getId_plato());
      st.setInt(2, ppedido.getCantidad());
      st.setInt(3, ppedido.getUsuario().getId());
      st.setInt(4, ppedido.getPedido().getId_pedido());
      st.setDouble(5, ppedido.getPrecio());
      st.executeUpdate();
      Plato_pedidoBean.addMessage("Accion Completada");
    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public List<Plato_pedido> listar() throws Exception {
    List<Plato_pedido> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("select id_plato_pedido,id_plato,cantidad,id_personal,id_pedido,precio  from plato_pedido");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Plato_pedido ppedido = new Plato_pedido();

        ppedido.setId_plato_pedido(rs.getInt(1));
        ppedido.getPlato().setId_plato(rs.getInt(2));
        ppedido.setCantidad(rs.getInt(3));
        ppedido.getUsuario().setId(rs.getInt(4));
        ppedido.getPedido().setId_pedido(rs.getInt(5));
        ppedido.setPrecio(rs.getDouble(6));  
        lista.add(ppedido);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }

  public void modificar(Plato_pedido ppedido) throws Exception {
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE  plato_pedido SET id_plato_pedido=?, id_plato=?, cantidad=?, id_personal=?, id_pedido=?, precio=? WHERE id_plato_pedido=?;");

      st.setInt(1, ppedido.getId_plato_pedido());
      st.setInt(2, ppedido.getPlato().getId_plato());
      st.setInt(3, ppedido.getCantidad());
      st.setInt(4, ppedido.getUsuario().getId());    
      st.setInt(5, ppedido.getPedido().getId_pedido());
      st.setDouble(6, ppedido.getPrecio());
      st.setInt(7, ppedido.getId_plato_pedido());
     
      st.executeUpdate();


    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public void eliminar(Plato_pedido ppedido) throws Exception {
    System.out.println("*******************************************************eliminar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM plato_pedido WHERE id_plato_pedido=?;");
      st.setInt(1, ppedido.getId_plato_pedido());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }
}
