/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.bean.Proveedor_productosBean;
import com.coffecheap.modelo.Producto;
import com.coffecheap.modelo.Proveedor;
import com.coffecheap.modelo.Proveedor_productos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acier
 */
public class Proveedor_productosDao extends Dao {

    public void registrar(Proveedor_productos Tt) throws Exception 
    {
       ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement ps = getCon().prepareStatement("select *from proveedor_productos where id_proveedor=? and id_producto=?");
            ps.setInt(1, Tt.getProveedor().getId_proveedor());
            ps.setInt(2, Tt.getProducto().getId_producto());
            rs= ps.executeQuery();
            
            if(rs.next())
            {
                Proveedor_productosBean.addMessage("ya existe un registro con estos datos");
            }else
            {
            PreparedStatement st = this.getCon().prepareStatement("insert into proveedor_productos (id_proveedor, id_producto, precio_insumo) values(?,?,?)");
            st.setInt(1, Tt.getProveedor().getId_proveedor());
            st.setInt(2, Tt.getProducto().getId_producto());
            st.setInt(3, Tt.getPrecio());
            st.executeUpdate();
            Proveedor_productosBean.addMessage("Se ingreso correctamente");
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    public List<Proveedor_productos> listar() throws Exception {
        List<Proveedor_productos> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select proveedor.nombre_proveedor , producto.nombre_producto,  proveedor_productos.precio_insumo from proveedor inner join proveedor_productos on (proveedor.id_proveedor = proveedor_productos.id_proveedor) inner join producto on (proveedor_productos.id_producto = producto.id_producto)");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) 
            {
                Proveedor_productos tt = new Proveedor_productos();
                tt.getProveedor().setNombre(rs.getString(1));
                tt.getProducto().setNombre(rs.getString(2));
                tt.setPrecio(rs.getInt(3));

                lista.add(tt);
            }

        } catch (Exception ex) {
            throw ex;
        } finally 
        {
            this.Desconecar();
        }
        return lista;
    }

     public List<Proveedor> listarProveedor() throws Exception {
        List<Proveedor> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select id_proveedor, nombre_proveedor from proveedor");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_proveedor(rs.getInt(1));
                proveedor.setNombre(rs.getString(2));
                lista.add(proveedor);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }
     
     public List<Producto> listarProducto() throws Exception {
        List<Producto> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select id_producto, nombre_producto from producto");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId_producto(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                lista.add(producto);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }
    
    public void modificar(Proveedor_productos Tt) throws Exception 
    {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE  proveedor_productos SET id_producto=?, precio_insumo=? WHERE id_proveedor=?");
            st.setInt(1, Tt.getProducto().getId_producto());
            st.setInt(2, Tt.getPrecio());
            st.setInt(3, Tt.getProveedor().getId_proveedor());
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }
    
//     public Proveedor_productos leerParaModificar(Proveedor_productos proveedorP) throws Exception 
//    {
//        Usuario usuario = null;
//        ResultSet rs;
//        boolean ver;
//        try {
//            this.Conectar();
//            PreparedStatement st = getCon().prepareCall("select iduser, user, pass, tipouser, nombre, apellido, codigo, idturno, telefono, direccion, dpi, nit, correo from usuario where iduser=?");
//            st.setInt(1, proveedorP.g());
//            rs = st.executeQuery();
//            
//             ver=rs.next();
//            
//            System.out.println(ver);
//            
//           if(ver==true){
//                usuario = new Usuario();
//                usuario.setId(rs.getInt(1));
//                usuario.setUsuario(rs.getString(2));
//                usuario.setPass(rs.getString(3));
//                usuario.getTipo().setId(rs.getInt(4));
//                usuario.setNombre(rs.getString(5));
//                usuario.setApellido(rs.getString(6));
//                usuario.setCodigo(rs.getInt(7));
//                usuario.getTurno().setId_turno(rs.getInt(8));
//                usuario.setTelefono(rs.getInt(9));
//                usuario.setDireccion(rs.getString(10));
//                usuario.setDpi(rs.getInt(11));
//                usuario.setNit(rs.getString(12));
//                usuario.setCorreo(rs.getString(13));
//                rs.close();
//            }
//          else
//           {
//            UsuarioBean.addMessage("no existe");
//            rs.close();
//           }  
//           
//            
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.Desconecar();
//        }
//        return usuario;
//    }

    public void eliminar(Proveedor_productos pac) throws Exception {
        System.out.println("*******************************************************eliminar dao");
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("DELETE FROM proveedor_productos WHERE id_proveedor_productos=?;");
            st.setInt(1, pac.getProveedor().getId_proveedor());
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

}
