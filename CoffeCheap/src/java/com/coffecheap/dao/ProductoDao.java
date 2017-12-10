/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffecheap.dao;

import com.coffecheap.bean.ProductoBean;
import com.coffecheap.modelo.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author medev
 */
public class ProductoDao extends Dao 
{
    public void registrar(Producto prod) throws Exception 
    {
      ResultSet rs;
        try 
        {
            this.Conectar();
            
            PreparedStatement ps = getCon().prepareStatement("select id_producto, nombre_producto from producto where nombre_producto=?");
            ps.setString(1, prod.getNombre());
            rs=ps.executeQuery();    
            if(rs.next())
            {
                prod.setId_producto(rs.getInt(1));
                suma(prod);
                tTransaccion(prod);
            }
            else
            {
            PreparedStatement st = this.getCon().prepareStatement("insert into producto(nombre_producto,existencia,id_unidad,id_tipos) values(?,?,?,?)");
            st.setString(1, prod.getNombre());
            st.setInt(2, prod.getExistencia());
            st.setInt(3, prod.getUmedida().getId_unidad());
            st.setInt(4, prod.getTproducto().getId_tipo());
            st.executeUpdate();
            ProductoBean.addMessage("Accion Completada");
            }
        }
        catch (Exception ex) 
        {
            throw ex;
        } 
        finally 
        {
            this.Desconecar();

        }
    }

    public void suma(Producto pro) 
    {
        try {
            this.Conectar();
            PreparedStatement ps = getCon().prepareStatement("update producto set  existencia=existencia+? where id_producto=?");
            ps.setInt(1, pro.getCantidad());
            ps.setInt(2, pro.getId_producto());
            ps.executeUpdate();
            ProductoBean.addMessage("Existencia del producto " + pro.getNombre() + " actualizada");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void tTransaccion(Producto pro) throws ParseException 
    {
        String detalle = "Cambio en existencia de producto ya existente";
        int tipo = 5;
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = new Date();
        String fechaString = formateador.format(fecha);
        Date tranformada = formateador.parse(fechaString);
        //fechaSus = fechaString;
        pro.setFecha(tranformada);
        try {
            this.Conectar();
            PreparedStatement ps = getCon().prepareStatement("insert into transaccion_inventario(fecha,id_producto,id_tipo_transaccion,cantidad,detalle) values(?,?,?,?,?)");
            ps.setString(1, formateador.format(tranformada));
            ps.setInt(2, pro.getId_producto());
            ps.setInt(3, tipo);
            ps.setInt(4, pro.getCantidad());
            ps.setString(5, detalle);
            ps.executeUpdate();
            ProductoBean.addMessage("Se ralizo el registro del producto" + pro.getNombre() + "con exito");
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }

    public List<Producto> listar() throws Exception {
        List<Producto> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("SELECT *FROM producto");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Producto prod = new Producto();

                prod.setId_producto(rs.getInt("id_producto"));
                prod.setNombre(rs.getString("nombre_producto"));
                prod.setExistencia(rs.getInt("existencia"));
                prod.getUmedida().setId_unidad(rs.getInt("id_unidad"));
                prod.getTproducto().setId_tipo(rs.getInt("id_tipos"));

                lista.add(prod);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }

    public void modificar(Producto prod
    ) throws Exception {
        System.out.println("*******************************************************modificar dao");
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE  producto SET id_producto=?, nombre_producto=?, existencia=?, id_unidad=?, id_tipos=? WHERE id_producto=?;");

            st.setInt(1, prod.getId_producto());
            st.setString(2, prod.getNombre());
            st.setInt(3, prod.getExistencia());
            st.setInt(4, prod.getUmedida().getId_unidad());
            st.setInt(5, prod.getTproducto().getId_tipo());
            st.setInt(6, prod.getId_producto());
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    public void eliminar(Producto prod) throws Exception {
        System.out.println("*******************************************************eliminar dao");
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("DELETE FROM producto WHERE id_producto=?;");
            st.setInt(1, prod.getId_producto());
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }
}
