/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.modelo.Venta_factura;
import com.coffecheap.modelo.Proveedor_productos;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
      PreparedStatement st = this.getCon().prepareStatement("insert into venta_factura values(?,?,?,?,?,?,?,?);");
      st.setInt(1, Tt.getId_venta_factura());
      st.setString(2, Tt.getNit_empresa());
      double  tem1=Tt.getTem_total();
      double  tem2=tem1-(tem1*0.12);
      double tem3;
      double  tem4=tem1*0.12;
      
      if(Tt.isOpc_propina()==true){
      tem3=tem1*0.05;
      }else{
      tem3=0;
      }
      Tt.setSubtotal(tem2);
      Tt.setIva(tem4);
      Tt.setPropina(tem3);
      Tt.setTotal(tem3+tem2+tem4);
      
      st.setDouble(3, Tt.getSubtotal());
      st.setDouble(4, Tt.getIva());
      st.setDouble(5, Tt.getPropina());
      st.setDouble(6, Tt.getTotal());
      st.setString(7,Tt.getTemp_fecha_emision());
      st.setInt(8, Tt.getPedido().getId_pedido());
      
      
    System.out.println("DAO");
    System.out.println("ID"  + Tt.getId_venta_factura());
    System.out.println("nit"  + Tt.getNit_empresa());
    System.out.println("sub"  + Tt.getSubtotal());
    System.out.println("iva"  + Tt.getIva());
    System.out.println("pro"  + Tt.getPropina());
    System.out.println("to"  + Tt.getTotal());
    System.out.println("date"  + Tt.getFecha_emision());
    System.out.println("id pe"  + Tt.getPedido().getId_pedido());
    
    
    
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
        tt.setNit_empresa(rs.getString(2));
        tt.setSubtotal(rs.getDouble(3));
        tt.setIva(rs.getDouble(4));
        tt.setPropina(rs.getDouble(5));
        tt.setTotal(rs.getDouble(6));
        tt.setFecha_emision(rs.getDate(7));
        tt.getPedido().setId_pedido(rs.getInt(8));
        lista.add(tt);
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }

    return lista;

  }

  public void modificar(Venta_factura Tt) throws Exception {
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE  venta_factura SET id_venta_factura=?, fecha_orden=?, fecha_entrega=?, cantidad_orden=?, id_producto=?, id_proveedor=?, precio=? WHERE id_venta_factura=?;");

      st.setInt(1, Tt.getId_venta_factura());
      st.setString(2, Tt.getNit_empresa());
      st.setDouble(3, Tt.getSubtotal());
      st.setDouble(4, Tt.getIva());
      st.setDouble(5, Tt.getPropina());
      st.setDouble(6, Tt.getTotal());
      st.setDate(7, (Date) Tt.getFecha_emision());
      st.setInt(8, Tt.getPedido().getId_pedido());
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

  
}
