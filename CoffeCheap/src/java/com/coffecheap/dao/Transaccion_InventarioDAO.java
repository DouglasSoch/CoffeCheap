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


public class Transaccion_InventarioDAO extends Dao
{
    public void registrar(Transaccion_inventario traInv) throws Exception
    {
        
        System.out.println("el id es:"+traInv.getId_transaccion());
        System.out.println("la fecha es:"+traInv.getFecha());
        System.out.println("el id producto  es:"+traInv.getProducto().getId_producto());
        System.out.println("el id tipo es:"+traInv.getTtransaccion().getId_tipo_transacciones());
        System.out.println("la cantidad es:"+traInv.getCantidad());
        System.out.println("el detalle es:"+traInv.getDetalle());
        try
        {   
            
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        
            this.Conectar();
                
            PreparedStatement st = this.getCon().prepareStatement("insert into transaccion_inventario (fecha,id_producto,id_tipo_transaccion,cantidad,detalle,id_compra)values(?,?,?,?,?,?)");
            st.setString(1, formateador.format(traInv.getFecha()));
            st.setInt(2, traInv.getProducto().getId_producto());
            st.setInt(3, traInv.getTtransaccion().getId_tipo_transacciones());
            st.setInt(4, traInv.getCantidad());
            st.setString(6, traInv.getDetalle());
            st.setInt(7, traInv.getCompra().getId_compras());
            st.executeUpdate();   
            Transaccion_inventarioBean .addMessage("Registro Guardado");
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.Desconecar();
        }
    }
      public List<Transaccion_inventario> mostrar() throws Exception
    {
        List<Transaccion_inventario> lista;
        ResultSet rs;
        try
        {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select transaccion_inventario.id_transaccion, transaccion_inventario.fecha, producto.id_producto, producto.nombre_producto, tipo_transacciones.id_tipo_transacciones,tipo_transacciones.nombre_trasaccion, transaccion_inventario.cantidad, transaccion_inventario.detalle, compra.id_compra, compra.serie,compra.no_factura, compra.costo, compra.fecha_entregacompra, orden_compras.fecha_orden, orden_compras.fecha_entrega from transaccion_inventario  inner join producto on(transaccion_inventario.id_producto = producto.id_producto) inner join tipo_transacciones on(transaccion_inventario.id_tipo_transaccion = tipo_transacciones.id_tipo_transacciones) inner join  compra on(transaccion_inventario.id_compra = compra.id_compra) inner join orden_compras on(compra.id_orden = orden_compras.id_orden_compras)");
            rs=st.executeQuery();
            lista = new ArrayList();
            
            while(rs.next())
            {
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
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.Desconecar();
        }
        return lista;
    }   
      
      public List<Compra> listarCompra() throws Exception
    {
        List<Compra> lista;
        ResultSet rs;
        try
        {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select id_compra, serie from compra");
            rs=st.executeQuery();
            lista = new ArrayList();
            
            while(rs.next())
            {
                Compra compra = new Compra();
                compra.setId_compras(rs.getInt(1));
                compra.setSerie(rs.getString(2));
                lista.add(compra);
            }
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.Desconecar();
        }
        return lista;
    }   

      public List<Transaccion_inventario> mostrarPorPrarametro(Transaccion_inventario  traInv) throws Exception
    {
        List<Transaccion_inventario> lista;
        ResultSet rs;
        
        try
        {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select traInv.id_transaccion, traInv.fecha, pro.nombre_producto, tipTran.nombre_trasaccion "
                    + "from transaccion_inventario as traInv inner join producto as pro on(traInv.id_producto = pro.id_producto) inner join tipo_transacciones as "
                    + "tipTran on(traInv.id_tipo_transaccion = tipTran.id_tipo_transacciones) where traInv.id_transaccion=?");
            st.setInt(1, traInv.getId_transaccion());
            rs=st.executeQuery();
            lista = new ArrayList();
            
            while(rs.next())
            {
                   Transaccion_inventario tra = new Transaccion_inventario();
                tra.setId_transaccion(rs.getInt(1));
                tra.setFecha((rs.getDate(2)));
                tra.getProducto().setNombre(rs.getString(3));
                tra.getTtransaccion().setNombre(rs.getString(4));
                lista.add(tra);
               
            }
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.Desconecar();
        }
        return lista;
    } 
      
      public List<Transaccion_inventario> mostrarPorPrarametroEspecial(Transaccion_inventario  traInv) throws Exception
    {
        List<Transaccion_inventario> lista;
        ResultSet rs;
        try
        {
            this.Conectar();
               
            PreparedStatement st = getCon().prepareCall("select traInv.id_transaccion, traInv.fecha, pro.nombre_producto, "
                    + "tipTran.nombre_trasaccion from transaccion_inventario as traInv inner join producto as pro on(traInv.id_producto = "
                    + "pro.id_producto) inner join tipo_transacciones as tipTran on(traInv.id_tipo_transaccion = tipTran.id_tipo_transacciones) "
                    + "where traInv.fecha=?");
           
            st.setString(1, traInv.getProducto().getNombre());
            rs=st.executeQuery();
            lista = new ArrayList();
            
            while(rs.next())
            {
                   Transaccion_inventario tra = new Transaccion_inventario();
                tra.setId_transaccion(rs.getInt(1));
                tra.setFecha((rs.getDate(2)));
                tra.getProducto().setNombre(rs.getString(3));
                tra.getTtransaccion().setNombre(rs.getString(4));
                lista.add(tra);
               
            }
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.Desconecar();
        }
        return lista;
    } 
      
