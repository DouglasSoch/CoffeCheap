/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.bean.Estado_mesaBean;
import com.coffecheap.modelo.Estado_mesa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class Estado_mesaDao extends Dao {

    /**
     * Metodo para ingresar un registro en estado mesa
     *
     * @param Tt para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void registrar(Estado_mesa Tt) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO `coffechip`.`estado_mesa` (`nombre`) VALUES (?);");
            st.setString(1, Tt.getNombre());

            st.executeUpdate();
Estado_mesaBean.addMessage("Registro Guardado");
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para listar todos los registros de estado mesa
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<Estado_mesa> listar() throws Exception {
        List<Estado_mesa> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("SELECT *FROM estado_mesa");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Estado_mesa tt = new Estado_mesa();

                tt.setId_estado(rs.getInt(1));
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
     * Metodo para modificar un registro de estado mesa
     *
     * @param tt para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar(Estado_mesa tt) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE  estado_mesa SET id_estado=?, nombre=? WHERE id_estado=?;");

            st.setInt(1, tt.getId_estado());
            st.setString(2, tt.getNombre());
            st.setInt(3, tt.getId_estado());

            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para eliminar un registro de estado mesa
     *
     * @param pac para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Estado_mesa pac) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("DELETE FROM estado_mesa WHERE id_estado=?;");
            st.setInt(1, pac.getId_estado());
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

}
