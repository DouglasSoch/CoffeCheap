package com.coffecheap.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.coffecheap.modelo.Compra;
import com.coffecheap.modelo.Producto;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bryan
 */
public class CompraDao extends Dao {

    /**
     * Metodo para registrar una compra
     *
     * @param orden para la sentencia SQL
     * @param producto para la sentencia SQL
     * @param cantidad para la sentencia SQL
     * @param costo para la sentencia SQL
     * @param nofactura para la sentencia SQL
     * @param serie para la sentencia SQL
     * @param fecha para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void Insertar(int orden, int producto, int cantidad, int costo, int nofactura, String serie, String fecha) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into compra values(0," + orden + "," + producto + "," + cantidad + "," + costo + "," + nofactura + ",'" + serie + "','" + fecha + "')");
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    /**
     * metodo para obtener la cantidad de compra
     *
     * @param producto para la sentencia SQL
     * @return int
     * @throws Exception por si resulta un error de SQL
     */
    public int Cantidad(int producto) throws Exception {

        int respuesta = 0;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select sum(cantidad) as total from compra where id_producto=" + producto + ";");
            rs = st.executeQuery();

            while (rs.next()) {
                Compra compra = new Compra();
                compra.setCantidad(rs.getInt("total"));
                respuesta = compra.getCantidad();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return respuesta;
    }

    /**
     * Metodo para actualizar la cantidad de compra
     *
     * @param cantidad para la sentencia SQL
     * @param producto para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void ActualizarCantidad(int cantidad, int producto) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update producto set existencia=" + cantidad + " where id_producto=" + producto + ";");
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

    /**
     * Metodo para modificar la compra
     *
     * @param compra para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void Modificar(Compra compra) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update compra set id_orden=?, id_producto=?, cantidad=?, costo=?, no_factura=?, serie=?, fecha_entregacompra=? where id_compra = ?");
            st.setInt(1, compra.getOcompras().getId_orden_compras());
            st.setInt(2, compra.getProducto().getId_producto());
            st.setInt(3, compra.getCantidad());
            st.setInt(4, compra.getCosto());
            st.setInt(5, compra.getNo_fac());
            st.setString(6, compra.getSerie());

            System.out.println("año: " + compra.getFechaEntrega().substring(6, 10));
            System.out.println("mes: " + compra.getFechaEntrega().substring(3, 5));
            System.out.println("dia: " + compra.getFechaEntrega().substring(0, 2));
            String fecha = compra.getFechaEntrega().substring(6, 10) + "-" + compra.getFechaEntrega().substring(3, 5) + "-"
                    + compra.getFechaEntrega().substring(0, 2);
            System.out.println("Fecha completa: " + fecha);
            st.setString(7, fecha);
            st.setInt(8, compra.getId_compras());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
            compra.setId_compras(0);
            compra.getOcompras().setId_orden_compras(0);
            compra.getProducto().setId_producto(0);
            compra.setCantidad(0);
            compra.setCosto(0);
            compra.setNo_fac(0);
            compra.setSerie(null);
        }
    }

    /**
     * Metodo para eliminar una compra
     *
     * @param compra para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void Eliminar(Compra compra) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("delete from compra where id_compra=?");
            st.setInt(1, compra.getId_compras());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
            compra.setId_compras(0);
        }
    }

    /**
     * Metodo para listar todos los registros de la compra
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<Compra> Mostrar() throws Exception {

        List<Compra> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select compra.id_compra, compra.id_orden, "
                    + "proveedor.nombre_proveedor, orden_compras.cantidad_orden,\n"
                    + "producto.nombre_producto, compra.cantidad, compra.costo, compra.no_factura,\n"
                    + "compra.serie, compra.fecha_entregacompra\n"
                    + "from compra\n"
                    + "inner join producto on(producto.id_producto=compra.id_producto)\n"
                    + "inner join orden_compras on(orden_compras.id_orden_compras=compra.id_orden)\n"
                    + "inner join proveedor on (proveedor.id_proveedor=orden_compras.id_proveedor)"
                    + " order by id_compra asc;");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Compra compra = new Compra();
                compra.setId_compras(rs.getInt("compra.id_compra"));
                compra.getOcompras().setId_orden_compras(rs.getInt("compra.id_orden"));
                compra.getOcompras().getPproductos().getProveedor().setNombre(rs.getString("proveedor.nombre_proveedor"));
                compra.getOcompras().setCantidad(rs.getInt("orden_compras.cantidad_orden"));
                compra.getOcompras().getPproductos().getProducto().setNombre(rs.getString("producto.nombre_producto"));
                compra.setCantidad(rs.getInt("compra.cantidad"));
                compra.setCosto(rs.getInt("compra.costo"));
                compra.setNo_fac(rs.getInt("compra.no_factura"));
                compra.setSerie(rs.getString("compra.serie"));
                compra.setFechaEntrega(rs.getString("compra.fecha_entregacompra"));
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
     * Metodo para listar por codigo de producto
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<String> CodigodeProducto() throws Exception {

        List<String> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select id_producto from producto;");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt("id_producto"));
                lista.add(String.valueOf(producto.getId_producto()));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

    /**
     * Metodo para verificar existencia
     *
     * @param codigo para la sentencia SQL
     * @return int
     * @throws Exception por si resulta un error de SQL
     */
    public int Operacion(int codigo) throws Exception {

        int numero = 0;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select existencia from producto where id_producto=" + codigo);
            rs = st.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setExistencia(rs.getInt("existencia"));
                numero = producto.getExistencia();
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return numero;
    }

    /**
     * Metodo para verificar compra
     *
     * @param codigo para la sentencia SQL
     * @return int
     * @throws Exception por si resulta un error de SQL
     */
    public int CodigoProducto(int codigo) throws Exception {

        int numero = 0;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select id_producto from compra where id_compra=" + codigo);
            rs = st.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_producto_eliminar(rs.getInt("id_producto"));
                numero = producto.getId_producto_eliminar();
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return numero;
    }

    /**
     * Metodo para verificar cantidad
     *
     * @param codigo para la sentencia SQL
     * @return int
     * @throws Exception por si resulta un error de SQL
     */
    public int CantidadProducto(int codigo) throws Exception {

        int numero = 0;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select cantidad from compra where id_compra=" + codigo);
            rs = st.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCantidad(rs.getInt("cantidad"));
                numero = producto.getCantidad();
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return numero;
    }

    /**
     * Metodo para modificar existencia
     *
     * @param cantidad para la sentencia SQL
     * @param codigo para la sentencia SQL
     */
    public void ActualizarExistencia(int cantidad, int codigo) {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update producto set existencia =" + cantidad + " where id_producto=" + codigo);
            st.executeUpdate();

        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(CompraDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                this.Desconecar();
            } catch (Exception ex) {
                Logger.getLogger(CompraDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Metodo para verificar existencia
     *
     * @param codigo para la sentencia SQL
     * @return int
     * @throws Exception por si resulta un error de SQL
     */
    public int CantidadEnTabla(int codigo) throws Exception {

        int numero = 0;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select existencia from producto where id_producto=" + codigo);
            rs = st.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setCantidad_eliminar(rs.getInt("existencia"));
                numero = producto.getCantidad_eliminar();
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return numero;
    }

    /**
     * Metodo para actulizar producto
     *
     * @param codigo para la sentencia SQL
     * @param cantidad para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void ActualizacionProductos(int codigo, int cantidad) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update producto set existencia=" + cantidad + " where id_producto=" + codigo);
            st.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
    }

}
