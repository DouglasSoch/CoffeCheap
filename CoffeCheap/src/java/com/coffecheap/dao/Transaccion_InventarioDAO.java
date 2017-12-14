package com.coffecheap.dao;

import com.coffecheap.bean.Transaccion_inventarioBean;
import com.coffecheap.modelo.Compra;
import com.coffecheap.modelo.Transaccion_inventario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static org.primefaces.component.datatable.DataTable.PropertyKeys.summary;

/**
 *
 * @author bryan
 */
public class Transaccion_InventarioDAO extends Dao {

    /**
     * Metodo para registrar una transaccion de inventario
     *
     * @param traInv para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void registrar(Transaccion_inventario traInv) throws Exception {
        try {
            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into transaccion_inventario (fecha,id_producto,id_tipo_transaccion,cantidad,detalle,id_compra)values(?,?,?,?,?,?)");
            st.setString(1, formateador.format(traInv.getFecha()));
            st.setInt(2, traInv.getProducto().getId_producto());
            st.setInt(3, traInv.getTtransaccion().getId_tipo_transacciones());
            st.setInt(4, traInv.getCantidad());
            st.setString(5, traInv.getDetalle());
            st.setInt(6, traInv.getCompra().getId_compras());
            st.executeUpdate();
            Transaccion_inventarioBean.addMessage("Registro Guardado");
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    /**
     * Metodo para reducir si hay una existencia
     *
     * @param tra para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void resta(Transaccion_inventario tra) throws Exception {
        try {
            this.Conectar();
            PreparedStatement ps = getCon().prepareStatement("update producto set  existencia=existencia-? where id_producto=?");
            ps.setInt(1, tra.getCantidad());
            ps.setInt(2, tra.getProducto().getId_producto());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Desconecar();
        }
    }

    /**
     * Metodo para listar todos los registrso de transaccion inventario
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<Transaccion_inventario> mostrar() throws Exception {
        List<Transaccion_inventario> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select transaccion_inventario.id_transaccion, transaccion_inventario.fecha, producto.id_producto, producto.nombre_producto, tipo_transacciones.id_tipo_transacciones,tipo_transacciones.nombre_trasaccion, transaccion_inventario.cantidad, transaccion_inventario.detalle, compra.id_compra, compra.serie,compra.no_factura, compra.costo, compra.fecha_entregacompra, orden_compras.fecha_orden, orden_compras.fecha_entrega from transaccion_inventario  inner join producto on(transaccion_inventario.id_producto = producto.id_producto) inner join tipo_transacciones on(transaccion_inventario.id_tipo_transaccion = tipo_transacciones.id_tipo_transacciones) inner join  compra on(transaccion_inventario.id_compra = compra.id_compra) inner join orden_compras on(compra.id_orden = orden_compras.id_orden_compras)");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Transaccion_inventario tra = new Transaccion_inventario();
                tra.setId_transaccion(rs.getInt(1));
                tra.setFecha((rs.getDate(2)));
                tra.getProducto().setId_producto(rs.getInt(3));
                tra.getProducto().setNombre(rs.getString(4));
                tra.getTtransaccion().setId_tipo_transacciones(rs.getInt(5));
                tra.getTtransaccion().setNombre(rs.getString(6));
                tra.setCantidad(rs.getInt(7));
                tra.setDetalle(rs.getString(8));
                tra.getCompra().setId_compras(rs.getInt(9));
                tra.getCompra().setSerie(rs.getString(10));
                tra.getCompra().setNo_fac(rs.getInt(11));
                tra.getCompra().setCosto(rs.getInt(12));
                tra.getCompra().setFechaEntrega(rs.getString(13));
                tra.getCompra().getOcompras().setTemp_fecha_orden(rs.getString(14));
                tra.getCompra().getOcompras().setTemp_fecha_entrega(rs.getString(15));
                lista.add(tra);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    /**
     * Metodo para listar factura utilizado para lista desplegable en el
     * FrontEnd
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<Compra> listarCompraFactura() throws Exception {
        List<Compra> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select id_compra, no_factura from compra");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Compra compra = new Compra();
                compra.setId_compras(rs.getInt(1));
                compra.setNo_fac(rs.getInt(2));
                lista.add(compra);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    /**
     * metodo para listar producto para lista desplegable en Front end
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<Transaccion_inventario> listarParaModificarProducto() throws Exception {
        List<Transaccion_inventario> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select id_producto, nombre_producto from producto");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Transaccion_inventario traInv = new Transaccion_inventario();
                traInv.getProducto().setId_producto(rs.getInt(1));
                traInv.getProducto().setNombre(rs.getString(2));
                lista.add(traInv);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    /**
     * Metodo para listar transaccion inventario para lista desplegable
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<Transaccion_inventario> listarParaModificarTtransaccion() throws Exception {
        List<Transaccion_inventario> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select id_tipo_transacciones, nombre_trasaccion from tipo_transacciones");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {

                Transaccion_inventario traInv = new Transaccion_inventario();
                traInv.getTtransaccion().setId_tipo_transacciones(rs.getInt(1));
                traInv.getTtransaccion().setNombre(rs.getString(2));
                lista.add(traInv);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    /**
     * Metodo para lista desplegable
     *
     * @param traInv para la sentencia SQL
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public Transaccion_inventario leerParaModificar(Transaccion_inventario traInv) throws Exception {
        Transaccion_inventario traInvAden = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select transaccion_inventario.id_transaccion, transaccion_inventario.fecha, producto.id_producto, producto.nombre_producto, tipo_transacciones.id_tipo_transacciones, tipo_transacciones.nombre_trasaccion, transaccion_inventario.cantidad, transaccion_inventario.detalle ,compra.id_compra, compra.no_factura from transaccion_inventario inner join producto on(transaccion_inventario.id_producto = producto.id_producto) inner join tipo_transacciones on(transaccion_inventario.id_tipo_transaccion = tipo_transacciones.id_tipo_transacciones) inner join compra on(transaccion_inventario.id_compra = compra.id_compra) where transaccion_inventario.id_transaccion=?");
            st.setInt(1, traInv.getId_transaccion());
            rs = st.executeQuery();

            while (rs.next()) {
                traInvAden = new Transaccion_inventario();

                traInvAden.setId_transaccion(rs.getInt(1));
                traInvAden.setFecha((rs.getDate(2)));
                traInvAden.getProducto().setId_producto(rs.getInt(3));
                traInvAden.getProducto().setNombre(rs.getString(4));
                traInvAden.getTtransaccion().setId_tipo_transacciones(rs.getInt(5));
                traInvAden.getTtransaccion().setNombre(rs.getString(6));
                traInvAden.setCantidad(rs.getInt(7));
                traInvAden.setDetalle(rs.getString(8));
                traInvAden.getCompra().setId_compras(rs.getInt(9));
                traInvAden.getCompra().setNo_fac(rs.getInt(10));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return traInvAden;
    }

    /**
     * Metodo para eliminar
     *
     * @param orco para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Transaccion_inventario orco) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("delete from transaccion_inventario where id_transaccion=?");
            st.setInt(1, orco.getId_transaccion());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    /**
     * Metodo para modificar
     *
     * @param orco para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar(Transaccion_inventario orco) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update transaccion_inventario set  id_producto=?, id_tipo_transaccion=?, cantidad=?, detalle=?, id_compra=? where id_transaccion=?");
            st.setInt(1, orco.getProducto().getId_producto());
            st.setInt(2, orco.getTtransaccion().getId_tipo_transacciones());
            st.setInt(3, orco.getCantidad());
            st.setString(4, orco.getDetalle());
            st.setInt(5, orco.getCompra().getId_compras());
            st.setInt(6, orco.getId_transaccion());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

}
