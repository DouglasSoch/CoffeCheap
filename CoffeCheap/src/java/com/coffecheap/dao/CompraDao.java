package com.coffecheap.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.coffecheap.modelo.Compra;

public class CompraDao extends Dao{

    public void Insertar(Compra compra) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into compra values(?,?,?,?,?,?,?,?)");
            st.setInt(1, compra.getId_compras());
            st.setInt(2, compra.getOcompras().getId_orden_compras());
            st.setInt(3, compra.getProveedor().getId_provedor());
            st.setInt(4, compra.getProducto().getId_producto());
            st.setInt(5, compra.getCantidad());
            st.setInt(6, compra.getCosto());
            st.setInt(7, compra.getNo_fac());
            st.setString(8, compra.getSerie());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
            compra.setId_compras(0);
            compra.getOcompras().setId_orden_compras(0);
            compra.getProveedor().setId_provedor(0);
            compra.getProducto().setId_producto(0);
            compra.setCantidad(0);
            compra.setCosto(0);
            compra.setNo_fac(0);
            compra.setSerie(null);
        }
    }

    public void Modificar(Compra compra) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update compra set id_orden=?, id_proveedor=?, id_producto=?, cantidad=?, costo=?, no_factura=?, serie=? where id_compra = ?");
            st.setInt(1, compra.getOcompras().getId_orden_compras());
            st.setInt(2, compra.getProveedor().getId_provedor());
            st.setInt(3, compra.getProducto().getId_producto());
            st.setInt(4, compra.getCantidad());
            st.setInt(5, compra.getCosto());
            st.setInt(6, compra.getNo_fac());
            st.setString(7, compra.getSerie());
            st.setInt(8, compra.getId_compras());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
            compra.setId_compras(0);
            compra.getOcompras().setId_orden_compras(0);
            compra.getProveedor().setId_provedor(0);
            compra.getProducto().setId_producto(0);
            compra.setCantidad(0);
            compra.setCosto(0);
            compra.setNo_fac(0);
            compra.setSerie(null);
        }
    }
    
    public void Eliminar(Compra compra) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("delete from compra where id_compra=?");
            st.setInt(1, compra.getId_compras());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconecar();
        }
    }
    
    public List<Compra> Mostrar() throws Exception{
    
        List<Compra> lista;
        ResultSet rs;
        
        try {
           this.Conectar();
           PreparedStatement st = this.getCon().prepareStatement("select * from compra");
            rs = st.executeQuery();
            lista = new ArrayList();
            
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setId_compras(rs.getInt("id_compra"));
                compra.getOcompras().setId_orden_compras(rs.getInt("id_orden"));
                compra.getProveedor().setId_provedor(rs.getInt("id_proveedor"));
                compra.getProducto().setId_producto(rs.getInt("id_producto"));
                compra.setCantidad(rs.getInt("cantidad"));
                compra.setCosto(rs.getInt("costo"));
                compra.setNo_fac(rs.getInt("no_factura"));
                compra.setSerie(rs.getString("serie"));
                lista.add(compra);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconecar();
        }
        return lista;
    }

}
