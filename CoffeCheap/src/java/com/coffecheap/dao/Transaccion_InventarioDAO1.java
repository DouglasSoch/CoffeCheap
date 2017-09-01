package com.coffecheap.dao;

import com.coffecheap.dao.Dao;
import com.coffecheap.modelo.Transaccion_inventario;
import java.sql.PreparedStatement;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class Transaccion_InventarioDAO1 extends Dao
{
    public void registrar(Transaccion_inventario traInv) throws Exception
    {
        try
        {
            
        System.out.println("id trzns"+traInv.getId_transaccion());
        System.out.println(traInv.getFecha());
        System.out.println("id por"+traInv.getProducto().getId_producto());
        System.out.println("id tTrans"+traInv.getTtransaccion().getId_tipo_transacciones());
        
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
              this.Conectar();
            
            
            PreparedStatement st = this.getCon().prepareStatement("insert into transaccion_inventario values(?,?,?,?)");
            st.setInt(1, traInv.getId_transaccion());
            st.setString(2, formateador.format(traInv.getFecha()));
            st.setInt(3, traInv.getProducto().getId_producto());
            st.setInt(4, traInv.getTtransaccion().getId_tipo_transacciones());
            st.executeUpdate();
            
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.Desconecar();
        }
    }
    /*
      public List<orden_compras> mostrar() throws Exception
    {
        List<orden_compras> lista;
        ResultSet rs;
        
        try
        {
            this.conectar();
            PreparedStatement st = getCn().prepareCall("select 	id_orden_compras, fecha_orden, "
                    + "fecha_entrega, cantidad_orden, id_producto, id_proveedor, precio from orden_compras");
            rs=st.executeQuery();
            lista = new ArrayList();
            
            while(rs.next())
            {
                orden_compras oc = new orden_compras();
                oc.setId_orden_compras(rs.getInt(1));
                oc.setFecha_orden(rs.getString(2));
                oc.setFecha_entrega(rs.getString(3));
                oc.setCantidad_orden(rs.getInt(4));
                oc.setId_producto(rs.getInt(5));
                oc.setId_proveedor(rs.getInt(6));
                oc.setPrecio(rs.getInt(7));
                lista.add(oc);
               
            }
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.cerrar();
        }
        return lista;
    }   
    
      public List<orden_compras> mostrarPorPrarametro(orden_compras or) throws Exception
    {
        List<orden_compras> lista;
        ResultSet rs;
        
        try
        {
            this.conectar();
            PreparedStatement st = getCn().prepareCall("select 	id_orden_compras, fecha_orden, "
                    + "fecha_entrega, cantidad_orden, id_producto, id_proveedor, precio from "
                    + "orden_compras where id_orden_compras=?");
            st.setInt(1, or.getId_orden_compras());
            rs=st.executeQuery();
            lista = new ArrayList();
            
            while(rs.next())
            {
                orden_compras oc = new orden_compras();
                oc.setId_orden_compras(rs.getInt(1));
                oc.setFecha_orden(rs.getString(2));
                oc.setFecha_entrega(rs.getString(3));
                oc.setCantidad_orden(rs.getInt(4));
                oc.setId_producto(rs.getInt(5));
                oc.setId_proveedor(rs.getInt(6));
                oc.setPrecio(rs.getInt(7));
                lista.add(oc);
               
            }
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.cerrar();
        }
        return lista;
    } 
      
      public List<orden_compras> listarParaModificar() throws Exception
    {
        List<orden_compras> lista;
        ResultSet rs;
        try
        {
            this.conectar();
            PreparedStatement st = getCn().prepareCall("select id_orden_compras from orden_compras");
            rs=st.executeQuery();
            lista = new ArrayList();
            
            while(rs.next())
            {
                orden_compras orco = new orden_compras();
                orco.setId_orden_compras(rs.getInt(1));
                lista.add(orco);
            }
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.cerrar();
        }
        return lista;
    }
      
         public void eliminar(orden_compras orco) throws Exception
    {
        try
        {
         this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from orden_compras where id_orden_compras=?");
            st.setInt(1, orco.getId_orden_compras());
            st.executeUpdate();
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.cerrar();
        }
    }
         
              public void modificar(orden_compras orco) throws Exception
    {
        try
        {
         this.conectar();
            PreparedStatement st = this.getCn().prepareStatement("update orden_compras set  fecha_orden=?, "
                    + "fecha_entrega=?, cantidad_orden=?, id_producto=?, id_proveedor=?, precio=? "
                    + "where id_orden_compras=?");
            st.setString(1, orco.getFecha_orden());
            st.setString(2, orco.getFecha_entrega());
            st.setInt(3, orco.getCantidad_orden());
            st.setInt(4, orco.getId_producto());
            st.setInt(5, orco.getId_proveedor());
            st.setInt(6, orco.getPrecio());
            st.setInt(7, orco.getId_orden_compras());
            st.executeUpdate();
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.cerrar();
        }
    }
*/
}