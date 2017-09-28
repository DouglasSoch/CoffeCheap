package com.coffecheap.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.coffecheap.modelo.Compra;

public class CompraDao extends Dao {

    ArrayList<Compra> compra1 = new ArrayList();

    

    public void Insertar(Compra compra) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into compra values(?,?,?,?,?,?,?,?)");
            st.setInt(2, compra.getOcompras().getId_orden_compras());
            st.setInt(3, compra.getOcompras().getPproductos().getProducto().getId_producto());
            st.setInt(4, compra.getCantidad());
            st.setInt(5, compra.getCosto());
            st.setInt(6, compra.getNo_fac());
            st.setString(7, compra.getSerie());
            st.setString(8, null);
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
        System.out.println("Probando Eliminar: " + compra.getId_compras());
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
            PreparedStatement st = this.getCon().prepareStatement("select compra.id_orden, "
                    + "proveedor.nombre_proveedor, orden_compras.cantidad_orden, \n"
                    + "producto.nombre_producto, compra.cantidad, compra.costo, compra.no_factura, "
                    + "compra.serie, compra.fecha_entregacompra\n"
                    + "from compra\n"
                    + "inner join producto on(producto.id_producto=compra.id_producto)\n"
                    + "inner join orden_compras on(orden_compras.id_orden_compras=compra.id_orden)\n"
                    + "inner join proveedor on (proveedor.id_proveedor=orden_compras.id_proveedor);");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Compra compra = new Compra();
                compra.getOcompras().setId_orden_compras(rs.getInt("compra.id_orden"));
                compra.getOcompras().getPproductos().getProveedor().setNombre(rs.getString("proveedor.nombre_proveedor"));
                compra.getOcompras().setCantidad(rs.getInt("orden_compras.cantidad_orden"));
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

    public void Prueba(Compra compra) {
        
        compra1.add (compra);
        for (int i = 0; i < compra1.size(); i++) {
            System.out.println("Id Compras 1: " + compra1.get(i).getId_compras());
            System.out.println("Orden de Compras: " + compra1.get(i).getOcompras().getId_orden_compras());
            System.out.println("Cantidad: " + compra1.get(i).getCantidad());
        }
    }
    
    public void Prueba2 (Compra compra){
        
        for (int i = 0; i < compra1.size(); i++) {
            System.out.println("Resultado "+compra1.get(i).getId_compras());
        }
        
    }

}
