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
 * @author Bryan
 */
public class ProductoDao extends Dao {

    /**
     * Metodo para registrar un producto
     *
     * @param prod por si resulta un error de SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void registrar(Producto prod) throws Exception {
        ResultSet rs;
        try {
            this.Conectar();

            PreparedStatement ps = getCon().prepareStatement("select id_producto, nombre_producto from producto where nombre_producto=?");
            ps.setString(1, prod.getNombre());
            rs = ps.executeQuery();
            if (rs.next()) {
                prod.setId_producto(rs.getInt(1));
                suma(prod);
                tTransaccion(prod);
            } else {
                PreparedStatement st = this.getCon().prepareStatement("insert into producto(nombre_producto,existencia,id_unidad,id_tipos) values(?,?,?,?)");
                st.setString(1, prod.getNombre());
                st.setInt(2, prod.getExistencia());
                st.setInt(3, prod.getUmedida().getId_unidad());
                st.setInt(4, prod.getTproducto().getId_tipo());
                st.executeUpdate();
                ProductoBean.addMessage("Accion Completada");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }
    }

    /**
     * Metodo para sumar la existencia de un producto
     *
     * @param pro por si resulta un error de SQL
     */
    public void suma(Producto pro) {
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

    /**
     * Metodo para insertar en transaccion inventario si en dado caso existe
     * regitro de producto
     *
     * @param pro por si resulta un error de SQL
     * @throws ParseException por si resulta un error de SQL
     */
    public void tTransaccion(Producto pro) throws ParseException {
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
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Metodo para listar producto
     *
     * @return List
     * @throws Exception por si resulta un error de SQL
     */
    public List<Producto> listar() throws Exception {
        List<Producto> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select producto.id_producto, producto.nombre_producto, producto.existencia, unidad_medida.id_unidad, unidad_medida.nombre, tipo_producto.id_tipo, tipo_producto.nombre_tipo from producto inner join unidad_medida on (producto.id_unidad = unidad_medida.id_unidad) inner join tipo_producto on (producto.id_tipos = tipo_producto.id_tipo)");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setId_producto(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setCantidad(rs.getInt(3));
                prod.getUmedida().setId_unidad(rs.getInt(4));
                prod.getUmedida().setNombre(rs.getString(5));
                prod.getTproducto().setId_tipo(rs.getInt(6));
                prod.getTproducto().setNombre(rs.getString(7));

                lista.add(prod);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }

    /**
     * Metodo para modificar producto
     *
     * @param prod para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void modificar(Producto prod) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE  producto SET  nombre_producto=?, existencia=?, id_unidad=?, id_tipos=? WHERE id_producto=?");
            st.setInt(1, prod.getId_producto());
            st.setInt(2, prod.getCantidad());
            st.setInt(3, prod.getUmedida().getId_unidad());
            st.setInt(4, prod.getTproducto().getId_tipo());
            st.setInt(5, prod.getId_producto());
            st.executeUpdate();
            ProductoBean.addMessage("Accion Completada");
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para eliminar producto
     *
     * @param prod para la sentencia SQL
     * @throws Exception por si resulta un error de SQL
     */
    public void eliminar(Producto prod) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("DELETE FROM producto WHERE id_producto=?;");
            st.setInt(1, prod.getId_producto());
            st.executeUpdate();
            ProductoBean.addMessage("Accion Completada");
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para obetener los valores de una fila
     *
     * @param pro para la sentencia SQL
     * @return objeto producto
     * @throws Exception por si resulta un error de SQL
     */
    public Producto leerFila(Producto pro) throws Exception {
        Producto proo = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement ps = getCon().prepareStatement("select id_producto,nombre_producto,existencia,id_unidad,id_tipos from producto where id_producto=?");
            ps.setInt(1, pro.getId_producto());
            rs = ps.executeQuery();

            while (rs.next()) {
                proo = new Producto();
                proo.setId_producto(rs.getInt(1));
                proo.setNombre(rs.getString(2));
                proo.setCantidad(rs.getInt(3));
                proo.getUmedida().setId_unidad(rs.getInt(4));
                proo.getTproducto().setId_tipo(rs.getInt(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Desconecar();
        }
        return proo;
    }
}
