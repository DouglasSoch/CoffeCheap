package com.coffecheap.dao;

import com.coffecheap.modelo.Tipo_plato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Tipo_platoDao extends Dao
        
{
    public void registrar(Tipo_plato tipoPlato) throws Exception {

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

  public List<Tipo_plato> listar() throws Exception {
    List<Tipo_plato> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("select id_tipo_plato, nombre from tipo_plato");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) 
      {
        Tipo_plato tipoPlato = new Tipo_plato();
        tipoPlato.setId(rs.getInt(1));
        tipoPlato.setNombre(rs.getString(2));
        lista.add(tipoPlato);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }

  public void modificar(Tipo_plato tipoPlato) throws Exception 
  {
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE tipo_plato SET nombre=? WHERE id_tipo_plato=?");
      st.setString(1, tipoPlato.getNombre());
      st.setInt(2, tipoPlato.getId());
      st.executeUpdate();


    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public void eliminar(Tipo_plato tipoPlato) throws Exception 
  {
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM tipo_plato WHERE id_tipo_plato=?");
      st.setInt(1, tipoPlato.getId());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }
}
