/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.bean.RecetaBean;
import com.coffecheap.modelo.Receta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author medev
 */
public class RecetaDao extends Dao {

    public void registrar(Receta receta) throws Exception {
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement ps = getCon().prepareStatement("select *from receta where id_plato=? and id_producto=? and id_unidad=?");
            ps.setInt(1, receta.getPlato().getId_plato());
            ps.setInt(2, receta.getProducto().getId_producto());
            ps.setInt(3, receta.getUmedida().getId_unidad());
            rs = ps.executeQuery();

            if (rs.next()) {
                RecetaBean.addMessage("Ya existe un registro con estos datos");
            } else {
                PreparedStatement st = getCon().prepareStatement("insert into receta values(?,?,?,?)");
                st.setInt(1, receta.getPlato().getId_plato());
                st.setInt(2, receta.getProducto().getId_producto());
                st.setInt(3, receta.getCantidad());
                st.setInt(4, receta.getUmedida().getId_unidad());
                st.executeUpdate();
                RecetaBean.addMessage("Accion Completada");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }
    }

    public List<Receta> listar() throws Exception {
        List<Receta> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("SELECT id_plato, id_producto, cantidad, id_unidad FROM receta");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Receta receta = new Receta();
                receta.getPlato().setId_plato(rs.getInt(1));
                receta.getProducto().setId_producto(rs.getInt(2));
                receta.setCantidad(rs.getInt(3));
                receta.getUmedida().setId_unidad(rs.getInt(4));
                lista.add(receta);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }

    public void modificar(Receta receta) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update receta set id_producto=?, cantidad=?, id_unidad=? WHERE id_plato=? and id_producto=?");
            st.setInt(1, receta.getProducto().getId_producto());
            st.setInt(2, receta.getCantidad());
            st.setInt(3, receta.getUmedida().getId_unidad());
            st.setInt(4, receta.getPlato().getId_plato());
            st.setInt(5, receta.getProducto().getId_producto());
            st.executeUpdate();
            RecetaBean.addMessage("Accion Completada");

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    public void eliminar(Receta receta) throws Exception 
    {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("DELETE FROM receta WHERE id_plato=? and id_producto=?;");
            st.setInt(1, receta.getPlato().getId_plato());
            st.setInt(2, receta.getProducto().getId_producto());
            st.executeUpdate();
            RecetaBean.addMessage("Accion Completada");
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    public Receta leerFila(Receta receta) throws Exception {
        Receta recet = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement ps = getCon().prepareStatement("select id_plato,id_producto,cantidad,id_unidad from receta where id_plato=? and id_producto=? and id_unidad=?");
            ps.setInt(1, receta.getPlato().getId_plato());
            ps.setInt(2, receta.getProducto().getId_producto());
            ps.setInt(3, receta.getUmedida().getId_unidad());
            rs = ps.executeQuery();

            while (rs.next()) {
                recet = new Receta();
                recet.getPlato().setId_plato(rs.getInt(1));
                recet.getProducto().setId_producto(rs.getInt(2));
                recet.setCantidad(rs.getInt(3));
                recet.getUmedida().setId_unidad(rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Desconecar();
        }
        return recet;
    }

}
