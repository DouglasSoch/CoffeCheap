package com.coffecheap.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.coffecheap.modelo.Compra;

public class CompraDao extends Dao {

    public void Insertar(Compra compra) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into compra values(?,?,?,?,?,?)");
            st.setInt(1, compra.getId_compras());
            st.setInt(2, compra.getOcompras().getId_orden_compras());
            st.setInt(3, compra.getCantidad());
            st.setInt(4, compra.getCosto());
            st.setInt(5, compra.getNo_fac());
            st.setString(6, compra.getSerie());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
            compra.setId_compras(0);
            compra.getOcompras().setId_orden_compras(0);
            compra.setCantidad(0);
            compra.setCosto(0);
            compra.setNo_fac(0);
            compra.setSerie(null);
        }
    }

    public void Modificar(Compra compra) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update compra set id_orden=?, cantidad=?, costo=?, no_factura=?, serie=? where id_compra = ?");
            st.setInt(1, compra.getOcompras().getId_orden_compras());
            st.setInt(2, compra.getCantidad());
            st.setInt(3, compra.getCosto());
            st.setInt(4, compra.getNo_fac());
            st.setString(5, compra.getSerie());
            st.setInt(6, compra.getId_compras());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
            compra.setId_compras(0);
            compra.getOcompras().setId_orden_compras(0);
            compra.setCantidad(0);
            compra.setCosto(0);
            compra.setNo_fac(0);
            compra.setSerie(null);
        }
    }

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

    public List<Compra> Mostrar() throws Exception {

        List<Compra> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select compra.id_compra, orden.fecha_orden, "
                    + "orden.fecha_entrega, proveedor.nombre_proveedor,\n"
                    + "producto.nombre_producto, compra.cantidad, compra.costo, compra.no_factura, compra.serie\n"
                    + "from compra\n"
                    + "inner join orden_compras as orden\n"
                    + "on (compra.id_orden=orden.id_orden_compras)\n"
                    + "inner join proveedor_productos\n"
                    + "on(orden.id_producto = proveedor_productos.id_producto)\n"
                    + "inner join producto\n"
                    + "on (proveedor_productos.id_producto=producto.id_producto)\n"
                    + "inner join proveedor\n"
                    + "on (proveedor_productos.id_proveedor=proveedor.id_proveedor);");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Compra compra = new Compra();
                compra.setId_compras(rs.getInt("compra.id_compra"));
                compra.getOcompras().setFecha_orden(rs.getDate("orden.fecha_orden"));
                compra.getOcompras().setFecha_entrega(rs.getDate("orden.fecha_entrega"));
                compra.getOcompras().getPproductos().getProducto().setNombre(rs.getString("producto.nombre_producto"));
                compra.setCantidad(rs.getInt("compra.cantidad"));
                compra.setCosto(rs.getInt("compra.costo"));
                compra.setNo_fac(rs.getInt("compra.no_factura"));
                compra.setSerie(rs.getString("compra.serie"));
                lista.add(compra);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

}