      public List<Transaccion_inventario> mostrarPorRangoEspecial(Transaccion_inventario  traInv) throws Exception
    {
        List<Transaccion_inventario> lista;
        ResultSet rs;
        try
        {
            this.Conectar();
            
                  SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                    
            PreparedStatement st = getCon().prepareCall("select traInv.id_transaccion, traInv.fecha, pro.nombre_producto,tipTran.nombre_trasaccion "
                    + "from transaccion_inventario as traInv inner join producto as pro on(traInv.id_producto = pro.id_producto) inner join tipo_transacciones "
                    + "as tipTran on(traInv.id_tipo_transaccion = tipTran.id_tipo_transacciones) where traInv.fecha BETWEEN ? AND ?");
            
            //String nu=formateador.format(traInv.getFecha());
           
            st.setString(1,traInv.getFechaUno());
            st.setString(2, traInv.getFechaDos());
            rs=st.executeQuery();
            lista = new ArrayList();
            
            while(rs.next())
            {
                   Transaccion_inventario tra = new Transaccion_inventario();
                tra.setId_transaccion(rs.getInt(1));
                tra.setFecha((rs.getDate(2)));
                tra.getProducto().setNombre(rs.getString(3));
                tra.getTtransaccion().setNombre(rs.getString(4));
                lista.add(tra);
               
            }
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.Desconecar();
        }
        return lista;
    }   
      
    
      public List<Transaccion_inventario> listarParaModificarProducto() throws Exception
    {
        List<Transaccion_inventario> lista;
        ResultSet rs;
        try
        {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select id_producto, nombre_producto from producto");
            rs=st.executeQuery();
            lista = new ArrayList();
            
            while(rs.next())
            {
                Transaccion_inventario traInv = new Transaccion_inventario();
                traInv.getProducto().setId_producto(rs.getInt(1));
                traInv.getProducto().setNombre(rs.getString(2));
                lista.add(traInv);
            }
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.Desconecar();
        }
        return lista;
    }
      
        public List<Transaccion_inventario> listarParaModificarTtransaccion() throws Exception
    {
        List<Transaccion_inventario> lista;
        ResultSet rs;
        try
        {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select id_tipo_transacciones, nombre_trasaccion from tipo_transacciones");
            rs=st.executeQuery();
            lista = new ArrayList();
            
            while(rs.next())
            {
                Transaccion_inventario traInv = new Transaccion_inventario();
                traInv.getTtransaccion().setId_tipo_transacciones(rs.getInt(1));
                traInv.getTtransaccion().setNombre(rs.getString(2));
                lista.add(traInv);
            }
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.Desconecar();
        }
        return lista;
    }
      
      public Transaccion_inventario leerParaModificar(Transaccion_inventario  traInv) throws Exception
    {
        Transaccion_inventario traInvAden = null;
        ResultSet rs;
        
        try
        {
            this.Conectar();
            PreparedStatement st = getCon().prepareCall("select id_transaccion, fecha, id_producto, id_tipo_transaccion from "
                    + "transaccion_inventario where id_transaccion=?");
            st.setInt(1, traInv.getId_transaccion());
            rs=st.executeQuery();
            
            
            while(rs.next())
            {
                   traInvAden = new Transaccion_inventario();
                   
                traInvAden.setId_transaccion(rs.getInt(1));
                traInvAden.setFecha((rs.getDate(2)));
                traInvAden.getProducto().setNombre(rs.getString(3));
                traInvAden.getTtransaccion().setNombre(rs.getString(4));
                
               
            }
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.Desconecar();
        }
        return traInvAden;
    } 
    /*  
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
*/         
              public void modificar(Transaccion_inventario orco) throws Exception
    {
        try
        {
         this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update orden_compras set  fecha_orden=?, "
                    + "fecha_entrega=?, cantidad_orden=?, id_producto=?, id_proveedor=?, precio=? "
                    + "where id_orden_compras=?");
            /*st.setString(1, orco.getFecha_orden());
            st.setString(2, orco.getFecha_entrega());
            st.setInt(3, orco.getCantidad_orden());
            st.setInt(4, orco.getId_producto());
            st.setInt(5, orco.getId_proveedor());
            st.setInt(6, orco.getPrecio());
            st.setInt(7, orco.getId_orden_compras());
*/
            st.executeUpdate();
        }catch(Exception e)
        {
            throw e;
        }finally
        {
            this.Desconecar();
        }
    }

}