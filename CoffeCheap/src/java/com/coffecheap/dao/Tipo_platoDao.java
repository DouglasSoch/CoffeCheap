package com.coffecheap.dao;

import com.coffecheap.bean.Tipo_platoBean;
import com.coffecheap.modelo.Tipo_plato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bryan
 */
public class Tipo_platoDao extends Dao {

    /**
     * Metodo para ingresar un registro en tipo Plato
     *
     * @param tipoPlato
     * @throws Exception
     */
    public void registrar(Tipo_plato tipoPlato) throws Exception {
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement ps = getCon().prepareStatement("select *from tipo_plato where nombre=?");
            ps.setString(1, tipoPlato.getNombre());
            rs = ps.executeQuery();

            if (rs.next()) {
                Tipo_platoBean.addMessage("ya existe un registro con estos datos");
            } else {
                PreparedStatement st = this.getCon().prepareStatement("insert into tipo_plato (id_tipo_plato, nombre) values(?,?)");
                st.setInt(1, tipoPlato.getId());
                st.setString(2, tipoPlato.getNombre());
                st.executeUpdate();
                Tipo_platoBean.addMessage("Se ingreso correctamente");
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }
    }

    /**
     * Metodo para listar todos los registros de tipo plato
     *
     * @return
     * @throws Exception
     */
    public List<Tipo_plato> listar() throws Exception {
        List<Tipo_plato> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select id_tipo_plato, nombre from tipo_plato");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Tipo_plato tipoPlato = new Tipo_plato();
                tipoPlato.setId(rs.getInt(1));
                tipoPlato.setNombre(rs.getString(2));
                lista.add(tipoPlato);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();
        }

        return lista;

    }

//     public List<Tipo_plato> listarProducto() throws Exception {
//        List<Tipo_plato> lista;
//        ResultSet rs;
//
//        try {
//            this.Conectar();
//            PreparedStatement st = this.getCon().prepareCall("select id_producto, nombre_producto from producto");
//            rs = st.executeQuery();
//            lista = new ArrayList();
//            while (rs.next()) {
//                Producto producto = new Producto();
//                producto.setId_producto(rs.getInt(1));
//                producto.setNombre(rs.getString(2));
//                lista.add(producto);
//            }
//
//        } catch (Exception ex) {
//            throw ex;
//        } finally {
//            this.Desconecar();
//        }
//
//        return lista;
//
//    }
    /**
     * Metodo para modifcar un registro de tipo plato
     *
     * @param tipoPlato
     * @throws Exception
     */
    public void modificar(Tipo_plato tipoPlato) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE tipo_plato SET nombre=? WHERE id_tipo_plato=?");
            st.setString(1, tipoPlato.getNombre());
            st.setInt(2, tipoPlato.getId());
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para eliminar un registro de tipo plato
     *
     * @param tipoPlato
     * @throws Exception
     */
    public void eliminar(Tipo_plato tipoPlato) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("DELETE FROM tipo_plato WHERE id_tipo_plato=?");
            st.setInt(1, tipoPlato.getId());
            st.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconecar();

        }

    }

    /**
     * Metodo para obtener un registro de una tabla de tipo plato
     *
     * @param tipoPlato
     * @return
     * @throws Exception
     */
    public Tipo_plato leerFila(Tipo_plato tipoPlato) throws Exception {
        Tipo_plato tipoPlatoN = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = getCon().prepareStatement("select id_tipo_plato, nombre from tipo_plato WHERE id_tipo_plato=?");
            st.setInt(1, tipoPlato.getId());
            rs = st.executeQuery();
            while (rs.next()) {
                tipoPlatoN = new Tipo_plato();
                tipoPlatoN.setId(rs.getInt(1));
                tipoPlatoN.setNombre(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.Desconecar();
        }
        return tipoPlatoN;
    }
}
