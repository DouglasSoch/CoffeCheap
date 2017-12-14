/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.bean.MesaBean;
import com.coffecheap.modelo.Mesa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class MesaDao extends Dao {

    /**
     * MEtodo para registrar una mesa
     *
     * @param Tt para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void registrar(Mesa Tt) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("INSERT INTO mesa (cantidad_comensales, ubicacion, id_estado) VALUES (?, ?, ?);");

            st.setInt(1, Tt.getCantidad_comensales());
            st.setString(2, Tt.getUbicacion());
            st.setInt(3, 1);
            st.executeUpdate();

            PreparedStatement st2 = this.getCon().prepareStatement("INSERT INTO pedido "
                    + "(id_mesa, hora, id_personal, cancelado)"
                    + " VALUES (?, ?, ?, ?);");

            java.util.Date utilDate = new java.util.Date(); //fecha actual
            long lnMilisegundos = utilDate.getTime();
            java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
            System.out.println("sql.Time: " + sqlTime);

            PreparedStatement stt = this.getCon().prepareCall("SELECT MAX(id_mesa) AS id_mesa FROM mesa;");
            ResultSet rs = stt.executeQuery();

            rs.next();
            st2.setInt(1, rs.getInt(1));
            st2.setTime(2, sqlTime);
            st2.setInt(3, 3);
            st2.setInt(4, 0);
            st2.executeUpdate();
            MesaBean.addMessage("Registro Guardado");

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo par listar todos los registros de la mesa
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     * Metodo para modificar una mesa
     *
     * @param tt para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar(Mesa tt) throws Exception {
        System.out.println("*******************************************************modificar dao");
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE mesa SET cantidad_comensales=?, ubicacion=?, id_estado=? WHERE id_mesa=?;");

            st.setInt(1, tt.getCantidad_comensales());
            st.setString(2, tt.getUbicacion());
            st.setInt(3, tt.getEstMesa().getId_estado());
            st.setInt(4, tt.getId_mesa());
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    public void eliminar(Mesa pac) throws Exception {

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
