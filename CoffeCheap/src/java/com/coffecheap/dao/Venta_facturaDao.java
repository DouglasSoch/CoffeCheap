/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.modelo.Cliente;
import com.coffecheap.modelo.Venta_factura;
import com.coffecheap.modelo.Proveedor_productos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acier
 */
public class Venta_facturaDao extends Dao {

  public void registrar(Venta_factura VF) throws Exception {

    try {

      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("insert into venta_factura values(?,?,?,?,?,?,?,?);");
      st.setInt(1, VF.getId_venta_factura());
      st.setString(2, VF.getNit_empresa());
      double tem1 = VF.getTem_total();
      double tem2 = tem1 - (tem1 * 0.12);
      double tem3;
      double tem4 = tem1 * 0.12;

      if (VF.isOpc_propina() == true) {
        tem3 = tem1 * 0.05;
      } else {
        tem3 = 0;
      }
      VF.setSubtotal(tem2);
      VF.setIva(tem4);
      VF.setPropina(tem3);
      VF.setTotal(tem3 + tem2 + tem4);

      st.setDouble(3, VF.getSubtotal());
      st.setDouble(4, VF.getIva());
      st.setDouble(5, VF.getPropina());
      st.setDouble(6, VF.getTotal());
      st.setString(7, VF.getTemp_fecha_emision());
      st.setInt(8, VF.getPedido().getId_pedido());

      System.out.println("DAO");
      System.out.println("ID" + VF.getId_venta_factura());
      System.out.println("nit" + VF.getNit_empresa());
      System.out.println("sub" + VF.getSubtotal());
      System.out.println("iva" + VF.getIva());
      System.out.println("pro" + VF.getPropina());
      System.out.println("to" + VF.getTotal());
      System.out.println("date" + VF.getFecha_emision());
      System.out.println("id pe" + VF.getPedido().getId_pedido());

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
        tt.setFecha_emision(rs.getTimestamp(7));
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

  public void modificar(Venta_factura VF) throws Exception {
    System.out.println("*******************************************************modificar dao");
    try {
      this.Conectar();
      PreparedStatement st = this.getCon().prepareStatement("UPDATE  venta_factura SET id_venta_factura=?, fecha_orden=?, fecha_entrega=?, cantidad_orden=?, id_producto=?, id_proveedor=?, precio=? WHERE id_venta_factura=?;");

      st.setInt(1, VF.getId_venta_factura());
      st.setString(2, VF.getNit_empresa());
      st.setDouble(3, VF.getSubtotal());
      st.setDouble(4, VF.getIva());
      st.setDouble(5, VF.getPropina());
      st.setDouble(6, VF.getTotal());
      st.setTimestamp(7, VF.getFecha_emision());
      st.setInt(8, VF.getPedido().getId_pedido());
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

  public boolean controlGenerarFactura(Venta_factura VF, int mesa) throws Exception {

    int es = 0;
    int idPedido = 0;
    String Ten = null;
    boolean estado = false;

    try {

      this.Conectar();

      PreparedStatement s4 = this.getCon().prepareStatement("select id_pedido from control where id_mesa=?;");
      s4.setInt(1, mesa);
      ResultSet n4 = s4.executeQuery();

      if (n4.next()) {

        if (n4.getInt(1) == 2) {

          PreparedStatement s2 = this.getCon().prepareStatement("select id_pedido from control where id_mesa=?;");
          s2.setInt(1, mesa);
          ResultSet n = s2.executeQuery();

          if (n.next()) {
            idPedido = n.getInt(1);
          }

          PreparedStatement s3 = this.getCon().prepareStatement("select *from venta_factura where id_pedido=?;");
          s3.setInt(1, idPedido);
          ResultSet n2 = s3.executeQuery();

          if (n2.next()) {
            estado = true;
          } else {
            estado = false;
          }

        }
      }

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
    }
    return estado;
  }

  public void registrar_venta(Venta_factura VF, int mesa, int clienteid) throws Exception {
    int idPedido = 0;
    double TenToT = 0.0;
    try {

      this.Conectar();

      PreparedStatement s2 = this.getCon().prepareStatement("select id_pedido from control where id_mesa=?;");
      s2.setInt(1, mesa);
      ResultSet n = s2.executeQuery();

      if (n.next()) {
        idPedido = n.getInt(1);
      }

      PreparedStatement s3 = this.getCon().prepareStatement("select sum(cantidad*precio) from plato_pedido WHERE id_pedido=?");
      s3.setInt(1, idPedido);
      ResultSet n2 = s3.executeQuery();

      if (n2.next()) {
        TenToT = n2.getInt(1);
      }

      double tem1 = TenToT;
      double tem2 = tem1 - (tem1 * 0.12);
      double tem3;
      double tem4 = tem1 * 0.12;

      if (VF.isOpc_propina() == true) {
        tem3 = tem1 * 0.05;
      } else {
        tem3 = 0;
      }
      VF.setNit_empresa("1234567-5");
      VF.setSubtotal(tem2);
      VF.setIva(tem4);
      VF.setPropina(tem3);
      VF.setTotal(tem3 + tem2 + tem4);

      java.util.Date dates = new java.util.Date();
      long fechaSis = dates.getTime();
      java.sql.Timestamp d = new java.sql.Timestamp(fechaSis);
      VF.setFecha_emision(d);

//      java.util.Date utilDate = new java.util.Date(); //fecha actual
//      long lnMilisegundos = utilDate.getTime();
//      java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
//      java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
//      java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);
//      System.out.println("util.Date: " + utilDate);
//      System.out.println("sql.Date: " + sqlDate);
//      System.out.println("sql.Time: " + sqlTime);
//      System.out.println("sql.Timestamp: " + sqlTimestamp);
      PreparedStatement st = this.getCon().prepareStatement("INSERT INTO `venta_factura` (`nit_empresa`, `subtotal`, `iva`, `propina`, `total`, `fecha_emision`, `id_pedido`, `id_cliente`) "
              + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);");

      st.setString(1, VF.getNit_empresa());
      st.setDouble(2, VF.getSubtotal());
      st.setDouble(3, VF.getIva());
      st.setDouble(4, VF.getPropina());
      st.setDouble(5, VF.getTotal());
      st.setTimestamp(6, VF.getFecha_emision());
      st.setInt(7, idPedido);
      st.setInt(8, clienteid);

      System.out.println("DAO");
      System.out.println("ID " + VF.getId_venta_factura());
      System.out.println("nit " + VF.getNit_empresa());
      System.out.println("sub " + VF.getSubtotal());
      System.out.println("iva " + VF.getIva());
      System.out.println("pro " + VF.getPropina());
      System.out.println("to " + VF.getTotal());
      System.out.println("date " + VF.getFecha_emision());
      System.out.println("id pe " + VF.getPedido().getId_pedido());

      st.executeUpdate();

    } catch (Exception ex) {
      throw ex;
    } finally {
      this.Desconecar();
      VF.setId_venta_factura(0);
      VF.setNit_empresa(null);
      VF.setSubtotal(0.0);
      VF.setIva(0.0);
      VF.setPropina(0.0);
      VF.setTotal(0.0);
      VF.setFecha_emision(null);
      VF.getPedido().setId_pedido(0);

      Cliente cli = new Cliente();
      cli.setId_cliente(0);
      cli.setNit_cliente(null);
      cli.setNombre(null);
      cli.setDireccion(null);
    }

  }

  public double Tem_Total() {

    return 10.10;
  }

}
