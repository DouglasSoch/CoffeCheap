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
 * @author Bryan
 */
public class RecetaDao extends Dao {

    /**
     * Metodo para registrar en receta
     *
     * @param receta para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
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

    /**
     * Metodo para listar todos los registros de recetaa
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<Receta> listar() throws Exception {
        List<Receta> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select  plato.id_plato, plato.nombre_platillo, producto.id_producto, producto.nombre_producto, receta.cantidad, unidad_medida.id_unidad, unidad_medida.nombre from receta inner join plato on (receta.id_plato = plato.id_plato) inner join producto on (receta.id_producto = producto.id_producto) inner join unidad_medida on (receta.id_unidad = unidad_medida.id_unidad)");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Receta receta = new Receta();
                receta.getPlato().setId_plato(rs.getInt(1));
                receta.getPlato().setNombre(rs.getString(2));
                receta.getProducto().setId_producto(rs.getInt(3));
                receta.getProducto().setNombre(rs.getString(4));
                receta.setCantidad(rs.getInt(5));
                receta.getUmedida().setId_unidad(rs.getInt(6));
                receta.getUmedida().setNombre(rs.getString(7));
                lista.add(receta);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }

    /**
     * Metodo para modificar un regsitro de receta
     *
     * @param receta para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar(Receta receta) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update receta set id_producto=?, cantidad=?, id_unidad=? WHERE id_plato=? ");
            st.setInt(1, receta.getProducto().getId_producto());
            st.setInt(2, receta.getCantidad());
            st.setInt(3, receta.getUmedida().getId_unidad());
            st.setInt(4, receta.getPlato().getId_plato());
            //st.setInt(5, receta.getProducto().getId_producto());
            st.executeUpdate();
            RecetaBean.addMessage("Accion Completada");

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * MEtodo para eliminar un registro de receta
     *
     * @param receta para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Receta receta) throws Exception {
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
