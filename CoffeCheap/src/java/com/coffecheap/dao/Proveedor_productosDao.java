/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.modelo.Proveedor_productos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acier
 */
public class Proveedor_productosDao extends Dao {

    public void registrar(Proveedor_productos Tt) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into proveedor_productos values(?,?);");

            st.setInt(1, Tt.getProveedor().getId_proveedor());
            st.setInt(2, Tt.getProducto().getId_producto());
            st.setInt(3, Tt.getPrecio());

            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    public List<Proveedor_productos> listar() throws Exception {
        List<Proveedor_productos> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("SELECT *FROM proveedor_productos");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Proveedor_productos tt = new Proveedor_productos();

                tt.getProveedor().setId_proveedor(rs.getInt(1));
                tt.getProducto().setId_producto(rs.getInt(2));
                tt.setPrecio(rs.getInt(3));

                lista.add(tt);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }

    public void modificar(Proveedor_productos Tt) throws Exception {
        System.out.println("*******************************************************modificar dao");
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE  proveedor_productos SET id_producto=?, precio_insumo=? WHERE id_proveedor=?;");
            st.setInt(1, Tt.getProducto().getId_producto());
            st.setInt(2, Tt.getPrecio());
            st.setInt(3, Tt.getProveedor().getId_proveedor());
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    public void eliminar(Proveedor_productos pac) throws Exception {
        System.out.println("*******************************************************eliminar dao");
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("DELETE FROM proveedor_productos WHERE id_proveedor_productos=?;");
            st.setInt(1, pac.getProveedor().getId_proveedor());
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

}
