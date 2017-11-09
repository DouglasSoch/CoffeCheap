/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.modelo.Plato;
import com.coffecheap.modelo.Tem_chef;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author javam
 */
public class Chef_temporal_Dao extends Dao{
    
    
          public ArrayList<Tem_chef> listar() throws Exception {
    ArrayList<Tem_chef> lista;
    ResultSet rs;
      
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM tem_chef");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Tem_chef plat = new Tem_chef();

        plat.setId_chef(rs.getInt("id_chef_temporal"));
        plat.getPedido().setId_pedido(rs.getInt("cod_pedido"));
        plat.getPlato().setId_plato(rs.getInt("id_plato"));
        plat.setCantidad(rs.getInt("cantidad"));
        plat.setDescripcion(rs.getString("descripcion"));
        plat.getEstadoPlato().setId(rs.getInt("id_estado"));
        
        
        
        lista.add(plat);
      } 

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }
                   
          
 public String ControlColor(int estado) throws Exception {
    String color = "";
   
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement s2 = this.getCon().prepareStatement("select id_estado from tem_chef WHERE id_chef_temporal=?;");
      s2.setInt(1, estado);
      ResultSet n = s2.executeQuery();

      if (n.next()) {
        if (n.getInt(1) == 1) {
          color = "Blue";
        } else {
          color = "Red";
        }

      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return color;

  }
 
 
 
//   public void modificar(Tem_chef tt) throws Exception {
//    try {
//      this.Conectar();
//      PreparedStatement st = this.getCon().prepareStatement("UPDATE  tem_chef SET id_estado=? WHERE id_chef_temporal=?;");
//
//      st.setInt(1, tt.getId_estado());
//      st.setString(2, tt.getNombre());
//      st.setInt(3, tt.getId_estado());
//
//      st.executeUpdate();
//
//    } catch (Exception ex) {
//      throw ex;
//    } finally {
//      this.Desconecar();
//    }
//  }
}
