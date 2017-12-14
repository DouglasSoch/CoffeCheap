/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;


import com.coffecheap.bean.PlatoBean;
import com.coffecheap.modelo.Plato;
import com.coffecheap.modelo.Tipo_plato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class PlatoDao extends Dao {
    /**
     * Metodo para ingresar un plato
     * @param plat
     * @throws Exception 
     */
    public void registrar(Plato plat) throws Exception {

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into plato(nombre_platillo,precio_plato,porciones,descripcion_plato,id_tipo) values(?,?,?,?,?)");
      st.setString(1, plat.getNombre());
      st.setDouble(2, plat.getPrecio());
      st.setInt(3, plat.getPorciones());    
      st.setString(4, plat.getDescripcion());
      st.setInt(5, plat.getTipoPlato().getId());  
      st.executeUpdate();
      PlatoBean.addMessage("Accion Completada");
    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }
/**
 * Metodo para listar tipo plato para una lista desplegable
 * @return
 * @throws Exception 
 */
      public List<Tipo_plato> listarTipoPlato() throws Exception {
    List<Tipo_plato> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("select id_tipo_plato, nombre from tipo_plato");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Tipo_plato tPlato = new Tipo_plato();
        tPlato.setId(rs.getInt(1));
        tPlato.setNombre(rs.getString(2));
        lista.add(tPlato);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }
    return lista;
  }
    
      /**
       * Metodo para listar todos los registros de plato
       * @return
       * @throws Exception 
       */
  public List<Plato> listar() throws Exception {
    List<Plato> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("select plato.id_plato, plato.nombre_platillo, plato.precio_plato, plato.porciones, plato.descripcion_plato, tipo_plato.id_tipo_plato, tipo_plato.nombre from plato inner join tipo_plato on (plato.id_tipo = tipo_plato.id_tipo_plato)");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Plato plat = new Plato();

        plat.setId_plato(rs.getInt(1));
        plat.setNombre(rs.getString(2));
        plat.setPrecio(rs.getDouble(3));
        plat.setPorciones(rs.getInt(4));
        plat.setDescripcion(rs.getString(5));
        plat.getTipoPlato().setId(rs.getInt(6));
        plat.getTipoPlato().setNombre(rs.getString(7));
        
        lista.add(plat);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }
/**
 * Metodo para modificar plato
 * @param plat
 * @throws Exception 
 */
  public void modificar(Plato plat) throws Exception 
  {
    try 
    {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE  plato SET nombre_platillo=?, precio_plato=?, porciones=?, descripcion_plato=? , id_tipo=? WHERE id_plato=?");
      st.setString(1, plat.getNombre());
      st.setDouble(2, plat.getPrecio());
      st.setInt(3, plat.getPorciones());    
      st.setString(4, plat.getDescripcion());
      st.setInt(5, plat.getTipoPlato().getId());
      st.setInt(6, plat.getId_plato());
      st.executeUpdate();
      PlatoBean.addMessage("Accion Completada");

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }
/**
 * Metodo para eliminar una plato
 * @param plat
 * @throws Exception 
 */
  public void eliminar(Plato plat) throws Exception 
  {
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM plato WHERE id_plato=?;");
      st.setInt(1, plat.getId_plato());
      st.executeUpdate();
            PlatoBean.addMessage("Accion Completada");
    } catch (Exception ex) 
    {
      throw ex;
    } finally 
    {
      this.Desconecar();
    }
  }
  /**
   * Metodo para obtener una fila e ingresarla en un objeto 
   * @param plat
   * @return
   * @throws Exception 
   */
   public Plato leerFila(Plato plat) throws Exception {
         Plato plato = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement ps = getCon().prepareStatement("select id_plato, nombre_platillo,precio_plato,porciones,descripcion_plato,id_tipo from plato where id_plato=?");
            ps.setInt(1, plat.getId_plato());
            rs = ps.executeQuery();

            while (rs.next()) {
                plato = new Plato();
                plato.setId_plato(rs.getInt(1));
                plato.setNombre(rs.getString(2));
                plato.setPrecio(rs.getDouble(3));
                plato.setPorciones(rs.getInt(4));
                plato.setDescripcion(rs.getString(5));
                plato.getTipoPlato().setId(rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Desconecar();
        }
        return plato;
    }
}
