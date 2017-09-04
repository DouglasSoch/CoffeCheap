/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;


import com.coffecheap.modelo.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author medev
 */
public class ProductoDao extends Dao{
    
    public void registrar(Producto prod) throws Exception {

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into producto values(?,?,?,?,?);");
      st.setInt(1, prod.getId_producto());
      st.setString(2, prod.getNombre());
      st.setInt(3, prod.getExistencia());
      st.setInt(4, prod.getUmedida().getId_unidad());    
      st.setInt(5, prod.getTproducto().getId_tipo());   
        

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public List<Producto> listar() throws Exception {
    List<Producto> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM producto");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Producto prod = new Producto();

        prod.setId_producto(rs.getInt("id_producto"));
        prod.setNombre(rs.getString("nombre_producto"));
        prod.setExistencia(rs.getInt("existencia"));
        prod.getUmedida().setId_unidad(rs.getInt("id_unidad"));
        prod.getTproducto().setId_tipo(rs.getInt("id_tipos"));
        
        
        
        lista.add(prod);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }

  public void modificar(Producto prod
  ) throws Exception {
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE  producto SET id_producto=?, nombre_producto=?, existencia=?, id_unidad=?, id_tipos=? WHERE id_producto=?;");

      st.setInt(1, prod.getId_producto());
      st.setString(2, prod.getNombre());
      st.setInt(3, prod.getExistencia());
      st.setInt(4, prod.getUmedida().getId_unidad());    
      st.setInt(5, prod.getTproducto().getId_tipo());   
      st.setInt(6, prod.getId_producto());  
      st.executeUpdate();


    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public void eliminar(Producto prod) throws Exception {
    System.out.println("*******************************************************eliminar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM producto WHERE id_producto=?;");
      st.setInt(1, prod.getId_producto());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }
}
