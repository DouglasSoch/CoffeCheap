/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;


import com.coffecheap.modelo.Personal_mesero;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author medev
 */
public class Personal_MeseroDao extends Dao {
    
    public void registrar(Personal_mesero permes) throws Exception {

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into personal_mesero values(?,?,?,?,?);");
      st.setInt(1, permes.getId_personal_servicio());
      st.setString(2, permes.getNombre());
      st.setString(3, permes.getTelefono());
      st.setInt(4, permes.getTurno().getId_turno());    
      
        

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public List<Personal_mesero> listar() throws Exception {
    List<Personal_mesero> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM personal_mesero");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Personal_mesero permes = new Personal_mesero();

        permes.setId_personal_servicio(rs.getInt("id_personal_servicio"));
        permes.setNombre(rs.getString("nombre"));
        permes.setTelefono(rs.getString("telefono"));
        permes.getTurno().setId_turno(rs.getInt("id_turno"));
        
        
        
        
        lista.add(permes);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }

  public void modificar(Personal_mesero permes
  ) throws Exception {
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE  personal_mesero SET id_personal_servicio=?, nombre=?, telefono=?, id_turno=? WHERE id_personal_servicio=?;");

      st.setInt(1, permes.getId_personal_servicio());
      st.setString(2, permes.getNombre());
      st.setString(3, permes.getTelefono());
      st.setInt(4, permes.getTurno().getId_turno());    
      st.setInt(5, permes.getId_personal_servicio());   
      st.executeUpdate();


    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public void eliminar(Personal_mesero permes) throws Exception {
    System.out.println("*******************************************************eliminar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM personal_mesero WHERE id_personal_servicio=?;");
      st.setInt(1, permes.getId_personal_servicio());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }
}
