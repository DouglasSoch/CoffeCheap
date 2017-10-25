/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.bean.Mesero_Temporal;
import com.coffecheap.modelo.Plato;
import com.coffecheap.modelo.Tem_chef;
import com.coffecheap.modelo.Tipo_plato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author medev
 */
public class MeseroTemporalDao extends Dao{
    
    
   
    
    public ArrayList<Tipo_plato> listar() throws Exception {
    ArrayList<Tipo_plato> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM tipo_plato;");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Tipo_plato plat = new Tipo_plato();

        plat.setId(rs.getInt("id_tipo_plato"));
        plat.setNombre(rs.getString("nombre"));
        
         
        
        
        lista.add(plat);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
      
    }

    return lista;

  }
    
       public ArrayList<Plato> listar2(Tem_chef pl) throws Exception {
    ArrayList<Plato> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM plato where id_tipo="+pl.getTipoPlato().getId());
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Plato plat = new Plato();

        plat.setId_plato(rs.getInt("id_plato"));
        plat.setNombre(rs.getString("nombre_platillo"));
        
        
        
        lista.add(plat);
      } 

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }
       
       
          public void Insertar(Tem_chef chef, int a, int b) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO plato_pedido (id_plato,cantidad,id_personal,id_pedido,precio) VALUES (?,?,?,?,?)");
            st.setInt(1, chef.getPlato().getId_plato());
            st.setInt(2, chef.getCantidad());
            st.setInt(3, a);
            st.setInt(4, b);
           // st.setInt(5, compra.getNo_fac());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }
       
      
       
}
