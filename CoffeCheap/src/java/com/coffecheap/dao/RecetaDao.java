/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.modelo.Receta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author medev
 */
public class RecetaDao extends Dao{
    public void registrar(Receta receta) throws Exception {

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into receta values(?,?,?,?);");
      st.setInt(1, receta.getPlato().getId_plato());
      st.setInt(2, receta.getProducto().getId_producto());
      st.setInt(3, receta.getCantidad());
      st.setInt(4, receta.getUmedida().getId_unidad());    
      
        

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public List<Receta> listar() throws Exception {
    List<Receta> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM receta;");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Receta receta = new Receta();

        receta.getPlato().setId_plato(rs.getInt("id_plato"));
        receta.getProducto().setId_producto(rs.getInt("id_producto"));
        receta.setCantidad(rs.getInt("cantidad"));
        receta.getUmedida().setId_unidad(rs.getInt("id_unidad"));
        
        
        
        
        
        lista.add(receta);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }

  public void modificar(Receta receta) throws Exception {
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE receta SET id_plato=?, id_producto=?, cantidad=?, id_unidad=? WHERE id_plato=? and id_producto=?;");

      st.setInt(1, receta.getPlato().getId_plato());
      st.setInt(2, receta.getProducto().getId_producto());
      st.setInt(3, receta.getCantidad());
      st.setInt(4, receta.getUmedida().getId_unidad());    
      st.setInt(5, receta.getPlato().getId_plato());
      st.setInt(6, receta.getProducto().getId_producto());
      st.executeUpdate();


    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public void eliminar(Receta receta) throws Exception {
    System.out.println("*******************************************************eliminar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM receta WHERE id_plato=? and id_producto=?;");
      st.setInt(1, receta.getPlato().getId_plato());
      st.setInt(2, receta.getProducto().getId_producto());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }
    
}
