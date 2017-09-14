/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.modelo.Venta_factura;
import com.coffecheap.modelo.Proveedor_productos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acier
 */
public class Venta_facturaDao extends Dao {

  public void registrar(Venta_factura Tt) throws Exception {

    try {

      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into venta_factura values(?,?,?,?,?,?,?);");
      st.setInt(1, Tt.getId_venta_factura());
     st.setString(2, Tt.getTemp_fecha_orden());
     
      st.setString(3, Tt.getTemp_fecha_entrega());
      st.setInt(4, Tt.getCantidad());    
      st.setInt(5, Tt.getPproductos().getProducto().getId_producto());   
      st.setInt(6, Tt.getPproductos().getProveedor().getId_proveedor());
      st.setDouble(7, Tt.getPrecio());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public List<Venta_factura> listar() throws Exception {
    List<Venta_factura> lista;
    ResultSet rs;

    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareCall("SELECT *FROM venta_factura");
      rs = st.executeQuery();
      lista = new ArrayList();
      while (rs.next()) {
        Venta_factura tt = new Venta_factura();

        tt.setId_venta_factura(rs.getInt(1));
        tt.setFecha_orden(rs.getDate(2));
        tt.setFecha_orden(rs.getDate(3));
        tt.setCantidad(rs.getInt(4));
        tt.getPproductos().getProducto().setId_producto(rs.getInt(5));
        tt.getPproductos().getProveedor().setId_proveedor(rs.getInt(6));
        tt.setPrecio(rs.getDouble(7));
        
        lista.add(tt);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }

  public void modificar(Venta_factura tt) throws Exception {
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE  venta_factura SET id_venta_factura=?, fecha_orden=?, fecha_entrega=?, cantidad_orden=?, id_producto=?, id_proveedor=?, precio=? WHERE id_venta_factura=?;");

     st.setInt(1, tt.getId_venta_factura());
     //st.setDate(2, tt.getFecha_orden());
     // st.setDate(3, tt.getFecha_entrega());
      st.setInt(4, tt.getCantidad());    
      st.setInt(5, tt.getPproductos().getProducto().getId_producto());   
      st.setInt(6, tt.getPproductos().getProveedor().getId_proveedor());
      st.setDouble(7, tt.getPrecio());
      st.setInt(8, tt.getId_venta_factura());
      st.executeUpdate();


    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }

  public void eliminar(Venta_factura pac) throws Exception {
    System.out.println("*******************************************************eliminar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("DELETE FROM venta_factura WHERE id_Venta_factura=?;");
      st.setInt(1, pac.getId_venta_factura());
      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();

    }

  }
  
  public List<Proveedor_productos> ListarProveedor_Produ(Venta_factura ordenid) throws Exception {

        List<Proveedor_productos> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select proveedor.id_proveedor, producto.id_producto,"
                    + "producto.nombre_producto, prov_prod.precio_insumo\n"
                    + "from proveedor \n"
                    + "inner join proveedor_productos as prov_prod\n"
                    + "on(proveedor.id_proveedor = prov_prod.id_proveedor)\n"
                    + "inner join producto \n"
                    + "on(prov_prod.id_producto = producto.id_producto) where proveedor.id_proveedor=?;");
            st.setInt(1, ordenid.getPproductos().getProveedor().getId_proveedor());
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Proveedor_productos prove_pro = new Proveedor_productos();
                prove_pro.getProveedor().setId_proveedor(rs.getInt("proveedor.id_proveedor"));
                prove_pro.getProducto().setId_producto(rs.getInt("producto.id_producto"));
                prove_pro.getProducto().setNombre(rs.getString("producto.nombre_producto"));
                prove_pro.setPrecio(rs.getInt("prov_prod.precio_insumo"));
                lista.add(prove_pro);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }


}
