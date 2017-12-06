/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//import com.coffecheap.modelo.Compra;
import com.coffecheap.modelo.Producto;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class Contador_Vista_Producto_Dao extends Dao{
    
    public List<Producto> Listar() throws Exception {

        List<Producto> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select producto.id_producto, producto.nombre_producto, "
                    + "producto.existencia, unidad_medida.nombre,\n"
                    + "tipo_producto.nombre_tipo\n"
                    + "from producto\n"
                    + "inner join unidad_medida on(producto.id_unidad=unidad_medida.id_unidad)\n"
                    + "inner join tipo_producto on(producto.id_tipos=tipo_producto.id_tipo)\n"
                    + " order by id_producto asc;");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("producto.id_producto"));
                producto.setNombre(rs.getString("producto.nombre_producto"));
                producto.setExistencia(rs.getInt("producto.existencia"));
                producto.getUmedida().setNombre(rs.getString("unidad_medida.nombre"));
                producto.getTproducto().setNombre(rs.getString("tipo_producto.nombre_tipo"));
                lista.add(producto);
                
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }
}
