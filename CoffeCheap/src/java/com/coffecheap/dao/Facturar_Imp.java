/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.modelo.Fac;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javam
 */
public class Facturar_Imp extends Dao{
     public List<Fac> listar() throws Exception {
        List<Fac> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select * from fac");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Fac factu = new Fac();
                factu.setFecha_emision(rs.getString("fecha_emision"));
                factu.setNombre_cliente(rs.getString("nombre_cliente"));
                factu.setNit_cliente(rs.getInt("nit_cliente"));
                factu.setDireccion(rs.getString("direccion"));
                factu.setNombre_platillo(rs.getString("nombre_platillo"));
                factu.setCantidad(rs.getInt("cantidad"));
                factu.setPrecio(rs.getInt("precio"));
                factu.setTot(rs.getInt("tot"));
                factu.setSubtotal(rs.getInt("subtotal"));
                factu.setIva(rs.getInt("iva"));
                factu.setPropina(rs.getInt("propina"));
                factu.setTotal(rs.getInt("total"));
                factu.setId_mesa(rs.getInt("id_mesa"));
                factu.setCantidad_comensales(rs.getInt("cantidad_comensales"));
                 factu.setNombre(rs.getString("nombre"));
                lista.add(factu);
            }
         
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }
}
