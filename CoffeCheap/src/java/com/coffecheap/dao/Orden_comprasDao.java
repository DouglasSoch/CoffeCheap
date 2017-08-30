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
      st.setInt(4, Tt.getCantidad());    
      st.setInt(5, Tt.getPproductos().getProducto().getId_producto());   
      st.setInt(6, Tt.getPproductos().getId_proveedor());   

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
        tt.setFecha_orden(rs.getDate(2));
        tt.setFecha_entrega(rs.getDate(3));
        tt.getPproductos().getProducto().setId_producto(rs.getInt(4));
        tt.getPproductos().setId_proveedor(rs.getInt(5));
        tt.setPrecio(rs.getDouble(6));
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
      st.setDate(2, tt.getFecha_orden());
      st.setDate(3, tt.getFecha_entrega());
      st.setInt(4, tt.getCantidad());    
      st.setInt(5, tt.getPproductos().getProducto().getId_producto());   
      st.setInt(6, tt.getPproductos().getId_proveedor()); 
      st.setInt(7, tt.getId_orden_compras());
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
