/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.modelo.Tipo_producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class Tipo_productoDao extends Dao {

    /**
     * Metodo para registrar un tipo de producto
     *
     * @param Tt
     * @throws Exception
     */
    public void registrar(Tipo_producto Tt) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into tipo_producto values(?,?);");

            st.setInt(1, Tt.getId_tipo());
            st.setString(2, Tt.getNombre());

            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para listar todo los tipos de producto
     *
     * @return
     * @throws Exception
     */
    public List<Tipo_producto> listar() throws Exception {
        List<Tipo_producto> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("SELECT *FROM tipo_producto");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Tipo_producto tt = new Tipo_producto();

                tt.setId_tipo(rs.getInt(1));
                tt.setNombre(rs.getString(2));

                lista.add(tt);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }

    /**
     * MEtodo para modificar un tipo de producto
     *
     * @param tt
     * @throws Exception
     */
    public void modificar(Tipo_producto tt) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE  tipo_producto SET id_tipo=?, nombre_tipo=? WHERE id_tipo=?;");

            st.setInt(1, tt.getId_tipo());
            st.setString(2, tt.getNombre());
            st.setInt(3, tt.getId_tipo());

            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * MEtodo para eliminar un tipo de producto
     *
     * @param pac
     * @throws Exception
     */
    public void eliminar(Tipo_producto pac) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("DELETE FROM tipo_producto WHERE id_tipo_producto=?;");
            st.setInt(1, pac.getId_tipo());
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

}
