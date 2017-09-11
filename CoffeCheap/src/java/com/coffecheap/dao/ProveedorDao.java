package com.coffecheap.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.coffecheap.modelo.Proveedor;

public class ProveedorDao extends Dao {

    public void Ingresar(Proveedor proveedor) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into proveedor values(?,?,?,?,?)");
            st.setInt(1, proveedor.getId_proveedor());
            st.setString(2, proveedor.getNombre());
            st.setInt(3, proveedor.getTelefono());
            st.setString(4, proveedor.getMail());
            st.setString(5, proveedor.getDireccion());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
            proveedor.setId_proveedor(0);
            proveedor.setNombre(null);
            proveedor.setTelefono(0);
            proveedor.setMail(null);
            proveedor.setDireccion(null);
        }
    }

    public void Borrar(Proveedor proveedor) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("delete from proveedor where id_proveedor=?");
            st.setInt(1, proveedor.getId_proveedor());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
            proveedor.setId_proveedor(0);
        }

    }

    public void Editar(Proveedor proveedor) throws Exception {

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("UPDATE proveedor SET nombre_proveedor=?, telefono_proveedor=?, email_proveedor=?, direccion_proveedor=? where id_proveedor=?");
            st.setString(1, proveedor.getNombre());
            st.setInt(2, proveedor.getTelefono());
            st.setString(3, proveedor.getMail());
            st.setString(4, proveedor.getDireccion());
            st.setInt(5, proveedor.getId_proveedor());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
            proveedor.setId_proveedor(0);
            proveedor.setNombre(null);
            proveedor.setTelefono(0);
            proveedor.setMail(null);
            proveedor.setDireccion(null);
        }

    }

    public List<Proveedor> Mostrar() throws Exception {

        List<Proveedor> lista;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getCon().prepareCall("select * from proveedor");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_proveedor(rs.getInt(1));
                proveedor.setNombre(rs.getString(2));
                proveedor.setNit(rs.getString(3));
                proveedor.setTelefono(rs.getInt(4));
                proveedor.setMail(rs.getString(5));
                proveedor.setDireccion(rs.getString(6));
                lista.add(proveedor);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
        }
        return lista;
    }

}
