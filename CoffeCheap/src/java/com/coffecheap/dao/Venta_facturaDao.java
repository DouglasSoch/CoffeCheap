/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.bean.Venta_facturaBean;
import com.coffecheap.modelo.Cliente;
import com.coffecheap.modelo.Pedido;
import com.coffecheap.modelo.Venta_factura;
import com.coffecheap.modelo.Proveedor_productos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryan
 */
public class Venta_facturaDao extends Dao {

    /**
     * Metodo para registrar en venta factura
     *
     * @param VF
     * @throws Exception
     */
    public void registrar(Venta_factura VF) throws Exception {

        try {

            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into venta_factura (id_venta_factura, nit_empresa, subtotal, iva, propina, total, fecha_emision, id_pedido, id_cliente) values (?,?,?,?,?,?,?,?,?)");
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
            st.setInt(9, VF.getCliente().getId_cliente());
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
            Venta_facturaBean.addMessage("Accion completada");
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para listar pedido para lista desplegable
     *
     * @return
     * @throws Exception
     */
    public List<Pedido> listarPedido() throws Exception {
        List<Pedido> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select id_pedido from pedido");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setId_pedido(rs.getInt(1));
                lista.add(pedido);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }

    /**
     * Metodo para listar cliente para lista desplegable
     *
     * @return
     * @throws Exception
     */
    public List<Cliente> listarCliente() throws Exception {
        List<Cliente> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select id_cliente, nit_cliente from cliente");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt(1));
                cliente.setNit_cliente(rs.getString(2));
                lista.add(cliente);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }

    /**
     * MEtodo para listar antes de modificar
     *
     * @param vf
     * @return
     * @throws Exception
     */
    public Venta_factura leerParaModificar(Venta_factura vf) throws Exception {
        Venta_factura tt = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select venta_factura.id_venta_factura, venta_factura.nit_empresa, venta_factura.subtotal, venta_factura.iva, venta_factura.propina, venta_factura.total, venta_factura.fecha_emision, pedido.id_pedido, cliente.id_cliente, cliente.nit_cliente from venta_factura inner join cliente on(venta_factura.id_cliente = cliente.id_cliente ) inner join pedido on(venta_factura.id_pedido = pedido.id_pedido) where id_venta_factura=?");
            st.setInt(1, vf.getId_venta_factura());
            rs = st.executeQuery();

            while (rs.next()) {
                tt = new Venta_factura();
                tt.setId_venta_factura(rs.getInt(1));
                tt.setNit_empresa(rs.getString(2));
                tt.setSubtotal(rs.getDouble(3));
                tt.setIva(rs.getDouble(4));
                tt.setPropina(rs.getDouble(5));
                tt.setTotal(rs.getDouble(6));
                tt.setFecha_emision(rs.getTimestamp(7));
                tt.getPedido().setId_pedido(rs.getInt(8));
                tt.getCliente().setId_cliente(9);
                tt.getCliente().setNombre(rs.getString(10));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return tt;
    }

    /**
     * Metodo para listar todos los registros de venta factura
     *
     * @return
     * @throws Exception
     */
    public List<Venta_factura> listar() throws Exception {
        List<Venta_factura> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select venta_factura.id_venta_factura, venta_factura.nit_empresa, venta_factura.subtotal, venta_factura.iva, venta_factura.propina, venta_factura.total, venta_factura.fecha_emision, pedido.id_pedido, cliente.id_cliente, cliente.nit_cliente from venta_factura inner join cliente on(venta_factura.id_cliente = cliente.id_cliente ) inner join pedido on(venta_factura.id_pedido = pedido.id_pedido)");
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
                tt.getCliente().setId_cliente(9);
                tt.getCliente().setNit_cliente(rs.getString(10));
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
     * Metodo para modificar un registro de Venta factura
     *
     * @param VF
     * @throws Exception
     */
    public void modificar(Venta_factura VF) throws Exception {
        System.out.println("modificar");
        System.out.println("ID" + VF.getId_venta_factura());
        System.out.println("nit" + VF.getNit_empresa());
        System.out.println("sub" + VF.getSubtotal());
        System.out.println("iva" + VF.getIva());
        System.out.println("pro" + VF.getPropina());
        System.out.println("to" + VF.getTotal());
        System.out.println("date" + VF.getFecha_emision());
        System.out.println("id pe" + VF.getPedido().getId_pedido());
        System.out.println("id cli" + VF.getCliente().getId_cliente());
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE  venta_factura SET nit_empresa=?, subtotal=?, iva=?, propina=?, total=?, fecha_emision=?, id_pedido=?, id_cliente=? WHERE id_venta_factura=?");
            st.setString(1, VF.getNit_empresa());
            st.setDouble(2, VF.getSubtotal());
            st.setDouble(3, VF.getIva());
            st.setDouble(4, VF.getPropina());
            st.setDouble(5, VF.getTotal());
            st.setTimestamp(6, VF.getFecha_emision());
            st.setInt(7, VF.getPedido().getId_pedido());
            st.setInt(8, VF.getCliente().getId_cliente());
            st.setInt(9, VF.getId_venta_factura());
            st.executeUpdate();
            Venta_facturaBean.addMessage("Accion Completada");
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para eliminar un registro de venta factura
     *
     * @param pac
     * @throws Exception
     */
    public void eliminar(Venta_factura pac) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("DELETE FROM venta_factura WHERE id_Venta_factura=?;");
            st.setInt(1, pac.getId_venta_factura());
            Venta_facturaBean.addMessage("Accion Completada");
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para control deneral de la factura
     *
     * @param VF
     * @param mesa
     * @return
     * @throws Exception
     */
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

                idPedido = n4.getInt(1);

                PreparedStatement s3 = this.getCon().prepareStatement("select *from venta_factura where id_pedido=?;");
                s3.setInt(1, idPedido);
                ResultSet n2 = s3.executeQuery();

                estado = n2.next();

            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }
        return estado;
    }

    /**
     * MEtodo para regsitrar en control
     *
     * @param VF
     * @param mesa
     * @param clienteid
     * @throws Exception
     */
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
