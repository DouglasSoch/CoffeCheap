/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.modelo.Orden_compras;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acier
 */
public class Orden_comprasDao extends Dao {

  public void registrar(Orden_compras Tt) throws Exception {

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into orden_compras values(?,?,?,?,?);");

      st.setInt(1, Tt.getId_orden_compras());
      st.setDate(2, Tt.getFecha_orden());
      st.setDate(3, Tt.getFecha_entrega());
      st.setInt(4, Tt.getPproductos().getProducto().getId_producto());
      
      
     st.setInt(4, Tt.getReserva().getId_reserva());
     st.setInt(5, Tt.getCliente().getId_cliente());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public List<Orden_compras> listar() throws Exception {
    List<Orden_compras> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM orden_compras");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Orden_compras tt = new Orden_compras();

        tt.setId_orden_compras(rs.getInt(1));
        tt.setCantidad_comensales(rs.getInt(2));
        tt.setUbicacion(rs.getString(3));
        tt.getReserva().setId_reserva(rs.getInt(4));
        tt.getCliente().setId_cliente(rs.getInt(5));
        lista.add(tt);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }

  public void modificar(Orden_compras tt) throws Exception {
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE  orden_compras SET id_Orden_compras=?, cantidad_Comensales=?, Ubicacion=?, id_reserva=?, id_cliente=? WHERE id_Orden_compras=?;");

      st.setInt(1, tt.getId_orden_compras());
      st.setInt(2, tt.getCantidad_comensales());
      st.setString(3, tt.getUbicacion());
      st.setInt(4, tt.getReserva().getId_reserva());
      st.setInt(5, tt.getCliente().getId_cliente());
      
      st.setInt(6, tt.getId_orden_compras());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public void eliminar(Orden_compras pac) throws Exception {
    System.out.println("*******************************************************eliminar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM orden_compras WHERE id_Orden_compras=?;");
      st.setInt(1, pac.getId_orden_compras());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

}
