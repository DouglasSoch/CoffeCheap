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
            PreparedStatement st = this.getCon().prepareStatement("insert into proveedor values(?,?,?,?,?,?)");
            st.setInt(1, proveedor.getId_proveedor());
            st.setString(2, proveedor.getNombre());
            st.setString(3, proveedor.getNit());            
            st.setInt(4, proveedor.getTelefono());
            st.setString(5, proveedor.getMail());
            st.setString(6, proveedor.getDireccion());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
            proveedor.setId_proveedor(0);
            proveedor.setNombre(null);
            proveedor.setNit(null);
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
            PreparedStatement st = this.getCon().prepareStatement("UPDATE proveedor SET nombre_proveedor=?, nit_proveedor=?, telefono_proveedor=?, email_proveedor=?, direccion_proveedor=? where id_proveedor=?");
            st.setString(1, proveedor.getNombre());
            st.setString(2, proveedor.getNit());
            st.setInt(3, proveedor.getTelefono());
            st.setString(4, proveedor.getMail());
            st.setString(5, proveedor.getDireccion());
            st.setInt(6, proveedor.getId_proveedor());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconecar();
            proveedor.setId_proveedor(0);
            proveedor.setNombre(null);
             proveedor.setNit(null);
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
                proveedor.setId_proveedor(rs.getInt("id_proveedor"));
                proveedor.setNombre(rs.getString("nombre_proveedor"));
                proveedor.setNit(rs.getString("nit_proveedor"));                
                proveedor.setTelefono(rs.getInt("telefono_proveedor"));
                proveedor.setMail(rs.getString("email_proveedor"));
                proveedor.setDireccion(rs.getString("direccion_proveedor"));
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
