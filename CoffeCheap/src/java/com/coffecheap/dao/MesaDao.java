/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.modelo.Mesa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acier
 */
public class MesaDao extends Dao {

  public void registrar(Mesa Tt) throws Exception {

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into mesa values(?,?,?,?);");

      st.setInt(1, Tt.getId_mesa());
      st.setInt(2, Tt.getCantidad_comensales());
      st.setString(3, Tt.getUbicacion());
      st.setInt(4, Tt.getEstMesa().getId_estado()); 
      st.executeUpdate();
      
      PreparedStatement st2 = this.getCon().prepareStatement("INSERT INTO pedido "
                  + "(id_mesa, hora, id_personal, cancelado)"
                  + " VALUES (?, ?, ?, ?);");

          java.util.Date utilDate = new java.util.Date(); //fecha actual
          long lnMilisegundos = utilDate.getTime();     
          java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);      
          System.out.println("sql.Time: " + sqlTime);    

          
          st2.setInt(1, Tt.getId_mesa());
          st2.setTime(2, sqlTime);
          st2.setInt(3, 3);
          st2.setInt(4, 0);
          st2.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public List<Mesa> listar() throws Exception {
    List<Mesa> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM mesa");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Mesa tt = new Mesa();
        tt.setId_mesa(rs.getInt(1));
        tt.setCantidad_comensales(rs.getInt(2));
        tt.setUbicacion(rs.getString(3));
        tt.getEstMesa().setId_estado(rs.getInt(4));
        
         
        lista.add(tt);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }

  public void modificar(Mesa tt) throws Exception {
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE  mesa SET id_mesa=?, cantidad_comensales=?, ubicacion=?, id_estado=?, id_cliente=? WHERE id_mesa=?;");

      st.setInt(1, tt.getId_mesa());
      st.setInt(2, tt.getCantidad_comensales());
      st.setString(3, tt.getUbicacion());
      st.setInt(4, tt.getEstMesa().getId_estado());
          
      st.setInt(5, tt.getId_mesa());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }



  public void eliminar(Mesa pac) throws Exception {
    System.out.println("*******************************************************eliminar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM mesa WHERE id_mesa=?;");
      st.setInt(1, pac.getId_mesa());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

}
